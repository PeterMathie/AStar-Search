package Search.src.uk.ac.hw.macs.search;

public class ChildWithCost implements Comparable<ChildWithCost> {
	
	public final Node node;
	public final int cost;
	
	public ChildWithCost(Node child, int cost) {
		this.node = child;
		//cost to enter this node
		this.cost = cost;
	}
	
	@Override
	public int compareTo(ChildWithCost o) {
		return Integer.compare(this.cost, o.cost);
	}

	@Override
	public String toString() {
		return "\nChildWithCost [node=" + node + ", cost=" + cost + "]";
	}
	
}
