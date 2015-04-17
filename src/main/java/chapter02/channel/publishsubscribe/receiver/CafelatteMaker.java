package chapter02.channel.publishsubscribe.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

/**
 * @author wglee21g@gmail.com
 */
@Component
public class CafelatteMaker implements CoffeeMaker {
	@Autowired
	private PublishSubscribeChannel messageChannel;

	@Override
	public void coffeeOrderListening() {
		messageChannel.subscribe(new MessageHandler() {
			@Override
			public void handleMessage(Message<?> message) throws MessagingException {
				String coffeeName = (String) message.getPayload();
				System.out.println("*** [CafelatteMaker] " + coffeeName + " order received!");

				if (isThisMake(coffeeName)) {
					System.out.println("***** " + coffeeName + " make complete!");
				}
			}
		});
	}

	@Override
	public boolean isThisMake(String coffeeName) {
		if (coffeeName.equals("Cafelatte")) {
			return true;
		}
		return false;
	}
}
