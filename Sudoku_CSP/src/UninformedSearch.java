
public class UninformedSearch {
	static SuperSudoku puzzle;
	
	/**
	 * Uniformed agent that solves the puzzle through a brute force search
	 * Starts in the top left corner and assigns values to empty cells from left to right, top to bottom
	 * Constraints are the value must be unique in the cell's group, row, and column
	 * @param inputPuzzle
	 * @return
	 */
	public static SuperSudoku solvePuzzle (SuperSudoku inputPuzzle) {
		puzzle = inputPuzzle;
		
		try {
			assignValue(0,0);
		} catch (Exception e) {
			
		}
		
		return puzzle;
	}
	
	/**
	 * Backtracking search that assigns values to the cells
	 * Breaks out of backtracking search by throwing an exception
	 * Solution is complete when search reaches cell 15,15 on the grid
	 * @param x
	 * @param y
	 * @throws Exception
	 */
	public static void assignValue (int x, int y) throws Exception {
		// Reached the end of the grid so the solution is complete
		if (y > 15)
			throw new Exception(""); 
		// Skip cells that are already assigned values
		else if (puzzle.sudokuGrid[x][y].getValue() != '-')
			nextCell(x,y);
		// Try each value and assign it if it is unique compared to other values in the cell's row, column, and group
		else {
			for(int i = 0; i < puzzle.domainOfValues.size(); i++){
				char value = puzzle.domainOfValues.get(i);
				if(checkRow(y, value) == true && checkColumn(x, value) == true && checkGroup(x, y, value) == true){
					puzzle.setCount(puzzle.getCount()+1);
					puzzle.sudokuGrid[x][y].setValue(value);
					nextCell(x,y);
				}
			}
			
			//resets cell back to unassigned if no valid value found
			puzzle.sudokuGrid[x][y].setValue('-');
		}
	}
	
	/**
	 * Returns the x,y grid coordinates of a cell
	 * @param x
	 * @param y
	 * @throws Exception
	 */
	public static void nextCell (int x, int y) throws Exception {
		if (x < 15) 
			assignValue(x+1, y);
		else
			assignValue(0, y+1);
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
