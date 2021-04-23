package search;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import components.City;
import components.Map;

public class AStarSearch implements Search {

    private PriorityQueue<CityEntry> frontier;
    private Set<CityEntry> explored;

    private City goalCity;

    public AStarSearch() {
        this.frontier = new PriorityQueue<>();
        this.explored = new HashSet<>();
    }

    // TODO
    @Override
    public List<CityEntry> search(Map map, String start, String goal) {
        if (map.getCity(start) == null || map.getCity(goal) == null)
            return null;

        City startCity = map.getCity(start);
        this.goalCity = map.getCity(goal);

        City currentCity = startCity;

        while (!this.frontier.isEmpty() && goalCheck(currentCity)) {

        }

        if (!goalCheck(currentCity))
            return null;

        return null;
    }

    // TODO
    private List<CityEntry> buildSolution(City city) {
        return null;
    }

    // TODO
    private void addCitiesToFrontier(List<City> cities) {
        for (City city : cities) {
            // Turn cities into city entries 
            // and add to frontier
        }
    }

    private boolean goalCheck(City city) {
        return city.equals(this.goalCity);
    }


}
