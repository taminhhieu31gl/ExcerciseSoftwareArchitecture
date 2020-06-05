package services;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.google.gson.Gson;

import entities.SinhVien;

public class MyTPublisher {
	private TopicConnection tConnect = null;
	private TopicSession qSession = null;
	private Topic topic = null;
	
	public MyTPublisher() throws NamingException, JMSException{
		Context ctx = new InitialContext();
		TopicConnectionFactory qFactory = (TopicConnectionFactory) ctx.lookup("cfName");
		tConnect = qFactory.createTopicConnection();
		qSession = tConnect.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		topic = (Topic) ctx.lookup("MyTopic");
		tConnect.start();
	}
	public static void main(String[] args) throws NamingException, JMSException{
		SinhVien sv = new SinhVien("01420011", "Nguyễn Văn Lành", 30);
		MyTPublisher sender = new MyTPublisher();
		sender.sendMessage(sv);
		sender.exit();
		
	}
	private void exit() throws JMSException{
		qSession.close();
		tConnect.close();
	}
	private void sendMessage(SinhVien sv) throws JMSException{
		Gson gson = new Gson();
		String json = gson.toJson(sv);
		TopicPublisher tPublisher = qSession.createPublisher(topic);
		Message msg = qSession.createObjectMessage(json);
		tPublisher.send(msg);
	}
}
