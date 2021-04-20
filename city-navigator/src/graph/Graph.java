package graph;

import java.util.LinkedList;

public class Graph<City>{

	LinkedList<Node<City>> nodes;

	public Graph(){
		nodes = new LinkedList<Node<City>>();
	}

	public int size() {
		return nodes.size();
	}

	public LinkedList<Node<City>> getNodeList(){
		return nodes;
	}

	public void addNode(City c) {
		nodes.add(new Node<City>(c));
	}

	public boolean addEdge(double cost, City from, City to) {
		Node<City> node1 = getNode(from);
		Node<City> node2 = getNode(to);
		if(node1 == null || node2 == null) {
			return false;
		}
		node1.addEdge(new Edge<City>(cost, node2));
		node2.addEdge(new Edge<City>(cost, node1));
		return true;
	}

	public Node<City> getNode(int index) {
		return nodes.get(index);
	}

	public int indexOf(Node<City> node) {
		for (int i = 0; i < nodes.size(); i++) {
			if(nodes.get(i).equals(node))
				return i;
		}
		return -1;
	}

	public Node<City> getNode(City c) {
		for (Node<City> node : nodes) {
			if(node.city.equals(c))
				return node;
		}
		return null;
	}


}
