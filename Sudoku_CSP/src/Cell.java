import java.util.ArrayList;


public class Cell {
	int x, y, group;
	char value;
	ArrayList<Character> domain;
	
	public Cell (int x, int y, int group, char value, ArrayList<Character> domain){
		this.x = x;
		this.y = y;
		this.group = group;
		this.value = value;
		this.domain = domain;
	}
	
	public char getValue (){
		return value;
	}
	public void setValue(char newValue){
		this.value = newValue;
	}
	
	public ArrayList<Character> getDomain(){
		return domain;
	}
	public void removeFromDomain (char removeValue){
		int index = this.domain.indexOf(removeValue);
		this.domain.remove(index);
	}
	public void addToDomain (char value){
		this.domain.add(value);
	}
	
	public String toString () {
		return Character.toString(value);
	}
}
