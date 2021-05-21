package ws6_task1;


import java.io.File;
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



public class paneForm {
	/********** fields ***********/
	protected TextField YearFeild = new TextField();
	protected TextField NameFeild = new TextField();
	
	/********** buttons ***********/	
	protected Button btnSubmit = new Button("Submit Query");
	protected Button btnExit = new Button("Exit");
	Button yesBtn = new Button ("Yes");
	Button noBtn = new Button ("No");
	
	/********** padding ***********/	
	private FlowPane paneBabyRanking = new FlowPane(5, 5);
	private HBox paneButtons = new HBox(8);
	
	public paneForm() {
	
		YearFeild.setPrefColumnCount(25);
		NameFeild.setPrefColumnCount(25);
		
		
		paneBabyRanking.setPadding(new Insets(10, 10, 10, 10));
		//***first screen***//
		paneBabyRanking.getChildren().addAll(new Label("Enter the Year: "), YearFeild, new Label("Enter the Name: "), NameFeild);
		paneButtons.getChildren().addAll(btnSubmit, btnExit);
		paneButtons.setAlignment(Pos.CENTER);
		
		
	
		

	}
}
