public class Ship {
	
	private int lenShip;
	private String name; 
	private int posRow; 
	private int posCol;
	private boolean horiz;
	
	public Ship(String n, int length) {
		name = n;
		lenShip = length;
	}
	
	public String getName() {
		return name;
	}
	
	public int getLength() {
		return lenShip;
	}
	
	public int getposRow() {
		return posRow;
	}
	public void setposRow(int r) {
		posRow = r;
	}
	public int getposCol() {
		return posCol;
	}
	public void setposCol(int c) {
		posCol = c;
	}

	public boolean getOrientation() {
		return horiz;
	}
	
	public void setOrientation(boolean h) {
		horiz = h;
	}
	
	public String toString() {
		return name + ", length: " + lenShip + ", [row,col]: [" + posRow + "," + posCol + "]";
	}
}
