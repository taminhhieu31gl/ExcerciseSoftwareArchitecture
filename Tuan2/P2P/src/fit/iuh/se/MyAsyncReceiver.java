package fit.iuh.se;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MyAsyncReceiver implements MessageListener{
	private QueueConnection qConnec = null;
	private QueueSession qSession = null;
	private Queue queue = null;
	public MyAsyncReceiver() throws NamingException, JMSException {
		// TODO Auto-generated constructor stub
		Context ctx = new InitialContext();
		QueueConnectionFactory qFactory = (QueueConnectionFactory) ctx.lookup("cfName");
		qConnec = qFactory.createQueueConnection();
		qSession = qConnec.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		queue = (Queue) ctx.lookup("MyQueue");
		qConnec.start();
		
		QueueReceiver qReceiver = qSession.createReceiver(	queue);
		qReceiver.setMessageListener(this);
		System.out.println("Vui Lòng Đợi........");
	
	}
	public static void main(String[] args) throws NamingException, JMSException {
		new MyAsyncReceiver();
	}
	@Override
	public void onMessage(Message msg) {
		// TODO Auto-generated method stub
		if(msg instanceof ObjectMessage) {
			try {
				ObjectMessage objmsg = (ObjectMessage) msg;
				SinhVien sv = (SinhVien) objmsg.getObject();
				System.out.println("Nhận được: " + sv);
			}catch(JMSException e) {
				e.printStackTrace();
			}
		}
		
	}

}
