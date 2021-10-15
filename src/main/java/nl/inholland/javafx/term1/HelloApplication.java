package nl.inholland.javafx.term1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage window) throws IOException {
        window.setHeight(600);
        window.setWidth(800);

        // Login
        window.setTitle("Login screen");
        GridPane gridPane = new GridPane();
        Label euroLabel = new Label("Amount €:");
        TextField euroValue = new TextField();
        Label dollarLabel = new Label("Dollar $:");
        Label dollarValue = new Label();
        Button convertBtn = new Button("Convert Euro to Dollar");

        // styling
        gridPane.add(euroLabel, 0, 0);
        gridPane.add(euroValue, 1, 0);

        gridPane.add(convertBtn, 1, 1);

        gridPane.add(dollarLabel, 0, 2);
        gridPane.add(dollarValue, 1, 2);

        Scene scene = new Scene(gridPane);
        window.setTitle("Currency converter");
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }
}