import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ServerThread extends Thread{
	
	Socket c = null;
	//Socket client = null;	
	BufferedReader br = null;
	PrintWriter pw = null;
	
	public ServerThread(Socket s){
		this.c = s;
	}
	
	public void run(){
		
		try{
			
			System.out.println("Server hat eine Verbindung akzeptiert.");
			br = new BufferedReader(new InputStreamReader(c.getInputStream()));
			//while(true) {
				while(br.ready()){
					String str = br.readLine();
					System.out.println(str);
					/*if(s.equals("\r\n")){
						break;
					}*/
				}
				
			pw = new PrintWriter(c.getOutputStream());
			String header = "HTTP/1.1 200 OK\r\nContent-type: text/html\r\n\r\n";
			String content = "<html><body><h1>Hallo Server...</h1></body></html>";
			pw.println(header + content);
			pw.flush();
			c.close();
			//}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
