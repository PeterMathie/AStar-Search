package Search.src.uk.ac.hw.macs.search;

/**
 * Represents a state in the search space.
 * 
 * @author Mary Ellen Foster <MaryEllen.Foster@glasgow.ac.uk>
 */
public interface State {
	public boolean isGoal();
	public Number getHeuristic();

}
