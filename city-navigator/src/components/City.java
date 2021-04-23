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
		int Radius=6371;//radius of earth in Km         
        double lat1 = this.x;
        double lat2 = city.x;
        double lon1 = this.y;
        double lon2 = city.y;
        double dLat = Math.toRadians(lat2-lat1);
        double dLon = Math.toRadians(lon2-lon1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
        Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
        Math.sin(dLon/2) * Math.sin(dLon/2);
        double c = 2 * Math.asin(Math.sqrt(a));
        double valueResult= Radius*c;

        return valueResult;
	}

	public void addRoad(Road road) {
		this.roads.add(road);
	}

	/**
	 * 
	 * @return list of cities reachable through the current city's roads
	 */
	public LinkedList<City> getReachableCities() {
		LinkedList<City> reachableCities = new LinkedList<>();

		for (Road road : this.roads)
			reachableCities.add(road.getCity1().equals(this) ? road.getCity2() : road.getCity1());

		return reachableCities;
	}

	public Road getRoadTo(City city) {
		for (Road road : this.roads) {
			if (road.getCity1().equals(city) || road.getCity2().equals(city)) {
				return road;
			}
		}

		return null;
	}

	public double getMaxRealSpeed() {
		double max = Double.MIN_VALUE;

		for (Road road : this.roads) {
			if (road.getRealSpeed() > max) {
				max = road.getRealSpeed();
			}
		}

		return max;
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
	public String getName() {
		return this.getName();
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	/**
	 * 
	 * SETTERS
	 */

	public void setName(String name) {
		this.name = name;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}
}
