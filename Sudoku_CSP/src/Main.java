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
		boolean puzzleSolved = false;
		
		puzzleFile = FileChooser.getFile();
		if (puzzleFile != null){
			//print File name and print initial state of puzzle
			System.out.println(puzzleFile.getName());
			SuperSudoku sudokuGame = new SuperSudoku(puzzleFile, grid, varAssignmentCount);
			System.out.println(sudokuGame.toString());
						
			//perform uninformed search and print number of tries of variable assignments and final puzzle state
			while (puzzleSolved == false){
				sudokuGame = UninformedAgent.uninformedSolver(sudokuGame);
				puzzleSolved = UninformedAgent.goalTest(sudokuGame);
			}
			
			System.out.println("Uninformed Search");
			System.out.println("\nNumber of Variable Assignments: " + sudokuGame.getCount());
			System.out.println(sudokuGame.toString());
		}
		else
			System.out.println("No file selected.");
	}

}
