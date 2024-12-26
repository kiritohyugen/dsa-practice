
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        // Create a Linear Queue with a capacity of 5
        Queue<Integer> queue = new ArrayLinearQueue<>(5);

        // Test enqueue operation
        System.out.println("Enqueuing elements:");
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        try {
            queue.enqueue(60); // This should throw an exception (Queue is full)
        } catch (IllegalStateException e) {
            System.out.println("Expected exception: " + e.getMessage());
        }

        // Test peek operation
        System.out.println("\nPeek front element: " + queue.peek());

        // Test dequeue operation
        System.out.println("\nDequeuing elements:");
        while (!queue.isEmpty()) {
            System.out.println("Dequeued: " + queue.dequeue());
        }

        try {
            queue.dequeue(); // This should throw an exception (Queue is empty)
        } catch (NoSuchElementException e) {
            System.out.println("Expected exception: " + e.getMessage());
        }

        // Test size and isEmpty
        System.out.println("\nIs queue empty? " + queue.isEmpty());
        System.out.println("Current size: " + queue.size());





        ArrayCircularQueue<Integer> queue2 = new ArrayCircularQueue<>(5);

        // Test enqueue operation
        System.out.println("Enqueueing elements:");
        queue2.enqueue(10);
        queue2.enqueue(20);
        queue2.enqueue(30);
        queue2.enqueue(40);
        queue2.enqueue(50);

        // Test queue full condition
        try {
            queue2.enqueue(60); // This should throw an exception (Queue is full)
        } catch (IllegalStateException e) {
            System.out.println("Expected exception: " + e.getMessage());
        }

        // Test peek operation
        System.out.println("\nPeek front element: " + queue2.peek());

        // Test dequeue operation
        System.out.println("\nDequeuing elements:");
        while (!queue2.isEmpty()) {
            System.out.println("Dequeued: " + queue2.dequeue());
        }

        try {
            queue2.dequeue(); // This should throw an exception (Queue is empty)
        } catch (NoSuchElementException e) {
            System.out.println("Expected exception: " + e.getMessage());
        }

        // Test circular nature of the queue
        System.out.println("\nTesting circular nature:");
        queue2.enqueue(60);
        queue2.enqueue(70);
        queue2.enqueue(80);
        System.out.println("Dequeued: " + queue2.dequeue());
        queue2.enqueue(90);
        queue2.enqueue(100);
        queue2.enqueue(110); // This should wrap around and fill the queue

        // Dequeue all elements to test wrap-around
        System.out.println("\nDequeuing elements after wrap-around:");
        while (!queue2.isEmpty()) {
            System.out.println("Dequeued: " + queue2.dequeue());
        }

        // Test size and isEmpty
        System.out.println("\nIs queue empty? " + queue2.isEmpty());
        System.out.println("Current size: " + queue2.size());
 
    }
}
