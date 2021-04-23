package search;

import components.City;

public class CityEntry {

    private City city;
    private City parentCity;
    private double cost;

    public CityEntry(City city, City parentCity, double cost) {
        this.city = city;
        this.parentCity = parentCity;
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        CityEntry c = (CityEntry) o;

        return this == c || (this.city.equals(c.getCity()) && this.cost == c.getCost());
    }

    // TODO: Implement compare to

    // GETTERS
    public City getCity() {
        return this.city;
    }

    public City getParentCity() {
        return this.parentCity;
    }

    public double getCost() {
        return this.cost;
    }

    // SETTERS
    public void setCity(City city) {
        this.city = city;
    }

    public void setParentCity(City parentCity) {
        this.parentCity = parentCity;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
