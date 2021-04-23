package search;

import java.util.List;

import components.Map;

public interface Search {
    public List<CityEntry> search(Map map, String start, String goal);
}
