import java.util.Scanner;

class QueueNode {
    Object value;
    QueueNode next;
    
    public QueueNode(Object value) {
        this.value = value;
        next = null;
    }
}

public class QueueList {
    QueueNode first;
    QueueNode last;
    int counter;
    static Scanner scan = new Scanner(System.in);
    
    public QueueList() {
        first = null;
        last = null;
        counter = 0;
    }
    
    public boolean isEmpty() {
        return first == null && last == null;
    }
    
    public boolean enqueue(Object val) {
        QueueNode newNode = new QueueNode(val);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        counter++;
        return true;
    }
    
    public boolean dequeue() {
        if (!isEmpty()) {
            if (first == last) {
                first = null;
                last = null;
            } else {
                first = first.next;
            }
            counter--;
            return true;
        }
        return false;
    }
    
    public Object getFirst() {
        return !isEmpty() ? first.value : null;
    }
    
    public Object getLast() {
        return !isEmpty() ? last.value : null;
    }
    
    public void display() {
        if (!isEmpty()) {
            QueueNode temp = first;
            while (temp != null) {
                System.out.print("[" + temp.value + "]->");
                temp = temp.next;
            }
            System.out.println();
        } else {
            System.out.println("Queue is empty");
        }
    }
    
    public static void main(String... args) {
        QueueList queue = new QueueList();
        
        while (true) {
            System.out.println("\n----- Queue Node Menu -----");
            System.out.println("[1] Enqueue");
            System.out.println("[2] Dequeue");
            System.out.println("[3] Display Queue");
            System.out.println("[4] Get First Element");
            System.out.println("[5] Get Last Element");
            System.out.println("[X] Exit");
            System.out.print("Select a choice: ");
            
            String choice = scan.nextLine().toUpperCase();
            
            switch (choice) {
                case "1":
                    System.out.print("Enter value to enqueue: ");
                    String val = scan.nextLine();
                    queue.enqueue(val);
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
                    Object first = queue.getFirst();
                    System.out.println(first != null ? "First element: " + first : "Queue is empty");
                    break;
                case "5":
                    Object last = queue.getLast();
                    System.out.println(last != null ? "Last element: " + last : "Queue is empty");
                    break;
                case "X":
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}