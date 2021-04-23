/**
 * 
 */
package main;

import components.City;
import maps.PuertoRico;
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
		PuertoRico mapPR = new PuertoRico();

		AStarSearch aStar = new AStarSearch();

		SearchSolution solution = aStar.search(mapPR, "Ponce", "San Juan");

		for (City city : solution.getPath()) {
			System.out.println(city.getName());
		}

		System.out.println(solution.getTravelTime());
	}

}
