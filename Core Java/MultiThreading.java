import java.util.Scanner;

public class MultiThreading {

    
    static class FactorialThread extends Thread {
        private int n;

        public FactorialThread(int n) {
            this.n = n;
        }

        @Override
        public void run() {
            long result = factorial(n);
            System.out.println("Factorial of " + n + " is: " + result);
        }

        private long factorial(int n) {
            long fact = 1;
            for (int i = 1; i <= n; i++) {
                fact *= i;
            }
            return fact;
        }
    }

    
    static class FibonacciThread extends Thread {
        private int n;

        public FibonacciThread(int n) {
            this.n = n;
        }

        public void run() {
            long result = fibonacci(n);
            System.out.println("Fibonacci of " + n + " is: " + result);
        }

        private long fibonacci(int n) {
            if (n <= 1) return n;
            long a = 0, b = 1;
            for (int i = 2; i <= n; i++) {
                long temp = a + b;
                a = b;
                b = temp;
            }
            return b;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();

        Thread factorialThread = new FactorialThread(n);
        Thread fibonacciThread = new FibonacciThread(n);

        factorialThread.start();
        fibonacciThread.start();

        try {
            factorialThread.join();
            fibonacciThread.join();
        } catch (InterruptedException e) {
            System.err.println("Threads were interrupted.");
        }

        System.out.println("Both calculations are complete.");
        scanner.close();
    }
}
