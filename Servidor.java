
/** 
import java.net.*;
import java.io.*;

import java.nio.charset.StandardCharsets;


public class Servidor {
    private Socket socket = null;
    private ServerSocket servidor = null;
    private DataInputStream mensajeCliente = null;

    public Servidor(int puerto){
        try {
            servidor = new ServerSocket(puerto);
            System.out.println("Waiting for a client ...");
            socket = servidor.accept();
            System.out.println("Cliente conectado");
            
            mensajeCliente = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String lineaMensajeCliente = "";
            
            while (!lineaMensajeCliente.equals("FIN")) {
                try {
                    lineaMensajeCliente = mensajeCliente.readUTF();
                    System.out.println("asd");
                }
                catch(IOException i) {}
            } 

            socket.close();
            mensajeCliente.close();
        }
        catch(IOException i) {}
    }
}
*/
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerConnection extends Thread{

    private Socket socket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private boolean shouldRun = true;



    public ServerConnection(Socket socket) {
        super("ServerConnectionThread");
        this.socket = socket;
        

    }

    public void sendStringToClient(String sText) {
        try {
            outputStream.writeUTF(sText);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
            System.out.println("cliente conectado");
            //sendStringToClient("1,2,3#1,2,3");

            while (shouldRun) {
                while (inputStream.available() == 0) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                String sTextIn = inputStream.readUTF();
                sendStringToClient(sTextIn);
            }
            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }
}
