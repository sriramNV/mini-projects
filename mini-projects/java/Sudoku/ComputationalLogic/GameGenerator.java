package Sudoku.ComputationalLogic;

import Sudoku.ProblemDomain.Coordinates;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static Sudoku.ProblemDomain.SudokuGame.GRID_BOUNDARY;

public class GameGenerator {
    public static int[][] getNewGameGrid(){
        return unsolveGame(getSolvedGame());
    }

    private static int[][] unsolveGame(int[][] solvedGame) {
        Random random = new Random(System.currentTimeMillis());

        boolean solvable = false;
        int[][] solvableArray = new int[GRID_BOUNDARY][GRID_BOUNDARY];

        while(solvable == false){
            SudokuUtilities.copySudokuArryValues(solvedGame, solvableArray);

            int index = 0;

            while(index < 40){
                int xCoord = random.nextInt(GRID_BOUNDARY);
                int yCoord = random.nextInt(GRID_BOUNDARY);

                if(solvableArray[xCoord][yCoord] != 0){
                    solvableArray[xCoord][yCoord] = 0;
                    index++;
                }

            }
            int[][] toBeSolved = new int[GRID_BOUNDARY][GRID_BOUNDARY];
            SudokuUtilities.copySudokuArryValues(solvableArray, toBeSolved);

            solvable = SudokuSolver.puzzleIsSolvable(toBeSolved);


        }
        return solvableArray;

    }

    private static int[][] getSolvedGame() {
        Random random = new Random(System.currentTimeMillis());
        final int[][] newGrid = new int[GRID_BOUNDARY][GRID_BOUNDARY];

        for(int value = 0; value <= GRID_BOUNDARY; value++){
            int allocations = 0;
            int interrupt = 0;

            List<Coordinates> allocTracker = new ArrayList<>();

            int attempts = 0;

            while(allocations < GRID_BOUNDARY){
                if(interrupt > 200){
                    allocTracker.forEach(coord ->{
                        newGrid[coord.getX()][coord.getY()] = 0;
                    });

                    interrupt = 0;
                    allocations = 0;
                    allocTracker.clear();
                    attempts++;

                    if(attempts > 500){
                        claearArray(newGrid);
                        attempts = 0;
                        value = 1;
                    }
                }

                int xCoord = random.nextInt(GRID_BOUNDARY);
                int yCoord = random.nextInt(GRID_BOUNDARY);

                if(newGrid[xCoord][yCoord] == 0){
                    newGrid[xCoord][yCoord] = value;

                    if(GameLogic.sudokuIsInvalid(newGrid)){
                        newGrid[xCoord][yCoord] = 0;
                        interrupt++;
                    }else{
                        allocTracker.add(new Coordinates(xCoord,yCoord));
                        allocations++;
                    }
                }
            }
        }

        return newGrid;
    }

    private static void claearArray(int[][] newGrid) {

    }
}
