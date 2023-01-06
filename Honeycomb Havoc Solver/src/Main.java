import java.util.ArrayList;

/**
 * 
 */

/**
 * @author alexe
 *
 */
public class Main {

	/**
	 * @param args
	 */
	//Global Variables
	static int numFruits  = 9;
	static int numPlayers = 3;

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub



		Sequence mySeq = new Sequence(numFruits);
		mySeq.print();

		//3 player game
		int playersTurn = 1;


	}

	public int nextTurn(int playersTurn) {
		if (numPlayers == 2) {
			if (playersTurn == 1)
				return 2;
			else if (playersTurn == 2)
				return 1;
		}
		
		if (numPlayers == 3) {
			if (playersTurn == 1)
				return 2;
			else if (playersTurn == 2)
				return 3;
			else if (playersTurn == 3)
				return 1;
		}
		
		if (numPlayers == 4) {
			if (playersTurn == 1)
				return 2;
			else if (playersTurn == 2)
				return 3;
			else if (playersTurn == 3)
				return 4;
			else if (playersTurn == 4)
				return 1;
		}
		return 0;
	}

}
