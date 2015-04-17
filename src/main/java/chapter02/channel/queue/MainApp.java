package chapter02.channel.queue;

import chapter02.channel.queue.receiver.MessageReceiver;
import chapter02.channel.queue.sender.MessageSender;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangeun.lee@sk.com
 */
public class MainApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/chapter02/queue-channel-context.xml");
		MessageSender messageSender = context.getBean("messageSender", MessageSender.class);
		MessageReceiver messageReceiver = context.getBean("messageReceiver", MessageReceiver.class);
		
		messageSender.sendMessage("Hello World!");
		messageReceiver.receiveMessage();
	}
}