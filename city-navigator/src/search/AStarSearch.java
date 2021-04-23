package search;

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

        CityEntry currentCityEntry = new CityEntry(startCity, null, 0, 0);
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
            CityEntry newCity = new CityEntry(city, parent, this.getCost(city, parent),
                    this.getTravelTimeToCurrent(city, parent));
            if (!this.frontier.contains(newCity) && !this.explored.contains(newCity)) {
                this.frontier.add(newCity);
            } else if (this.frontier.contains(newCity) && newCity.getCost() < this.getFromFrontier(newCity).getCost()) {
                this.replaceFrontierEntry(newCity);
            }
        }
    }

    private double getTravelTimeToCurrent(City city, CityEntry parent) {
        return parent.getTravelTimeToCity() + city.getRoadTo(parent.getCity()).getTravelTime();
    }

    private double getCost(City city, CityEntry parent) {
        double roadTravelTime = city.getRoadTo(parent.getCity()).getTravelTime();
        return roadTravelTime == Double.POSITIVE_INFINITY ? roadTravelTime
                : parent.getTravelTimeToCity() + roadTravelTime + city.distanceTo(this.goalCity) / this.maxRealSpeed;
    }

    private void replaceFrontierEntry(CityEntry cityEntry) {
        PriorityQueue<CityEntry> newQueue = new PriorityQueue<>();

        while (!this.frontier.isEmpty()) {
            CityEntry temp = this.frontier.poll();
            if (temp.equals(cityEntry)) {
                newQueue.add(cityEntry);
            } else {
                newQueue.add(temp);
            }
        }

        this.frontier = newQueue;
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
