package components;

import java.util.LinkedList;

import components.Road.TrafficCongestionDegree;

public class Map {

    LinkedList<City> cities;

    public Map() {
        this.cities = new LinkedList<>();
    }

    public int cityCount() {
        return this.cities.size();
    }

    public void addCity(City c) {
        this.cities.add(c);
    }

    public City getCity(String cityName) {

        for (City city : this.cities) {
            if (city.getName().equals(cityName))
                return city;
        }

        return null;
    }

    public boolean addRoadBetweenCities(String city1Name, String city2Name, double distance, int speedLimit,
            TrafficCongestionDegree trafficLevel) {
        return this.addRoadBetweenCities(this.getCity(city1Name), this.getCity(city2Name), distance, speedLimit,
                trafficLevel);
    }

    public boolean addRoadBetweenCities(City city1, City city2, double distance, int speedLimit,
            TrafficCongestionDegree trafficLevel) {
        if (city1 == null || city2 == null)
            return false;

        if (!this.cities.contains(city1) || !this.cities.contains(city2))
            return false;

        Road road = new Road(city1, city2, distance, speedLimit, trafficLevel);
        city1.addRoad(road);
        city2.addRoad(road);

        return true;
    }

    public LinkedList<City> getCities() {
        return this.cities;
    }
}
