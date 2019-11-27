package HW5_MVC_GUI;


import java.util.Arrays;
import javafx.collections.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;

public class SportClubGUIView {
	
	private TextField numOfPlayersField, nameField;
	private ComboBox<ClubStatus> statusComboBox;
	private Text introText, numOfPlayersLabel, nameLabel, statusLabel, resultLabel;
	private TextArea result;
	private Button addButton, displayButton, bonusButton;
	private VBox primaryBox;
	
	private final static ClubStatus DEFAULT_STATUS = ClubStatus.ACTIVE;
	private final static Font font = Font.font("Arial", 20);
	
	public SportClubGUIView() {
		System.setProperty("glass.accessible.force", "false");
		
		primaryBox = new VBox();
		primaryBox.setAlignment(Pos.CENTER);
		primaryBox.setSpacing(20);
		primaryBox.setStyle("-fx-background-color: GOLDENROD");

		introText = new Text("Welcome to the Sport Club input system!\n Provide the sport club data.");
		introText.setFont(font);
		VBox introBox = new VBox(introText);
		introBox.setAlignment(Pos.CENTER);
		introBox.setSpacing(10);
		primaryBox.getChildren().add(introBox);
		
		nameLabel = new Text("Enter a club name:");
		nameLabel.setFont(font);
		nameField = new TextField();
		VBox nameBox = new VBox(nameLabel, nameField);
		nameBox.setAlignment(Pos.CENTER);
		nameBox.setSpacing(10);
		primaryBox.getChildren().add(nameBox);
		
		numOfPlayersLabel = new Text("Enter the number of players:");
		numOfPlayersLabel.setFont(font);
		numOfPlayersField = new TextField();
		VBox numOfPlayersBox = new VBox(numOfPlayersLabel, numOfPlayersField);
		numOfPlayersBox.setAlignment(Pos.CENTER);
		numOfPlayersBox.setSpacing(10);
		primaryBox.getChildren().add(numOfPlayersBox);
		
		statusLabel = new Text("Select the club status:");
		statusLabel.setFont(font);
		ObservableList<ClubStatus> statusOptions = FXCollections.observableArrayList((Arrays.asList(ClubStatus.values())));
		statusComboBox = new ComboBox<ClubStatus>(statusOptions);
		statusComboBox.setValue(ClubStatus.ACTIVE);
		VBox statusBox = new VBox(statusLabel, statusComboBox);
		statusBox.setAlignment(Pos.CENTER);
		statusBox.setSpacing(10);
		primaryBox.getChildren().add(statusBox);
		
		addButton = new Button("Add Sport Club");
		displayButton = new Button("Show Club Data");
		bonusButton = new Button("Process Bonus");
		
		HBox buttonBox = new HBox(addButton, displayButton, bonusButton);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.setSpacing(10);
		primaryBox.getChildren().add(buttonBox);

		resultLabel = new Text("");
		resultLabel.setFont(font);
		resultLabel.setFill(Color.BLUE);
		resultLabel.setVisible(false);
		result = new TextArea("");
		result.setVisible(false);
		result.setEditable(false);
		VBox resultBox = new VBox(resultLabel, result);
		resultBox.setAlignment(Pos.CENTER);
		resultBox.setSpacing(10);
		primaryBox.getChildren().add(resultBox);

	}
	
	public Parent getParent() {
		return primaryBox;
	}

	public void setProcessBenefitsAction(EventHandler<ActionEvent> handler) {
		bonusButton.setOnAction(handler);
	}
	public void setDisplayEmployeesAction(EventHandler<ActionEvent> handler) {
		displayButton.setOnAction(handler);
	}
	public void setAddEmployeeAction(EventHandler<ActionEvent> handler) {
		addButton.setOnAction(handler);
	}

	public void displayResultText(String label, String output) {
		resultLabel.setVisible(true);
		resultLabel.setText(label);
		
		result.clear();
		result.setVisible(true);
		result.setText(output);
	}
	
	public void hideResultText() {
		result.clear();
		result.setVisible(false);
		resultLabel.setVisible(false);
	}
	public void clearInputs() {
		nameField.clear();
		numOfPlayersField.clear();
		statusComboBox.setValue(DEFAULT_STATUS);
	}
	
	public String getNameField() {
		return nameField.getText();
	}
	public String getNumOfPlayersField() {
		return numOfPlayersField.getText();
	}
	public ClubStatus getStatusField() {
		return statusComboBox.getValue();
	}
	
	public void setNameField(String text) {
		nameField.setText(text);
	}
	public void setIdField(String text) {
		numOfPlayersField.setText(text);
	}
	
	public void setStatusField(ClubStatus status) {
		statusComboBox.setValue(status);
	}	
}
