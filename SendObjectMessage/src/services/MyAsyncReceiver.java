package services;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.SinhVien;

public class MyAsyncReceiver implements MessageListener{

	private QueueConnection qConnect = null;
	private QueueSession qSession = null;
	private Queue queue = null;
	public MyAsyncReceiver() throws NamingException, JMSException{
		// TODO Auto-generated constructor stub
		Context ctx = new InitialContext();
		QueueConnectionFactory qFactory = (QueueConnectionFactory)ctx.lookup("cfName");
		qConnect = qFactory.createQueueConnection();
		qSession = qConnect.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		queue = (Queue) ctx.lookup("MyQueue");
		qConnect.start();
		QueueReceiver qReceiver = qSession.createReceiver(queue);
		qReceiver.setMessageListener(this);
		System.out.println("Waiting.....");
	}	
	public static void main(String[] args)throws NamingException, JMSException {
		new MyAsyncReceiver();
	}
	@Override
	public void onMessage(Message msg) {
		// TODO Auto-generated method stub
		if(msg instanceof ObjectMessage) {
			try {
				ObjectMessage objmsg = (ObjectMessage) msg;
				SinhVien sv = (SinhVien) objmsg.getObject();
				System.out.println(sv);
				
			}catch(JMSException e) {
				e.printStackTrace();
			}
		}
	}

}
