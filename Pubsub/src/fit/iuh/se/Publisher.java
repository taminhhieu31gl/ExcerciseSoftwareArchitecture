package fit.iuh.se;

import javax.jms.DeliveryMode;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.InitialContext;

public class Publisher {
	public static void main(String[] args) throws Exception
    {
		
       InitialContext ctx = new InitialContext();                                                                 
       Topic topic = (Topic) ctx.lookup("MyTopic");                                                                         
       TopicConnectionFactory connFactory = (TopicConnectionFactory) ctx.
           lookup("connectionFactoryName2");
                                     
       TopicConnection topicConn = connFactory.createTopicConnection();

       TopicSession topicSession = topicConn.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
                                                                          
       TopicPublisher topicPublisher = topicSession.createPublisher(topic);

       TextMessage message = topicSession.createTextMessage();
       message.setText("Hello World");
                                                                           
       topicPublisher.publish(message);

       System.out.println("Message published: " + message.getText());
       topicConn.close();
    }
}
