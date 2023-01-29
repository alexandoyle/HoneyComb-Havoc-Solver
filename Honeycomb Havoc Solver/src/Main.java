import java.util.ArrayList;
import java.util.List;

/*
 * Created by Alex Estevan & Michael Goolsbey
 * This program simulates games of Honeycomb Havoc
 * to determine the best possible move in any scenario (test)
 */
public class Main {

	//Global Variables
	static int numFruits  = 11;
	static int numPlayers = 3;

	static int[]    threePlayerBestMove           = new int[] 	 { 0, 	1, 		1, 		2, 		2, 		1, 		1, 		2, 		2, 		0, 		0,		0};
	static double[] threePlayerBestMovePercentage = new double[] { 0,  100,   100, 	  100, 	   50, 	   75, 	  100, 	  100, 	  100, 		0, 		0, 		0};

	public static void main(String[] args) 
	{

		int playersTurn = 1;

		//Boolean List to keep track of wins
		//True = Win, False = Loss
		List<Double> oneFruitWinsVsLosses  = new ArrayList<Double>();
		List<Double> twoFruitsWinsVsLosses = new ArrayList<Double>();

		//*****************************//
		//        Simulate Game
		//*****************************//
		boolean youDied = false;

		int simulation = 0;

		//if pmove = false, that player takes 1 fruit
		//if pmove = true, that player takes 2 fruits
		boolean p1move = false, p2move = false, p3move = false;

		//Simulate through 8 different game variations
		while(simulation < 8)
		{
			//make sure it starts with player 1 in every game
			playersTurn = 1;



			//*****************************//
			//        Debug Display
			//*****************************//
			int display = simulation + 1;
			int p1moveINT, p2moveINT, p3moveINT;

			if (!p1move) p1moveINT = 1;
			else p1moveINT = 2;
			if (!p2move) p2moveINT = 1;
			else p2moveINT = 2;
			if (!p3move) p3moveINT = 1;
			else p3moveINT = 2;

			System.out.println("**********************************************");
			System.out.println("Simulation #" + display + "   p1: " + p1moveINT + "  |  p2: " + p2moveINT + "  |  p3: " + p3moveINT);
			System.out.println("**********************************************");
			System.out.println();
			//*****************************//
			//        Debug Display
			//*****************************//



			//Declare new sequence of fruits at the beginning of every simulation
			Sequence mySeq = new Sequence(numFruits);
			mySeq.print();
			int numTurns = 0;
			boolean endGameEarly = false;

			//Simulate a single game until any player dies
			while (!youDied  && !endGameEarly) {

				//System.out.println("Players " + playersTurn + " turn.");
				switch (playersTurn)
				{
				case 1:
				{
					//Only do this on Player 1's first turn
					if (numTurns == 0) {
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
						numTurns++;
						break;
					}
					//Do this on all the other Player 1's turns
					else {
						int numFruitsLeft = mySeq.fruitsLeft();
						//System.out.println(numFruitsLeft + " fruits left");
						System.out.println("Best Move: " + threePlayerBestMove[numFruitsLeft] + "  |  Percentage: " + threePlayerBestMovePercentage[numFruitsLeft]);

						if (threePlayerBestMovePercentage[numFruitsLeft] == 100) {
							int numFruitsPlayerOneShouldTake = threePlayerBestMove[numFruitsLeft];

							System.out.println("Doing Player 1's best move with 100% success.");
							if (numFruitsPlayerOneShouldTake == 1) {
								youDied = mySeq.take1();
								printMove(youDied, playersTurn, 1);
								mySeq.print();
							}
							else
							{
								youDied = mySeq.take2();
								printMove(youDied, playersTurn, 2);
								mySeq.print();
							}
							break;
						} 
						else {

							int numFruitsPlayerOneShouldTake = threePlayerBestMove[numFruitsLeft];

							System.out.println("Doing Player 1's best move with " + threePlayerBestMovePercentage[numFruitsLeft] + "% success.");
							if (numFruitsPlayerOneShouldTake == 1) {
								youDied = false;
								printMove(youDied, playersTurn, 1);
								mySeq.print();
							}
							else
							{
								youDied = false;
								printMove(youDied, playersTurn, 2);
								mySeq.print();
							}
							endGameEarly = true;
							break;

						}
					}
				}

				case 2:
				{
					if(!p2move || mySeq.getSize() <= 2){
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
					if(!p3move || mySeq.getSize() <= 2){
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
			if (!endGameEarly) {
				if (!p1move) {
					if (playersTurn == 1) 
					{
						oneFruitWinsVsLosses.add(0.0);
					}
					else 
					{
						oneFruitWinsVsLosses.add(1.0);
					}
				}
				else {
					if (playersTurn == 1) 
					{
						twoFruitsWinsVsLosses.add(0.0);
					}
					else 
					{
						twoFruitsWinsVsLosses.add(1.0);
					}
				}
			}
			
			else if (endGameEarly) {
				int numFruitsLeft = mySeq.fruitsLeft();
				if (!p1move) {
					oneFruitWinsVsLosses.add( (threePlayerBestMovePercentage[numFruitsLeft] / 100));
					
				}
				else {
					twoFruitsWinsVsLosses.add( (threePlayerBestMovePercentage[numFruitsLeft] / 100));
				}
			}

			double oneFruitWinRate = winPercentageCalculator(oneFruitWinsVsLosses);
			double twoFruitsWinRate = winPercentageCalculator(twoFruitsWinsVsLosses);
			System.out.println("Player 1's 1-Fruit winrate is: " + oneFruitWinRate);
			System.out.println("Player 1's 2-Fruit winrate is: " + twoFruitsWinRate);
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

	public static double winPercentageCalculator (List<Double> winsVsLosses) {

		int counter = 0;
		double a = 0;
		double winRate;
		double x;

		while (winsVsLosses.size() > counter) {
			x = winsVsLosses.get(counter);

			a = a + x;		
			counter++;
		}

		/*
		System.out.println();
		System.out.println("a: " + a);
		System.out.println("Counter: " + counter);
		 */

		double numGamesSimulated = counter;
		System.out.println("Number of Games Simulated: " + numGamesSimulated);

		//calculate the winRate
		winRate = a / numGamesSimulated;
		return winRate;
	}
}
