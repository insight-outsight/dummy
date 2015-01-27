package javalanguage.io_socket.socket;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 *  java 的zero copy多在网络应用程序中使用。Java的libaries在linux和unix中支持zero copy，关键的api是java.nio.channel.FileChannel的
 *	transferTo()，transferFrom()方法。我们可以用这两个方法来把bytes直接从调用它的channel传输到另一个writable byte channel，中间不会
 *	使data经过应用程序，以便提高数据转移的效率。
 *
 * @author root
 *
 */
public class NIOTransferToClient {
	
	public static void main(String[] args) throws IOException{
		NIOTransferToClient sfc = new NIOTransferToClient();
		sfc.testSendfile();
	}
	public void testSendfile() throws IOException {
	    String host = "localhost";
	    int port = 9026;
	    SocketAddress sad = new InetSocketAddress(host, port);
	    SocketChannel sc = SocketChannel.open();
	    sc.connect(sad);
	    sc.configureBlocking(true);

	    String fname = NIOTransferToClient.class.getResource("").getPath()+"msg.txt";
	    long fsize = 183678375L, sendzise = 4094;
	    
	 
	    try(FileInputStream fis = new FileInputStream(fname);
	    	FileChannel fc = fis.getChannel();	){
	        long start = System.currentTimeMillis();
		    long nsent = 0, curnset = 0;
		    curnset =  fc.transferTo(0, fsize, sc);
		    System.out.println("total bytes transferred--"+curnset+" and time taken in MS--"+(System.currentTimeMillis() - start));
		    //fc.close();
	    };

	  }


}
