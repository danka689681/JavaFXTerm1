package nl.inholland.javafx.term1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DecimalFormat;

public class HelloApplication extends Application {
    @Override
    public void start(Stage window) throws IOException {
        window.setHeight(500);
        window.setWidth(500);
        DecimalFormat df2 = new DecimalFormat(".##");

        // Login
        window.setTitle("Login screen");
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10); // Vertical spacing between grid items
        gridPane.setHgap(8); // Horizontal spacing between grid items
        gridPane.setAlignment(Pos.CENTER);

        Label daysRentedLabel = new Label("Number of days rented:");
        TextField daysRentedValue = new TextField();
        Label kmDrivenLabel = new Label("Number of kilomerters driven:");
        TextField kmDrivenValue = new TextField();
        CheckBox checkBox = new CheckBox("Fuel tank not full when returned");
        Label numLitersLabel = new Label("Number of liters:");
        TextField numLitersValue = new TextField();
        Button calculateBtn = new Button("Calculate payment");
        Label resultLabel = new Label("Amount due:");
        Label resultValue = new Label();
        // styling
        gridPane.add(daysRentedLabel, 0, 0);
        gridPane.add(daysRentedValue, 1, 0);
        gridPane.add(kmDrivenLabel, 0, 1);
        gridPane.add(kmDrivenValue, 1,1);
        gridPane.add(checkBox, 0,2);

        gridPane.add(numLitersLabel, 0, 3);
        gridPane.add(numLitersValue, 1, 3);
        gridPane.add(calculateBtn, 1, 4);
        gridPane.add(resultLabel, 0, 5);
        gridPane.add(resultValue, 1, 5);

        calculateBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            int days = Integer.parseInt(daysRentedValue.getText());
            int pricePerDay = 45;
            double kmDriven = Double.parseDouble(kmDrivenValue.getText());
            double kmToPay = kmDriven - 100;
            double numLiters = Double.parseDouble(numLitersValue.getText());
            double extraKm = 0.25;
            double result = days * pricePerDay + (kmToPay > 0 ? kmToPay * extraKm : 0) + (checkBox.isSelected() ? numLiters*2 : 0);
            resultValue.setText(String.valueOf(df2.format(result)));

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