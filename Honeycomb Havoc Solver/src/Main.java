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
			
			
			
			Sequence mySeq = new Sequence(numFruits);
			mySeq.print();
			
			while (!youDied) {
				System.out.println("Player's turn: "+ playersTurn);
				switch (playersTurn)
				{
					case 1:
					{
						if(!p1move) youDied = mySeq.take1();
						else youDied = mySeq.take2();
						break;
					}
					case 2:
					{
						if(!p2move) youDied = mySeq.take1();
						else youDied = mySeq.take2();
						break;
					}
					case 3:
					{
						if(!p3move) youDied = mySeq.take1();
						else youDied = mySeq.take2();
						break;
					}
					
				}
				mySeq.print();
				
				printMove(youDied, playersTurn);
				
				//only change turns if no-one has died yet
				if (!youDied) {
					mySeq.print();
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

	public static void printMove(boolean youDied, int playersTurn) {
		if (!youDied) {
			System.out.println("Player: " + playersTurn + " took the fruit");
			System.out.println();
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
		System.out.println("Counter: " + a);
		System.out.println("numGamesSimulated: " + a);
		double numGamesSimulated = counter;
		
		//calculate the winRate
		winRate = a / numGamesSimulated;
		return winRate;
	}
}
