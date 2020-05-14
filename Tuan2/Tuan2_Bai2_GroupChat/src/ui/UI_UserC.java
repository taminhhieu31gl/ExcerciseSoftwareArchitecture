package ui;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.naming.Context;
import javax.naming.InitialContext;

import javax.jms.Topic;
import javax.jms.Session;
import javax.jms.Message;
import javax.jms.TextMessage;
import javax.jms.TopicSession;
import javax.jms.JMSException;
import javax.jms.TopicPublisher;
import javax.jms.MessageListener;
import javax.jms.TopicSubscriber;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;

public class UI_UserC {
	TopicSubscriber subscriber;

	JFrame frame = new JFrame("Chat C");
	JButton btnSend = new JButton("Send");
	JTextArea output = new JTextArea();
	JTextArea input = new JTextArea();
	public UI_UserC() throws Exception {
		Context ctx = new InitialContext();
		TopicConnectionFactory factory = (TopicConnectionFactory) ctx.lookup("cfName");
		 
		TopicConnection conn = factory.createTopicConnection();
		final TopicSession session = conn.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		Topic topic = (Topic) ctx.lookup("MyTopic");	
		final TopicPublisher publisher = session.createPublisher(topic);
		subscriber = session.createSubscriber(topic);
		output.setEditable(false);
		setMessageListener();
		conn.start();
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = input.getText();
				if (msg.length() > 0) {
					try {
						//String sender = System.getProperty("user.name");
						TextMessage m = session.createTextMessage(msg);
						m.setStringProperty("sender", "C");
						//publisher.publish(m);
						publisher.send(m);
						input.setText("");
					} catch (JMSException ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(input);
		panel.add(btnSend, BorderLayout.EAST);
		JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, output, panel);
		//split.setOneTouchExpandable(true);
		split.setDividerLocation(205);

		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(split);
		frame.setSize(new Dimension(400, 300));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public void setMessageListener() throws JMSException {
		subscriber.setMessageListener(new MessageListener() {
			public void onMessage(Message m) {
				try {
					TextMessage msg = (TextMessage) m;
					String sender = msg.getStringProperty("sender");
					output.append(sender + "> " + msg.getText() + "\n");
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
	}
	public static void main(String[] args) throws Exception {
		new UI_UserC();
	}

}