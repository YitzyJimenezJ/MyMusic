import com.sun.org.apache.xpath.internal.objects.XString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class main{
    //public static void main(String[] args){
    //ManejadorCanciones manejadorCanciones = new ManejadorCanciones();
    //manejadorCanciones.guardarCancion("Prueba", "genero", "artista", "album", "letra", 20);
    public void iniciarServidor(String[] args){
        Servidor server = new Servidor(3333);
        try {
            ServerSocket = new  ServerSocket(3333);//para abrir el socket

            System.out.println("Servidor Iniciado");
            socket = serverSocket.accept();
            System.out.printf("Cliente conectado");
            //os = new ObjectOutputStream(socket.getInputStream());
            //is = new ObjectOutputStream(socket.getInputStream());

            //Para leer lo que escriba el usuario
            BufferedReader brRequest = new BufferedReader(new InputStreamReader(System.in));
            //para imprimir datos del servidor
            PrintStream toServer = new PrintStream(clientSocket.getOutputStream());
            //Para leer lo que envie el servidor
            InputStream stream = clientSocket.getInputStream();
            //mensaje para el cliente
            System.out.println("Client> Introduzca expresión matematica ");
            //captura comando escrito por el usuario
            String request = brRequest.readLine();
            //manda al servidor
            toServer.println(request);
            //lee respuesta del servidor
            byte[] bytes = new byte[256];
            stream.read(bytes,0,256);
            //convierte a string
            String received = new String(bytes,"UTF-8");
            //imprime en pantalla
            System.out.println("Server> " + request + " = " + received.trim());



        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static Server getServer(){
        if (Object.equals(Servidor,null)){
            Servidor = new Server();
        }
        return Servidor;
    }

    //}
}
