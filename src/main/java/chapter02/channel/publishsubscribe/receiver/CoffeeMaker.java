package chapter02.channel.publishsubscribe.receiver;

/**
 * @author wglee21g@gmail.com
 */
public interface CoffeeMaker {
	void coffeeOrderListening();

	boolean isThisMake(String coffeeName);
}
