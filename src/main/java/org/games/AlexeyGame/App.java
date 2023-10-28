package org.games.AlexeyGame;

import Snake.Main;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

	@Override
	public void start(Stage stage) {

		ToggleButton toggleButton1 = new ToggleButton("Snake");
		toggleButton1.setMaxSize(100, 30);

		toggleButton1.setOnAction(action -> {

			if (toggleButton1.isSelected()) {
				ConectionSnake();
			}

		});

		HBox box = new HBox(toggleButton1);
		Scene scene = new Scene(box, 300, 300);
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		launch();
	}

	// метод для Змейки

	public void ConectionSnake() {

		Stage stage = new Stage();
		Main main = new Main();

		try {
			main.start(stage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}