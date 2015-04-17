package chapter02.channel.queue.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author wglee21g@gmail.com
 */
@Component
public class MessageReceiver {
	@Autowired
	private QueueChannel messageChannel;

	public void receiveMessage() {
		Message<String> message = (Message<String>) messageChannel.receive();
		String messagePayload = message.getPayload();

		System.out.println(messagePayload);
	}
}
