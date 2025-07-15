import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class StackNQueue{
    public static void main(String[] args) {



        System.out.println("\nStack Operations:\n");

        Stack<String> stack = new Stack<>();

        stack.push("Apple");
        stack.push("Banana");
        stack.push("Cherry");
        stack.push("Date");
        stack.push("Blueberry");

      
        System.out.println("Stack: " + stack);
        
        System.out.println("Top element: " + stack.peek());
        
        System.out.println("Popped element: " + stack.pop());

        System.out.println("Stack after pop: " + stack);
        
        System.out.println("Is the stack empty? " + stack.isEmpty());
      
        System.out.println("Size of the stack: " + stack.size());

       
        System.out.println("\n Queue Operations:");

        Queue<String> queue = new LinkedList<>();

        queue.add("Apple");
        queue.add("Banana");
        queue.add("Cherry");
        queue.add("Date");
        queue.add("Blueberry");

        
        System.out.println("Queue: " + queue);
       
        System.out.println("Front element: " + queue.peek());
        
        System.out.println("Polled element: " + queue.poll());

        System.out.println("Queue after dequeue: " + queue);
       
        System.out.println("Is the queue empty? " + queue.isEmpty());
        
        System.out.println("Size of the queue: " + queue.size());
    }
}