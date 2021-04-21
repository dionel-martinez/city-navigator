/**
 * 
 */
package components;

import java.awt.geom.Point2D;
import java.util.LinkedList;

public class City {

	private String name;
	private double x, y; // City coordinates
	private LinkedList<Road> roads;

	public City(String name, double x, double y) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.roads = new LinkedList<>();
	}
	
	/**
	 * @param city
	 * @return straight line distance to the given city
	 */
	public double distanceTo(City city) {
		return Point2D.distance(x, y, city.getX(), city.getY());
	}

	public void addRoad(Road road) {
		this.roads.add(road);
	}
	/**
	 * 
	 * @return list of cities reachable through the current citie's roads
	 */
	public LinkedList<City> getReachableCities() {
		LinkedList<City> reachableCities = new LinkedList<>();

		for (Road road : this.roads) 
			reachableCities.add(road.getCity1().equals(this) ? road.getCity2() : road.getCity1());
		
		return reachableCities;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass())
			return false;
		City c = (City) o;
		
		return this == c || (this.name.equals(c.getName()) && x == c.getX() && y == c.getY());
	}
	
	/**
	 * 
	 * GETTERS
	 */
	public String getName() {return this.getName();}
	public double getX() {return this.x;}
	public double getY() {return this.y;}

}
