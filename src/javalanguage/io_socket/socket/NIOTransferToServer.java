package javalanguage.io_socket.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;


/**
 *  java 的zero copy多在网络应用程序中使用。Java的libaries在linux和unix中支持zero copy，关键的api是java.nio.channel.FileChannel的
 *	transferTo()，transferFrom()方法。我们可以用这两个方法来把bytes直接从调用它的channel传输到另一个writable byte channel，中间不会
 *	使data经过应用程序，以便提高数据转移的效率。
 *
 * @author root
 *
 */
public class NIOTransferToServer  {
  ServerSocketChannel listener = null;
  protected void mySetup()
  {
    InetSocketAddress listenAddr =  new InetSocketAddress(9026);

    try {
      listener = ServerSocketChannel.open();
      ServerSocket ss = listener.socket();
      ss.setReuseAddress(true);
      ss.bind(listenAddr);
      System.out.println("Listening on port : "+ listenAddr.toString());
    } catch (IOException e) {
      System.out.println("Failed to bind, is port : "+ listenAddr.toString()
          + " already in use ? Error Msg : "+e.getMessage());
      e.printStackTrace();
    }

  }

  public static void main(String[] args)
  {
    NIOTransferToServer dns = new NIOTransferToServer();
    dns.mySetup();
    dns.readData();
  }

  private void readData()  {
	  ByteBuffer dst = ByteBuffer.allocate(4096);
	  try {
		  while(true) {
			  SocketChannel conn = listener.accept();
			  System.out.println("Accepted : "+conn);
			  conn.configureBlocking(true);
			  int nread = 0;
			  while (nread != -1)  {
				  try {
					  nread = conn.read(dst);
				  } catch (IOException e) {
					  e.printStackTrace();
					  nread = -1;
				  }
				  dst.rewind();
			  }
		  }
	  } catch (IOException e) {
		  e.printStackTrace();
	  }
  }
}
