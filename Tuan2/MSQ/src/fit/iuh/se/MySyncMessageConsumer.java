package fit.iuh.se;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class MySyncMessageConsumer {
	public static void main(String[] args) {
		ConnectionFactory conectionFactory = null;
		Connection connection = null;
		Destination destination = null;
		Session session = null;
		MessageConsumer consumer = null;
		Message message = null;
		boolean useTransaction = false;
		try {
			Context context = new InitialContext();
			conectionFactory = (ConnectionFactory) context.lookup("connectionFactoryName");
			connection = conectionFactory.createConnection();
			connection.start();
			session = connection.createSession(useTransaction, Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue("MyQueue");
			consumer = session.createConsumer(destination);
			message = (TextMessage) consumer.receive();
			System.out.println("Da nhan duoc message la: "+message);
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				consumer.close();
				session.close();
				connection.close();
			} catch (JMSException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
