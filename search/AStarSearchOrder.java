package Search.src.uk.ac.hw.macs.search;

import java.util.List;
import java.util.Set;



public class AStarSearchOrder implements SearchOrder{

    private void bubbleSort(List<FrontierNode> frontier) {
        FrontierNode temp;
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            //compare each element to the next elem swapping when elems are out of order repeatly until no more swaps can be made 
            for (int i = 0; i < frontier.size()-1; i++) {
                int currF = frontier.get(i).node.valueAS.getHeuristic()+frontier.get(i).node.valueAS.costToEnter;
                int nextF = frontier.get(i+1).node.valueAS.getHeuristic()+frontier.get(i+1).node.valueAS.costToEnter;
                if (currF>nextF) {
                    temp = frontier.get(i);
                    frontier.set(i, frontier.get(i + 1));
                    frontier.set(i + 1, temp);
                    sorted = false;
                }
            }
        }
    }

    @Override
    public void addToFrontier(List<FrontierNode> frontier, FrontierNode parent, Set<ChildWithCost> children) {
        FrontierNode newNode;
        for (ChildWithCost child: children){
            //converts child node into frontier node
            newNode = new FrontierNode(child.node, parent, child.node.valueAS.costToEnter);
            //adds  new frontier node ot list frontier unordered
            frontier.add(newNode);

             //simple sorting algorithm to order list correctly
             bubbleSort(frontier);

        }
    }
}





            /*for(int i=0;i<frontier.size();i++){
                int printf = frontier.get(i).cost + frontier.get(i).node.valueAS.getHeuristic();
                System.out.println("\nFrontier List: "+i+": x:"+frontier.get(i).node.valueAS.x+", y:"+frontier.get(i).node.valueAS.y+", f="+printf+", g="+frontier.get(i).cost +", h="+ frontier.get(i).node.valueAS.getHeuristic());
            }*/

            //System.out.println("\n"+child);