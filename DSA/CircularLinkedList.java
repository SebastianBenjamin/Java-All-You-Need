class Node{
int data;
Node next;
Node(int data){
    this.data=data;
    this.next=null;
}
}
public class CircularLinkedList{
    public static void main(String[] args) {
        CircularLinkedList CLL = new CircularLinkedList();
        Node head=new Node(100);
        head.next=head;
        for(int i=0;i<10;i++){
            head=CLL.insertNode(head, i);
        }
      
        CLL.printList(head);
        // System.out.println();
        // CLL.printList(CLL.insertNode(head,200));
        // System.out.println();
        // CLL.printList(CLL.insertAtFirst(head,200));
        System.out.println();
        // CLL.printList(CLL.deleteFirst(head));
        // System.out.println();
        // CLL.printList(CLL.deleteLast(head));
        CLL.printList(CLL.insertAtPosition(head,101,2));
        System.out.println();
        CLL.printList(CLL.deleteAtPosition(head,2));
        
    }
    Node insertNode(Node head,int data){
        Node currentNode=head;
        while(currentNode.next!=head){currentNode=currentNode.next;}
        Node newNode=new Node(data);
        currentNode.next=newNode;
        newNode.next=head;
        return head;
    }
    void printList(Node head){
    if(head == null) return;
    Node currentNode = head;
    do {
        System.out.print(currentNode.data + " -> ");
        currentNode = currentNode.next;
    } while(currentNode != head);
    System.out.printf("head(%d)", head.data);
}

    Node insertAtFirst(Node head,int data){
        Node currentNode=head;
        while(currentNode.next!=head){
            currentNode=currentNode.next;
        }
        Node newNode=new Node(data);
        currentNode.next=newNode;
        newNode.next=head;
        return newNode;
    }
      Node insertAtPosition(Node head,int data,int position){
        Node currentNode=head;
        Node newNode=new Node(data);
        
        int count=0;
        while (currentNode.next!=head&&count<position-1) {
            currentNode=currentNode.next;
            count++;
        }
        newNode.next=currentNode.next;
        currentNode.next=newNode;

    return head;
    }
    Node deleteLast(Node head){
        Node currentNode=head;
        while(currentNode.next.next!=head){currentNode=currentNode.next;}
        currentNode.next=head;
        return head;
    }
    Node deleteFirst(Node head){
        Node currentNode=head;
        while (currentNode.next!=head) {currentNode=currentNode.next;}
        currentNode.next=head.next;
        return head.next;
    }
    Node deleteAtPosition(Node head,int position){
        Node currentNode=head;
        int count=0;
        while (currentNode.next!=head&&count<position-1) {
            currentNode=currentNode.next;
            count++;
        }
        currentNode.next=currentNode.next.next;
        return head;
    }
  

}