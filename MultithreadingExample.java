import java.util.Scanner;

class FibonacciThread extends Thread {
    private int n;

    public FibonacciThread(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        try {
            int a = 0, b = 1;
            System.out.println("Fibonacci Series:");
            for (int i = 1; i <= n; i++) {
                System.out.print(a + " ");
                int next = a + b;
                a = b;
                b = next;
                Thread.sleep(1000); // 1000 ms delay
            }
            System.out.println();
        } catch (InterruptedException e) {
            System.out.println("Fibonacci thread interrupted.");
        }
    }
}

class PrimeThread extends Thread {
    private int start, end;

    public PrimeThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        try {
            System.out.println("Prime Numbers:");
            for (int i = start; i <= end; i++) {
                if (isPrime(i)) {
                    System.out.print(i + " ");
                    Thread.sleep(500); // 500 ms delay
                }
            }
            System.out.println();
        } catch (InterruptedException e) {
            System.out.println("Prime thread interrupted.");
        }
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}

public class MultithreadingExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of terms for Fibonacci: ");
        int n = scanner.nextInt();

        System.out.print("Enter the range for Prime numbers (start and end): ");
        int start = scanner.nextInt();
        int end = scanner.nextInt();

        FibonacciThread fibonacciThread = new FibonacciThread(n);
        PrimeThread primeThread = new PrimeThread(start, end);

        fibonacciThread.start();
        primeThread.start();
    }
}
