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

	public double distanceTo(City city) {
		// Returns the straight line distance to
		// the given city
		return this.getPoint().distance(city.getPoint());
	}

	public void addRoad(Road road) {
		this.roads.add(road);
	}

	public LinkedList<City> getReachableCities() {
		// Returns a list of cities reachable through the
		// current citie's roads

		LinkedList<City> reachableCities = new LinkedList<>();

		for (Road road : this.roads) {
			reachableCities.add(road.getCity1() == this ? road.getCity2() : road.getCity1());
		}

		return reachableCities;
	}

	public String getName() {
		return this.getName();
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public Point2D getPoint() {
		return new Point2D.Double(this.x, this.y);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;

		City c = (City) o;
		return this.name.equals(c.getName()) && this.getPoint().equals(c.getPoint());
	}
}
