package javalanguage.io_socket.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public final class Handler implements Runnable {
	final SocketChannel socketChannel;
	final SelectionKey selectionKey;
	ByteBuffer input = ByteBuffer.allocate(20);
	ByteBuffer output = ByteBuffer.allocate(10);
	static final int READING = 0, SENDING = 1;
	int state = READING;

	Handler(Selector sel, SocketChannel c) throws IOException {
		socketChannel = c;
		c.configureBlocking(false);
		// Optionally try first read now
		selectionKey = socketChannel.register(sel, 0);
		selectionKey.attach(this);
		selectionKey.interestOps(SelectionKey.OP_READ);
		sel.wakeup();
	}

	boolean inputIsComplete() {
		return false;
	}

	boolean outputIsComplete() {
		return false;
	}

	void process() { 
		/* ... */
	}

	// class Handler continued
	public void run() {
		try {
			if (state == READING)
				read();
			else if (state == SENDING)
				send();
		} catch (IOException ex) { 
			/* ... */
		}
	}

	void read() throws IOException {
		socketChannel.read(input);
		if (inputIsComplete()) {
			process();
			state = SENDING;
			// Normally also do first write now
			selectionKey.interestOps(SelectionKey.OP_WRITE);
		}
	}

	void send() throws IOException {
		socketChannel.write(output);
		if (outputIsComplete())
			selectionKey.cancel();
	}
}