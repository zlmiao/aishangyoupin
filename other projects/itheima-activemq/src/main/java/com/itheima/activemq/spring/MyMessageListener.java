package com.itheima.activemq.spring;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.xml.soap.Text;

/**
 * 消费者  做个监听
 */
public class MyMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        //获取消息
        if(message instanceof TextMessage){
            TextMessage textMessage = (TextMessage)message;
            String text;
            try {
                text = textMessage.getText();
                System.out.println(text);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

}
