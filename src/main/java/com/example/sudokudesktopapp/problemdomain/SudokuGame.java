package com.example.sudokudesktopapp.problemdomain;

import com.example.sudokudesktopapp.computationlogic.SudokuUtilities;
import com.example.sudokudesktopapp.constants.GameState;

import java.io.Serializable;

public class SudokuGame implements Serializable {
    private final GameState gameState;
    private final int[][] gridstate;

    public static final int GRID_BOUNDRY=9;

    public SudokuGame(GameState gameState, int[][] gridstate) {
        this.gameState = gameState;
        this.gridstate = gridstate;
    }

    public GameState getGameState() {
        return gameState;
    }

    public int[][] getCopyOfGridstate() {
        return SudokuUtilities.copyToNewArray(gridstate);
    }
}
