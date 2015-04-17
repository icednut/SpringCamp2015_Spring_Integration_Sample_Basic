package chapter03.tcp.receive;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wglee21g@gmail.com
 */
public class MainApp {
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("/META-INF/chapter03/tcp-receive-context.xml");
	}
}