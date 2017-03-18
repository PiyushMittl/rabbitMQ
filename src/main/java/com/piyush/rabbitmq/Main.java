package com.piyush.rabbitmq;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import com.piyush.rabbitmq.producer.Producer;
import com.piyush.rabbitmq.queueconsumer.QueueConsumer;

public class Main {
	public Main() throws Exception {

		QueueConsumer consumer = new QueueConsumer("QueueByPiyush");
		Thread consumerThread = new Thread(consumer);
		consumerThread.start();

		Producer producer = new Producer("QueueByPiyush");

		for (int i = 0; i < 100000; i++) {
			HashMap message = new HashMap();
			message.put("message number", i);
			producer.sendMessage(message);
			System.out.println("Message Number " + i + " sent.");
		}
	}

	/**
	 * @param args
	 * @throws SQLException
	 * @throws IOException
	 */
	public static void main(String[] args) throws Exception {
		new Main();
	}
}