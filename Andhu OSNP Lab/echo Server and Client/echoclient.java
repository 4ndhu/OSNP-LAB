import java.net.*;
import java.io.*;
public class echoclient
{
	public static void main(String args[])throws Exception
	{
		Socket s=new Socket("localhost",8088);
		
		DataInputStream din=new DataInputStream(s.getInputStream());
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String str="";
		while(!str.equals("stop"))
		{
			System.out.println("\nEnter Message:");
			str=br.readLine();
			dout.writeUTF(str);
			dout.flush();
			String str2=din.readUTF();
			System.out.println("Server Echo:"+str2);
}
dout.close();
din.close();
s.close();
}
}
