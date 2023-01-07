import java.util.ArrayList;
import java.util.List;

/*
 * Created by Alex Estevan & Michael Goolsbey
 * This program simulates games of Honeycomb Havoc
 * to determine the best possible move in any scenario
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



		// Sequence mySeq = new Sequence(numFruits);
		// mySeq.print();


	
		int playersTurn = 1;

		//Boolean List to keep track of wins
		//True = Win, False = Loss
		List<Boolean> WinsVsLosses = new ArrayList<Boolean>();
		
		//*****************************//
		//        Simulate Game
		//*****************************//
		boolean youDied = false;
		
		int simulation = 0;
		boolean p1move = false, p2move = false, p3move = false;
		
		while(simulation < 8)
		{
			int display = simulation + 1;
			int p1moveINT, p2moveINT, p3moveINT;
			
			if (!p1move) p1moveINT = 1;
			else p1moveINT = 2;
			if (!p2move) p2moveINT = 1;
			else p2moveINT = 2;
			if (!p3move) p3moveINT = 1;
			else p3moveINT = 2;
			
			System.out.println("*************************************");
			System.out.println("Simulation #" + display + "   p1: " + p1moveINT + "  |  p2: " + p2moveINT + "  |  p3: " + p3moveINT);
			System.out.println("*************************************");
			System.out.println();
			
			//Declare new sequence of fruits at the beginning of every simulation
			Sequence mySeq = new Sequence(numFruits);
			mySeq.print();
			
			while (!youDied) {
				//System.out.println("Player's turn: "+ playersTurn);
				switch (playersTurn)
				{
					case 1:
					{
						if(!p1move)  {
							youDied = mySeq.take1();
							printMove(youDied, playersTurn, 1);
							mySeq.print();
						}
							
						else {
							youDied = mySeq.take2();
							printMove(youDied, playersTurn, 2);
							mySeq.print();
						}
						break;
					}
					case 2:
					{

						if(!p2move){
							youDied = mySeq.take1();
							printMove(youDied, playersTurn, 1);
							mySeq.print();
						}
							
						else {
							youDied = mySeq.take2();
							printMove(youDied, playersTurn, 2);
							mySeq.print();
						}
						break;


					}
					case 3:
					{

						if(!p3move){
							youDied = mySeq.take1();
							printMove(youDied, playersTurn, 1);
							mySeq.print();
						}
							
						else {
							youDied = mySeq.take2();
							printMove(youDied, playersTurn, 2);
							mySeq.print();
						}
						break;
					}	
				}
				
				
				//only change turns if no-one has died yet
				if (!youDied) {
					playersTurn = nextTurn(playersTurn);
				}
			}
			
			//if player 1 dies in this scenario, add it to the statistics as a death
			if (playersTurn == 1) 
			{
				WinsVsLosses.add(false);
			}
			else 
			{
				WinsVsLosses.add(true);
			}

			double winRate = winPercentageCalculator(WinsVsLosses);
			System.out.println("Player 1's winrate is: " + winRate);
			System.out.println();
			
			if(!p1move)
			{
				p1move = true;
			}
			else
			{
				p1move = false;
				if(!p2move)
				{
					p2move = true;
				}
				else
				{
					p2move = false;
					if(!p3move)
					{
						p3move = true;
					}
				}
			}
			simulation++;
			youDied = false;
		}
		
		

		
	}

	public static int nextTurn(int playersTurn) {
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

	public static void printMove(boolean youDied, int playersTurn, int numFruits) {
		if (!youDied) {
			if (numFruits == 1) {
			System.out.println("Player: " + playersTurn + " took 1 fruit");
			System.out.println();
			}
			if (numFruits == 2) {
				System.out.println("Player: " + playersTurn + " took 2 fruits");
				System.out.println();
				}
		}
		else
		{
			System.out.println("Player: " + playersTurn + " took the honeycomb and died.");
		}
	}
	
	public static double winPercentageCalculator (List<Boolean> winsVsLosses) {
		
		int counter = 0;
		double a = 0;
		double winRate;
		boolean x;
		
		while (winsVsLosses.size() > counter) {
			x = winsVsLosses.get(counter);
			
			if (x) {
				a++;
			}		
				counter++;
		}
		System.out.println();
		System.out.println("a: " + a);
		System.out.println("Counter: " + counter);
		
		double numGamesSimulated = counter;
		System.out.println("numGamesSimulated: " + numGamesSimulated);
		//calculate the winRate
		winRate = a / numGamesSimulated;
		return winRate;
	}
}
