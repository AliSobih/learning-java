/*** Client side ***/

package project;

import java.io.*;
import java.net.*;
 
public class ClientTCP {
    
    public Socket asocket;
    public PrintWriter out;
    public BufferedReader in;
    
    public ClientTCP(int port) throws IOException
    {   
        asocket = new Socket("127.0.0.1", port);
    }

    public void sendData(int price1, int price2, int price3) throws IOException
    {
        out = new PrintWriter(asocket.getOutputStream(), true);

        out.println(price1);
        out.println(price2);
        out.println(price3);
    }
    
    
    public int receiveData() throws IOException
    {
       
        in = new BufferedReader(new InputStreamReader(asocket.getInputStream()));

       
        int totalPrice = Integer.parseInt(in.readLine());
        
       
        return totalPrice;
    }
}
