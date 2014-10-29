import java.util.ArrayList;


public class Cell {
	int x, y, group;
	char value;
	ArrayList<Character> domain = new ArrayList<Character>();
	
	public Cell (int x, int y, int group, char value, ArrayList<Character> domain){
		this.x = x;
		this.y = y;
		this.group = group;
		this.value = value;
		
		if(domain != null)
			this.domain.addAll(domain);
		else
			this.domain = null;
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
	public void setDomain(ArrayList<Character> domain){
		this.domain.clear();
		this.domain.addAll(domain);
	}
	
	public int getGroup () {
		return group;
	}
	
	public String toString () {
		return Character.toString(value);
	}
}
