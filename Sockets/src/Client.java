import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
	
	public static void main(String[] args){
		
		try{
			Socket client = new Socket(InetAddress.getLocalHost(),9999);
			if(client.isConnected()){
				System.out.println("Client ist verbunden.");
			}
			
			PrintWriter p = new PrintWriter(client.getOutputStream());
			p.println("Das ist die Nachricht vom Client");
			p.flush();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
