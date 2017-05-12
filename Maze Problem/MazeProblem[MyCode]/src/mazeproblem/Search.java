package mazeproblem;
import java.util.ArrayList;
import java.util.Stack;
/**
 * @author GenjOr MuSTafa
 */
public class Search {
    //Attributes
    public static ArrayList<Node> frontier=new ArrayList<>();
    public static ArrayList<Node> explored=new ArrayList<>();
    public static Node currentNode;
    //Behavior
    public static Stack<Node> BFS(MazeProblem problem){
        currentNode=problem.initialState;
        frontier.add(currentNode);
        while(true){
            if(frontier.isEmpty())
                return null;
            currentNode=frontier.remove(0);
            if (problem.isGoal(currentNode))
                return currentNode.retPath();
            explored.add(currentNode);
            
            ArrayList<String>pMoves=problem.possibleMoves(currentNode);
            for(String move: pMoves){
                Node child=problem.transition(currentNode, move);
                updatefrontier(child);
            }
        }
    }
    public static void main(String args[]){
        MazeProblem problem= new MazeProblem(2,1,1,3);
        BFS(problem);
        
    }
}
