package search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;

import components.City;
import components.Map;
import components.Road;

public class RandomSearch implements Search{
	
	private Set<CityEntry> explored;
	private City goalCity;
    private double maxRealSpeed;
	private Random rand = new Random();
	
	public RandomSearch() {
		this.explored = new HashSet<CityEntry>();
	}
	
	@Override
	public SearchSolution search(Map map, String start, String goal) {
		
		SearchSolution min = searchHelper(map, start, goal);
		for (int i = 0; i < 600; i++) {
			SearchSolution randomPath = searchHelper(map, start, goal);
			if(randomPath.getTravelTime() < min.getTravelTime()) {
				min = randomPath;
			}
		}
		return min;
		
	}
	
	private SearchSolution searchHelper(Map map, String start, String goal) {
		
		if(map.getCity(start) == null || map.getCity(goal) == null) {
			return null;
		}
		
		City startCity = map.getCity(start);
		this.goalCity = map.getCity(goal);
		this.maxRealSpeed = map.getMaxRealSpeed();
		double totalTimeTravel = 0.0;
		
		HashSet<City> visited = new HashSet<>();
		CityEntry currentCityEntry = new CityEntry(startCity, null, 0, 0);
		LinkedList<City> path = new LinkedList<>();
		path.add(startCity);
		visited.add(startCity);
		SearchSolution solution = new SearchSolution(path, 0);
		
		while(!currentCityEntry.getCity().equals(this.goalCity)) {
			int index = rand.nextInt(currentCityEntry.getCity().getReachableCities().size());
			City nextCity = currentCityEntry.getCity().getReachableCities().get(index);
			if(!visited.contains(nextCity)) {
				path.add(nextCity);
				CityEntry child = new CityEntry(nextCity, currentCityEntry,
						this.getCost(nextCity, currentCityEntry), 
						this.getTravelTimeToCurrent(nextCity, currentCityEntry)); 
				totalTimeTravel = totalTimeTravel + this.getTravelTimeToCurrent(nextCity, currentCityEntry);
				currentCityEntry = child;
				visited.add(currentCityEntry.getCity());
			}
			else {
				boolean stuck = true;
				for(City city : currentCityEntry.getCity().getReachableCities()) {
					if(!visited.contains(city)) {
						stuck = false;
					}
				}
				if(stuck) {
					currentCityEntry = currentCityEntry.getParent();
				}
			}

		}
		solution.setTravelTime(totalTimeTravel);
		return solution;
	}
	
	private double getCost(City city, CityEntry parent) {
        double roadTravelTime = city.getRoadTo(parent.getCity()).getTravelTime();
        return roadTravelTime == Double.POSITIVE_INFINITY ? roadTravelTime
                : parent.getTravelTimeToCity() + roadTravelTime + city.distanceTo(this.goalCity) / this.maxRealSpeed;
    }
	
    private double getTravelTimeToCurrent(City city, CityEntry parent) {
        return parent.getTravelTimeToCity() + city.getRoadTo(parent.getCity()).getTravelTime();
    }
}
