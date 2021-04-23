package search;

import components.Map;

public interface Search {
    public SearchSolution search(Map map, String start, String goal);
}
