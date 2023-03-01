package test_15;

public class Letra {
	
	public String name;
	public int col;
	public int row;

	public Letra(String name, int col, int row) {
		this.name = name;
		this.col = col;
		this.row = row;
	}
	
	public String toString() {
		return name+" - ["+row+", "+col+"]";
	}

}
