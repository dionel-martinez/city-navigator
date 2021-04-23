package search;

import components.City;

public class CityEntry implements Comparable<CityEntry> {

    private City city;
    private CityEntry parent;
    private double cost;
    private double travelTimeToCity;

    public CityEntry(City city, CityEntry parent, double cost, double travelTimeToCity) {
        this.city = city;
        this.parent = parent;
        this.cost = cost;
        this.travelTimeToCity = travelTimeToCity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        CityEntry c = (CityEntry) o;

        return this.city.equals(c.getCity());
    }

    @Override
    public int compareTo(CityEntry o) {
        return Double.compare(this.cost, o.getCost());
    }

    // GETTERS
    public City getCity() {
        return this.city;
    }

    public CityEntry getParent() {
        return this.parent;
    }

    public double getCost() {
        return this.cost;
    }

    public double getTravelTimeToCity() {
        return this.travelTimeToCity;
    }

    // SETTERS
    public void setCity(City city) {
        this.city = city;
    }

    public void setParent(CityEntry parentCity) {
        this.parent = parentCity;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setTravelTimeToCity(double travelTimeToCity) {
        this.travelTimeToCity = travelTimeToCity;
    }
}
