/**
 * 
 */
package main;

import maps.PuertoRico;
import maps.PuertoRicoRandom;
import search.AStarSearch;
import search.SearchSolution;

/**
 * @author dionel.martinez
 *
 */
public class CityNavigator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PuertoRico mapPR = new PuertoRicoRandom();

		AStarSearch aStar = new AStarSearch();

		SearchSolution aStarSol = aStar.search(mapPR, "Ponce", "San Juan");

		System.out.println("***** ASTAR ******");
		printSolution(aStarSol);
	}

	private static void printSolution(SearchSolution solution) {
		System.out.println("*** PATH ***");
		for (int i = 0; i < solution.getPath().size(); i++) {
			if (i == solution.getPath().size() - 1) {
				System.out.print(solution.getPath().get(i).getName());
			} else {
				System.out.print(solution.getPath().get(i).getName() + " --> ");
			}
		}

		System.out.println();
		System.out.println("*** TRAVEL TIME ***");
		System.out.println(solution.getTravelTime() + " hrs");
	}

}
