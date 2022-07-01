import java.util.ArrayList;
import java.util.Random;

public class Application {

	final static int _SIMULATION = 10000;
	static int score = 0;
	static ArrayList<Integer> dice = new ArrayList<>();

	public static void main(String[] args) {

		
		int count = 0;
		while (count < _SIMULATION) {

			dice = (ArrayList<Integer>) PopulateDiceRoll(5);
			
			int roll = 1;
			boolean newRoll = true;

			// populate dice roll
			while (newRoll) {
				newRoll = CheckAndRoll(roll);
				System.out.println("Your score is: " + score);
				roll++;
			}
			
			count++;
			
			// reset score for next iteration
			score = 0;
			System.out.println();
		}

	}

	public static ArrayList<Integer> PopulateDiceRoll(int size) {

		Random rand = new Random();
		int n;

		ArrayList<Integer> diceRoll = new ArrayList<Integer>(size);

		for (int i = 0; i < size; i++) {
			n = rand.nextInt(6) + 1;
			diceRoll.add(n);
		}

		return diceRoll;
	}

	public static boolean CheckAndRoll(int roll) {

		// check value
		System.out.println("Roll: " + roll + " - Dice array: " + dice);
		if (dice.contains(3)) {

			// get indexes that contains three's
			for (int i = 0; i < dice.size(); i++) {
				if (dice.get(i) == 3) {

					// remove from list
					dice.remove(i);
				}
			}

			if (dice.size() > 0) {
				dice = PopulateDiceRoll(dice.size());
				return true;
			}

		} else {

			int lowest = dice.get(0);

			for (int i = 0; i < dice.size(); i++) {
				// get the lowest value
				if(lowest >= dice.get(i)) {
					lowest = dice.get(i);
				}
			}
			
			System.out.println("lowest: " + lowest);
			for (int i = 0; i < dice.size(); i++) {

				if(lowest == 1) {
					dice.remove(i);
					UpdateScore(1);

					if (dice.size() > 0) {
						dice = PopulateDiceRoll(dice.size());
						return true;
					}
				}
				
				if(lowest == 2) {
					dice.remove(i);
					UpdateScore(2);

					if (dice.size() > 0) {
						dice = PopulateDiceRoll(dice.size());
						return true;
					}
				}
				
				if(lowest == 4) {
					dice.remove(i);
					UpdateScore(4);

					if (dice.size() > 0) {
						dice = PopulateDiceRoll(dice.size());
						return true;
					}
				}
				
				if(lowest == 5) {
					dice.remove(i);
					UpdateScore(5);

					if (dice.size() > 0) {
						dice = PopulateDiceRoll(dice.size());
						return true;
					}
				}
				
				if(lowest == 6) {
					dice.remove(i);
					UpdateScore(6);

					if (dice.size() > 0) {
						dice = PopulateDiceRoll(dice.size());
						return true;
					}
				}
			}
		}
		
		return false;
	}

	public static void UpdateScore(int addScore) {
		score += addScore;
	}

}
