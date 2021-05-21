
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.collections.FXCollections;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;



public class paneForm extends BorderPane {
	
	//*** address book attributes ***/
	protected TextField FirstName = new TextField();
	protected TextField LastName = new TextField();
	protected TextField City = new TextField(); 
	String st[] = {"ON", "QC", "NS", "NB", "MB", "BC", "PE", "SK", "AB", "NL"};
	protected ChoiceBox<String> Province = new ChoiceBox<String>(FXCollections.observableArrayList(st));
	protected TextField PostCode = new TextField(); 
	
	//*** address book buttons ***/
	protected Button btnAdd = new Button("Add");
	protected Button btnFirst = new Button("First");
	protected Button btnNext = new Button("Next");
	protected Button btnPrevious = new Button("Previous");
	protected Button btnLast = new Button("Last");
	protected Button btnUpdate = new Button("Update");
	
	//*** address book pane ***/
	private FlowPane paneAddressBook = new FlowPane(5, 5);
	private HBox paneButtons = new HBox(8);
	
	
	
	
	
	
	///**** final pane output ***///
	
	public paneForm() {
		
		//** setting the sizes **//
		FirstName.setPrefColumnCount(25);
		LastName.setPrefColumnCount(25);
		City.setPrefColumnCount(5);
		//Province.setPrefColumnCount(2);
		PostCode.setPrefColumnCount(5);
		
		//** padding **//
		paneAddressBook.setPadding(new Insets(10, 10, 10, 10));
		
		//** output **//
		paneAddressBook.getChildren().addAll(new Label("First Name"), FirstName,new Label("Last Name"), LastName, new Label("City"), City, new Label("Province"), Province, new Label("Postal Code"), PostCode);
		paneButtons.getChildren().addAll(btnAdd, btnFirst, btnNext, btnPrevious, btnLast, btnUpdate);
		paneButtons.setAlignment(Pos.CENTER);

		//** setting the output **//
		setCenter(paneAddressBook);
		setBottom(paneButtons);
	}
	
}