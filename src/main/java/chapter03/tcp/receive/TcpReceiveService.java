package chapter03.tcp.receive;

/**
 * @author wglee21g@gmail.com
 */
public class TcpReceiveService {
	public void receive(byte[] message) {
		String resultMessage = new String(message);
		System.out.println(resultMessage);
	}
}
