package chapter02.channel.publishsubscribe.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.awt.*;
import java.net.URI;

/**
 * @author wglee21g@gmail.com
 */
@Component
public class AmericanoMaker implements CoffeeMaker {
	@Autowired
	private PublishSubscribeChannel messageChannel;

	@Override
	public void coffeeOrderListening() {
		messageChannel.subscribe(new MessageHandler() {
			@Override
			public void handleMessage(Message<?> message) throws MessagingException {
				String coffeeName = (String) message.getPayload();
				System.out.println("*** [AmericanoMaker] " + coffeeName + " order received!");

				if (isThisMake(coffeeName)) {
					System.out.println("***** " + coffeeName + " make complete!");
				}
			}
		});

		RestTemplate restTemplate = new RestTemplate();
		String uri = "http://example.com/point/{id}";
		UriComponents uriComponents =
				UriComponentsBuilder.fromUriString(uri)
						.build()
						.expand("41")
						.encode();
		URI url = uriComponents.toUri();
		Point point = restTemplate.getForObject(url, Point.class);
	}

	@Override
	public boolean isThisMake(String coffeeName) {
		if (coffeeName.equals("Americano")) {
			return true;
		}
		return false;
	}

	private class GetMethod {
		public GetMethod(String url) {
		}

		public byte[] getResponseBody() {
			return new byte[0];
		}

		public void releaseConnection() {
		}
	}

	private class HttpClient {
		public int executeMethod(GetMethod method) {
			return 0;
		}
	}

	private class HttpStatus {
		public static final int SC_OK = 1;
	}
}
