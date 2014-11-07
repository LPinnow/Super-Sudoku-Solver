import java.util.ArrayList;


public class Cell {
	int x, y, group;
	char value;
	ArrayList<Character> domain = new ArrayList<Character>();
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param group
	 * @param value
	 * @param domain
	 */
	public Cell (int x, int y, char value, ArrayList<Character> domain) {
		this.x = x;
		this.y = y;
		this.value = value;
		
		if(domain != null)
			this.domain.addAll(domain);
		else
			this.domain = null;
	}
	
	public char getValue() {
		return value;
	}
	public void setValue(char newValue) {
		this.value = newValue;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public ArrayList<Character> getDomain(){
		return domain;
	}
	public void setDomain(ArrayList<Character> domain){
		this.domain.clear();
		this.domain.addAll(domain);
	}
	
	public String toString () {
		return Character.toString(value);
	}
}
