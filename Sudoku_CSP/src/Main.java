import java.io.File;
import java.io.IOException;


public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		File puzzleFile = null;
		puzzleFile = FileChooser.getFile();
		if (puzzleFile != null){
			System.out.println(puzzleFile.getName());
			SuperSudoku sudokuGame = new SuperSudoku(puzzleFile);
			sudokuGame.initializeGrid();
			System.out.println(sudokuGame.toString());
		}
		else
			System.out.println("No file selected.");
	}

}
