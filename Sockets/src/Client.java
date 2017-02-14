import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
	
	public static void main(String[] args){

		BufferedReader br = null;
		Socket client = null;
		PrintWriter p = null;
		
		try{
			client = new Socket(InetAddress.getLocalHost(),9999);
			br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			if(client.isConnected()){
				System.out.println("Client ist verbunden.");
			}
			
			p = new PrintWriter(client.getOutputStream());

			//while(true) {
				
				while(br.ready()){
					String s = br.readLine();
					System.out.println(s);
					/*if(s.equals("\r\n")){
						break;
					}*/
					
				}
				
				p.println("Das ist die Nachricht vom Client");
				p.flush();
							
				if(p.checkError()){
					//break;
					client.close();
					System.out.println("Closing connection");
					System.exit(1);
				}
					
			//}
			
			//client.close();	
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
