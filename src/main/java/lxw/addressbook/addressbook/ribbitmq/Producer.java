package lxw.addressbook.addressbook.ribbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

// 生产者
public class Producer {
    private final static String QUEUE_NAME = "hello1";

    public static void main(String[] args) throws IOException, TimeoutException {


        ConnectionFactory connectionFactory = new ConnectionFactory();
//        connectionFactory.setHost("49.235.228.207");
        connectionFactory.setHost("49.235.228.207");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        String message = "Hello World";

        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println("发送消息：" + message);

        try {
            channel.close();
            connection.close();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
