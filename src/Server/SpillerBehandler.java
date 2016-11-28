package server;

import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by Bror on 18.11.2016.
 */

public class SpillerBehandler extends Thread {

    private Socket socket;

    public SpillerBehandler(Socket isocket) {
        socket = isocket;
    }

    public void run() {
        try {
            PrintStream output = new PrintStream(socket.getOutputStream());
            output.println("itzzz workzzz");
        } catch (Exception e) {
            System.err.print("Melding ikke motatt");
        }
    }

}