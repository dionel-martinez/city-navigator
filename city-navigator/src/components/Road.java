/**
 * 
 */
package components;

public class Road {
	public enum TrafficCongestionDegree {
		NONE(0), VERY_LOW(0.125), LOW(0.25), LOW_MED(0.375), MEDIUM(0.5), MED_HIGH(0.625), HIGH(0.75), VERY_HIGH(0.875),
		CLOSED(1);

		double degree;

		TrafficCongestionDegree(double degree) {
			this.degree = degree;
		}

	}

	private City city1, city2;
	private int speedLimit;
	private double distance;
	private TrafficCongestionDegree trafficLevel;

	public Road(City city1, City to, double distance, int speedLimit, TrafficCongestionDegree trafficLevel) {
		this.city1 = city1;
		this.city2 = to;
		this.distance = distance;
		this.speedLimit = speedLimit;
		this.trafficLevel = trafficLevel;
	}

	public Road(City from, City to, double distance, int speedLimit) {
		this(from, to, distance, speedLimit, TrafficCongestionDegree.VERY_LOW);
	}

	public double getTravelTime() {
		// Return the travel time (cost) of a road
		return trafficLevel == TrafficCongestionDegree.CLOSED ? Double.POSITIVE_INFINITY
				: getDistance() / this.getRealSpeed();
	}

	public double getRealSpeed() {
		return this.speedLimit * (1 - this.trafficLevel.degree);
	}

	/**
	 * 
	 * GETTERS AND SETTERS
	 */
	public City getCity1() {return city1;}
	public City getCity2() {return city2;}
	public int getSpeedLimit() {return this.speedLimit;}
	public TrafficCongestionDegree getTrafficCongestionDegree() {return this.trafficLevel;}
	public double getDistance() {return this.distance;}
	
	public void setCity1(City city1) {this.city1 = city1;}
	public void setCity2(City city2) {this.city2 = city2;}
	public void setSpeedLimit(int speedLimit) {this.speedLimit = speedLimit;}
	public void setTrafficCongestionDegree(TrafficCongestionDegree tcd) {this.trafficLevel = tcd;}
	public void setDistance(double distance) {this.distance = distance;}

}
