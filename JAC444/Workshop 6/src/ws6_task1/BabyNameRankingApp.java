/**********************************************
Workshop 6
Course:JAC44 - Winter 2021
Last Name: <Fahmi>
First Name: <Lara>
ID: 109742197
Section: NEE
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 2021-02-13
**********************************************/
package ws6_task1;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BabyNameRankingApp extends Application {
	protected paneForm pane = new paneForm();
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception{

			pane.btnSubmit.setOnAction(null);
			
			//*** baby names ranking pane ***/
			VBox vPane = new VBox();
			FlowPane firstPane = new FlowPane(5, 5);
			HBox btnPane = new HBox(10);

			//*** fields ***//
			TextField yearField = new TextField();
			TextField genderField = new TextField();
			TextField nameField = new TextField();
			
			
			//*** pane padding ***/
			firstPane.setPadding(new Insets(30,20,50,20));
			yearField.setPrefColumnCount(25);
			yearField.setPrefSize(200, 10);
			genderField.setPrefSize(30, 10);
			nameField.setPrefSize(200, 10);
			btnPane.setAlignment(Pos.BASELINE_CENTER);
			
			 
			//*** getChildren ***/
			firstPane.getChildren().addAll(new Label("Enter the Year:   "), yearField, new Label("Enter the Name:"), nameField,new Label("Select the Gender:"), genderField );
			btnPane.getChildren().addAll(pane.btnSubmit, pane.btnExit); 
			vPane.getChildren().addAll(firstPane, btnPane);
			
			
			
			
			
			
			
			//*** question screen (2nd screen)***/
			
			
			VBox SecondPane = new VBox();
			HBox resultStringPane = new HBox(10);
			HBox wannaPlayAgainPane = new HBox(10);
			HBox yesNoBtnPane = new HBox(10);
			
			
		
			//*** pane padding ***/
			resultStringPane.setPadding(new Insets(10,20,10,20));
			wannaPlayAgainPane.setPadding(new Insets(10,20,10,20));
			yesNoBtnPane.setPadding(new Insets(30,30,20,30));
			resultStringPane.setAlignment(Pos.BASELINE_LEFT);
			wannaPlayAgainPane.setAlignment(Pos.BASELINE_LEFT);
			pane.btnSubmit.setPrefSize(100, 10);
			pane.btnExit.setPrefSize(100, 10);
			yesNoBtnPane.setAlignment(Pos.BASELINE_CENTER);
			
			Label resultStringLabel = new Label();
			resultStringLabel.setPrefWidth(300);
			resultStringPane.getChildren().add(resultStringLabel);

			
			//*** getChildren ***/
			wannaPlayAgainPane.getChildren().add(new Label("Do you want to search another name?"));
			yesNoBtnPane.getChildren().addAll(pane.yesBtn, pane.noBtn); 			
			SecondPane.getChildren().addAll(resultStringPane, wannaPlayAgainPane, yesNoBtnPane);
			

			 // Create a scene and place a button in the scene
			Scene scene = new Scene(vPane, 350, 200);
			Scene sceneTwo = new Scene(SecondPane, 350, 200);	
			primaryStage.setTitle("Baby Ranking");
			// first display the first scene and then after performing the event handler, show the second scene
			primaryStage.setScene(scene);			
			primaryStage.show();

			
			

			pane.btnSubmit.setOnAction(event -> {
				String line;
				String b_name = null;
				String b_nameRank;
				String nameGender = null;				
				String fieldName = nameField.getText().trim().substring(0,1).toUpperCase();
				fieldName += nameField.getText().substring(1,nameField.getText().length()).toLowerCase().trim();
				int year = Integer.parseInt(yearField.getText());
				
				
					if(year < 2009 || year > 2018) {
						resultStringLabel.setText("The Entered Year Must be Between 2009 to 2018");
					}
					else {
						
						String fileName = "babynamesranking" + yearField.getText() + ".txt";
						try(RandomAccessFile raf = new RandomAccessFile(fileName, "rw")){
							
							
							while((line = raf.readLine()) != null) {							
								
								String [] lineArray = line.split("\t");
								b_nameRank = lineArray[0];
								
								
								if(genderField.getText().equals("M") || genderField.getText().equals("m")) {
									b_name  = lineArray[1].trim();	//trim the name from  1 
									
									nameGender = "Boy's";
								}
								else if (genderField.getText().equals("F") || genderField.getText().equals("f")) {
									b_name  = lineArray[3].trim();	//trim the name from  3 
									nameGender = "Girl";
								}
								
								String resultString;
								if(b_name.equals(fieldName)) {
									resultString = nameGender + " name " + b_name + " is ranked #" + b_nameRank + " in " + yearField.getText() + " year" ;
									resultStringLabel.setText(resultString);
									raf.seek(raf.length());
									
								}
							}
							
							if(!b_name.equals(fieldName)) {
								resultStringLabel.setText("The name you entered is not found. Try another name.");
							}

					}  catch(Exception e) {
						System.out.println(e);
					}
				}
					primaryStage.setScene(sceneTwo);
				
				
			});
			
			
			
			pane.btnExit.setOnAction(event -> {
					
					primaryStage.close();
					
			});
			
			
			pane.yesBtn.setOnAction(event -> {
					nameField.clear();
					yearField.clear();
					genderField.clear();
					primaryStage.setScene(scene);
			});
			
			
			
			pane.noBtn.setOnAction(event -> {
					
					primaryStage.close();

			});
			
		
			
			

	}
	

}