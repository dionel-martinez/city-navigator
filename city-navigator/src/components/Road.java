/**
 * 
 */
package components;

import java.awt.geom.Point2D;

public class Road {
	public enum TrafficCongestionDegree{
		NONE(0),
		VERY_LOW(0.125),
		LOW(0.25), 
		LOW_MED(0.375),
		MEDIUM(0.5),
		MED_HIGH(0.625),
		HIGH(0.75),
		VERY_HIGH(0.875),
		CLOSED(1);

		double degree;
		TrafficCongestionDegree(double degree) {
			this.degree = degree;
		}

	}

	City city1, city2;
	int speedLimit;
	double distance;
	TrafficCongestionDegree trafficLevel;

	public Road(City from, City to, double distance, int speedLimit, TrafficCongestionDegree trafficLevel) {
		this.city1 = from;
		this.city2 = to;
		this.distance = distance;
		this.speedLimit = speedLimit;
		this.trafficLevel = trafficLevel;
	}
	
	public Road(City from, City to, double distance, int speedLimit) {
		this(from, to, distance, speedLimit, TrafficCongestionDegree.VERY_LOW);
	}
	
	// TODO
	
	public double travelTime() {
		return trafficLevel == TrafficCongestionDegree.CLOSED ? Double.POSITIVE_INFINITY : getDistance()/(speedLimit*(1-trafficLevel.degree));

	}
	
	public double getDistance() {
        return Point2D.distance(city1.x, city2.x, city1.y, city2.y);
     }
	
	public City getCity1() {return city1;}
	public City getCity2() {return city2;}
	
	public void setTrafficCongestionDegree(TrafficCongestionDegree tcd) {
		this.trafficLevel = tcd;
	}

}
