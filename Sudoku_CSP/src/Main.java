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
		
		puzzleFile = FileChooser.getFile();
		if (puzzleFile != null){
			System.out.println(puzzleFile.getName());
			SuperSudoku sudokuGame = new SuperSudoku(puzzleFile, grid);
			System.out.println(sudokuGame.toString());
		}
		else
			System.out.println("No file selected.");
	}

}
