package kops.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//send a message and read a response
public class ClientSocketDemo {

	public static void main(String[] args)throws IOException {
		String serverIP = "192.168.117.38";
		Socket socket = new Socket(serverIP, 52746);
		
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		out.write("HELLO libby!\n");
		out.flush();
		
		
		InputStream in = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String response = reader.readLine();
		
		System.out.println("Response");
		System.out.println(response);
		
		socket.close();
		
		
	}

}
