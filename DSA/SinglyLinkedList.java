import java.util.*;;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList {
    public static void main(String[] args) {
        SinglyLinkedList SLL = new SinglyLinkedList();
        Node head = SLL.insertAtFirst(null, 10);
        // Node temp=head; -- enable for testing hasCycle()
        for (int i = 1; i <= 10; i++) {
            head = SLL.insertAtFirst(head, i);
        }
        // while(head.next!=null){ -- enable for testing hasCycle()
        // head=head.next;
        // }
        // head.next=temp;

        SLL.printNodes(head);
        // SLL.printNodes(SLL.insertAtPosition(head, 100, 11));
        // SLL.printNodes(SLL.insertLast(head, 102));
        // SLL.printNodes(SLL.deleteFirst(head));
        // SLL.printNodes(SLL.deleteLast(head));
        // SLL.printNodes(SLL.deleteByPosition(head,10));
        // SLL.printNodes(SLL.deleteByValue(head,2));
        // System.out.println(SLL.findNode(head,1));
        // System.out.println(SLL.sumOfNodes(head));
        // System.out.println(SLL.maxOfNodes(head));
        // System.out.println(SLL.minOfNodes(head));
        // System.out.println(SLL.oddNode(head));
        // System.out.println(SLL.countNoOfNodes(head));
        // System.out.println(SLL.middleNode(head));
        // System.out.println(SLL.findOccurences(head,10));
        // System.out.println(SLL.hasCycle(head));
        // SLL.printNodes(SLL.reverseListPointer(head));
        // SLL.printNodes(SLL.reverseList(head));
        System.out.println(SLL.secondLargest(head));

    }

    void printNodes(Node head) {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.print("null");
        System.out.println();
    }

    Node insertAtFirst(Node head, int data) {
        if (head == null)
            return new Node(data);
        Node newNode = new Node(data);
        newNode.next = head;
        return newNode;
    }

    Node insertLast(Node head, int data) {
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        Node newNode = new Node(data);
        currentNode.next = newNode;
        newNode.next = null;
        return head;
    }

    Node insertAtPosition(Node head, int data, int position) {
        if (head == null)
            return new Node(data);
        if (position == 0) {
            Node newNode = new Node(data);
            newNode.next = head;
            return newNode;
        }
        int count = 0;
        Node currentNode = head;
        Node newNode = new Node(data);
        while (currentNode != null) {
            if (position - 1 != count) {
                currentNode = currentNode.next;
                count++;
            } else {
                break;
            }
        }
        newNode.next = currentNode.next;
        currentNode.next = newNode;
        return head;
    }

    Node deleteFirst(Node head) {
        return head.next;
    }

    Node deleteLast(Node head) {
        Node currentNode = head;
        while (currentNode.next.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = null;
        return head;
    }

    Node deleteByPosition(Node head, int position) {
        Node currentNode = head;
        if (position == 0 && currentNode.next == null) {
            return null;
        } else if (position == 0 && currentNode.next != null) {
            return currentNode.next;
        }
        int count = 0;
        while (currentNode != null && count != position - 1) {
            currentNode = currentNode.next;
            count++;
        }
        currentNode.next = currentNode.next.next;
        return head;
    }

    Node deleteByValue(Node head, int data) {
        Node currentNode = head;
        if (currentNode.data == data) {
            return currentNode.next;
        }
        while (currentNode != null && currentNode.next != null && currentNode.next.data != data) {
            currentNode = currentNode.next;
        }

        currentNode.next = currentNode.next.next;

        return head;
    }

    boolean findNode(Node head, int data) {
        if (head.data == data)
            return true;
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.data == data)
                return true;
            else
                currentNode = currentNode.next;
        }
        return false;
    }

    int sumOfNodes(Node head) {
        Node currentNode = head;
        int sum = 0;
        while (currentNode != null) {
            sum += currentNode.data;
            currentNode = currentNode.next;
        }
        return sum;
    }

    int maxOfNodes(Node head) {
        Node currentNode = head;
        int max = 0;
        while (currentNode != null) {
            if (max < currentNode.data) {
                max = currentNode.data;
            }
            currentNode = currentNode.next;
        }
        return max;
    }

    int minOfNodes(Node head) {
        Node currentNode = head;
        int min = currentNode.data;
        while (currentNode != null) {
            if (min > currentNode.data) {
                min = currentNode.data;
            }
            currentNode = currentNode.next;
        }
        return min;
    }

    ArrayList<Integer> oddNode(Node head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            if (head.data % 2 == 1) {
                list.add(head.data);
            }
            head = head.next;
        }
        list.add(list.size());// count of odd
        return list;
    }

    ArrayList<Integer> evenNode(Node head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            if (head.data % 2 == 0) {
                list.add(head.data);
            }
            head = head.next;
        }
        list.add(list.size());// count of even
        return list;
    }

    int countNoOfNodes(Node head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }

    int middleNode(Node head) {
        Node currentNode = head;
        int count = 0;
        while (currentNode != null) {
            currentNode = currentNode.next;
            count++;
        }
        currentNode = head;
        count = Math.round(count / 2);
        for (int i = 0; i < count; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }

    int findOccurences(Node head, int data) {
        Node currentNode = head;
        int occurrences = 0;
        while (currentNode != null) {
            if (currentNode.data == data) {
                occurrences++;
            }
            currentNode = currentNode.next;
        }
        return occurrences;
    }

    boolean hasCycle(Node head) {
        ArrayList<Node> list = new ArrayList<>();
        while (head != null) {
            if (list.contains(head)) {
                head.next = null;
                return true;
            }
            list.add(head);

            head = head.next;
        }

        return false;
    }

    Node reverseListPointer(Node head) {
        Node previousNode = null;
        Node currentNode = head;
        Node nextNode = null;

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return previousNode;
    }

    Node reverseList(Node head) {
        Node currentNode = head;
        ArrayList<Integer> list = new ArrayList<>();
        while (currentNode != null) {
            list.add(currentNode.data);
            currentNode = currentNode.next;
        }
        currentNode = head;
        Collections.reverse(list);
        for (int i = 0; i < list.size(); i++) {
            currentNode.data = list.get(i);
            currentNode = currentNode.next;
        }
        return head;
    }

    int secondLargest(Node head) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        while (head != null) {
            if (largest < head.data) {
                secondLargest = largest;
                largest = head.data;
            } else if (secondLargest < head.data && head.data != largest) {
                secondLargest = head.data;
            }
            head = head.next;
        }
        return secondLargest;
    }

    boolean isPalindrome(Node head) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();

        Node currentValue = head;
        while (currentValue != null) {
            list.add(currentValue.data);
            list1.add(currentValue.data);
            currentValue = currentValue.next;
        }

        Collections.reverse(list1);

        return list1.toString().equals(list.toString());

    }

}