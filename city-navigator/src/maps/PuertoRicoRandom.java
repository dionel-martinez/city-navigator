package maps;

import java.util.LinkedList;
import java.util.Random;

import components.Road;
import components.Road.TrafficCongestionDegree;

public class PuertoRicoRandom extends PuertoRico {

    public PuertoRicoRandom() {
        addCities();
        createRoads();
    }

    protected void createRoads() {
        LinkedList<Road> roads = new LinkedList<Road>();

        roads.add(new Road(ponce, santaIsabel, 24, 100));
        roads.add(new Road(salinas, santaIsabel, 12, 100));
        roads.add(new Road(salinas, cayey, 28, 100));
        roads.add(new Road(salinas, arroyo, 33, 100));
        roads.add(new Road(arroyo, humacao, 50, 100));
        roads.add(new Road(humacao, fajardo, 40, 100));
        roads.add(new Road(humacao, caguas, 31, 100));
        roads.add(new Road(canovanas, fajardo, 32, 100));
        roads.add(new Road(canovanas, caguas, 36, 100));
        roads.add(new Road(sanJuan, canovanas, 30, 100));
        roads.add(new Road(sanJuan, vegaBaja, 47, 100));
        roads.add(new Road(sanJuan, caguas, 33, 100));
        roads.add(new Road(cayey, caguas, 25, 100));
        roads.add(new Road(cayey, barranquitas, 30, 100));
        roads.add(new Road(barranquitas, santaIsabel, 40, 100));
        roads.add(new Road(barranquitas, villalba, 33, 100));
        roads.add(new Road(ponce, villalba, 30, 100));
        roads.add(new Road(ponce, adjuntas, 25, 100));
        roads.add(new Road(ponce, yauco, 35, 100));
        roads.add(new Road(yauco, sanGerman, 27, 100));
        roads.add(new Road(yauco, lajas, 30, 100));
        roads.add(new Road(lajas, sanGerman, 5, 100));
        roads.add(new Road(sanGerman, mayaguez, 20, 100));
        roads.add(new Road(mayaguez, aguadilla, 28, 100));
        roads.add(new Road(lares, adjuntas, 32, 100));
        roads.add(new Road(lares, arecibo, 29, 100));
		roads.add(new Road(lares, mayaguez, 47, 100));
        roads.add(new Road(aguadilla, arecibo, 50, 100));
        roads.add(new Road(arecibo, manati, 30, 100));
        roads.add(new Road(manati, barranquitas, 55, 100));
        roads.add(new Road(manati, vegaBaja, 10, 100));
        roads.add(new Road(vegaBaja, barranquitas, 47, 100));

        Random rand = new Random();
        for (Road road : roads) {
            switch (rand.nextInt(14)) {

            case 1:
                road.setTrafficCongestionDegree(TrafficCongestionDegree.NONE);
                break;

            case 2:
                road.setTrafficCongestionDegree(TrafficCongestionDegree.VERY_LOW);
                break;

            case 3:
                road.setTrafficCongestionDegree(TrafficCongestionDegree.LOW);
                break;

            case 4:
                road.setTrafficCongestionDegree(TrafficCongestionDegree.LOW_MED);
                break;

            case 5:
                road.setTrafficCongestionDegree(TrafficCongestionDegree.MEDIUM);
                break;

            case 6:
                road.setTrafficCongestionDegree(TrafficCongestionDegree.MED_HIGH);
                break;

            case 7:
                road.setTrafficCongestionDegree(TrafficCongestionDegree.HIGH);
                break;

            case 8:
                road.setTrafficCongestionDegree(TrafficCongestionDegree.VERY_HIGH);
                break;

            case 11:
                road.setTrafficCongestionDegree(TrafficCongestionDegree.CLOSED);
                break;

            default:
                road.setTrafficCongestionDegree(TrafficCongestionDegree.VERY_LOW);

            }
            addRoadBetweenCities(road.getCity1(), road.getCity2(), road.getDistance(), road.getSpeedLimit(),
                    road.getTrafficCongestionDegree());
        }

    }

}
