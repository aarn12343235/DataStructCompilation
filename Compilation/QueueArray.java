import java.util.Scanner;

public class QueueArray {
    private Object[] items;
    private int count;
    static Scanner scan = new Scanner(System.in);
    
    public QueueArray(int size) {
        items = new Object[size];
        count = 0;
    }
    
    public boolean isFull() {
        return count == items.length;
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean enqueue(Object data) {
        if (!isFull()) {
            items[count++] = data;
            return true;
        }
        return false;
    }
    
    public boolean dequeue() {
        if (!isEmpty()) {
            for (int i = 1; i < count; i++) {
                items[i - 1] = items[i];
            }
            items[--count] = null;
            return true;
        }
        return false;
    }
    
    public Object front() {
        return !isEmpty() ? items[0] : null;
    }
    
    public void display() {
        if (!isEmpty()) {
            for (int i = 0; i < count; i++) {
                System.out.println("[" + items[i] + "]");
            }
            System.out.println();
        } else {
            System.out.println("Queue is empty!");
        }
    }
    
    public static void main(String... args) {
        System.out.print("Enter queue size: ");
        int size = scan.nextInt();
        scan.nextLine(); // Clear newline
        
        QueueArray queue = new QueueArray(size);
        
        while (true) {
            System.out.println("\n----- Queue Array Menu -----");
            System.out.println("[1] Enqueue");
            System.out.println("[2] Dequeue");
            System.out.println("[3] Display Queue");
            System.out.println("[4] Get Front Element");
            System.out.println("[X] Exit");
            System.out.print("Select a choice: ");
            
            String choice = scan.nextLine().toUpperCase();
            
            switch (choice) {
                case "1":
                    if (!queue.isFull()) {
                        System.out.print("Enter value to enqueue: ");
                        String val = scan.nextLine();
                        queue.enqueue(val);
                    } else {
                        System.out.println("Queue is full!");
                    }
                    break;
                case "2":
                    if (queue.dequeue()) {
                        System.out.println("Dequeued successfully");
                    } else {
                        System.out.println("Queue is empty");
                    }
                    break;
                case "3":
                    queue.display();
                    break;
                case "4":
                    Object front = queue.front();
                    System.out.println(front != null ? "Front element: " + front : "Queue is empty");
                    break;
                case "X":
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}