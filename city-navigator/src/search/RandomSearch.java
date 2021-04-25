package search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import components.City;
import components.Map;

public class RandomSearch implements Search{
	
	private Set<CityEntry> explored;
	private City goalCity;
	
	public RandomSearch() {
		this.explored = new HashSet<CityEntry>();
	}
	
	@Override
	public SearchSolution search(Map map, String start, String goal) {
		
		if(map.getCity(start) == null || map.getCity(goal) == null) {
			return null;
		}
		
		City startCity = map.getCity(start);
		this.goalCity = map.getCity(goal);
		
		return null;
	}
}
