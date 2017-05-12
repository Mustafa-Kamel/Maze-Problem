package mazeproblem;
import java.util.ArrayList;
/**
 * @author GenjOr MuSTafa
 */
public class Node {
    //Attributes
   //Data
   public int row,col;
   public boolean block;
   public String parentMove;
   //Pointers
   public Node Parent;
   public ArrayList<Node> children;
   //Behaviour
   //Constructor
   Node(int r,int c,boolean b){
       this.row=r; this.col=c; this.block=b;
       this.parentMove=null;
       this.Parent=null;
       this.children=new ArrayList<>();
       
   }
   Node(Node node){
       this.row=node.row; this.col=node.col; this.block=node.block;
       this.parentMove=node.parentMove;
       this.Parent=node.Parent;
       this.children=node.children;
   }
   public boolean compareNodes(Node node){
       if(this.row==node.row&&this.col==node.col)
           return true;
       return false;
       /*
       if (!node.block){
           if(this.row==node.row){
               if(this.col==node.col){
                   return true;
                }
            }
        }
       */
   }
}

