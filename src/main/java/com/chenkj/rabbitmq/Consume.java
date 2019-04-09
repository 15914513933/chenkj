package com.chenkj.rabbitmq;

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class Consume {
	public final static String QUEUE_NAME="rabbitMQ.test.queue";
	public final static String EXCHANGE_NAME="rabbitMQ.test.exchange";

    public static void main(String[] args) throws Exception {
        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置RabbitMQ相关信息
        factory.setHost("192.168.10.14");
        factory.setUsername("chenkj");
        factory.setPassword("123456");
        factory.setVirtualHost("/");
        factory.setPort(5672);
        //创建一个新的连接
        Connection connection = factory.newConnection();
        //创建一个通道
        Channel channel = connection.createChannel();
        channel.basicQos(64);
        Consumer consumer = new DefaultConsumer(channel){
        	public void handleDelivery(String consumerTag,
        			Envelope envelope,AMQP.BasicProperties properties,byte[] body){
        		System.out.println("recv message:"+new String(body));
        	}
        	
        };
        while(true){
        	channel.basicConsume(QUEUE_NAME, consumer);
        }
        //关闭通道和连接
        //channel.close();
        //connection.close();
    }
}
