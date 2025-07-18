import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node right;
    Node left;
    Node(int data){
        this.data=data;
    }
}
public class BinarySearchTree {
    public static void main(String[] args) {
        BinarySearchTree BST=new BinarySearchTree();
        Node root= BST.insert(null,1000);
        BST.levelOrderTraversing(root);
    }
    Node insert(Node root,int data){
         if(root == null){
            return new Node(data);
        }
        if(data<root.data){
            root.left=insert(root.left, data);
        }else{
            root.right=insert(root.right, data);
        }
        return root;
    }
     void levelOrderTraversing(Node root){
        Queue<Node> queue=new LinkedList();
        if(root==null){
            System.out.println("No data");
           
        }
        queue.add(root);
        while(!queue.isEmpty()){
            Node currentNode=queue.poll();
            System.out.print(currentNode.data+" -> ");

            if(currentNode.left!=null){
                queue.add(currentNode.left);
            }
            if(currentNode.right!=null){
                queue.add(currentNode.right);
            }
        }
    }

}
