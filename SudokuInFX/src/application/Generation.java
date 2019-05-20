package application;

import java.util.Random;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Generation {
	
	GridPane gamefield = new GridPane();
	Stage game = new Stage();
	Scene scene = new Scene(gamefield,800,600);
	Random r = new Random();
	int[] arrayRow = new int[81];
	MenuBar menu = new MenuBar();
	Menu hint = new Menu();
	Menu check = new Menu();
	
	
	public TextField createField(){
		TextField createField = new TextField();
		for(int x : arrayRow) {
			arrayRow[x] = 1 + r.nextInt(8);
			createField.setText(String.valueOf(arrayRow[x]));
		}
		createField.setAlignment(Pos.CENTER);
		createField.setPrefSize(50, 50);
		createField.setEditable(false);
		gamefield.setVgap(5);
		gamefield.setHgap(5);
		return createField;
	}
	public void CreateBackground() {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				gamefield.addRow(i, createField());
				gamefield.setAlignment(Pos.CENTER);
				
			}
		}
		game.setScene(scene);
		game.show();
	}
	
}
