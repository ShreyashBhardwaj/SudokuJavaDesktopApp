package com.example.sudokudesktopapp.userinterface;

import com.example.sudokudesktopapp.problemdomain.SudokuGame;

public interface IUserInterfaceContract
{
    interface EventListener{
        void onSudokuInput(int x, int y, int input);
        void onDialogClick();
    }

    interface View{
        void setListener(IUserInterfaceContract.EventListener listener);
        void updateSquare(int x, int y, int input);
        void updatedBoard(SudokuGame game);
        void showDialog(String message);
        void showError(String message);
    }
}
