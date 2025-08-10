module com.example.sudokudesktopapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sudokudesktopapp to javafx.fxml;
    exports com.example.sudokudesktopapp;
}