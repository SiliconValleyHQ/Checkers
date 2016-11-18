package Server;

import java.io.IOException;
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

    public void kjor() throws IOException {
        try {
            PrintStream output = new PrintStream(socket.getOutputStream());
            output.println("<h3>melding mottatt</h3>");
            output.close();
        } catch (Exception e) {
            System.err.print("Melding ikke motatt");
        }
    }
}
