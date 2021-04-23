package search;

import java.util.List;

import components.City;

public class SearchSolution {

    List<City> path;
    double travelTime;

    public SearchSolution(List<City> path, double travelTime) {
        this.path = path;
        this.travelTime = travelTime;
    }

    // GETTERS
    public List<City> getPath() {
        return this.path;
    }

    public double getTravelTime() {
        return this.travelTime;
    }

    // SETTERS
    public void setPath(List<City> path) {
        this.path = path;
    }

    public void setTravelTime(double travelTime) {
        this.travelTime = travelTime;
    }
}
