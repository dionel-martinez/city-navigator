package maps;

import java.util.LinkedList;

import components.Road;
import components.Road.TrafficCongestionDegree;

public class PuertoRicoVarying extends PuertoRico {

    public PuertoRicoVarying() {
        addCities();
        createRoads();
    }

    protected void createRoads() {
        LinkedList<Road> roads = new LinkedList<Road>();

        roads.add(new Road(ponce, santaIsabel, 24, 100, TrafficCongestionDegree.VERY_HIGH));
        roads.add(new Road(salinas, santaIsabel, 12, 100, TrafficCongestionDegree.MEDIUM));
        roads.add(new Road(salinas, cayey, 28, 100));
        roads.add(new Road(salinas, arroyo, 33, 90));
        roads.add(new Road(arroyo, humacao, 50, 90));
        roads.add(new Road(humacao, fajardo, 40, 90));
        roads.add(new Road(humacao, caguas, 31, 100));
        roads.add(new Road(canovanas, fajardo, 32, 90));
        roads.add(new Road(canovanas, caguas, 36, 90));
        roads.add(new Road(sanJuan, canovanas, 30, 100));
        roads.add(new Road(sanJuan, vegaBaja, 47, 100, TrafficCongestionDegree.MEDIUM));
        roads.add(new Road(sanJuan, caguas, 33, 100));
        roads.add(new Road(cayey, caguas, 25, 100, TrafficCongestionDegree.HIGH));
        roads.add(new Road(cayey, barranquitas, 30, 70));
        roads.add(new Road(barranquitas, santaIsabel, 40, 70));
        roads.add(new Road(barranquitas, villalba, 33, 70));
        roads.add(new Road(ponce, villalba, 30, 70, TrafficCongestionDegree.LOW_MED));
        roads.add(new Road(ponce, adjuntas, 25, 70, TrafficCongestionDegree.MEDIUM));
        roads.add(new Road(ponce, yauco, 35, 90));
        roads.add(new Road(yauco, sanGerman, 27, 90));
        roads.add(new Road(yauco, lajas, 30, 90));
        roads.add(new Road(lajas, sanGerman, 5, 90));
        roads.add(new Road(sanGerman, mayaguez, 20, 90));
        roads.add(new Road(mayaguez, aguadilla, 28, 90));
        roads.add(new Road(lares, adjuntas, 32, 70));
        roads.add(new Road(lares, arecibo, 29, 70));
        roads.add(new Road(lares, mayaguez, 47, 70));
        roads.add(new Road(aguadilla, arecibo, 50, 90));
        roads.add(new Road(arecibo, manati, 30, 90));
        roads.add(new Road(manati, barranquitas, 55, 70));
        roads.add(new Road(manati, vegaBaja, 10, 100));
        roads.add(new Road(vegaBaja, barranquitas, 47, 70));

        for (Road road : roads) {
            addRoadBetweenCities(road.getCity1(), road.getCity2(), road.getDistance(), road.getSpeedLimit(),
                    road.getTrafficCongestionDegree());
        }

    }

}
