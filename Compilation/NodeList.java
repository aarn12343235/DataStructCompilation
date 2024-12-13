import java.util.Scanner;

class Node {
    String data;
    Node tail;
    
    public Node(String data) {
        tail = null;
        this.data = data;
    }
}

public class NodeList {
    Node last;
    int counter;
    static Scanner scan = new Scanner(System.in);
    
    public NodeList() {
        last = null;
        counter = 0;
    }
    
    public boolean isEmpty() {
        return counter == 0;
    }
    
    public boolean add(Node item) {
        if (isEmpty())
            last = item;
        else {
            Node node = last;
            while (node.tail != null) {
                node = node.tail;
            }
            node.tail = item;
        }
        counter++;
        return true;
    }
    
    public boolean delete(int location) {
        Node temp = last;
        
        if (location < 0 || isEmpty() || location >= counter) {
            System.out.println("Out of bounds, try a different location");
            return false;
        }
        
        if (location == 0)
            last = last.tail;
        else {
            for (int i = 0; i < location - 1; i++) {
                temp = temp.tail;
            }
            temp.tail = temp.tail.tail;
        }
        counter--;
        return true;
    }
    
    public void display() {
        if (!isEmpty()) {
            Node temp = last;
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.tail;
            }
        } else {
            System.out.println("List is empty");
        }
    }
    
    public static void main(String... args) {
        NodeList nodeList = new NodeList();
        
        while (true) {
            System.out.println("\n----- Node List Menu -----");
            System.out.println("[1] Add Node");
            System.out.println("[2] Delete Node");
            System.out.println("[3] Display List");
            System.out.println("[X] Exit");
            System.out.print("Select a choice: ");
            
            String choice = scan.nextLine().toUpperCase();
            
            switch (choice) {
                case "1":
                    System.out.print("Enter node data: ");
                    String data = scan.nextLine();
                    nodeList.add(new Node(data));
                    break;
                case "2":
                    if (!nodeList.isEmpty()) {
                        System.out.print("Enter location to delete: ");
                        int location = scan.nextInt();
                        scan.nextLine(); // Clear newline
                        nodeList.delete(location);
                    } else {
                        System.out.println("List is empty");
                    }
                    break;
                case "3":
                    nodeList.display();
                    break;
                case "X":
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}