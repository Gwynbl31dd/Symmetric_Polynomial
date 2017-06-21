package distrib.main;

import distrib.process.EquationUtils;

/**
 * Start the equation computation mode
 * @author Anthony Paulin 
 * @version 0.1
 * @since 08-06-17
 * @category Main
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("************Math & Problem Solving************");
		System.out.println("**********************************************");
		new EquationUtils();
		/*
		 * For test purpose, you can use new EquationUtils(ArrayList<Double>
		 * list); ex : ArrayList<Double> list = new ArrayList<Double>();
		 * list.add(2.0); list.add(4.0); list.add(6.0); new EquationUtils(list);
		 */
		System.exit(0);
	}
}
