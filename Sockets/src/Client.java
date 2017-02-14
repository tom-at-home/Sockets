import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
	
	public static void main(String[] args){

		BufferedReader in = null;
		Socket client = null;
		PrintWriter out = null;
		
		try{
			client = new Socket(InetAddress.getLocalHost(),9999);
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			if(client.isConnected()){
				System.out.println("Client ist verbunden.");
			}
			
			out = new PrintWriter(client.getOutputStream());	

			//while(true) {
				
				while(in.ready()){
					String str = in.readLine();
					System.out.println(str);
					/*if(str.equals("\r\n")){
						break;
					}*/
					
				}

				out.println("Das ist die Nachricht vom Client");
				out.flush();			
											
				if(out.checkError()){
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
