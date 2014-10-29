import java.util.ArrayList;


public class UninformedAgent {
	
	public static SuperSudoku uninformedSolver(SuperSudoku inputPuzzle) {
		SuperSudoku puzzle = inputPuzzle;
		int groupNum = 0;
		ArrayList<Character> cellDomain = new ArrayList<Character>();
		
		for (int y = 0; y < 16; y++){
			for(int x = 0; x < 16; x++){
				System.out.println("Checking cell: (" + x + "," + y + ") *** value: " + puzzle.sudokuGrid[x][y].getValue());
				groupNum = puzzle.sudokuGrid[x][y].getGroup();
				cellDomain = puzzle.sudokuGrid[x][y].getDomain();
				
				
				if (puzzle.sudokuGrid[x][y].getValue() == '-'){
					checkGroup(groupNum, cellDomain, puzzle);
					checkRow(x, cellDomain, puzzle);
					checkColumn(y, cellDomain, puzzle);
					
					if(cellDomain.size() == 1){
						puzzle.sudokuGrid[x][y].setValue(cellDomain.get(0));
						System.out.println("Setting the cell (" + x + "," + y + ") to " + cellDomain.get(0).toString());
					}
					
					puzzle.setCount(puzzle.getCount() + 1);
				}
				
			}
		}
		
		return puzzle;
	}
	
	private static ArrayList<Character> checkRow(int x, ArrayList<Character> cellDomain, SuperSudoku inputPuzzle) {
		for(int y = 0; y < 16; y++){
			char cellValue = inputPuzzle.sudokuGrid[x][y].getValue();
			
			if(cellValue != '-' && cellDomain.contains(cellValue))
				cellDomain.remove(cellDomain.indexOf(cellValue));
		}
		
		return cellDomain;
	}
	
	private static ArrayList<Character> checkColumn(int y, ArrayList<Character> cellDomain, SuperSudoku inputPuzzle) {
		for(int x = 0; x < 16; x++){
			char cellValue = inputPuzzle.sudokuGrid[x][y].getValue();
			
			if(cellValue != '-' && cellDomain.contains(cellValue))
				cellDomain.remove(cellDomain.indexOf(cellValue));
		}
		
		return cellDomain;
	}
	
	/**
	 * Checks for and removes values in the group from a cell's domain of available values
	 * @param group
	 * @param cellDomain
	 * @param inputPuzzle
	 * @return
	 */
	private static ArrayList<Character> checkGroup(int group, ArrayList<Character> cellDomain, SuperSudoku inputPuzzle) {
		switch (group) {
			case 1: {
				for(int y = 0; y < 4; y++){
					for(int x = 0; x < 4; x++){
						char cellValue = inputPuzzle.sudokuGrid[x][y].getValue();
						
						if(cellValue != '-' && cellDomain.contains(cellValue))
							cellDomain.remove(cellDomain.indexOf(cellValue));
					}
				}
				break;
			}
			case 2: {
				for(int y = 0; y < 4; y++){
					for(int x = 4; x < 8; x++){
						char cellValue = inputPuzzle.sudokuGrid[x][y].getValue();
						
						if(cellValue != '-' && cellDomain.contains(cellValue))
							cellDomain.remove(cellDomain.indexOf(cellValue));
					}
				}
				break;
			}
			case 3: {
				for(int y = 0; y < 4; y++){
					for(int x = 8; x < 12; x++){
						char cellValue = inputPuzzle.sudokuGrid[x][y].getValue();
						
						if(cellValue != '-' && cellDomain.contains(cellValue))
							cellDomain.remove(cellDomain.indexOf(cellValue));
					}
				}
				break;
			}
			case 4: {
				for(int y = 0; y < 4; y++){
					for(int x = 12; x < 16; x++){
						char cellValue = inputPuzzle.sudokuGrid[x][y].getValue();
						
						if(cellValue != '-' && cellDomain.contains(cellValue))
							cellDomain.remove(cellDomain.indexOf(cellValue));
					}
				}
				break;
			}
			case 5: {
				for(int y = 4; y < 8; y++){
					for(int x = 0; x < 4; x++){
						char cellValue = inputPuzzle.sudokuGrid[x][y].getValue();
						
						if(cellValue != '-' && cellDomain.contains(cellValue))
							cellDomain.remove(cellDomain.indexOf(cellValue));
					}
				}
				break;
			}
			case 6: {
				for(int y = 4; y < 8; y++){
					for(int x = 4; x < 8; x++){
						char cellValue = inputPuzzle.sudokuGrid[x][y].getValue();
						
						if(cellValue != '-' && cellDomain.contains(cellValue))
							cellDomain.remove(cellDomain.indexOf(cellValue));
					}
				}
				break;
			}
			case 7: {
				for(int y = 4; y < 8; y++){
					for(int x = 8; x < 12; x++){
						char cellValue = inputPuzzle.sudokuGrid[x][y].getValue();
						
						if(cellValue != '-' && cellDomain.contains(cellValue))
							cellDomain.remove(cellDomain.indexOf(cellValue));
					}
				}
				break;
			}
			case 8: {
				for(int y = 4; y < 8; y++){
					for(int x = 12; x < 16; x++){
						char cellValue = inputPuzzle.sudokuGrid[x][y].getValue();
						
						if(cellValue != '-' && cellDomain.contains(cellValue))
							cellDomain.remove(cellDomain.indexOf(cellValue));
					}
				}
				break;
			}
			case 9: {
				for(int y = 8; y < 12; y++){
					for(int x = 0; x < 4; x++){
						char cellValue = inputPuzzle.sudokuGrid[x][y].getValue();
						
						if(cellValue != '-' && cellDomain.contains(cellValue))
							cellDomain.remove(cellDomain.indexOf(cellValue));
					}
				}
				break;
			}
			case 10: {
				for(int y = 8; y < 12; y++){
					for(int x = 4; x < 8; x++){
						char cellValue = inputPuzzle.sudokuGrid[x][y].getValue();
						
						if(cellValue != '-' && cellDomain.contains(cellValue))
							cellDomain.remove(cellDomain.indexOf(cellValue));
					}
				}
				break;
			}
			case 11: {
				for(int y = 8; y < 12; y++){
					for(int x = 8; x < 12; x++){
						char cellValue = inputPuzzle.sudokuGrid[x][y].getValue();
						
						if(cellValue != '-' && cellDomain.contains(cellValue))
							cellDomain.remove(cellDomain.indexOf(cellValue));
					}
				}
				break;
			}
			case 12: {
				for(int y = 8; y < 12; y++){
					for(int x = 12; x < 16; x++){
						char cellValue = inputPuzzle.sudokuGrid[x][y].getValue();
						
						if(cellValue != '-' && cellDomain.contains(cellValue))
							cellDomain.remove(cellDomain.indexOf(cellValue));
					}
				}
				break;
			}
			case 13: {
				for(int y = 12; y < 16; y++){
					for(int x = 0; x < 4; x++){
						char cellValue = inputPuzzle.sudokuGrid[x][y].getValue();
						
						if(cellValue != '-' && cellDomain.contains(cellValue))
							cellDomain.remove(cellDomain.indexOf(cellValue));
					}
				}
				break;
			}
			case 14: {
				for(int y = 12; y < 16; y++){
					for(int x = 4; x < 8; x++){
						char cellValue = inputPuzzle.sudokuGrid[x][y].getValue();
						
						if(cellValue != '-' && cellDomain.contains(cellValue))
							cellDomain.remove(cellDomain.indexOf(cellValue));
					}
				}
				break;
			}
			case 15: {
				for(int y = 12; y < 16; y++){
					for(int x = 8; x < 12; x++){
						char cellValue = inputPuzzle.sudokuGrid[x][y].getValue();
						
						if(cellValue != '-' && cellDomain.contains(cellValue))
							cellDomain.remove(cellDomain.indexOf(cellValue));
					}
				}
				break;
			}
			case 16: {
				for(int y = 12; y < 16; y++){
					for(int x = 12; x < 16; x++){
						char cellValue = inputPuzzle.sudokuGrid[x][y].getValue();
						
						if(cellValue != '-' && cellDomain.contains(cellValue))
							cellDomain.remove(cellDomain.indexOf(cellValue));
					}
				}
				break;
			}
		}
		
		return cellDomain;
	}
	
	public static boolean goalTest (SuperSudoku puzzle) {
		//System.out.println("Checking for Goal State...");
		for (int y = 0; y < 16; y++){
			for(int x = 0; x < 16; x++){
				if (puzzle.sudokuGrid[x][y].getValue() == '-')
					return false;
			}
		}
		
		return true;
	}
}
