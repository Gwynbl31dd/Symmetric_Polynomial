package distrib.process;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class used to process an equation.
 * @author Anthony Paulin 
 * @version 0.1
 * @since 09-06-17
 * @category Mathematics theory
 *
 */
public final class EquationUtils {
	private final int MAX_SIZE = 10;// Define the maximum number generated
	private final int MIN = 0;// Define the min double generated
	private final int MAX = 100;// Define the max double generated

	/**
	 * Default constructor, populate a list wih double random numbers
	 */
	public EquationUtils() {

		// Populate the list
		ArrayList<Double> list = new ArrayList<Double>();
		for (int i = 0; i < MAX_SIZE; i++) {
			// Generate a random number
			list.add(ThreadLocalRandom.current().nextDouble(MIN, MAX));
		}
		processList(list);
	}

	/**
	 * Bypass the random number generation and process a list of double numbers
	 * 
	 * @param list a list of Double numbers
	 */
	public EquationUtils(ArrayList<Double> list) {
		processList(list);
	}

	/**
	 * Compute the equation
	 * @param list
	 *            a list of double numbers
	 */
	private void processList(ArrayList<Double> list) {
		// Initiate the result from the product of all
		// the combinations
		Double finalResult = 0.0;
		char sign = '+';// Initialize the sign

		// Show all the INPUT made
		System.out.println("INPUT:");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		// Show the OUTPUT (Equation) and compute it at the same time
		System.out.println("\n\nOUTPUT:");

		/*
		 * Calculate the result for each line and add the result to the final
		 * result
		 */
		for (int i = 1; i <= list.size(); i++)// i is the number of line
		{
			// if the ligne number (i) is %2, the sign is negative
			if (i % 2 == 0) {
				sign = '-';
			} else {
				sign = '+';
			}
			// Start the combination process to generate all the possible k n!
			// combination
			finalResult += combinations(list, i, 0, new Double[i], sign, 0.0);
			System.out.println();
		}
		// Finally, print the final result
		System.out.println("\n\nCALCULATED RESULT:" + finalResult);
	}
	
	/**
	 * Make a copy of the array in a tab and make all the possibilities without repetitions.
	 * Also return the result of each line of the equation
	 * @param arr Array of double to process
	 * @param len number of number for the product
	 * @param startPosition Where was the process
	 * @param result the copy in a table of the combination of the numbers
	 * @param sign the sign used to add numbers
	 * @param calculatedResult the calculated result
	 * @return the result processed
	 */
	private Double combinations(ArrayList<Double> arr, int len, int startPosition, Double[] result, char sign,
			Double calculatedResult) {
		if (len == 0) {
			double multiplicator = 1.0;// Instantiate a multiplicator to keep
										// the product result
			System.out.print(sign);
			for (int i = 0; i < result.length; i++) {
				if (i == 0) {
					System.out.print('(');
				} else {
					System.out.print('*');
				}

				System.out.print(" " + result[i] + " ");

				multiplicator *= result[i];// Multiply the result with the
											// previous product
			}

			// Subtract or add the multiplicator result following the sign
			if (sign == '-') {
				calculatedResult -= multiplicator;
			} else {
				calculatedResult += multiplicator;
			}

			System.out.print(')');
			return calculatedResult;// Return the result of the lign
		}

		for (int i = startPosition; i <= arr.size() - len; i++) {
			result[result.length - len] = arr.get(i);
			//Start another combination
			calculatedResult = combinations(arr, len - 1, i + 1, result, sign, calculatedResult);
		}

		return calculatedResult;// Return the final result
	}
}
