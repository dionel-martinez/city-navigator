package search;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import components.City;
import components.Map;

public class AStarSearch implements Search {

    private PriorityQueue<CityEntry> frontier;
    private Set<CityEntry> explored;

    private City goalCity;
    private double maxRealSpeed;

    public AStarSearch() {
        this.frontier = new PriorityQueue<>();
        this.explored = new HashSet<>();
    }

    @Override
    public SearchSolution search(Map map, String start, String goal) {
        if (map.getCity(start) == null || map.getCity(goal) == null)
            return null;

        City startCity = map.getCity(start);
        this.goalCity = map.getCity(goal);
        this.maxRealSpeed = map.getMaxRealSpeed();

        CityEntry currentCityEntry = new CityEntry(startCity, null, 0);
        if (this.goalTest(currentCityEntry.getCity())) {
            return this.buildSolution(currentCityEntry);
        }

        this.addCitiesToFrontier(startCity.getReachableCities(), currentCityEntry);
        this.explored.add(currentCityEntry);

        while (!this.frontier.isEmpty()) {
            currentCityEntry = this.frontier.poll();
            if (this.goalTest(currentCityEntry.getCity())) {
                return this.buildSolution(currentCityEntry);
            }
            this.addCitiesToFrontier(currentCityEntry.getCity().getReachableCities(), currentCityEntry);
            this.explored.add(currentCityEntry);
        }

        return null;
    }

    private SearchSolution buildSolution(CityEntry goal) {
        LinkedList<City> path = new LinkedList<>();
        SearchSolution solution = new SearchSolution(null, 0);

        buildSolutionHelper(goal, path, solution);

        Collections.reverse(path);
        solution.setPath(path);

        return solution;
    }

    private void buildSolutionHelper(CityEntry entry, LinkedList<City> path, SearchSolution solution) {
        if (entry.getParent() == null) { // Reached start city
            path.add(entry.getCity());
            return;
        }

        path.add(entry.getCity());
        solution.setTravelTime(
                solution.getTravelTime() + entry.getParent().getCity().getRoadTo(entry.getCity()).getTravelTime());

        buildSolutionHelper(entry.getParent(), path, solution);
    }

    private void addCitiesToFrontier(List<City> cities, CityEntry parent) {
        for (City city : cities) {
            CityEntry newCity = new CityEntry(city, parent, this.getCost(city, parent));
            if (!this.frontier.contains(newCity) && !this.explored.contains(newCity)) {
                this.frontier.add(newCity);
            } else if (this.frontier.contains(newCity) && newCity.getCost() < this.getFromFrontier(newCity).getCost()) {
                this.replaceFrontierEntry(newCity);
            }
        }
    }

    private double getCost(City city, CityEntry parent) {
        double roadTravelTime = city.getRoadTo(parent.getCity()).getTravelTime();
        return roadTravelTime == Double.POSITIVE_INFINITY ? roadTravelTime
                : parent.getCost() + roadTravelTime + city.distanceTo(goalCity) / this.maxRealSpeed;
    }

    private void replaceFrontierEntry(CityEntry cityEntry) {
        CityEntry oldEntry = this.getFromFrontier(cityEntry);

        // Update old entry with new values
        oldEntry.setCost(cityEntry.getCost());
        oldEntry.setParent(cityEntry.getParent());
    }

    private CityEntry getFromFrontier(CityEntry cityEntry) {
        for (CityEntry c : this.frontier) {
            if (c.equals(cityEntry))
                return c;
        }

        return null;
    }

    private boolean goalTest(City city) {
        return city.equals(this.goalCity);
    }

}
