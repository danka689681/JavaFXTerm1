package nl.inholland.javafx.term1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DecimalFormat;

public class HelloApplication extends Application {
    @Override
    public void start(Stage window) throws IOException {
        window.setHeight(300);
        window.setWidth(300);
        DecimalFormat df2 = new DecimalFormat(".##");

        // Login
        window.setTitle("Login screen");
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10); // Vertical spacing between grid items
        gridPane.setHgap(8); // Horizontal spacing between grid items
        gridPane.setAlignment(Pos.CENTER);

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

        convertBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                double result = Double.parseDouble(euroValue.getText()) * 1.18;
                dollarValue.setText(String.valueOf(df2.format(result)));
            }
        });

        Scene scene = new Scene(gridPane);
        window.setTitle("Currency converter");
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }
}