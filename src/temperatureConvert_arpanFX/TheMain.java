package temperatureConvert_arpanFX;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class TheMain extends Application{
	public static void main(String [] args){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("tempConvert.fxml"));
		VBox rootNode = loader.load();

		MenuBar menuBar = createMenu();
		rootNode.getChildren().add(0, menuBar);
		Scene scene = new Scene(rootNode);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter Tool");
		primaryStage.show();
	}

	private MenuBar createMenu() {
		//fileMenu
		Menu fileMenu = new Menu("File");
		MenuItem newMenuItem = new Menu("New");

		newMenuItem.setOnAction(event -> System.out.println("New Menu Item Clicked"));

		SeparatorMenuItem separator = new SeparatorMenuItem();
		MenuItem quitMenuItem = new Menu("Quit");

		quitMenuItem.setOnAction(event -> {
			Platform.exit();
			System.exit(0);
		});

		fileMenu.getItems().addAll(newMenuItem, separator, quitMenuItem);

		//Help Menu
		Menu helpMenu = new Menu("Help");
		MenuItem aboutApp = new MenuItem("About");

		aboutApp.setOnAction(event -> aboutApp()); //Lambda

		helpMenu.getItems().addAll(aboutApp);
		//MenuBar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, helpMenu);
		return menuBar;
	}

	private void aboutApp() {
		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("About App");
		alertDialog.setHeaderText("Temperature Converter Tool by Arpan Bhattacharya");
		alertDialog.setContentText("This is first JavaFX Desktop App by the developer as a hands-on project." +
				"\n Developed on: 5-June-2022" +
				"\n Developer: Arpan Bhattacharya" +
				"\n Production Origin: Delhi-NCR, India" +
				"\n Tech & Version: JavaFX version 8 and above");
		alertDialog.show();
	}
}
