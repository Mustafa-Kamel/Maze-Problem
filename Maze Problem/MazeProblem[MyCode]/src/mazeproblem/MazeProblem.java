package mazeproblem;

import java.util.ArrayList;

/**
 * @author GenjOr MuSTafa
 */
public class MazeProblem {
    //Attributes
    public final int MAZE_HEIGHT=7;
    public final int MAZE_LENGTH=6;
    public Node[][] grid=new Node[MAZE_HEIGHT][MAZE_LENGTH];
    public Node initialState;
    public Node goalState;
    public final String UP="up";
    public final String DOWN="down";
    public final String RIGHT="right";
    public final String LEFT="left";
    //Behaviour
    public MazeProblem(int stR,int stC,int goalR,int goalC){
        for(int i=0;i<MAZE_HEIGHT;i++){
            for(int j=0;j<MAZE_LENGTH;j++){
                grid[i][j]=new Node(i,j,false);
            }
        }
        initialState=grid[stR][stC];
        goalState=grid[goalR][goalC];
        grid[1][1].block=true;
        grid[3][3].block=true;
    }
    public boolean goalTest(Node node){        
        return this.goalState.compareNodes(node);
    }
    public ArrayList<String> possibleMoves(Node node){
        ArrayList<String> moves= new ArrayList<>();
        if(node.row+1<MAZE_HEIGHT){
            if(!grid[node.row+1][node.col].block)
                moves.add(DOWN);
        }
        if(node.row-1 >=0){
            if(!grid[node.row-1][node.col].block)
                moves.add(UP);
        }
        if(node.col+1<MAZE_LENGTH){
            if(!grid[node.row][node.col+1].block)
                moves.add(RIGHT);
        }
        if(node.col-1 >=0){
            if(!grid[node.row][node.col-1].block)
                moves.add(LEFT);
        }
        return moves;
    }
    public Node transition(Node node,String move){
        if(move.equals(UP)){
            node.children.add(grid[node.row-1][node.col]);
            grid[node.row-1][node.col].Parent=node;
            return grid[node.row+1][node.col];
        }else if(move.equals(DOWN)){
            node.children.add(grid[node.row+1][node.col]);
            grid[node.row+1][node.col].Parent=node;
            return grid[node.row+1][node.col];
        }else if(move.equals(RIGHT)){
            node.children.add(grid[node.row][node.col+1]);
            grid[node.row][node.col+1].Parent=node;
            return grid[node.row][node.col+1];
        }else if(move.equals(LEFT)){
            node.children.add(grid[node.row][node.col-1]);
            grid[node.row][node.col-1].Parent=node;
            return grid[node.row][node.col-1];
        }        
        return null;
    }
}
