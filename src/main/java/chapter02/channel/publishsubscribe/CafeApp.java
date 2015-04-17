package chapter02.channel.publishsubscribe;

import chapter02.channel.publishsubscribe.receiver.AmericanoMaker;
import chapter02.channel.publishsubscribe.receiver.CafelatteMaker;
import chapter02.channel.publishsubscribe.receiver.MilkteaMaker;
import chapter02.channel.publishsubscribe.sender.CoffeeOrderManager;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wglee21g@gmail.com
 */
public class CafeApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/chapter02/publish-subscribe-channel-context.xml");
		CoffeeOrderManager coffeeOrderManager = context.getBean("coffeeOrderManager", CoffeeOrderManager.class);
		AmericanoMaker americanoMaker = context.getBean("americanoMaker", AmericanoMaker.class);
		CafelatteMaker cafelatteMaker = context.getBean("cafelatteMaker", CafelatteMaker.class);
		MilkteaMaker milkteaMaker = context.getBean("milkteaMaker", MilkteaMaker.class);
		
		americanoMaker.coffeeOrderListening();
		cafelatteMaker.coffeeOrderListening();
		milkteaMaker.coffeeOrderListening();
		
		coffeeOrderManager.orderCoffee("Americano");
		System.out.println("");
		coffeeOrderManager.orderCoffee("Milktea");
	}
}
