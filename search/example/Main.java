package Search.src.uk.ac.hw.macs.search.example;

import Search.src.uk.ac.hw.macs.search.Node;
import Search.src.uk.ac.hw.macs.search.SearchOrder;
import Search.src.uk.ac.hw.macs.search.SearchProblem;

public class Main {

	private static Node addChild(int value, boolean goal, Node parent) {
		//define child node to be a node of type intState
		Node child = new Node(new IntState(value, goal));
	
		parent.addChild(child, 1);
		return child;
	}
	
	public static void main(String[] args) {
		//root node is starting node or current noce
		//no need to assign bool isGoal as all but goal node are false
		Node root = new Node(new IntState(0));
		//goal is the goal node with isGoal being tagged true
		Node goal = new Node(new IntState(5, true));
		//adds chain of child nodes
		Node child = addChild(1, false, root);
		child = addChild(2, false, child);
		child = addChild(3, false, child);
		addChild(4, false, child);
		//add to root's hashset of children
		root.addChild(goal, 1);

		//serch order algorithm used
		SearchOrder order = new BreadthFirstSearchOrder();
		//search problem we are using
		SearchProblem problem = new SearchProblem(order);
		//call search to be performed on the problem
		problem.doSearch(root);
	}
	

}
