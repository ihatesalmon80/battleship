public class Runner {
	
	public static void main(String[] args) {
		
		Board board1 = new Board(10,10);
	
	//	String printBoard1 = board1.toString();
	
	//	System.out.println(printBoard1);
		
		board1.addShip(2,2,4,true);
		board1.addShip(7,3,3,false);
		
		if (board1.foundShip(3)) {
			System.out.println("found ship of length 3");
		}
		else {
			System.out.println("nope");
		}
		
		board1.shoot(2,2);
		
		System.out.println(board1.toString());
	}	
}
