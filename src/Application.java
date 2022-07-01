import java.util.ArrayList;
import java.util.Random;

public class Application {

	final int _SIMULATION = 10000;
	static int score = 0;
	static ArrayList<Integer> dice = new ArrayList<>();

	public static void main(String[] args) {

		dice.add(3);
		dice.add(1);
		dice.add(3);
		dice.add(6);
		dice.add(6);

		int count = 0;
		while (count < 1) {

			int roll = 1;
			boolean newRoll = true;

			// populate dice roll
			// diceArray = (ArrayList<Integer>) PopulateDiceRoll(5);
			while (newRoll) {
				newRoll = CheckAndRoll(roll);
				System.out.println("Your score is: " + score);
				roll++;
			}
			count++;
		}

	}

	public static ArrayList<Integer> PopulateDiceRoll() {

		Random rand = new Random();
		int n;

		ArrayList<Integer> diceRoll = new ArrayList<Integer>(dice.size());

		for (int i = 0; i < dice.size(); i++) {
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
				dice = PopulateDiceRoll();
				return true;
			}

		} else {

			int lowest = dice.get(0);

			for (int i = 0; i < dice.size(); i++) {

				switch (dice.get(i)) {
				case 1:
					dice.remove(i);
					UpdateScore(1);

					if (dice.size() > 0) {
						dice = PopulateDiceRoll();
						return true;
					}
				case 2:
					dice.remove(i);
					UpdateScore(2);

					if (dice.size() > 0) {
						dice = PopulateDiceRoll();
						return true;
					}
				case 4:
					dice.remove(i);
					UpdateScore(4);

					if (dice.size() > 0) {
						dice = PopulateDiceRoll();
						return true;
					}

				case 5:
					dice.remove(i);
					UpdateScore(5);

					if (dice.size() > 0) {
						dice = PopulateDiceRoll();
						return true;
					}
				case 6:
					dice.remove(i);
					UpdateScore(6);

					if (dice.size() > 0) {
						dice = PopulateDiceRoll();
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
