/*
 * Sudoku Solver using Constraint Satisfaction
 * Main.java
 * Author: Leah Pinnow
 * Purpose: The purpose of this program is to show the increase in performance by
 * comparing the number of times an agent attempts to assign a variable to a sudoku cell.
 * An uninformed agent that does not use any heuristics and looks at cells starting from
 * left to right, top to bottom is compared to an MRV agent that assigns values to cells
 * starting with the cell has the has the least possible values that can be assigned to it.
 */


import java.io.File;
import java.io.IOException;


public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException{
		File puzzleFile = null;
		Cell [][] grid = new Cell[16][16];
		int varAssignmentCount = 0;
		
		puzzleFile = FileChooser.getFile();
		if (puzzleFile != null){
			//print File name and print initial state of puzzle
			System.out.println(puzzleFile.getName());
			SuperSudoku sudokuGame = new SuperSudoku(puzzleFile, grid, varAssignmentCount);
			System.out.println(sudokuGame.toString());
			
			uninformedSearch(sudokuGame);
			
			sudokuGame = new SuperSudoku(puzzleFile, grid, varAssignmentCount);
			mrvSearch(sudokuGame);
		}
		else
			System.out.println("No file selected.");
	}
	
	/**
	 * Brute-Force search that assigns cells values starting in the top left corner
	 * and progresses from left to right, top to bottom
	 * @param sudokuGame
	 */
	private static void uninformedSearch(SuperSudoku sudokuGame) {
		sudokuGame = UninformedSearch.solvePuzzle(sudokuGame);
		
		System.out.println("Uninformed Search");
		System.out.println("\nNumber of Variable Assignments: " + sudokuGame.getCount());
		System.out.println(sudokuGame.toString());
	}
	
	/**
	 * Solves the puzzle by selecting the next cell to be assigned a variable based on minimum remaining values
	 * @param sudokuGame
	 */
	private static void mrvSearch(SuperSudoku sudokuGame) {
		sudokuGame = MRVSearch.solvePuzzle(sudokuGame);
		
		
		System.out.println("MRV Search");
		System.out.println("\nNumber of Variable Assignments: " + sudokuGame.getCount());
		System.out.println(sudokuGame.toString());
	}

}
