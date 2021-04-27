/**
 * 
 */
package search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import components.City;
import components.Map;

/**
 * @author dionel.martinez
 *
 */
public class BestFirstSearch implements Search {

	private PriorityQueue<CityEntry> frontier;
    private Set<CityEntry> explored;
	private City startCity, goalCity;
    private double maxRealSpeed;
	private final String id = "Greedy Best First Search";

	public BestFirstSearch() {
		this.frontier = new PriorityQueue<>();
        this.explored = new HashSet<>();

	}

	@Override
	public SearchSolution search(Map map, String start, String goal) {

		if ((startCity = map.getCity(start)) == null || (goalCity = map.getCity(goal)) == null)
			return null;

		frontier = new PriorityQueue<>();
        maxRealSpeed = map.getMaxRealSpeed();
        
        CityEntry currentCityEntry = new CityEntry(startCity, null, 0, 0);
        
        if (currentCityEntry.getCity().equals(goalCity)) {
            return buildSolution(currentCityEntry);
        }
        
        addCitiesToFrontier(startCity.getReachableCities(), currentCityEntry);
        explored.add(currentCityEntry);
        
        while (!frontier.isEmpty()) {
            currentCityEntry = frontier.poll();
            if (currentCityEntry.getCity().equals(goalCity)) {
                return this.buildSolution(currentCityEntry);
            }
            this.addCitiesToFrontier(currentCityEntry.getCity().getReachableCities(), currentCityEntry);
            this.explored.add(currentCityEntry);
        }

        return null;
	}
	
    private SearchSolution buildSolution(CityEntry goal) {
        LinkedList<City> path = new LinkedList<>();

        buildSolutionHelper(goal, path);

        return new SearchSolution(path, goal.getTravelTimeToCity());
    }

    private void buildSolutionHelper(CityEntry entry, LinkedList<City> path) {
        if (entry == null) { // Reached start city
            return;
        }

        path.add(0, entry.getCity());
        buildSolutionHelper(entry.getParent(), path);
    }
    private void addCitiesToFrontier(List<City> cities, CityEntry parent) {
        for (City city : cities) {
            CityEntry newCity = new CityEntry(city, parent, getCostToGoalCityFrom(city), getTravelTimeToCurrent(city, parent));
            if (!this.frontier.contains(newCity) && !this.explored.contains(newCity)) {
                this.frontier.add(newCity);
                
            }
        }
    }
    private double getTravelTimeToCurrent(City city, CityEntry parent) {
        return parent.getTravelTimeToCity() + city.getRoadTo(parent.getCity()).getTravelTime();
    }
    
    private double getCostToGoalCityFrom(City city) {
        return city.distanceTo(goalCity) / maxRealSpeed;
    }

	@Override
	public String getIdentifier() {
		return id;
	}


}
