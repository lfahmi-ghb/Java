

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

import java.io.*;

public class bookAddresses extends Application {

	protected paneForm pane = new paneForm();
	//Use fixed-length string for storing each attribute in the address
	final int LENFirstName = 32; 
	final int LENLastNAME = 32;  
	final int LENCity = 20; 
	final int LENProv = 2; 
	final int LENPostCode = 7; 
	protected int counter = 0;
	
	
	
	
	//*** main method ***/
	public static void main(String[] args) {
		launch();
	}
	

	@Override 
	public void start(Stage primaryStage) {
		
		//*******Add an address******//
		pane.btnAdd.setOnAction(event -> {
			try ( RandomAccessFile inout =  new RandomAccessFile("Application.dat", "rw");) {
				inout.seek(inout.length());
				
				
				//*******write the user information to the random access file******//	
				inout.write(setLEN(pane.FirstName.getText().getBytes(), LENFirstName)); 
				inout.write(setLEN(pane.LastName.getText().getBytes(), LENLastNAME));
				inout.write(setLEN(pane.City.getText().getBytes(), LENCity));
				inout.write(setLEN(pane.Province.getValue().getBytes(), LENProv));
				inout.write(setLEN(pane.PostCode.getText().getBytes(), LENPostCode));
				
				System.out.println("Address #" + counter + " was written Application.dat");
				clear();
				
			} catch (IOException e) { 
				e.printStackTrace(); 
			}
		});
		
		
		
		
		//*******show the first address******//	
		pane.btnFirst.setOnAction(event -> {
			try (RandomAccessFile raf = new RandomAccessFile("Application.dat", "rw")){
				if (raf.length() > 0) {
					raf.seek(0);
					read(raf);
					System.out.println("First Record was Read Successfully");
					counter = 1;
				}
				else {
					System.out.println("Address book doesn't have addresses, add an address to view it.");
				}
			} catch (IOException e) {
				e.printStackTrace();
				}
		});
		
		
		
		
		//*******show the next address******//
		pane.btnNext.setOnAction(event -> {
			try ( RandomAccessFile raf = new RandomAccessFile("Application.dat", "rw") ) {
					if (counter * 93 < raf.length()) {
						raf.seek(counter * 93);
						read(raf);
						counter++;
						System.out.println("The next record #("  + counter + ") is read.");
					}
					else {
						System.out.println("The last record was read, and it's the end of the file.");
					}
				} catch (IOException e) { 
					e.printStackTrace(); 
				}
		});
		
		
		//*******show the previous address******//
		pane.btnPrevious.setOnAction(event -> {
			try ( RandomAccessFile raf = new RandomAccessFile("Application.dat", "rw")) {
					if (counter > 1) 
						counter--;
					else
						counter = 1;
					raf.seek((counter * 93) - 93);
					read(raf);
					System.out.println("The previous record #("  + counter + ") is read.");
				} catch (IOException e) {
					e.printStackTrace();
				}
		});
		
		

		//*******show the last address******//
		pane.btnLast.setOnAction(e -> 
		{try ( RandomAccessFile raf = new RandomAccessFile("Application.dat", "rw")) {
			counter = ((int)raf.length()) / 93;
			raf.seek((counter * 93) - 93);
			read(raf);
			System.out.println("The Last Record #("  + counter + ") is Read Successfully.");
		}
		catch (IOException ex) {
			System.out.println("Error" + ex);
		}
		
		});
		

		//*******update the current address******//	
		pane.btnUpdate.setOnAction(event -> {
			try ( RandomAccessFile raf =new RandomAccessFile("Application.dat", "rw")) {
				raf.seek(counter * 93 - 93);
					
					//*******update the user information to the random access file******//	
				raf.write(setLEN(pane.FirstName.getText().getBytes(), LENFirstName)); 
				raf.write(setLEN(pane.LastName.getText().getBytes(), LENLastNAME));
				raf.write(setLEN(pane.City.getText().getBytes(), LENCity));
				raf.write(setLEN(pane.Province.getValue().getBytes(), LENProv));
				raf.write(setLEN(pane.PostCode.getText().getBytes(), LENPostCode));
					
					System.out.println("Address #" + counter + " was updated.");
				} catch (IOException e) { 
					e.printStackTrace();
				}
		});


		 // Create a scene and place a button in the scene
		Scene scene = new Scene(pane, 390, 150);
		primaryStage.setTitle("Adress Book"); 
		primaryStage.setScene(scene); 
		primaryStage.show(); 
	}

	
	
	private void clear() {
		pane.FirstName.setText("");
	 	pane.LastName.setText("");
	 	pane.City.setText("");
	 	pane.PostCode.setText("");
	}

	
	//*******read the user information******//	
	private void read(RandomAccessFile raf) throws IOException {
		int pos;
		
		//allocate memory for the attribute
		//set the position to read the attribute
		//set the attribute's value in the pane
		byte[] firstname = new byte[LENFirstName];	
		pos = raf.read(firstname);
		pane.FirstName.setText(new String(firstname));
		
		byte[] lastname = new byte[LENLastNAME];	
		pos = raf.read(lastname);
		pane.LastName.setText(new String(lastname));
		
		byte[] city = new byte[LENCity];	
		pos += raf.read(city);
		pane.City.setText(new String(city));
		
		byte[] province = new byte[LENProv];	
		pos += raf.read(province);
		pane.Province.setValue(new String(province));
		
		byte[] postalcode = new byte[LENPostCode];	
		pos += raf.read(postalcode);
		pane.PostCode.setText(new String(postalcode));
	}
	
	
	
	private byte[] setLEN(byte[] attr, int len) {
		byte[] byt = new byte[len];
		for (int i = 0; i < attr.length; i++) {
			byt[i] = attr[i];
		}
		return byt;
	}
		
}



