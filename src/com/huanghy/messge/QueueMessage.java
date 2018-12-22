package com.huanghy.messge;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * <pre>
 *     maven工程依赖
 *      <dependency>
            <groupId>org.apache.activemq</groupId>
            <artifactId>activemq-all</artifactId>
            <version>5.7.0</version>
        </dependency>
 *</pre>

 */

public class QueueMessage {

    public static void main(String[] args) {
        try {
//            testMQProducerQueue();
            TestMQConsumerQueue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * queue的发送代码
     *      将消息发送出去，会展示在管理台中queue里面，但是只发送上去了，没有接收的话，消息不算完全发送出去
     * @throws Exception
     */
    public static void testMQProducerQueue() throws Exception{
        //1、创建工厂连接对象，需要制定ip和端口号
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        //2、使用连接工厂创建一个连接对象
        Connection connection = connectionFactory.createConnection();
        //3、开启连接
        connection.start();
        //4、使用连接对象创建会话（session）对象
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5、使用会话对象创建目标对象，包含queue和topic（一对一和一对多）
        Queue queue = session.createQueue("test-queue");
        //6、使用会话对象创建生产者对象
        MessageProducer producer = session.createProducer(queue);
        //7、使用会话对象创建一个消息对象
        TextMessage textMessage = session.createTextMessage("hello!test-queue");
        //8、发送消息
        producer.send(textMessage);
        //9、关闭资源
        producer.close();
        session.close();
        connection.close();
    }

    /**
     * queue的接收代码
     *      接收queue消息，控制台输出hello!test-queue
     *      queue发送和接收是一套代码，只发送没接收不行，发送了需要有客户端去接收才行
     * @throws Exception
     */
    public static void TestMQConsumerQueue() throws Exception{
        //1、创建工厂连接对象，需要制定ip和端口号
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        //2、使用连接工厂创建一个连接对象
        Connection connection = connectionFactory.createConnection();
        //3、开启连接
        connection.start();
        //4、使用连接对象创建会话（session）对象
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5、使用会话对象创建目标对象，包含queue和topic（一对一和一对多）
        Queue queue = session.createQueue("test-queue");
        //6、使用会话对象创建生产者对象
        MessageConsumer consumer = session.createConsumer(queue);
        //7、向consumer对象中设置一个messageListener对象，用来接收消息
        consumer.setMessageListener(new MessageListener() {

            @Override
            public void onMessage(Message message) {
                // TODO Auto-generated method stub
                if(message instanceof TextMessage){
                    TextMessage textMessage = (TextMessage)message;
                    try {
                        System.out.println(textMessage.getText());
                    } catch (JMSException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        });
        //8、程序等待接收用户消息
        System.in.read();
        //9、关闭资源
        consumer.close();
        session.close();
        connection.close();
    }

}
