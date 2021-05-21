package Task1;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server extends Application {
    private List<ServerClient> client = new ArrayList<>();
    private static TextArea chatInterface = new TextArea("MultiThreadServer started at " + new Date() + "\n");
    
    
    public void start(Stage serverStage) {
    	 	    	
        new Thread(new setupServer()).start();
        
        /** padding **/
        Scene scene = new Scene(chatInterface, 600,500);
        
        /** making the stage **/
        chatInterface.setEditable(false);
        serverStage.setTitle("Multi-threaded Server");
        serverStage.setScene(scene);
        serverStage.show();
    }

    class setupServer implements Runnable {
        public void run() {
            try {
                @SuppressWarnings("resource")
				ServerSocket serverSocket = new ServerSocket(8080);
                chatInterface.appendText("Connection from  " + serverSocket + " at " + new Date() + "\n");
                
                /** loop over messages **/
                while (true) {
                    Socket s = serverSocket.accept();
                    client.add(new ServerClient(s));
                }
            } 
            
            catch(IOException e) {
                System.out.println("Error.");
            }
        }
    }

    class ServerClient implements Runnable {
        private Socket socket;
        private PrintWriter Message;

        ServerClient(Socket socket) {
        	   this.socket = socket;
        	   Thread thread = new Thread(this);
        	   thread.start();
        }

        public void run() {
            try {
                @SuppressWarnings("resource")
				Scanner fromClient = new Scanner(socket.getInputStream());
                Message = new PrintWriter(socket.getOutputStream());

                chatInterface.appendText("Connection from " + socket + " at " + new Date() + "\n");

                while(true) {
                    String messagesFromClients = fromClient.nextLine();
                    chatInterface.appendText(messagesFromClients + "\n");

                    for(ServerClient message : client) {
                    	 Message.println(message);
                    	 Message.flush();
                    }
                }
            } catch (IOException e) {
            	e.printStackTrace();
            }
            catch (NoSuchElementException e) {};
        }
    }

    public static void main(String[] args) { 
    	launch(args); 
    	}

}