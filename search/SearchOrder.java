package Search.src.uk.ac.hw.macs.search;

import java.util.List;
import java.util.Set;

public interface SearchOrder {
	
	public void addToFrontier(List<FrontierNode> frontier, FrontierNode parent, Set<ChildWithCost> children);

}
