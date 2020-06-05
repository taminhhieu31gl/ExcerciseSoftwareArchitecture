
package services;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.google.gson.Gson;

import entities.SinhVien;

public class MyTSubscriber2 implements MessageListener{
	private TopicConnection tConnect = null;
	private TopicSession tSession = null;
	private Topic topic = null;
	
	public MyTSubscriber2() throws NamingException, JMSException{
		// TODO Auto-generated constructor stub
		Context ctx = new InitialContext();
		TopicConnectionFactory qFactory = (TopicConnectionFactory) ctx.lookup("cfName");
		tConnect = qFactory.createTopicConnection();
		tSession = tConnect.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		topic = (Topic) ctx.lookup("MyTopic");
		tConnect.start();
		
		TopicSubscriber tSubscriber = tSession.createSubscriber(topic);
		tSubscriber.setMessageListener(this);
		System.out.println("Subscriber_2 is waiting....");
	}
	public static void main(String[] args) throws NamingException, JMSException {
		new MyTSubscriber2();
	}
	
	@Override
	public void onMessage(Message msg) {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		if(msg instanceof TextMessage) {
			try {
				TextMessage tmsg = (TextMessage) msg;
				String json = tmsg.getText();
				System.out.println(json);
				SinhVien sv = gson.fromJson(json, SinhVien.class);
				System.out.println(sv);
			}catch(JMSException e) {
				e.printStackTrace();
			}
		}
	}
	

}
