package com.example.sudokudesktopapp.computationlogic;

import com.example.sudokudesktopapp.constants.GameState;
import com.example.sudokudesktopapp.constants.Rows;
import com.example.sudokudesktopapp.problemdomain.SudokuGame;

import static com.example.sudokudesktopapp.problemdomain.SudokuGame.GRID_BOUNDRY;

public class GameLogic {

    public static SudokuGame getNewGame(){
        return new SudokuGame(
                GameState.NEW,
                GameGenerator.getNewGameGrid()
        );
    }

    public static GameState checkForCompletion(int[][] grid){
        if (sudokuIsInvalid(grid)) return GameState.ACTIVE;
        if (tilesAreNotFilled(grid)) return GameState.ACTIVE;

        return GameState.COMPLETE;
    }

    private static boolean sudokuIsInvalid(int[][] grid) {
        if(rowsAreInvalid(grid)) return true;
        if(columnsAreInvalid(grid)) return true;
        if(squaresAreInvalid(grid)) return true;
        else return false;
     }

    private static boolean squaresAreInvalid(int[][] grid) {
        if(rowOfSquaresIsInvalid(Rows.TOP,grid))
    }

    private static boolean tilesAreNotFilled(int[][] grid) {
        for(int xIndex = 0; xIndex < GRID_BOUNDRY; xIndex++)
        {
            for(int yIndex = 0; yIndex < GRID_BOUNDRY; yIndex++){
                if(grid[xIndex][yIndex] == 0) return true;
            }
        }
        return false;
    }

}
