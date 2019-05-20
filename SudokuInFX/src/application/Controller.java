package application;


import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class Controller {
	@FXML
	Button button = new Button();
	@FXML
	MenuItem changeenglish = new MenuItem();
	@FXML
	MenuItem changepolish = new MenuItem();
	@FXML
	MenuItem changegerman = new MenuItem();
	@FXML
	MenuItem changedutch = new MenuItem();
	@FXML
	Menu file = new Menu();
	@FXML
	Menu instruction = new Menu();
	@FXML
	Menu changelang = new Menu();
	@FXML
	MenuItem close = new MenuItem();
	
	
	Generation SudGen = new Generation();
	@FXML
	private void closeAction(ActionEvent evt){
		System.exit(0);
		
		
	}
	@FXML
	private void PolishAction(ActionEvent evt){
		button.setText("START SUDOKU");
        changepolish.setText("Zmień język na polski");
        changedutch.setText("Zmień język na niderlandzki");
        changegerman.setText("Zmień język na niemiecki");
        changeenglish.setText("Zmień język na angielski");
        file.setText("Opcje");
        instruction.setText("Instrukcja");
        changelang.setText("Język");
        close.setText("Zamknij");
        String musicFile = "xpError.wmv"; 
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
	}
	@FXML
	private void EnglishAction(ActionEvent evt){
		button.setText("START SUDOKU");
        changeenglish.setText("Change language to English");
        changegerman.setText("Change language to German");
        changepolish.setText("Change language to Polish");
        changedutch.setText("Change language to Dutch");
        file.setText("Options");
        instruction.setText("Instruction");
        changelang.setText("Language");
        close.setText("Exit");
        String musicFile = "xpError.wmv"; 
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
	}
	@FXML
	private void GermanAction(ActionEvent evt){
		button.setText("START SUDOKU");
		changeenglish.setText("Ändern Sie die Sprache in Englisch");
        changegerman.setText("Ändern Sie die Sprache in Deutsch");
        changepolish.setText("Ändern Sie die Sprache in Polnisch");
        changedutch.setText("Ändern Sie die Sprache in Niederländisch");
        file.setText("Optionen");
        instruction.setText("Anleitung");
        changelang.setText("Sprache");
        close.setText("Knappen Spiel");
        String musicFile = "xpError.wmv"; 
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
	}
	@FXML
	private void DutchAction(ActionEvent evt){
		button.setText("START SUDOKU");
		changedutch.setText("Taal veranderen naar Nederlands");
        changepolish.setText("Taal veranderen naar Pools");
        changeenglish.setText("Taal veranderen naar Engels");
        changegerman.setText("Taal veranderen naar Duits");
        file.setText("Opties");
        instruction.setText("Instructie");
        changelang.setText("Taal");
        close.setText("Spel afsluiten");
        String musicFile = "xpError.wmv"; 
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
	}
	@FXML
	private void StartGame(ActionEvent evt) {
		SudGen.CreateBackground();
		String musicFile = "XPstart.mp3";
		Media sound = new Media(new File(musicFile).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
	}


}
