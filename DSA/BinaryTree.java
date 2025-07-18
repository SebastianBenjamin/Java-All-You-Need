import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data=data;
        this.right=null;
        this.left=null;
    }
}
public class BinaryTree {
    public static void main(String[] args) {
        BinaryTree BT=new BinaryTree();
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        System.out.println("Level Order Traversing");
       BT.levelOrderTraversing(root);
       System.out.println();
       System.out.println("In Order");
       BT.inOrder(root);
       System.out.println();
       System.out.println("In Order Recursive");
       BT.inOrderRecursive(root);
       System.out.println();
       System.out.println("Pre Order Recursive");
       BT.preOrderRecursive(root);
       System.out.println();
       System.out.println("Post Order Recursive");
       BT.postOrderRecursive(root);
    
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
    void inOrder(Node root){
        Stack <Node> stack=new Stack();
        Node currentNode=root;
        while(currentNode!=null||!stack.isEmpty()){
            while(currentNode!=null){
            stack.push(currentNode);
            currentNode=currentNode.left;
        }
        currentNode=stack.pop();
        System.out.print(currentNode.data+" -> ");
        currentNode=currentNode.right;
        }
    }
    void inOrderRecursive(Node root){
        Node current=root;
        if(current!=null){
            inOrderRecursive(current.left);
            System.out.print(current.data+" -> ");
            inOrderRecursive(current.right);
        }
    }

    void preOrderRecursive(Node root){
        Node current=root;
        if(current!=null){
            System.out.print(current.data+" -> ");
            preOrderRecursive(current.left);
            preOrderRecursive(current.right);
        }
    }
    void postOrderRecursive(Node root){
        Node current=root;
        if(current!=null){
            postOrderRecursive(current.left);
            postOrderRecursive(current.right);
            System.out.print(current.data+" -> ");
        }
    }
    
}