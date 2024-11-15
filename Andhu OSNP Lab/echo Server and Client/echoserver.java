import java.net.*;
import java.io.*;
public class echoserver
{
	public static void main(String args[])throws Exception
	{
		ServerSocket ss=new ServerSocket(8088);
		System.out.println("server is running");
		Socket s=ss.accept();
		DataInputStream din=new DataInputStream(s.getInputStream());
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());
		String str=" ";
		while(! str.equals("stop"))
		{
			str=din.readUTF();
			System.out.println(" "+str);
			dout.writeUTF(str);
			dout.flush();
		}
din.close();
dout.close();
s.close();
ss.close();
System.out.println("server closed");
}
}
