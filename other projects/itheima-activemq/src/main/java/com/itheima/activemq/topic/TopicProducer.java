package com.itheima.activemq.topic;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

public class TopicProducer {

	// 发送topic
	@Test
	public void send() throws Exception {
		// 1.创建连接的工厂 指定MQ服务器的地址
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.25.130:61616");
		// 2.获取连接
		Connection connection = connectionFactory.createConnection();
		// 3.开启连接
		connection.start();
		// 4.根据连接对象创建session (提供了操作activmq的方法)
		// 第一个参数：表示是否开启分布式事务（JTA） 一般就是false :表示不开启。 只有设置了false ,第二个参数才有意义。
		// 第二个参数：表示设置应答模式 自动应答和手动应答 。使用的是自动应答
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		// 5.根据session创建目的地（destination）topic
		Topic topic = session.createTopic("topic-test");
		// 6.创建生产者
		MessageProducer producer = session.createProducer(topic);
		// 7.构建消息对象
		TextMessage message = session.createTextMessage("topic关二哥是否安在");
		// 8.通过生产者发送消息
		producer.send(message);
		// 9.关闭资源
		producer.close();
		session.close();
		connection.close();
	}
}
