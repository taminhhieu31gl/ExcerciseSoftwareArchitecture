package fit.iuh.se;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MyQSender {
	private QueueConnection qConnect = null;
	private QueueSession qSession = null;
	private Queue queue = null;
	public MyQSender() throws NamingException, JMSException {
		Context ctx = new InitialContext();
		QueueConnectionFactory qFactory = (QueueConnectionFactory)ctx.lookup("cfName");
		qConnect = qFactory.createQueueConnection();
		qSession = qConnect.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		qConnect.start();
	}
	public static void main(String[] args) throws NamingException, JMSException {
		SinhVien sv = new SinhVien("17087871","Tạ Minh Hiếu", 21);
		MyQSender sender =  new MyQSender();
		sender.sendObjectMessage(sv);
		sender.exit();
	}
	private void exit() throws JMSException {
		// TODO Auto-generated method stub
		qSession.close();
		qConnect.close();
		
	}
	private void sendObjectMessage(SinhVien sv) throws JMSException{
		// TODO Auto-generated method stub
		ObjectMessage msg = qSession.createObjectMessage();
		QueueSender qSender = qSession.createSender(queue);
		msg.setObject(sv);
		qSender.send(msg);
	}
}
