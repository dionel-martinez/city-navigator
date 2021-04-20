package graph;

import java.util.LinkedList;

import graph.Edge;

public class Node<City>{


	//Node Info
	City city;
	LinkedList<Edge<City>> edges;


	public Node(City city) {
		this.city = city;
		edges = new LinkedList<Edge<City>>();
	}

	public void addEdge(Edge<City> edge) {
		edges.add(edge);
	}

	public LinkedList<Node<City>> getNodeChildrens() {
		LinkedList<Node<City>> childrens = new LinkedList<Node<City>>();
		for(Edge<City> e: edges) {
			childrens.add(e.getNode());
		}
		return childrens;
	}

}
