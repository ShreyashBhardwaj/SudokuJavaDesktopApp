package com.example.sudokudesktopapp.computationlogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.sudokudesktopapp.problemdomain.Cooridnates;
import com.example.sudokudesktopapp.problemdomain.SudokuGame;

import static com.example.sudokudesktopapp.problemdomain.SudokuGame.GRID_BOUNDRY;

public class GameGenerator {
    public static int[][] getNewGrid(){
        return unsolvedGame(getSolvedGame()); 
    }

    private static int[][] unsolvedGame(int[][] solvedGame) {
        Random r = new Random(System.currentTimeMillis());

        boolean solvable = false;
        int[][] solveableArray = new int[GRID_BOUNDRY][GRID_BOUNDRY];

        while(solvable == false){
            SudokuUtilities.copySudokuArrayValues(solvedGame, solveableArray);

            int index = 0;
            while(index < 40){
                int xCoordinate = r.nextInt(GRID_BOUNDRY);
                int yCoordinate = r.nextInt(GRID_BOUNDRY);

               if (solveableArray[xCoordinate][yCoordinate] != 0){
                   solveableArray[xCoordinate][yCoordinate] = 0;
                   index++;
               }
            }

            int[][] toBeSolved = new int[GRID_BOUNDRY][GRID_BOUNDRY];
            SudokuUtilities.copySudokuArrayValues(solveableArray,toBeSolved);

            solvable = SudokuSolver.puzzleIsSolvable(toBeSolved);


        }

        return solveableArray;
    }

    private static int[][] getSolvedGame() {
        Random r = new Random(System.currentTimeMillis());
        int[][] newGrid = new int[GRID_BOUNDRY][GRID_BOUNDRY];

        for(int value=1; value<=GRID_BOUNDRY;value++)
        {
             int allocations = 0;
             int interrupt = 0;

             List<Cooridnates> allocTracker = new ArrayList<>();

             int attempts = 0;

             while(allocations< GRID_BOUNDRY){
                 if (interrupt>200){
                     allocTracker.forEach(cooridnates -> {
                         newGrid[cooridnates.getX()][cooridnates.getY()] = 0;
                     });

                     interrupt = 0;
                     allocations = 0;
                     allocTracker.clear();
                     attempts++;

                     if (attempts>500){
                         clearArray(newGrid);
                         attempts = 0;
                         value = 1;
                     }
                 }
                 int xCoordinate = r.nextInt(GRID_BOUNDRY);
                 int yCoordinate = r.nextInt(GRID_BOUNDRY);

                 if(newGrid[xCoordinate][yCoordinate] == 0){
                     newGrid[xCoordinate][yCoordinate] = value;

                     if (GameLogic.sudokuIsInvalid(newGrid)){
                         newGrid[xCoordinate][yCoordinate] = 0;
                         interrupt++;
                     }else {
                         allocTracker.add(new Cooridnates(xCoordinate,yCoordinate));
                         allocations++;
                     }
                 }
             }
        }

        return newGrid;
    }

    private static void clearArray(int[][] newGrid) {
        for(int xIndex =1; xIndex < GRID_BOUNDRY;xIndex++)
        {
            for (int yIndex = 1; yIndex < GRID_BOUNDRY;yIndex++)
            {
                newGrid[xIndex][yIndex] = 0;
            }
        }
    }
}
