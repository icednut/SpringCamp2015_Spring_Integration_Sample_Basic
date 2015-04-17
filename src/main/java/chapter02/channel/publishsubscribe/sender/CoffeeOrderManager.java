package chapter02.channel.publishsubscribe.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author wglee21g@gmail.com
 */
@Component
public class CoffeeOrderManager {
	@Autowired
	private PublishSubscribeChannel messageChannel;

	public void orderCoffee(String coffeeName) {
		Message<String> message = MessageBuilder.withPayload(coffeeName).build();
		messageChannel.send(message);
	}
}