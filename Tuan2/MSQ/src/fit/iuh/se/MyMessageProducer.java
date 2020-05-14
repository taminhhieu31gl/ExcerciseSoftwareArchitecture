package fit.iuh.se;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;

public class MyMessageProducer {
	public static void main(String[] args) {
		ConnectionFactory conectionFactory = null;
		Connection connection = null;
		Session session = null;
		Destination destination = null;
		MessageProducer producer = null;
		Message message = null;
		 boolean useTransaction = false;
		 try {
			 Context context = new InitialContext();
			 conectionFactory = (ConnectionFactory) context.lookup("connectionFactoryName");
			 connection = conectionFactory.createConnection();
			 connection.start();
			 session = connection.createSession(useTransaction, Session.AUTO_ACKNOWLEDGE);
			 destination = session.createQueue("MyQueue");
			 producer = session.createProducer(destination);
			 message = session.createTextMessage("tessttttttttttttttt");
			 System.out.println("Da Gui Roi" + message);
			 producer.send(message);
		 }catch(Exception e) {
			 e.printStackTrace();
			 
		 }finally {
			try {
				producer.close();
				session.close();
				connection.close();
			}catch(JMSException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
