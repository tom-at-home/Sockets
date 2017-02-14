import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ServerThread extends Thread{
	
	Socket c = null;
	//Socket client = null;	
	BufferedReader in = null;
	PrintWriter out = null;
	
	public ServerThread(Socket s){
		this.c = s;
	}
	
	public void run(){
		
		try{
			
			System.out.println("Server hat eine Verbindung akzeptiert.");
			in = new BufferedReader(new InputStreamReader(c.getInputStream()));
			//while(true) {
				while(in.ready()){
					String str = in.readLine();
					System.out.println(str);
					/*if(s.equals("\r\n")){
						break;
					}*/
				}
				
			out = new PrintWriter(c.getOutputStream());
			String header = "HTTP/1.1 200 OK\r\nContent-type: text/html\r\n\r\n";
			String content = "<html><body><h1>Hallo Client...</h1></body></html>";
			out.println(content);
			out.flush();
			//c.close();
			//}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
