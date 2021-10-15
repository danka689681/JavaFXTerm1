module nl.inholland.javafx.term1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens nl.inholland.javafx.term1 to javafx.fxml;
    exports nl.inholland.javafx.term1;
}