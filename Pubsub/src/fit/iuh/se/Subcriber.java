package fit.iuh.se;

import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.InitialContext;

public class Subcriber {
	public static void main(String[] args) throws Exception {
		InitialContext ctx = new InitialContext();

		Topic topic = (Topic) ctx.lookup("MyTopic");

		TopicConnectionFactory connFactory = (TopicConnectionFactory) ctx.lookup("connectionFactoryName2");

		TopicConnection topicConn = connFactory.createTopicConnection();
		TopicSession topicSession = topicConn.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

		TopicSubscriber topicSubscriber = topicSession.createSubscriber(topic);

		topicConn.start();

		TextMessage message = (TextMessage) topicSubscriber.receive();

		System.out.println("Message received: " + message.getText());
		topicConn.close();
	}
}
