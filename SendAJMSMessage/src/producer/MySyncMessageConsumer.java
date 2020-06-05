package producer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MySyncMessageConsumer {
	public static void main(String[] args) {
		ConnectionFactory connectionFactory = null;
		Connection connection = null;
		Session session = null;
		Destination destination = null;
		MessageConsumer consumer = null;
		Message message = null;
		boolean useTransaction = false;
		try {
			Context context = new InitialContext();
			connectionFactory = (ConnectionFactory) context.lookup("connectionFactoryName");
			connection = connectionFactory.createConnection();
			connection.start();
			session=connection.createSession(useTransaction, Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue("MyQueue");
			consumer=session.createConsumer(destination);
			message=(TextMessage)consumer.receive();
			System.out.println("Received message: "+message);
		}catch(NamingException e) {
			e.printStackTrace();
		}catch(JMSException e) {
			e.printStackTrace();
		}finally {
			try {
				consumer.close();
				session.close();
				connection.close();
			}catch (JMSException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
