package chapter02.channel.direct;

import chapter02.channel.direct.sender.MessageSender;
import chapter02.channel.direct.receiver.MessageReceiver;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangeun.lee@sk.com
 */
public class MainApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/chapter02/direct-channel-context.xml");
		MessageSender messageSender = context.getBean("messageSender", MessageSender.class);
		MessageReceiver messageReceiver = context.getBean("messageReceiver", MessageReceiver.class);

		messageReceiver.receiveMessage();
		messageSender.sendMessage("Hello World!");
	}
}
