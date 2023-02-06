/*** Server side ***/

package project;

import java.io.*;
import java.net.*;
  
public class ServerTCP {
    
    public ServerTCP(int port)
    {
        ServerSocket server = null;
  
        try {
              server = new ServerSocket(port);
            while (true) {
                Socket client = server.accept();
                System.out.println("New client connected " + client.getInetAddress().getHostAddress());
                ClientHandler clientSock = new ClientHandler(client);
                new Thread(clientSock).start();
            }
        }
        catch (IOException e) {}
        finally {
            if (server != null) {
                try {
                    server.close();
                }
                catch (IOException e) {}
            }
        }
    }
    
    private static class ClientHandler implements Runnable {
        
        private final Socket clientSocket;
  
        public ClientHandler(Socket socket)
        {
            this.clientSocket = socket;
        }
  
        @Override
        public void run()
        {
            BufferedReader in = null;
            PrintWriter out   = null;
           
            try {   
                out = new PrintWriter(clientSocket.getOutputStream(), true);
  
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
  
                int[] FruitsQyt = new int[3];
                String line;
                int i = 0;
                while ((line = in.readLine()) != null) {
                    
                    FruitsQyt[i] = Integer.parseInt(line);
                    i++;
                    System.out.printf("Sent from the client: %s\n", line);
                    
                    if (i == 3)
                    {
                        int apple  = FruitsQyt[0];
                        int banana = FruitsQyt[1];
                        int orange = FruitsQyt[2];
                        int total = apple*20 + banana*30 + orange*10;
                        out.println(total);
                    }
                }                
            }
            catch (IOException e) {}
            finally {
                try {
                    if (out != null) {
                        out.close();
                    }
                    if (in != null) {
                        in.close();
                        clientSocket.close();
                    }
                }
                catch (IOException e) {}
            }
        }
    }
    
    public static void main(String[] args)
    {
        ServerTCP server = new ServerTCP(5000);
    }
}
