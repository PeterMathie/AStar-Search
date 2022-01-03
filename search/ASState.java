package Search.src.uk.ac.hw.macs.search;

public class ASState implements State {

    public boolean goal, wall;
    public int costToEnter;
	public int x;
	public int y;
	public int gx;
	public int gy;

    public ASState(int costToEnter) {
        this.costToEnter = costToEnter;
    }
    
	public ASState(int costToEnter, boolean goal) {
        this.costToEnter = costToEnter;
        this.goal = goal;
    }
    
    public ASState(int costToEnter, boolean goal, int x, int y, int gx, int gy, boolean wall) {
        this.costToEnter = costToEnter;
        this.goal = goal;
        this.x = x;
        this.y = y;
        this.gx = gx;
        this.gy = gy;
        this.wall = wall;
	}
	@Override
	public boolean isGoal() {
		return this.goal;
	}

	public boolean isWall() {
		return this.wall;
    }
    //Manhattan method for getting the heuristics, the vertical distance plus the horrozontal distance
	@Override
	public Integer getHeuristic() {
		int dx = gx - this.x;
		int dy = gy - this.y;
		int heuristic = Math.abs(dx+dy);
		return heuristic;
	}

	@Override
	public String toString() {
		int f = costToEnter+getHeuristic();
		return "ASState [pos="+x+","+y+", cost= " +costToEnter+" f="+f+"]";
	}
	
}