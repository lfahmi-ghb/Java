package Task1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JTextField;

public class Client extends Application {
	
    /**  text area  **/
    private static TextArea chatInterface = new TextArea( "Please Enter Your Name Followed by Your Message... \n");
    
    /**  text  feilds  **/
    private static TextField messageField = new TextField();
    private static TextField nameFeild = new TextField();

    /**  lables  **/
    private final Label nameLabel = new Label("       Name:");
    private final Label messageLabel = new Label("       Message:");
    
    /**  buttons  **/
    private final Button sendBtn = new Button("Send");


    private PrintWriter txtMessage;

    
    
    /** start thread **/
    public void start(Stage primaryStage) {
    
    	
    /** boxes **/
        HBox nameBox = new HBox(25, nameLabel, nameFeild);

        HBox sendBtnBox = new HBox(10, messageLabel, messageField, sendBtn );

        HBox setArea = new HBox (chatInterface);
        
        VBox fullBox = new VBox(15, setArea, nameBox, sendBtnBox);
        
        
    /** padding **/
        chatInterface.setPrefHeight(300);
        messageField.setPrefHeight(10);
        messageField.setPrefWidth(200);
        sendBtn.setAlignment(Pos.CENTER);


        Scanner scanner = new Scanner(System.in);

        sendBtn.setOnAction(event -> {
        	
        	txtMessage.println(nameFeild.getText() + ": " + messageField.getText());
        	// flush message everytime a message is sent
        	txtMessage.flush();
            messageField.setText("");
            
            
            primaryStage.setTitle(nameFeild.getText());
        });

        try {
        	
            Socket socket = new Socket("localhost", 8080);
            
            txtMessage = new PrintWriter(socket.getOutputStream());
            
            new Receive(socket);
            
        }
        
        catch(IOException event) {
        	
            System.out.println("Error: " + event.getMessage());
            
        }
        
        
        /** making the stage **/
        Scene scene = new Scene(fullBox, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    class Receive implements Runnable {
        private Socket socket;

        Receive(Socket soc) {
            socket = soc;
            new Thread(this).start();
        }

        public void run() {
            try {
                @SuppressWarnings("resource")
				Scanner Message = new Scanner(socket.getInputStream());
                while(true) {
                    String message = Message.nextLine();
                    chatInterface.appendText(message + "\n");
                }
            } catch (IOException ex) {
                System.out.println("Error from client: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) { 
    	launch(args); 
    	
    }
}