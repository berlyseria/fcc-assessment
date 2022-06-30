import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Application {

	public static void main(String[] args) {

		final int _SIMULATION = 10000;

		ArrayList<Integer> diceArray;

		HashMap<Integer, Integer> diceValueMap;

		int score = 0;
		int count = 0;

		// Simulate 10,000
		while (count < 1) {

			// populate dice roll
			diceArray = (ArrayList<Integer>) populateDiceArray(5);
			
			int roll = 0;
			System.out.println("Roll: " + roll + " - dice value: " + diceArray + " with size of " + diceArray.size());
			System.out.println();

			diceArray = CheckForThree(diceArray);
			System.out.println("Three's were removed. Score is 0");
			
			// populate dice roll
			diceArray = (ArrayList<Integer>) populateDiceArray(diceArray.size());

			// iterate through our dice array to check for values and score
			for (int i = 0; i < diceArray.size(); i++) {

				// check each roll value
				if (diceArray.get(i) == 3) {
					System.out.println("A 3 is rolled, will be removed from the board. Score is 0");
					diceArray.remove(i);
					break;
				} else if (diceArray.get(i) == 1) {
					System.out.println("value is 1. This is the lowest value. Awarded a score of 1");
					diceArray.remove(i);
					score += 1;
					break;
				} else if (diceArray.get(i) == 2) {
					System.out.println("value is 2. Awarded a score of 2");
					diceArray.remove(i);
					score += 2;
					break;
				} else {
					System.out.println("value is " + diceArray.get(i) + ". Awarded a score of " + diceArray.get(i));
					diceArray.remove(i);
					score += diceArray.get(i);
				}
			}

			roll++;
			System.out.println();

			System.out.println("after round... " + diceArray);
			System.out.println("Your score is: " + score);
			count++;
		}

	}

	public static List<Integer> populateDiceArray(int size) {

		Random rand = new Random();
		int n;

		ArrayList<Integer> roll = new ArrayList<Integer>(5);

		for (int i = 0; i < size; i++) {
			n = rand.nextInt(6) + 1;
			roll.add(n);
			// System.out.println(roll.get(i));
		}

		return roll;
	}

	public static int GetScore(ArrayList<Integer> diceArray, int score) {

		int newScore = score;
		ArrayList<Integer> dice = diceArray;

		for (int i = 0; i < diceArray.size(); i++) {

			System.out.println("dice value: " + dice.get(i));

			// check each roll value
			if (dice.get(i) == 3) {
				System.out.println("A 3 is rolled, will be removed from the board");
				dice.remove(i);
				System.out.println("dice value after 3 is taken off: " + dice);
			} else if (dice.get(i) == 1) {
				System.out.println("value is 1. This is the lowest value. Awarded a score of 2");
				dice.remove(i);
				newScore += 1;
			} else if (dice.get(i) == 2) {
				System.out.println("value is 2. Awarded a score of 1");
				dice.remove(i);
				newScore += 2;
			}
		}

		return newScore;
	}

	public static ArrayList<Integer> CheckForThree(ArrayList<Integer> dice) {

		for (int i = 0; i < dice.size(); i++) {
			if (dice.get(i) == 3) {
				dice.remove(i);
			}
		}

		System.out.println(dice);
		return dice;
	}

}
