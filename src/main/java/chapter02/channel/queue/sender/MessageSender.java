package chapter02.channel.queue.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author wglee21g@gmail.com
 */
@Component
public class MessageSender {
	@Autowired
	private QueueChannel messageChannel;

	public void sendMessage(String messageContent) {
		Message<String> message = MessageBuilder.withPayload(messageContent).build();
		messageChannel.send(message);
	}
}
