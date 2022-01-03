package Search.src.uk.ac.hw.macs.search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Represents a search problem.
 * 
 * @author Mary Ellen Foster <MaryEllen.Foster@glasgow.ac.uk>
 */
public class SearchProblem {
	public List<int[]> path = new LinkedList();
	private SearchOrder searchOrder;
	
	public SearchProblem(SearchOrder searchOrder) {
		this.searchOrder = searchOrder;
	}

	public boolean doSearch(Node root) {
		//initialise open list
		List<FrontierNode> frontier = new LinkedList();
		//add current node to open list
		frontier.add(new FrontierNode(root, null, 0));
		//initialise closed list
		Set<Node> visitedStates = new HashSet();	
		FrontierNode goalNode = null;
		while (true) {
			if (frontier.isEmpty()) {
				// We didn't find it
				break;
			}
			//pop first (index 0) node off frontier list
			FrontierNode searchNode = frontier.remove(0);

			//System.out.println("\nSearch node: " + searchNode);
			//System.out.println("\nCurrent node child: " + searchNode.node.getChildren() );
			//System.out.println("\nVisited nodes: " + visitedStates);

			
			// If current node is in closed list ignore current node
			if (visitedStates.contains(searchNode.node)) {
				continue;
			}
			
			// Have we reached a goal state? If so, we're done
			if (searchNode.node.isGoalAS()) {
				goalNode = searchNode;
				break;
			}
			
			// Otherwise: Expand current node
			searchOrder.addToFrontier(frontier, searchNode, searchNode.node.getChildren());
			visitedStates.add(searchNode.node);

		}
		//if no path to goal has been found
		if (goalNode == null) {
			System.out.println("No goal found");
			return false;
		} else {
			//prints path from goal to route
			System.out.println("Found goal node: " + goalNode.node);
			System.out.println("Cost: " + goalNode.cost);
			System.out.println("Nodes expanded: " + visitedStates.size());
			System.out.println("Path to root:");
			FrontierNode fnode = goalNode;
			while (fnode != null) {
				int[] arr = new int[2];
				arr[0]=fnode.node.getValueAS().x;
				arr[1]=fnode.node.getValueAS().y;
				path.add(arr);
				System.out.println("- node: " + fnode.node.getValueAS());
				fnode = fnode.parent;
			}
			return true;
		}

	}
	public List<int[]> getPath(){
		return path;
	}

}
