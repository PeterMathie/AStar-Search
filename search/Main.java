package Search.src.uk.ac.hw.macs.search;
import java.util.HashMap;
import java.util.List;

import javax.print.attribute.HashAttributeSet;

public class Main {
	public static void main(String[] args) {

		Node[][] maze = problem2();

		//serch order algorithm used
		SearchOrder order = new AStarSearchOrder();
		//search problem we are using
		SearchProblem problem = new SearchProblem(order);

		//call search to be performed on the problem
		problem.doSearch(maze[0][0]);
		printProblem(maze);
		printPath(maze, problem.getPath());
		count();
	}

	public static void count(){
		//String num = "111111111111";
		String num = "1111111111111111111111111111111111111111111111111111111111111111";
		System.out.println(num.length());
	}

	private static Node[][] problem1() {
		// 1 = 1 move cost
		// 3 = 3 move cost
		// 2,6 = Goal
		// 1,1 = Start
		final Node[][] problem1 = new Node[4][6];
		int gx = 5;
		int gy = 1;

		problem1[0][0] = new Node(new ASState(0, false, 0, 0, gx, gy, false));
		problem1[0][1] = new Node(new ASState(1, false, 0, 1, gx, gy, false));
		problem1[0][2] = new Node(new ASState(1, false, 0, 2, gx, gy, false));
		problem1[0][3] = new Node(new ASState(3, false, 0, 3, gx, gy, false));
		problem1[0][4] = new Node(new ASState(3, false, 0, 4, gx, gy, false));
		problem1[0][5] = new Node(new ASState(3, false, 0, 5, gx, gy, false));

		problem1[1][0] = new Node(new ASState(1, false, 1, 0, gx, gy, false));
		problem1[1][1] = new Node(new ASState(1, false, 1, 1, gx, gy, false));
		problem1[1][2] = new Node(new ASState(0, false, 1, 2, gx, gy, true));
		problem1[1][3] = new Node(new ASState(0, false, 1, 3, gx, gy, true));
		problem1[1][4] = new Node(new ASState(3, false, 1, 4, gx, gy, false));
		problem1[1][5] = new Node(new ASState(1, true, 1, 5, gx, gy, false));

		problem1[2][0] = new Node(new ASState(1, false, 2, 0, gx, gy, false));
		problem1[2][1] = new Node(new ASState(1, false, 2, 1, gx, gy, false));
		problem1[2][2] = new Node(new ASState(0, false, 2, 2, gx, gy, true));
		problem1[2][3] = new Node(new ASState(1, false, 2, 3, gx, gy, false));
		problem1[2][4] = new Node(new ASState(1, false, 2, 4, gx, gy, false));
		problem1[2][5] = new Node(new ASState(1, false, 2, 5, gx, gy, false));

		problem1[3][0] = new Node(new ASState(1, false, 3, 0, gx, gy, false));
		problem1[3][1] = new Node(new ASState(1, false, 3, 1, gx, gy, false));
		problem1[3][2] = new Node(new ASState(1, false, 3, 2, gx, gy, false));
		problem1[3][3] = new Node(new ASState(1, false, 3, 3, gx, gy, false));
		problem1[3][4] = new Node(new ASState(3, false, 3, 4, gx, gy, false));
		problem1[3][5] = new Node(new ASState(1, false, 3, 5, gx, gy, false));
		int f;
		// goal, children, goal, x, y, gx, gy
		for (int p = 0; p <= 3; p++) {
			for (int q = 0; q <= 5; q++) {
				// if the parent node is on the edge ignore out of bound nodes
				// if child node is a wall skip
				if (p < 3 && problem1[p + 1][q].valueAS.wall == false) {
					f = problem1[p + 1][q].valueAS.costToEnter + problem1[p + 1][q].valueAS.getHeuristic();
					problem1[p][q].addChild(problem1[p + 1][q], f);
				}
				if (p > 0 && problem1[p - 1][q].valueAS.wall == false) {
					f = problem1[p - 1][q].valueAS.costToEnter + problem1[p - 1][q].valueAS.getHeuristic();
					problem1[p][q].addChild(problem1[p - 1][q], f);
				}
				if (q < 5 && problem1[p][q + 1].valueAS.wall == false) {
					f = problem1[p][q + 1].valueAS.costToEnter + problem1[p][q + 1].valueAS.getHeuristic();
					problem1[p][q].addChild(problem1[p][q + 1], f);
				}
				if (q > 0 && problem1[p][q - 1].valueAS.wall == false) {
					f = problem1[p][q - 1].valueAS.costToEnter + problem1[p][q - 1].valueAS.getHeuristic();
					problem1[p][q].addChild(problem1[p][q - 1], problem1[p][q - 1].valueAS.costToEnter);
				}
			}
		}

		//Node root1 = problem1[0][0];
		//Node goal1 = problem1[1][5];

		return problem1;
	}

	private static Node[][] problem2() {
		final Node[][] problem2 = new Node[4][6];

		int g2x = 2;
		int g2y = 3;
		int f;
		problem2[0][0] = new Node(new ASState(0, false, 0, 0, g2x, g2y, false));
		problem2[0][1] = new Node(new ASState(1, false, 0, 1, g2x, g2y, false));
		problem2[0][2] = new Node(new ASState(1, false, 0, 2, g2x, g2y, false));
		problem2[0][3] = new Node(new ASState(1, false, 0, 3, g2x, g2y, false));
		problem2[0][4] = new Node(new ASState(1, false, 0, 4, g2x, g2y, false));
		problem2[0][5] = new Node(new ASState(1, false, 0, 5, g2x, g2y, false));

		problem2[1][0] = new Node(new ASState(3, false, 1, 0, g2x, g2y, false));
		problem2[1][1] = new Node(new ASState(0, false, 1, 1, g2x, g2y, true));
		problem2[1][2] = new Node(new ASState(0, false, 1, 2, g2x, g2y, true));
		problem2[1][3] = new Node(new ASState(0, false, 1, 3, g2x, g2y, true));
		problem2[1][4] = new Node(new ASState(1, false, 1, 4, g2x, g2y, false));
		problem2[1][5] = new Node(new ASState(1, false, 1, 5, g2x, g2y, false));

		problem2[2][0] = new Node(new ASState(3, false, 2, 0, g2x, g2y, false));
		problem2[2][1] = new Node(new ASState(3, false, 2, 1, g2x, g2y, false));
		problem2[2][2] = new Node(new ASState(1, false, 2, 2, g2x, g2y, false));
		problem2[2][3] = new Node(new ASState(1, false, 2, 3, g2x, g2y, false));
		problem2[2][4] = new Node(new ASState(1, false, 2, 4, g2x, g2y, false));
		problem2[2][5] = new Node(new ASState(1, false, 2, 5, g2x, g2y, false));

		problem2[3][0] = new Node(new ASState(3, false, 3, 0, g2x, g2y, false));
		problem2[3][1] = new Node(new ASState(3, false, 3, 1, g2x, g2y, false));
		problem2[3][2] = new Node(new ASState(1, true, 3, 2, g2x, g2y, false));
		problem2[3][3] = new Node(new ASState(1, false, 3, 3, g2x, g2y, false));
		problem2[3][4] = new Node(new ASState(1, false, 3, 4, g2x, g2y, false));
		problem2[3][5] = new Node(new ASState(1, false, 3, 5, g2x, g2y, false));

		// goal, children, goal, x, y, gx, gy
		for (int p = 0; p <= 3; p++) {
			for (int q = 0; q <= 5; q++) {
				// if the parent node is on the edge ignore out of bound nodes
				// if child node is a wall skip
				if (p < 3 && problem2[p + 1][q].valueAS.wall == false) {
					f = problem2[p + 1][q].valueAS.costToEnter + problem2[p + 1][q].valueAS.getHeuristic();
					problem2[p][q].addChild(problem2[p + 1][q], f);
				}
				if (p > 0 && problem2[p - 1][q].valueAS.wall == false) {
					f = problem2[p - 1][q].valueAS.costToEnter + problem2[p - 1][q].valueAS.getHeuristic();
					problem2[p][q].addChild(problem2[p - 1][q], f);
				}
				if (q < 5 && problem2[p][q + 1].valueAS.wall == false) {
					f = problem2[p][q + 1].valueAS.costToEnter + problem2[p][q + 1].valueAS.getHeuristic();
					problem2[p][q].addChild(problem2[p][q + 1], f);
				}
				if (q > 0 && problem2[p][q - 1].valueAS.wall == false) {
					f = problem2[p][q - 1].valueAS.costToEnter + problem2[p][q - 1].valueAS.getHeuristic();
					problem2[p][q].addChild(problem2[p][q - 1], problem2[p][q - 1].valueAS.costToEnter);
				}
			}
		}
		//Node root2 = problem2[0][0];
		//Node goal2 = problem2[3][5];

		return problem2;
	}

	private static Node[][] problem3() {
		final Node[][] problem3 = new Node[4][6];
		int g3x = 2;
		int g3y = 3;
		int f;
		// ASState fields: ASState(costToEnter, goal, x, y, goalx, goaly, wall)
		problem3[0][0] = new Node(new ASState(0, false, 0, 0, g3x, g3y, false));
		problem3[0][1] = new Node(new ASState(0, false, 0, 1, g3x, g3y, true));
		problem3[0][2] = new Node(new ASState(1, false, 0, 2, g3x, g3y, false));
		problem3[0][3] = new Node(new ASState(1, false, 0, 3, g3x, g3y, false));
		problem3[0][4] = new Node(new ASState(1, false, 0, 4, g3x, g3y, false));
		problem3[0][5] = new Node(new ASState(1, false, 0, 5, g3x, g3y, false));

		problem3[1][0] = new Node(new ASState(3, false, 1, 0, g3x, g3y, false));
		problem3[1][1] = new Node(new ASState(1, false, 1, 1, g3x, g3y, false));
		problem3[1][2] = new Node(new ASState(1, false, 1, 2, g3x, g3y, false));
		problem3[1][3] = new Node(new ASState(1, false, 1, 3, g3x, g3y, true));
		problem3[1][4] = new Node(new ASState(1, false, 1, 4, g3x, g3y, true));
		problem3[1][5] = new Node(new ASState(1, false, 1, 5, g3x, g3y, false));

		problem3[2][0] = new Node(new ASState(3, false, 2, 0, g3x, g3y, false));
		problem3[2][1] = new Node(new ASState(0, false, 2, 1, g3x, g3y, true));
		problem3[2][2] = new Node(new ASState(1, false, 2, 2, g3x, g3y, false));
		problem3[2][3] = new Node(new ASState(0, false, 2, 3, g3x, g3y, true));
		problem3[2][4] = new Node(new ASState(0, false, 2, 4, g3x, g3y, true));
		problem3[2][5] = new Node(new ASState(1, false, 2, 5, g3x, g3y, false));

		problem3[3][0] = new Node(new ASState(3, false, 3, 0, g3x, g3y, false));
		problem3[3][1] = new Node(new ASState(3, false, 3, 1, g3x, g3y, false));
		problem3[3][2] = new Node(new ASState(1, false, 3, 2, g3x, g3y, false));
		problem3[3][3] = new Node(new ASState(3, false, 3, 3, g3x, g3y, false));
		problem3[3][4] = new Node(new ASState(1, false, 3, 4, g3x, g3y, false));
		problem3[3][5] = new Node(new ASState(1, true, 3, 5, g3x, g3y, false));

		for (int p = 0; p <= 3; p++) {
			for (int q = 0; q <= 5; q++) {
				// if the parent node is on the edge ignore out of bound nodes
				// if child node is a wall skip
				if (p < 3 && problem3[p + 1][q].valueAS.wall == false) {
					f = problem3[p + 1][q].valueAS.costToEnter + problem3[p + 1][q].valueAS.getHeuristic();
					problem3[p][q].addChild(problem3[p + 1][q], f);
				}
				if (p > 0 && problem3[p - 1][q].valueAS.wall == false) {
					f = problem3[p - 1][q].valueAS.costToEnter + problem3[p - 1][q].valueAS.getHeuristic();
					problem3[p][q].addChild(problem3[p - 1][q], f);
				}
				if (q < 5 && problem3[p][q + 1].valueAS.wall == false) {
					f = problem3[p][q + 1].valueAS.costToEnter + problem3[p][q + 1].valueAS.getHeuristic();
					problem3[p][q].addChild(problem3[p][q + 1], f);
				}
				if (q > 0 && problem3[p][q - 1].valueAS.wall == false) {
					f = problem3[p][q - 1].valueAS.costToEnter + problem3[p][q - 1].valueAS.getHeuristic();
					problem3[p][q].addChild(problem3[p][q - 1], problem3[p][q - 1].valueAS.costToEnter);
				}
			}
		}
		//Node root3 = problem3[0][0];
		//Node goal3 = problem3[3][2];

		return problem3;
	}
	public static void printProblem(Node[][] problem) {
		System.out.println("\n");
		System.out.println("+---+---+---+---+---+---+ ");
		for (int p = 0; p <= 3; p++) {
			for (int q = 0; q <= 5; q++) {
				if (problem[p][q].valueAS.wall)
					System.out.print("| # ");
				if (problem[p][q].valueAS.goal)
					System.out.print("| G ");
				if (!problem[p][q].valueAS.goal && !problem[p][q].valueAS.wall)
					System.out.print("| " + problem[p][q].valueAS.costToEnter + " ");
			}
			System.out.println("| ");
			System.out.println("+---+---+---+---+---+---+ ");
		}
		System.out.println("\n");
	}

	private static HashMap<int[], String> getDirections(List<int[]> path){
		int[] prev = path.get(0);
		HashMap<int[], String> directions = new HashMap<>();

		for(int j=0;j<path.size();j++){

			int[] i = path.get(j);
			int xDiff = i[0]-prev[0];
			int yDiff = i[1]-prev[1];
			prev[0] = i[0];
			prev[1] = i[1];
			
			if(xDiff == 1 && yDiff == 0){
				directions.put(i, " ^ ");
			}
			if(xDiff == -1 && yDiff == 0){
				directions.put(i, " v ");
			}
			if(xDiff == 0 && yDiff == 1){
				directions.put(i, " < ");
			}
			if(xDiff == 0 && yDiff == -1){
				directions.put(i, " > ");
			}
		}
		return directions;
	}

	private static void printPath(Node[][] problem, List<int[]> path) {
		
		HashMap<int[], String> directions = getDirections(path);
		System.out.println("+---+---+---+---+---+---+ ");
		for (int p = 0; p <= 3; p++) {
			for (int q = 0; q <= 5; q++) {
				boolean flag = false;
				if (problem[p][q].valueAS.goal){
					System.out.print("| G ");
				}
				for (int[] i : directions.keySet()) {
					if(i[0] == p && i[1] == q){
						flag = true;
						
						

						if (p==0 && q==0){
							System.out.print("|"+directions.get(i));
						}
						
						else {
							System.out.print("|"+directions.get(i));
							flag = true;
						}
					}
				}
				if (problem[p][q].valueAS.wall && !flag)
					System.out.print("| # ");
				if (!problem[p][q].valueAS.goal && !problem[p][q].valueAS.wall && !flag)
					System.out.print("| " + problem[p][q].valueAS.costToEnter + " ");
			}
			System.out.println("|");
			System.out.println("+---+---+---+---+---+---+ ");
		}
		System.out.println("\n");
	}



	private static Node[][] problem4() {
		final Node[][] problem3 = new Node[4][12];
		int g3x = 2;
		int g3y = 3;
		int f;
		// ASState fields: ASState(costToEnter, goal, x, y, goalx, goaly, wall)
		problem3[0][0] = new Node(new ASState(0, false, 0, 0, g3x, g3y, false));
		problem3[0][1] = new Node(new ASState(0, false, 0, 1, g3x, g3y, true));
		problem3[0][2] = new Node(new ASState(1, false, 0, 2, g3x, g3y, false));
		problem3[0][3] = new Node(new ASState(1, false, 0, 3, g3x, g3y, false));
		problem3[0][4] = new Node(new ASState(1, false, 0, 4, g3x, g3y, false));
		problem3[0][5] = new Node(new ASState(1, false, 0, 5, g3x, g3y, false));
		problem3[0][6] = new Node(new ASState(0, false, 0, 0, g3x, g3y, false));
		problem3[0][7] = new Node(new ASState(0, false, 0, 1, g3x, g3y, true));
		problem3[0][8] = new Node(new ASState(1, false, 0, 2, g3x, g3y, false));
		problem3[0][9] = new Node(new ASState(1, false, 0, 3, g3x, g3y, false));
		problem3[0][10] = new Node(new ASState(1, false, 0, 4, g3x, g3y, false));
		problem3[0][11] = new Node(new ASState(1, false, 0, 5, g3x, g3y, false));


		problem3[1][0] = new Node(new ASState(3, false, 1, 0, g3x, g3y, false));
		problem3[1][1] = new Node(new ASState(1, false, 1, 1, g3x, g3y, false));
		problem3[1][2] = new Node(new ASState(1, false, 1, 2, g3x, g3y, false));
		problem3[1][3] = new Node(new ASState(1, false, 1, 3, g3x, g3y, true));
		problem3[1][4] = new Node(new ASState(1, false, 1, 4, g3x, g3y, true));
		problem3[1][5] = new Node(new ASState(1, false, 1, 5, g3x, g3y, false));
		problem3[1][6] = new Node(new ASState(0, false, 0, 0, g3x, g3y, false));
		problem3[1][7] = new Node(new ASState(0, false, 0, 1, g3x, g3y, true));
		problem3[1][8] = new Node(new ASState(1, false, 0, 2, g3x, g3y, false));
		problem3[1][9] = new Node(new ASState(1, false, 0, 3, g3x, g3y, false));
		problem3[1][10] = new Node(new ASState(1, false, 0, 4, g3x, g3y, false));
		problem3[1][11] = new Node(new ASState(1, false, 0, 5, g3x, g3y, false));


		problem3[2][0] = new Node(new ASState(3, false, 2, 0, g3x, g3y, false));
		problem3[2][1] = new Node(new ASState(0, false, 2, 1, g3x, g3y, true));
		problem3[2][2] = new Node(new ASState(1, false, 2, 2, g3x, g3y, false));
		problem3[2][3] = new Node(new ASState(0, false, 2, 3, g3x, g3y, true));
		problem3[2][4] = new Node(new ASState(0, false, 2, 4, g3x, g3y, true));
		problem3[2][5] = new Node(new ASState(1, false, 2, 5, g3x, g3y, false));
		problem3[2][6] = new Node(new ASState(0, false, 0, 0, g3x, g3y, false));
		problem3[2][7] = new Node(new ASState(0, false, 0, 1, g3x, g3y, true));
		problem3[2][8] = new Node(new ASState(1, false, 0, 2, g3x, g3y, false));
		problem3[2][9] = new Node(new ASState(1, false, 0, 3, g3x, g3y, false));
		problem3[2][10] = new Node(new ASState(1, false, 0, 4, g3x, g3y, false));
		problem3[2][11] = new Node(new ASState(1, false, 0, 5, g3x, g3y, false));


		problem3[3][0] = new Node(new ASState(3, false, 3, 0, g3x, g3y, false));
		problem3[3][1] = new Node(new ASState(3, false, 3, 1, g3x, g3y, false));
		problem3[3][2] = new Node(new ASState(1, false, 3, 2, g3x, g3y, false));
		problem3[3][3] = new Node(new ASState(3, false, 3, 3, g3x, g3y, false));
		problem3[3][4] = new Node(new ASState(1, false, 3, 4, g3x, g3y, false));
		problem3[3][5] = new Node(new ASState(1, true, 3, 5, g3x, g3y, false));
		problem3[3][6] = new Node(new ASState(0, false, 0, 0, g3x, g3y, false));
		problem3[3][7] = new Node(new ASState(0, false, 0, 1, g3x, g3y, true));
		problem3[3][8] = new Node(new ASState(1, false, 0, 2, g3x, g3y, false));
		problem3[3][9] = new Node(new ASState(1, false, 0, 3, g3x, g3y, false));
		problem3[3][10] = new Node(new ASState(1, false, 0, 4, g3x, g3y, false));
		problem3[3][11] = new Node(new ASState(1, false, 0, 5, g3x, g3y, false));


		for (int p = 0; p <= 3; p++) {
			for (int q = 0; q <= 11; q++) {
				// if the parent node is on the edge ignore out of bound nodes
				// if child node is a wall skip
				if (p < 3 && problem3[p + 1][q].valueAS.wall == false) {
					f = problem3[p + 1][q].valueAS.costToEnter + problem3[p + 1][q].valueAS.getHeuristic();
					problem3[p][q].addChild(problem3[p + 1][q], f);
				}
				if (p > 0 && problem3[p - 1][q].valueAS.wall == false) {
					f = problem3[p - 1][q].valueAS.costToEnter + problem3[p - 1][q].valueAS.getHeuristic();
					problem3[p][q].addChild(problem3[p - 1][q], f);
				}
				if (q < 5 && problem3[p][q + 1].valueAS.wall == false) {
					f = problem3[p][q + 1].valueAS.costToEnter + problem3[p][q + 1].valueAS.getHeuristic();
					problem3[p][q].addChild(problem3[p][q + 1], f);
				}
				if (q > 0 && problem3[p][q - 1].valueAS.wall == false) {
					f = problem3[p][q - 1].valueAS.costToEnter + problem3[p][q - 1].valueAS.getHeuristic();
					problem3[p][q].addChild(problem3[p][q - 1], problem3[p][q - 1].valueAS.costToEnter);
				}
			}
		}
		//Node root3 = problem3[0][0];
		//Node goal3 = problem3[3][2];

		return problem3;
	}
}
 

 

 
