import java.net.*;
import java.io.*;
public class chatserver
{
	public static void main(String args[])throws Exception
	{
		ServerSocket ss=new ServerSocket(5000);
		System.out.println("server is running");
		Socket s=ss.accept();
		
		DataInputStream din=new DataInputStream(s.getInputStream());
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String str=" ";
		String strser=" ";
	
		while(! str.equals("stop"))
		{
			str=din.readUTF();
			System.out.println("client:"+str);
			System.out.println("\n server Enter Message:");
			strser=br.readLine();
			dout.writeUTF(strser);
			dout.flush();
		}
	din.close();
	dout.close();
	s.close();
	ss.close();
	System.out.println("server closed");
}
}
