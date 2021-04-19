/**
 * 
 */
package components;

/**
 * @author dionel.martinez
 *
 */
public class Road {
	enum TrafficCongestionDegree{
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
		
		return -1;
	}

}
