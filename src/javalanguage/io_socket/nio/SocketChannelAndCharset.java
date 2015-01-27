package javalanguage.io_socket.nio;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.net.InetSocketAddress;
import java.io.IOException;
/**
 * 利用SocketChannel进行套接字通讯，并设置Charset以支持汉字
 * @author Administrator
 *
 */
public class SocketChannelAndCharset {

	private Charset charset = Charset.forName("GBK");// 创建GBK字符集
	private SocketChannel channel;

	public void readHTMLContent() {
		try {
			InetSocketAddress socketAddress = new InetSocketAddress(
					"www.baidu.com", 80);
			// 打开连接
			channel = SocketChannel.open(socketAddress);
			// 发送请求，使用GBK编码
			channel.write(charset.encode("GET " + "/ HTTP/1.1" + "\r\n\r\n"));
			// 读取数据
			ByteBuffer buffer = ByteBuffer.allocate(1024);// 创建1024字节的缓冲
			while (channel.read(buffer) != -1) {
				buffer.flip();// flip方法在读缓冲区字节操作之前调用。
				System.out.println(charset.decode(buffer));
				// 使用Charset.decode方法将字节转换为字符串
				buffer.clear();// 清空缓冲
			}
		} catch (IOException e) {
			System.err.println(e.toString());
		} finally {
			if (channel != null) {
				try {
					channel.close();
				} catch (IOException e) {
				}
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new SocketChannelAndCharset().readHTMLContent();
	}

}
