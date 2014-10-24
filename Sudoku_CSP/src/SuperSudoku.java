import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class SuperSudoku {
	public File sudokuPuzzle;
	public static Cell[][] sudokuCell = new Cell[16][16];
	public static Cell currentCell;
	
	public SuperSudoku (File puzzle){
		this.sudokuPuzzle = puzzle;
	}
	
	
	public void initializeGrid() throws IOException {
		int groupNumber = 1;
		char cellValue = '-';
		ArrayList<Character> fileInput = new ArrayList<Character>(256);
		
		//Initializes the list of possible values for each cell of 1-16
		ArrayList<Integer> initialDomain = new ArrayList<Integer>(16);
		for (int x = 1; x <= 16; x++){
			initialDomain.add(x);
		}
		
		//reads the file and stores values in a string
		try{
			BufferedReader in = new BufferedReader(new FileReader(sudokuPuzzle));
			int c = 0;
			while ((c = in.read()) != -1){
				char character = (char) c;
				if(character != '\n' && character != '\r')
					fileInput.add(character);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		// Sets up a 16x16 grid, creating an instance of each node
		int pointer = 0;
        for (int y = 0; y < 16; y++) {
           for (int x = 0; x < 16; x++) {
        	   cellValue = fileInput.get(pointer);
               sudokuCell[x][y] = new Cell(x, y, groupNumber, cellValue, initialDomain);
               pointer++;
           }
        }
	}
	
	public String toString(){
		String gridString = "Puzzle: \n";
		for (int y = 0; y < 16; y++) {
           for (int x = 0; x < 16; x++) {
        	   gridString += (sudokuCell[x][y].toString() + " ");
        	   
        	   if(x == 15)
        		   gridString = gridString.concat("\n");
           }
        }
		
		return gridString;
	}
}
