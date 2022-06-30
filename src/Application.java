import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Application {

	public static void main(String[] args) {

		final int _SIMULATION = 10000;

		ArrayList<Integer> diceArray;

		HashMap<Integer, Integer> diceValueMap;

		int count = 0;

		while (count < _SIMULATION) {
			int score = 0;
			// populate dice roll
			diceArray = (ArrayList<Integer>) populateDiceArray(5);
			
			System.out.println("Dice value: " + diceArray + " with size of " + diceArray.size());
			System.out.println();

			diceArray = CheckForThree(diceArray);
			System.out.println("Three's were removed. Score is 0");
			
			// populate dice roll
			diceArray = (ArrayList<Integer>) populateDiceArray(diceArray.size());
			score = GetScore(diceArray, score);

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
		}

		return roll;
	}

	public static int GetScore(ArrayList<Integer> diceArray, int score) {

		int newScore = score;
		ArrayList<Integer> dice = diceArray;

		for (int i = 0; i < diceArray.size(); i++) {

			System.out.println("dice value: " + dice.get(i));

			// check each roll value
			if (dice.get(i) == 1) {
				System.out.println("value is 1. This is the lowest value. Awarded a score of 1");
				dice.remove(i);
				newScore += 1;
			} else if (dice.get(i) == 2) {
				System.out.println("value is 2. Awarded a score of 2");
				dice.remove(i);
				newScore += 2;
			}
			else {
				System.out.println("value is " + dice.get(i) + ". Awarded a score of " + dice.get(i));
				dice.remove(i);
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
