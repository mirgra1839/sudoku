package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		//try {
			AnchorPane root = FXMLLoader.load(getClass().getResource("Sudoku.fxml"));
			
			primaryStage.setResizable(true);
			primaryStage.setTitle("Sudoku");
			primaryStage.setScene(new Scene(root,600,400));
			primaryStage.show();
			
		/*} catch(Exception e) {
			e.printStackTrace();
		}*/
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
