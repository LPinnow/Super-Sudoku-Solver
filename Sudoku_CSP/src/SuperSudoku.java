import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class SuperSudoku {
	public File sudokuPuzzle;
	public Cell[][] sudokuCell;
	public static ArrayList<Character> domainOfValues;
	
	public SuperSudoku (File puzzle, Cell[][] sudokuCell) throws IOException{
		this.sudokuPuzzle = puzzle;
		this.sudokuCell = sudokuCell;
		domainOfValues = initializeGrid();
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
        	   
        	   //assign a group to each cell
        	   groupNumber = getGroupNumber(x, y);
        	   		
        	   if(cellValue == '-')
        		   sudokuCell[x][y] = new Cell(x, y, groupNumber, cellValue, initialDomain);
        	   else
        		   sudokuCell[x][y] = new Cell(x, y, groupNumber, cellValue, null);
        	   
               pointer++;
           }
        }
        
        return initialDomain;
	}
	
	/**
	 * Returns a group number based on the x,y coordinates of a cell for a 16x16 grid
	 * @param x
	 * @param y
	 * @return groupNumber
	 */
	private int getGroupNumber(int x, int y){ 
		int groupNumber = 0;
		
			if(y <= 3) {
				if (x <= 3)
					groupNumber = 1;
				else if (x <= 7)
					groupNumber = 2;
				else if (x <= 11)
					groupNumber = 3;
				else
					groupNumber = 4;
			}
			else if (y <= 7){
				if (x <= 3)
					groupNumber = 5;
				else if (x <= 7)
					groupNumber = 6;
				else if (x <= 11)
					groupNumber = 7;
				else
					groupNumber = 8;
			}
			else if (y <= 11){
				if (x <= 3)
					groupNumber = 9;
				else if (x <= 7)
					groupNumber = 10;
				else if (x <= 11)
					groupNumber = 11;
				else
					groupNumber = 12;
			}
			else {
				if (x <= 3)
					groupNumber = 13;
				else if (x <= 7)
					groupNumber = 14;
				else if (x <= 11)
					groupNumber = 15;
				else
					groupNumber = 16;
			}
		
		return groupNumber;
	}
	
	/**
	 * Returns a string representation of the value for each cell of a 16x16 grid
	 */
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
