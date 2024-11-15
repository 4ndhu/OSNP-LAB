import java.net.*;
import java.io.*;
public class chatclient
{
	public static void main(String args[])throws Exception
	{
		Socket s=new Socket("localhost",5000);
		
		DataInputStream din=new DataInputStream(s.getInputStream());
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String str="";
		String strser="";
		while(!str.equals("stop"))
		{
			System.out.println("\nEnter Message:");
			str=br.readLine();
			dout.writeUTF(str);
			dout.flush();
			
			strser=din.readUTF();
			System.out.println("Server :"+strser);
}
dout.close();
din.close();
s.close();
}
}
