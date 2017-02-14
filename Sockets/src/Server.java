import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main (String[] args){
		
		ServerSocket server = null;
		Socket client = null;

		try {
			
			server = new ServerSocket(9999);
			
			//while(true){
				client = server.accept();
				new ServerThread(client).start();
			//}
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
}
