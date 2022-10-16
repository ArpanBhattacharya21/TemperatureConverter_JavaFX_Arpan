package temperatureConvert_arpanFX;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

	@FXML public Label welcomeLabel;
	@FXML public ChoiceBox<String> choiceBox;
	@FXML public TextField userInput;
	@FXML public Button convertButton;
	private static final String C_To_F = "Celsius To Fahrenheit";
	private static final String F_To_C = "Fahrenheit To Celsius";
	private static final String C = "Choose conversion";
	private boolean isC_TO_F = true;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		choiceBox.getItems().add(C);
		choiceBox.getItems().add(C_To_F);
		choiceBox.getItems().add(F_To_C);
		choiceBox.setValue(C);
		choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

			if(newValue.equals(C_To_F)){
				isC_TO_F = true;
			}
			else if(newValue.equals(F_To_C)){
				isC_TO_F = false;
			}

		});

		convertButton.setOnAction(event -> convert());
	}

	private void convert()
	{
		String input = userInput.getText();
		float enteredTemp = 0.0f;
		try{
			enteredTemp = Float.parseFloat(input);
		}
		catch(Exception e){
			warnUser();
			return;
		}
		float newTemp = 0.0f;
			//testing
		if(isC_TO_F){
			newTemp = (enteredTemp*9/5)+32; //Celsius to Fahrenheit
		}
		else
		{
			newTemp = (enteredTemp-32)*5/9; //Fahrenheit to Celsius
		}
		display(newTemp);

	}
	private void display(float newTemp) {
		String unit = isC_TO_F ? "F" : "C";
		Alert res = new Alert(Alert.AlertType.INFORMATION);
		res.setTitle("RESULT!");
		res.setContentText("The new temperature is " + newTemp+unit);
		res.show();
	}
	private void warnUser() {
		Alert dialog = new Alert(Alert.AlertType.ERROR);
		dialog.setTitle("Error Occurred!");
		dialog.setHeaderText("Invalid temperature entered!");
		dialog.setContentText("Please enter a valid temperature!");
		dialog.show();
	}
}

