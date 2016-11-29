package server;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * Created by Bror on 18.11.2016.
 */

public class Server {

    private String ip = "localhost";
    private int port = 28702;
    private Scanner scanner = new Scanner(System.in);
    private Thread thread;

    private Socket socket;
    private DataOutputStream dos;
    private DataInputStream dis;

    private ServerSocket serverSocket;

    public Server() {
        System.out.println("Skriv inn ip-adressen");
        ip = scanner.nextLine();
        System.out.println("skriv inn en port");
        port = scanner.nextInt();
        while (port < 1 || port > 66666) {
            System.out.println("Porten du skrev inn er ikke en gyldig port mellom 1 og 66666");
            port = scanner.nextInt();
        }
        serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Venter på spillere på port " + port + "...");
            while ((socket = serverSocket.accept())!=null) {
                System.out.println("Ny spiller forespørsel");
                new SpillerBehandler(socket).start();
            }
        } catch (Exception e) {
            System.err.println("Port " + port + " er opptatt...");
            e.printStackTrace();
        }

    }

    private void lytterEtterAnnenServer() {
        Socket socket = null;
        try {
            socket = serverSocket.accept();
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*public Server() throws IOException{
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
    }*/

}