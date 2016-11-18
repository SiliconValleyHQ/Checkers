package Server;

import java.io.*;
import java.net.*;

/**
 * Created by Bror on 18.11.2016.
 */

public class Server {

    private ServerSocket server;

    public Server(String[] args) throws IOException{
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(4444);
        } catch (IOException e) {
            System.err.println("Ingen forbindelse ved port 4444");
            System.exit(1);
        }

        try {
            Socket socket;
            System.out.println("Venter på spiller...");
            while ((socket=server.accept())!=null) {
                System.out.print("Ny spill forespørsel");
                new SpillerBehandler(socket).start();
            }
        } catch (IOException e) { // Husk å sette inn nummerkode i stede for e
            e.printStackTrace();
        }
    }
}