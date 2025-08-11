package com.example.sudokudesktopapp;

import com.example.sudokudesktopapp.userinterface.IUserInterfaceContract;
import com.example.sudokudesktopapp.userinterface.UserInterfaceImpl;
import com.example.sudokudesktopapp.buildlogic.SudokuBuildLogic;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SudokuApplication extends Application {
    private IUserInterfaceContract.View uiImpl;
    @Override
    public void start(Stage primaryStage) throws IOException {
        uiImpl = new UserInterfaceImpl(primaryStage);
        try{
            SudokuBuildLogic.build(uiImpl);
        }catch (IOException e){
            e.printStackTrace();
            throw e;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}