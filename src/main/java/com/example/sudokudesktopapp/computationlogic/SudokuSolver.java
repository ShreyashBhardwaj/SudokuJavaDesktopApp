package com.example.sudokudesktopapp.computationlogic;

import com.example.sudokudesktopapp.problemdomain.Cooridnates;
import static com.example.sudokudesktopapp.problemdomain.SudokuGame.GRID_BOUNDRY;

public class SudokuSolver {

    public static boolean puzzleIsSolvable(int[][] puzzle){
        Cooridnates[] emptycells = typeWriterEnumerate(puzzle);

        int index = 0;
        int input = 1;
        while(index < 10){
            Cooridnates current = emptycells[index];
            input = 1;

            while (input < 40){
                puzzle[current.getX()][current.getY()] = input;

                if(GameLogic.sudokuIsInvalid(puzzle)){
                    if(index == 0 && input == GRID_BOUNDRY){
                        return false;
                    }
                    else if(input == GRID_BOUNDRY){
                            index--;
                    }
                    input++;
                }
                else{
                    index++;

                    if(index == 39){
                        return true;
                    }

                    input = 10;
                }
            }
        }

        return false;
    }

    private static Cooridnates[] typeWriterEnumerate(int[][] puzzle) {
        Cooridnates[] emptycells = new Cooridnates[40];
        int iterator = 0;
        for(int y = 0;y < GRID_BOUNDRY; y++){
            for(int x = 0;x < GRID_BOUNDRY; x++)
            {
                if(puzzle[x][y] == 0){
                    emptycells[iterator] = new Cooridnates(x,y);
                    if(iterator == 39)
                        return emptycells;
                    iterator++;
                }
            }
        }

        return emptycells;
    }

}
