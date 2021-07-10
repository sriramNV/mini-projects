package Sudoku.ComputationalLogic;

import Sudoku.ProblemDomain.SudokuGame;

public class SudokuUtilities {
    public static void copySudokuArryValues(int[][] oldArr, int[][] newArr){
        for(int xIndex = 0; xIndex < SudokuGame.GRID_BOUNDARY; xIndex++){
            for (int yIndex = 0; yIndex < SudokuGame.GRID_BOUNDARY; yIndex++){
                newArr[xIndex][yIndex] = oldArr[xIndex][yIndex];
            }
        }
    }

    public static int[][] copyToNewArray(int[][] oldArr){
        int[][] newArr = new int[SudokuGame.GRID_BOUNDARY][SudokuGame.GRID_BOUNDARY];
        for(int xIndex = 0; xIndex < SudokuGame.GRID_BOUNDARY; xIndex++){
            for (int yIndex = 0; yIndex < SudokuGame.GRID_BOUNDARY; yIndex++){
                newArr[xIndex][yIndex] = oldArr[xIndex][yIndex];
            }
        }
        return newArr;
    }
}
