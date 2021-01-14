package chat;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private ObjectOutputStream output;
    private ObjectInputStream input;

    private ServerSocket server;
    private Socket connection;

    String AknietPublicIPAddress = "178.91.241.9";
    String move = "move";

    public Server() {
        String moveBack=runServer(move);
    }

    public String runServer(String move) {
        try {
            server = new ServerSocket(12345, 100);
            String end = "";
            while (!end.equals("END")) {
                try {
                    showMessage("before connection server");
                    connection = server.accept();
                    showMessage("connection server");
                    connection.getInetAddress().getHostAddress();

                    output = new ObjectOutputStream(connection.getOutputStream());
                    output.flush();

                    input = new ObjectInputStream(connection.getInputStream());
                    showMessage("\ngot I/O streams\n");

                    String message = "Connection Successfull";
                    sendMessage(message);
                    do {
                        try {
                            message = (String) input.readObject();
                            showMessage("\n" + message);

                            message = move;
                            sendMessage(message);
                            if (message.equals("END")) {
                                end = message;
                                message = "TERMINATE";
                            }
                        } catch (ClassNotFoundException classNotFoundException) {
                            showMessage("ERROR CNFE SERVER");
                        }
                    }
                    while (!message.equals("TERMINATE"));
                } catch (EOFException eofexception) {
                    showMessage("ERROR EOF SERVER");
                } finally {
                    try {
                        showMessage("close server start");
                        output.close();
                        input.close();
                        connection.close();
                        showMessage("close server end");
                    } catch (IOException ioexception) {
                        ioexception.printStackTrace();
                    }
                }
            }
        } catch (IOException ioexception) {
            ioexception.printStackTrace();
        }
        //
        return null;
    }

    public void sendMessage(String message) {
        try {
            output.writeObject("SERVER>>> " + message);
            output.flush();
            showMessage("\nSERVER>>> " + message);
        } catch (IOException ioexception) {
            ioexception.printStackTrace();
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}