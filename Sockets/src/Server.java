import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main (String[] args){
		
		ServerSocket server = null;
		Socket client = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			server = new ServerSocket(9999);
			client = server.accept();
			System.out.println("Server hat eine Verbindung akzeptiert.");
			br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			//while(true) {
			while(br.ready()){
				String s = br.readLine();
				System.out.println(s);
				/*if(s.equals("\r\n")){
					break;
				}*/
			}
			//}	
				
			pw = new PrintWriter(client.getOutputStream());
			String header = "HTTP/1.1 200 OK\r\nContent-type: text/html\r\n\r\n";
			String content = "<html><body><h1>Hallo Server...</h1></body></html>";
			pw.println(header + content);
			pw.flush();
			client.close();
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
}
