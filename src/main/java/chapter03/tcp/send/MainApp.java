package chapter03.tcp.send;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wglee21g@gmail.com
 */
public class MainApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/chapter03/tcp-send-context.xml");
		TcpSendGateway sendGateway = context.getBean("sendGateway", TcpSendGateway.class);

		sendGateway.send("Hello World!");
	}
}
