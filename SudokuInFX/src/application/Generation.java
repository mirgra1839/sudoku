package application;

import java.util.Random;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Generation {
	
	MenuBar menubar = new MenuBar();
	Menu menu = new Menu("Check/Sprawdz/Kontrollieren/Controleren");
	MenuItem check = new MenuItem("click");	
	
	
	//----------------------------------------------#
	// Define different aspects of the JavaFX view. #
	//----------------------------------------------#
	
	GridPane gamefield = new GridPane();
	Stage gameStage = new Stage();
	Scene gameScene = new Scene(gamefield, 800, 600);;
	Random r = new Random();  // Define randomizer. 
	
	//----------------------------------------#
	// Define integers and main Array.        #
	//----------------------------------------#
	int[] arrayRow = new int[81];
	int i = 0;
	int j = 0;
	int s = 0;
	
	
	//--------------------------------------------#
	// Method createFieldZero. used for zero-ing. #
	//--------------------------------------------#
	public TextField createFieldZero() {
		TextField createField = new TextField();
		createField.setAlignment(Pos.CENTER);
		createField.setPrefSize(50, 50); 
		gamefield.setVgap(5);          ////// visual layout.
		gamefield.setHgap(5);
		return createField;
		}
    //---------------------------------------------------------------------#
	// Constructor for TextFields. Used for generating the board.          #
	//---------------------------------------------------------------------#
	public TextField createField() {
		TextField createField = new TextField();
		for(int x : arrayRow) {  //Prints all numbers.
			arrayRow[x] = 1 + r.nextInt(8);
			/*
			sudoktry Sud = new sudoktry();
			Sud.generateBoard();
			Sud.generatePlayer();
			String sudokustring = new String(String.valueOf(Sud));
			char singlenumber = sudokustring.charAt(x);
			*/
			createField.setText(String.valueOf(arrayRow[x]));	
			//createField.setText(String.valueOf(singlenumber));	

		}
		//-------------------------------#
		// Sets up the size and distance.#
		//-------------------------------#
		createField.setAlignment(Pos.CENTER);
		createField.setPrefSize(50, 50);
		createField.setEditable(false);
		gamefield.setVgap(5);
		gamefield.setHgap(5);
		return createField;
	}
	//---------------------------------------------------------------#
	// Method for creation the initial background with solid numbers.#
	//---------------------------------------------------------------#
	public void CreateBackground() {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				gamefield.addRow(i, createField());
				gamefield.setAlignment(Pos.CENTER);
				
			}
		}
		//--------------------------------------------------------------#
		// Sets the main scene for the game window and makes it visible.#
		//--------------------------------------------------------------#
		gameStage.setScene(gameScene);
		gameStage.show();
	}
	
	//-------------------------------------------------------------------------#
	// Creates and defines empty slots on the game board at random.			   #
	//-------------------------------------------------------------------------#
	public void CreateZeroes() {
		s = r.nextInt(8);
		j = r.nextInt(8);
		gamefield.add(createFieldZero(), s, j);
		s = r.nextInt(8);
		j = r.nextInt(8);
		gamefield.add(createFieldZero(), s, j);
		s = r.nextInt(8);
		j = r.nextInt(8);
		gamefield.add(createFieldZero(), s, j);
		s = r.nextInt(8);
		j = r.nextInt(8);
		gamefield.add(createFieldZero(), s, j);
		s = r.nextInt(8);
		j = r.nextInt(8);
		gamefield.add(createFieldZero(), s, j);
		s = r.nextInt(8);
		j = r.nextInt(8);
		gamefield.add(createFieldZero(), s, j);
		s = r.nextInt(8);
		j = r.nextInt(8);
		gamefield.add(createFieldZero(), s, j);
		s = r.nextInt(8);
		j = r.nextInt(8);
		gamefield.add(createFieldZero(), s, j);
		s = r.nextInt(8);
		j = r.nextInt(8);
		gamefield.add(createFieldZero(), s, j);
		s = r.nextInt(8);
		j = r.nextInt(8);
		gamefield.add(createFieldZero(), s, j);
		s = r.nextInt(8);
		j = r.nextInt(8);
		gamefield.add(createFieldZero(), s, j);
		s = r.nextInt(8);
		j = r.nextInt(8);
		gamefield.add(createFieldZero(), s, j);
		s = r.nextInt(8);
		j = r.nextInt(8);
		gamefield.add(createFieldZero(), s, j);
		s = r.nextInt(8);
		j = r.nextInt(8);
		gamefield.add(createFieldZero(), s, j);
		s = r.nextInt(8);
		j = r.nextInt(8);
		gamefield.add(createFieldZero(), s, j);
		s = r.nextInt(8);
		j = r.nextInt(8);
		gamefield.add(createFieldZero(), s, j);
		s = r.nextInt(8);
		j = r.nextInt(8);
		gamefield.add(createFieldZero(), s, j);
		s = r.nextInt(8);
		j = r.nextInt(8);
		gamefield.add(createFieldZero(), s, j);
		s = r.nextInt(8);
		j = r.nextInt(8);
		gamefield.add(createFieldZero(), s, j);
		s = r.nextInt(8);
		j = r.nextInt(8);
		gamefield.add(createFieldZero(), s, j);
		s = r.nextInt(8);
		j = r.nextInt(8);
		gamefield.add(createFieldZero(), s, j);
		s = r.nextInt(8);
		j = r.nextInt(8);
		gamefield.add(createFieldZero(), s, j);
		s = r.nextInt(8);
		j = r.nextInt(8);
		gamefield.add(createFieldZero(), s, j);
		s = r.nextInt(8);
		j = r.nextInt(8);
		gamefield.add(createFieldZero(), s, j);
		s = r.nextInt(8);
		j = r.nextInt(8);
		gamefield.add(createFieldZero(), s, j);
		s = r.nextInt(8);
		j = r.nextInt(8);
		gamefield.add(createFieldZero(), s, j);
		s = r.nextInt(8);
		j = r.nextInt(8);
		gamefield.add(createFieldZero(), s, j);
		s = r.nextInt(8);
		j = r.nextInt(8);
		gamefield.add(createFieldZero(), s, j);
		s = r.nextInt(8);
		j = r.nextInt(8);
		gamefield.add(createFieldZero(), s, j);
		s = r.nextInt(8);
		j = r.nextInt(8);
		
		gamefield.add(createFieldZero(), s, j);
		gamefield.setAlignment(Pos.CENTER);
	}
	
}
