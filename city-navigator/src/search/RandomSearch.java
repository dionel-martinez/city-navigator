package search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;

import components.City;
import components.Map;
import components.Road.TrafficCongestionDegree;

public class RandomSearch implements Search {

	private City goalCity;
	private double maxRealSpeed;
	private Random rand = new Random();
	private final int stepLimit = 1000;

	@Override
	public SearchSolution search(Map map, String start, String goal) {

		SearchSolution min = searchHelper(map, start, goal);
		return min;
	}

	private SearchSolution searchHelper(Map map, String start, String goal) {

		if (map.getCity(start) == null || map.getCity(goal) == null) {
			return null;
		}

		City startCity = map.getCity(start);
		this.goalCity = map.getCity(goal);
		this.maxRealSpeed = map.getMaxRealSpeed();
		double totalTimeTravel = 0.0;
		int steps = 0;

		HashSet<City> visited = new HashSet<>();
		CityEntry currentCityEntry = new CityEntry(startCity, null, 0, 0);
		LinkedList<City> path = new LinkedList<>();
		path.add(startCity);
		visited.add(startCity);
		SearchSolution solution = new SearchSolution(path, 0);

		while (!currentCityEntry.getCity().equals(this.goalCity) && steps++ < stepLimit) {
			int index = rand.nextInt(currentCityEntry.getCity().getReachableCities().size());
			City nextCity = currentCityEntry.getCity().getReachableCities().get(index);

			// Make sure it doesn't travel through a closed road
			while (currentCityEntry.getCity().getRoadTo(nextCity)
					.getTrafficCongestionDegree() == TrafficCongestionDegree.CLOSED) {
				index = rand.nextInt(currentCityEntry.getCity().getReachableCities().size());
				nextCity = currentCityEntry.getCity().getReachableCities().get(index);
			}

			if (!visited.contains(nextCity)) {
				path.add(nextCity);
				CityEntry child = new CityEntry(nextCity, currentCityEntry, this.getCost(nextCity, currentCityEntry),
						this.getTravelTimeToCurrent(nextCity, currentCityEntry));
				totalTimeTravel =  this.getTravelTimeToCurrent(nextCity, currentCityEntry);
				currentCityEntry = child;
				visited.add(currentCityEntry.getCity());
			} else {
				boolean stuck = true;
				for (City city : currentCityEntry.getCity().getReachableCities()) {
					if (!visited.contains(city)) {
						stuck = false;
					}
				}
				if (stuck) {
					currentCityEntry = currentCityEntry.getParent();
				}
			}

		}

		// Check if step limit was reached
		if (steps >= stepLimit) {
			solution.setPath(new LinkedList<>());
			solution.setTravelTime(Double.POSITIVE_INFINITY);
		} else {
			solution.setTravelTime(totalTimeTravel);
		}
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

	@Override
	public String getIdentifier() {
		return "Random Search";
	}
}
