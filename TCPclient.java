import java.io.*;
import java.net.*;
import java.util.*;

public class TCPclient {
    private static Scanner sc;
	public static void main(String[] args) throws IOException{
		System.out.println("Client started...");
		Socket socket = new Socket("127.0.0.1",4444);
		System.out.println("Client connected..");
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
		while(true) {
			sc = new Scanner(System.in);
			String msg = sc.nextLine();
			if(msg.equals("exit")) {
				break;
			}
			// send to server
			oos.writeObject(msg);
			try {
				Object fromServer = ois.readObject();
				System.out.println("From Server : " + (String) fromServer);
			} catch (ClassNotFoundException e) {
				// TODO: handle exception
               e.printStackTrace();				
			}
		}
		socket.close();
	}
}