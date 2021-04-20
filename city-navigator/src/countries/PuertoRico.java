/**
 * 
 */
package countries;

import java.util.LinkedList;
import java.util.Random;

import components.City;
import components.Road;
import components.Road.TrafficCongestionDegree;
import graph.Graph;

public class PuertoRico extends Graph<City> {

	public PuertoRico() {
		super();
		addCities();
		createRoads();
	}

	public City cayey = new City("Cayey",18.1147676,-66.1677892);
	public City salinas = new City("Salinas",18.0045791,-66.3244161);
	public City santaIsabel = new City("Santa Isabel",17.9810439,-66.4269804);
	public City barranquitas = new City("Barranquitas",18.1845662,-66.3138549);
	public City ponce = new City("Ponce",17.9702607,-66.6639921);
	public City villalba = new City("Villalba",18.1301094,-66.509399);
	public City caguas = new City("Caguas",18.23931,-66.0770615);
	public City arroyo = new City("Arroyo",17.9965036,-66.0924881);
	public City humacao = new City("Humacao",18.1381108,-65.8387628);
	public City fajardo = new City("Fajardo",18.3332889,-65.6738796);
	public City canovana = new City("Canovana",18.3811414,-65.922932);
	public City sanJuan = new City("San Juan",18.3893875,-66.1305125);
	public City vegaBaja = new City("Vega Baja",18.4430098,-66.4198185);
	public City manati = new City("Manati",18.418203,-66.5262785);
	public City arecibo = new City("Arecibo",18.4049622,-66.745303);
	public City lares = new City("Lares",18.295587,-66.8905283);
	public City adjunta = new City("Adjunta",18.1812148,-66.7859854);
	public City yauco = new City("Yauco",18.0339475,-66.881348);
	public City lajas = new City("Lajas",18.0466201,-67.0668792);
	public City sanGerman = new City("San German",18.0831448,-67.0519916);
	public City mayaguez = new City("Mayaguez",18.2019879,-67.1686796);
	public City aguadilla = new City("Aguadilla",18.419396,-67.1711135);

	private void addCities() {
		addNode(cayey);
		addNode(salinas);
		addNode(santaIsabel);
		addNode(barranquitas);
		addNode(ponce);
		addNode(villalba);
		addNode(caguas);
		addNode(arroyo);
		addNode(humacao);
		addNode(fajardo);
		addNode(canovana);
		addNode(sanJuan);
		addNode(vegaBaja);
		addNode(manati);
		addNode(arecibo);
		addNode(lares);
		addNode(adjunta);
		addNode(yauco);
		addNode(lajas);
		addNode(sanGerman);
		addNode(mayaguez);
		addNode(aguadilla);

	}

	private void createRoads() {
		LinkedList<Road> roads = new LinkedList<Road>();
		
		roads.add(new Road(ponce, santaIsabel, 24, 100, null));
		roads.add(new Road(salinas, santaIsabel, 12, 100, null));
		roads.add(new Road(salinas, cayey, 28, 100, null));
		roads.add(new Road(salinas, arroyo, 33, 100, null));
		roads.add(new Road(arroyo, humacao, 50, 100, null));
		roads.add(new Road(humacao, fajardo, 40, 100, null));
		roads.add(new Road(humacao, caguas, 31, 100, null));
		roads.add(new Road(canovana, fajardo, 32, 100, null));
		roads.add(new Road(canovana, caguas, 36, 100, null));
		roads.add(new Road(sanJuan, canovana, 30, 100, null));
		roads.add(new Road(sanJuan, vegaBaja, 47, 100, null));
		roads.add(new Road(sanJuan, caguas, 33, 100, null));
		roads.add(new Road(cayey, caguas, 25, 100, null));
		roads.add(new Road(cayey, barranquitas, 30, 100, null));
		roads.add(new Road(barranquitas, santaIsabel, 40, 100, null));
		roads.add(new Road(barranquitas, villalba, 33, 100, null));
		roads.add(new Road(ponce, villalba, 30, 100, null));
		roads.add(new Road(ponce, adjunta, 25, 100, null));
		roads.add(new Road(ponce, yauco, 35, 100, null));		
		roads.add(new Road(yauco, sanGerman, 27, 100, null));
		roads.add(new Road(yauco, lajas, 30, 100, null));
		roads.add(new Road(lajas, sanGerman, 5, 100, null));
		roads.add(new Road(sanGerman, mayaguez, 20, 100, null));
		roads.add(new Road(mayaguez, aguadilla, 28, 100, null));
		roads.add(new Road(lares, adjunta, 32, 100, null));
		roads.add(new Road(lares, arecibo, 29, 100, null));
		roads.add(new Road(aguadilla, arecibo, 50, 100, null));
		roads.add(new Road(arecibo, manati, 30, 100, null));
		roads.add(new Road(manati, barranquitas, 55, 100, null));
		roads.add(new Road(manati, vegaBaja, 10, 100, null));
		roads.add(new Road(vegaBaja, barranquitas, 47, 100, null));

		Random rand = new Random();
		for(Road road: roads) {
			switch(rand.nextInt(14)) {
			
			case 1: road.setTrafficCongestionDegree(TrafficCongestionDegree.NONE);
			break;
			
			case 2: road.setTrafficCongestionDegree(TrafficCongestionDegree.VERY_LOW);
			break;
			
			case 3: road.setTrafficCongestionDegree(TrafficCongestionDegree.LOW);
			break;
			
			case 4: road.setTrafficCongestionDegree(TrafficCongestionDegree.LOW_MED);
			break;
			
			case 5: road.setTrafficCongestionDegree(TrafficCongestionDegree.MEDIUM);
			break;
			
			case 6: road.setTrafficCongestionDegree(TrafficCongestionDegree.MED_HIGH);
			break;
			
			case 7: road.setTrafficCongestionDegree(TrafficCongestionDegree.HIGH);
			break;
			
			case 8: road.setTrafficCongestionDegree(TrafficCongestionDegree.VERY_HIGH);
			break;
			
			case 11: road.setTrafficCongestionDegree(TrafficCongestionDegree.CLOSED);
			break;
			
			default: road.setTrafficCongestionDegree(TrafficCongestionDegree.NONE);
			
			}
			addEdge(road.travelTime(), road.getCity1(), road.getCity2());
		}

	}



}
