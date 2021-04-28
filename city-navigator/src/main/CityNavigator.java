/**
 * 
 */
package main;

import java.util.LinkedList;
import java.util.List;

import components.City;
import components.Map;
import maps.PuertoRico;
import maps.PuertoRicoClosed;
import maps.PuertoRicoRandom;
import maps.PuertoRicoVarying;
import search.AStarSearch;
import search.BestFirstSearch;
import search.RandomSearch;
import search.Search;
import search.SearchSolution;

/**
 * @author dionel.martinez, milton.pagan1, jesus.garcia15
 *
 */
public class CityNavigator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Search> algorithms = new LinkedList<>();

		Search aStar = new AStarSearch();
		Search randSearch = new RandomSearch();
		Search bestFirstSearch = new BestFirstSearch();
		

		algorithms.add(aStar);
		algorithms.add(bestFirstSearch);
		algorithms.add(randSearch);


		PuertoRico basePR = new PuertoRico();
		PuertoRico varyingPR = new PuertoRicoVarying();
		PuertoRico closedPR = new PuertoRicoClosed();
		PuertoRico randomPR = new PuertoRicoRandom();

		System.out.println("\n******* Base Map ********");
		test(algorithms, basePR, "Ponce", "San Juan");
		System.out.println("\n******* Varying traffic ********");
		test(algorithms, varyingPR, "Ponce", "San Juan");
		System.out.println("\n******* Closed roads ********");
		test(algorithms, closedPR, "Ponce", "San Juan");
		System.out.println("\n******* Random traffic ********");
		test(algorithms, randomPR, "Ponce", "San Juan");
	}

	private static void printSolution(SearchSolution solution) {
		System.out.println("\t*** PATH ***");
		System.out.print("\t");
		
		if(solution == null) {
			System.out.println("Does not exist!");
			return;
		}
		
		int i=0;
		for (City c : solution.getPath()) {
			if (i == solution.getPath().size() - 1) {
				System.out.print(c.getName());
			} else {
				System.out.print(c.getName() + " --> ");
			}
			i++;
		}

		System.out.println("\n\t*** TRAVEL TIME ***");
		System.out.println("\t" + solution.getTravelTime() + " hrs");
	}

	private static void test(List<Search> searchAlgs, Map map, String start, String goal) {
		for (Search search : searchAlgs) {
			System.out.println("\n***** " + search.getIdentifier() + " *****");
			printSolution(search.search(map, start, goal));
		}
	}
}
