import java.util.ArrayList;


public class MRVSearch {
	static SuperSudoku puzzle;
	
	/**
	 * Agent that solves a sudoku puzzle using a minimum remaining values heuristic
	 * Constraints are the value must be unique in the cell's group, row, and column
	 * @param inputPuzzle
	 * @return
	 */
	public static SuperSudoku solvePuzzle (SuperSudoku inputPuzzle) {
		puzzle = inputPuzzle;
		
		try {
			Cell firstCell = null;

			// Start the search with the cell that has minimum remaining values
			firstCell = getCellWithMRV();
			assignValue(firstCell);
			
		} catch (Exception e) {
		}
		
		return puzzle;
	}
	
	/**
	 * Backtrack search that assigns values to cells
	 * Throws exception to break out of search when all cells have an assigned value
	 * @param cell
	 * @throws Exception
	 */
	public static void assignValue (Cell cell) throws Exception {
		if(goalTest() == true)
			throw new Exception("Solution Complete");
		else {
			for(int i = 0; i < puzzle.domainOfValues.size(); i++){
				char value = puzzle.domainOfValues.get(i);
				if(checkRow(cell.getY(), value) == true && checkColumn(cell.getX(), value) == true && checkGroup(cell.getX(),cell.getY(), value) == true){
					puzzle.setCount(puzzle.getCount()+1);
					cell.setValue(value);
					assignValue(getCellWithMRV());
				}
			}
			
			//resets cell back to unassigned if no valid value found
			cell.setValue('-');
		}
	}
	
	/**
	 * Returns the sudoku cell that has the smallest number of unique values possible
	 * @return
	 */
	public static Cell getCellWithMRV(){
		int minDomainSize = 16, currentDomainSize = 0;;
		int x = 0, y = 0;
		
		for(int row = 0; row < 16; row++){
			for(int column = 0; column < 16; column++){
				if(puzzle.sudokuGrid[column][row].getValue() == '-'){
					currentDomainSize = countAssignedValues(puzzle.sudokuGrid[column][row]);
					if (currentDomainSize < minDomainSize){
						minDomainSize = currentDomainSize;
						x = column;
						y = row;
					}
				}
			}
		}
		
		return puzzle.sudokuGrid[x][y];
	}
	
	/**
	 * Returns an integer representing the number of unique values that do not violate the constraints
	 * @param c
	 * @return
	 */
	private static int countAssignedValues (Cell c){
		int count = 0;
		
		ArrayList<Character> assignedValues = new ArrayList<Character>();
		assignedValues.addAll(c.getDomain());
		
		removeAssignedValues(c);
		count = c.getDomain().size();
		c.setDomain(assignedValues);
		
		return count;
	}
	
	/**
	 * Removes values from a cell's domain list that are already assigned to another cell
	 * in that cell's group, row, or column
	 * @param c
	 */
	private static void removeAssignedValues(Cell c) {
		//remove assigned values from a cell's row and group
		for(int x = 0; x < 16; x++){
			char cellValue = puzzle.sudokuGrid[x][c.getY()].getValue();
			
			if(cellValue != '-' && c.getDomain().contains(cellValue))
				c.getDomain().remove(c.getDomain().indexOf(cellValue));
		}
		
		for(int y = 0; y < 16; y++){
			char cellValue = puzzle.sudokuGrid[c.getX()][y].getValue();
			
			if(cellValue != '-' && c.getDomain().contains(cellValue))
				c.getDomain().remove(c.getDomain().indexOf(cellValue));
		}
		
		//remove assigned values for a cell's group
		int x = c.getX();
		int y = c.getY();
		x = (x/4) * 4 ;
		y = (y/4) * 4 ;
		
	    for(int row = 0; row < 4; row++ )
	         for(int col = 0; col < 4; col++ ){
	        	 char cellValue = puzzle.sudokuGrid[x+col][y+row].getValue();
		         if(cellValue != '-' && c.getDomain().contains(cellValue))
		        	 c.getDomain().remove(c.getDomain().indexOf(cellValue));
	         }
	}
	
	/**
	 * Iterates through all the cells in the grid and returns true if all cells have an assigned value
	 * @return
	 */
	private static boolean goalTest () {
		for(int y = 0; y < 16; y++){
			for(int x = 0; x < 16; x++){
				if(puzzle.sudokuGrid[x][y].getValue() == '-')
					return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Constraint: Value must be unique to a cell's row
	 * @param y
	 * @param value
	 * @return
	 */
	private static boolean checkRow(int y, char value){
		for(int x = 0; x < 16; x++){
			if (puzzle.sudokuGrid[x][y].getValue() == value){
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Constraint: Value must be unique to a cell's column
	 * @param x
	 * @param value
	 * @return
	 */
	private static boolean checkColumn(int x, char value){
		for(int y = 0; y < 16; y++){
			if (puzzle.sudokuGrid[x][y].getValue() == value){
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Constraint: Value must be unique to a cell's group
	 * @param x
	 * @param y
	 * @param value
	 * @return
	 */
	private static boolean checkGroup(int x, int y, char value){
		x = (x/4) * 4 ;
		y = (y/4) * 4 ;
		
	    for(int r = 0; r < 4; r++ )
	         for(int c = 0; c < 4; c++ ){
		         if( puzzle.sudokuGrid[x+c][y+r].getValue() == value){
		            return false;
		         }
	         }
		return true;
	}
}
