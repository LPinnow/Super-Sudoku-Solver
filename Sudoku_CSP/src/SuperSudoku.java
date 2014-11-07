import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Initializes a 16x16 super sudoku board
 * @author main
 */
public class SuperSudoku {
	public File sudokuPuzzle;
	public Cell[][] sudokuGrid;
	public ArrayList<Character> domainOfValues;
	public int count;
	
	
	/**
	 * Creates a 16x16 super sudoku board
	 * Fills in the board based on assigned values in a file selected by the user
	 * @param puzzle
	 * @param sudokuGrid
	 * @param count
	 * @throws IOException
	 */
	public SuperSudoku (File puzzle, Cell[][] sudokuGrid, int count) throws IOException{
		this.sudokuPuzzle = puzzle;
		this.sudokuGrid = sudokuGrid;
		this.domainOfValues = initializeGrid();
		this.count = count;
	}
	
	/**
	 * Reads in a file containing a text representation of a 16x16 sudoku grid
	 * Initializes each cell in the grid to the corresponding file text value
	 * @throws IOException
	 */
	private ArrayList<Character> initializeGrid() throws IOException {
		int groupNumber = 1;
		char cellValue = '-';
		ArrayList<Character> fileInput = new ArrayList<Character>(256);
		ArrayList<Character> initialDomain = new ArrayList<Character>(16);
		
		//reads the file and stores values in an ArrayList of characters
		try{
			BufferedReader in = new BufferedReader(new FileReader(sudokuPuzzle));
			int c = 0;
			while ((c = in.read()) != -1){
				char character = (char) c;
				if(character != '\n' && character != '\r'){
					fileInput.add(character);
					
					if(!initialDomain.contains(character) && c != '-')
						initialDomain.add(character);
				}
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		//Checks if there are 16 characters in the initial domain of values
		//Adds hexadecimal values to initial domain if puzzle doesn't include 16 characters
		if(initialDomain.size() < 16) {
			for(int x = 0; x < 9; x++){
				char c = (char) x;
				if (!initialDomain.contains(c))
					initialDomain.add(c);
			}
			for(char c = 'A'; c < 'G'; c++){
				if (!initialDomain.contains(c))
					initialDomain.add(c);
			}			
		}
		
		System.out.println("Domain of Values: " + initialDomain.toString());
		
		// Sets up a 16x16 grid, creating an instance of each node
		int pointer = 0;
        for (int y = 0; y < 16; y++) {
           for (int x = 0; x < 16; x++) {
        	   //read value in array list and set as the value for the current cell
        	   cellValue = fileInput.get(pointer);
        	   		
        	   if(cellValue == '-'){
        		   sudokuGrid[x][y] = new Cell(x, y, cellValue, initialDomain);
        		   //System.out.println("Setting the cell (" + x + "," + y + ") to " + sudokuGrid[x][y].getDomain().toString());
        	   }
        	   else
        		   sudokuGrid[x][y] = new Cell(x, y, cellValue, null);
        	   
               pointer++;
           }
        }
        
        return initialDomain;
	}
	
	public Cell[][] getSudokuGrid() {
		return sudokuGrid;
	}
	
	/**
	 * Returns a character array list containing all 16 possible values
	 * @return domainOfValues
	 */
	public ArrayList<Character> getDomainValues() {
		return domainOfValues;
	}
	
	/**
	 * Getter and Setter for the count of variable assignments made
	 * @param c
	 */
	public void setCount (int c){
		this.count = c;
	}
	public int getCount() {
		return count;
	}
	
	/**
	 * Returns a string representation of the value for each cell of a 16x16 grid
	 */
	public String toString() {
		String gridString = "Puzzle: \n";
		for (int y = 0; y < 16; y++) {
           for (int x = 0; x < 16; x++) {
        	   gridString += (sudokuGrid[x][y].toString() + " ");
        	   
        	   if(x == 15)
        		   gridString = gridString.concat("\n");
           }
        }
		
		return gridString;
	}
}
