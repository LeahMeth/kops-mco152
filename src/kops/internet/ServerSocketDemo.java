package kops.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;



//read one line and send a message
public class ServerSocketDemo {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(52746);
				
		Socket socket = serverSocket.accept();
		
		InputStream in = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String response = reader.readLine();
		
		System.out.println("Response");
		System.out.println(response);
		
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		//NEED the newline
		out.write("How are you?\n");
		out.flush();
		
		
	
		

		serverSocket.close();
	}

}
