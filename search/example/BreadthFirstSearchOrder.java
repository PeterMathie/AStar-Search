package Search.src.uk.ac.hw.macs.search.example;

import java.util.List;
import java.util.Set;

import Search.src.uk.ac.hw.macs.search.ChildWithCost;
import Search.src.uk.ac.hw.macs.search.FrontierNode;
import Search.src.uk.ac.hw.macs.search.SearchOrder;

public class BreadthFirstSearchOrder implements SearchOrder {

	@Override
	public void addToFrontier(List<FrontierNode> frontier, FrontierNode parent, Set<ChildWithCost> children) {
		// Add them at the end, ignoring the cost
		for (ChildWithCost child : children) {
			frontier.add(new FrontierNode(child.node, parent, child.cost));
		}
	}

}
