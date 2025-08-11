module com.example.sudokudesktopapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.xml.dom;


    opens com.example.sudokudesktopapp to javafx.fxml;
    exports com.example.sudokudesktopapp;
}