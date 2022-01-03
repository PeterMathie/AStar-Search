package Search.src.uk.ac.hw.macs.search;

import java.util.HashSet;
import java.util.Set;

public class Node {

	public State value;	
	//goal and heuristics
	public ASState valueAS;
	//for a node of index[i][j] children are at nodes [i-1][j], [i+1][j], [i][j-1], [i][j+1]
	public Set<ChildWithCost> children;

	public Node(ASState valueAS) {
		this.valueAS       = valueAS;
		this.children      = new HashSet<>();
	}

	public Node(State value) {
		this.value = value;
	}

	//adds a node's children to its set chlildren
	public boolean addChild(Node child, int cost) {
		return children.add(new ChildWithCost(child, cost));
	}
	
	//retruns the set of a given nodes children
	public Set<ChildWithCost> getChildren() {
		return children;
	}
	//the cost to enter the node (1 for regulare, 3 for exspensive and 100 for walls)
	public ASState getValueAS() {
		return valueAS;
	}
	public State getValue() {
		return value;
	}
	//boolean to indicate if node is the goal or not
	public boolean isGoalAS() {
		return valueAS.isGoal();
	}
	public boolean isGoal() {
		return value.isGoal();
	}
	@Override
	public String toString() {
		return "Node [value=" + valueAS + "]";
	}
}
