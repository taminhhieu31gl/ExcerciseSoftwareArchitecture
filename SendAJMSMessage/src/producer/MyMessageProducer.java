package producer;


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
	public static void main(String[] args)  {
		ConnectionFactory connectionFactory = null;
		Connection connection = null;
		Session session = null;
		Destination destination = null;
		MessageProducer producer = null;
		Message message = null;
		boolean useTransaction = false;
		try {
			//Thiết lập kết nối tới JMS provider
			//thông tin cần thiết trong file jndi.properties
			Context context = new InitialContext();
			connectionFactory = (ConnectionFactory) context.lookup("connectionFactoryName");
			connection = connectionFactory.createConnection();
			connection.start();
			session = connection.createSession(useTransaction, Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue("MyQueue");
			producer = session.createProducer(destination);
			message = session.createTextMessage("testtttttt");
			producer.send(message);
		}catch(JMSException e){
			e.printStackTrace();
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