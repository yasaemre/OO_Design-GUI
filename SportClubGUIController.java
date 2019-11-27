package HW5_MVC_GUI;


import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SportClubGUIController extends Application {

	private League league;
	private SportClubGUIView sportClubInputView;

	public SportClubGUIController() {
		league = new League();
		sportClubInputView = new SportClubGUIView();
		
		sportClubInputView.setProcessBenefitsAction(this::processBenefits);
		sportClubInputView.setDisplayEmployeesAction(this::displayClubs);
		sportClubInputView.setAddEmployeeAction(this::addClub);
	}

	@Override
	public void start(Stage primaryStage) {
		SportClubGUIController controller = new SportClubGUIController();
	
		Scene scene = new Scene(controller.sportClubInputView.getParent(), 600, 600, Color.GOLDENROD);
		primaryStage.setTitle("Club Data Processing System");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	private void addClub(ActionEvent event) {
		String errorMessage = "";
		try {
			String clubName = sportClubInputView.getNameField();
			if (clubName.isEmpty()) {
				errorMessage = "Club Name must not be empty.";
				throw new IllegalArgumentException();
			}

			try {
				String numPlayers = sportClubInputView.getNumOfPlayersField(); 

				if (numPlayers.isEmpty()) {
					errorMessage = "Number of players must not be empty.";
					throw new IllegalArgumentException();
				}
				int numOfPlayers = Integer.parseInt(numPlayers);

				ClubStatus status = sportClubInputView.getStatusField();

				SportClub club = new SoccerClub(numOfPlayers, clubName, status);
				league.addClub(club);
			} catch (NumberFormatException ex) {
				errorMessage = "Number of players must be numeric.";
				throw new IllegalArgumentException();
			}

		} catch (IllegalArgumentException ex) {
			Alert error = new Alert(AlertType.ERROR);
			error.setTitle("Error");
			error.setHeaderText(null);
			error.setContentText(errorMessage);
			error.showAndWait();

		} finally {
			sportClubInputView.clearInputs();
			sportClubInputView.hideResultText();
		}
	}

	private void processBenefits(ActionEvent event) {
		ArrayList<SportClub> clubList = league.getClubList(); 
		String output = "";
		for (SportClub s : clubList) {
			output += s.bonus() + "\n";
		}
		sportClubInputView.displayResultText("Processing Bonuses", output); 
	}

	private void displayClubs(ActionEvent event) {
		ArrayList<SportClub> clubList = league.getClubList(); 
		String output = "";
		for (SportClub s : clubList) {
			output += s.toString() + "\n";
		}
		sportClubInputView.displayResultText("Club:", output);
	}
}
