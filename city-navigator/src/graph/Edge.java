package graph;

public class Edge<City>{

	double cost;
	Node<City> node;

	public Edge(double cost, Node<City> node) {
		this.cost = cost;
		this.node = node;
	}

	public Node<City> getNode() {
		return node;
	}
	
	public double getCost() {
		return cost;
	}

}