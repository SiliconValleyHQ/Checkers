package server;

import java.io.*;
import java.net.*;

/**
 * Created by Bror on 18.11.2016.
 */

public class Server {

    public Server() throws IOException{
        ServerSocket serverSocket = null;
        int port = 28702;
        try {
            serverSocket = new ServerSocket(port);
            Socket socket;
            System.out.println("Venter på spillere på port " + port + "...");
            while ((socket = serverSocket.accept())!=null) {
                System.out.println("Ny spiller forespørsel");
                new SpillerBehandler(socket).start();
            }
        } catch (Exception e) {
            System.err.println("Ingen forbindelse ved port " + port + "...");
            e.printStackTrace();
        }
    }

}
