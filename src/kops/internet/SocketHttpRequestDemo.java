package kops.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketHttpRequestDemo {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket socket = new Socket("www.google.com", 80);	//port for http= www
		
		String httpRequestString = "GET /index.html\n\n";	//the request 
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		out.write(httpRequestString);
		out.flush();
		
		// read outputstream to the screen
		InputStream in = socket.getInputStream();
		BufferedReader b = new BufferedReader(new InputStreamReader(in));
		String s;
		while((s = b.readLine()) == null){
			System.out.println(s);
		}
		socket.close();
	}

}
