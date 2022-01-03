package Search.src.uk.ac.hw.macs.search;

public class FrontierNode {
	public Node node;
	public FrontierNode parent;
	public int cost;
	//type of elems in frontier list
	public FrontierNode(Node node, FrontierNode parent, int cost) {
		this.node = node;
		this.parent = parent;
		//cost of path to this node from start (g value)
		this.cost = cost;
		if (parent != null) {
			this.cost += parent.cost;
		}
	}

	@Override
	public String toString() {
		//return "\nFrontierNode [node=" + node + ", parent=" + parent + ", cost=" + cost + "]";
		return "\nFrontierNode [node=" + node + "]";
	}
	
	
}
