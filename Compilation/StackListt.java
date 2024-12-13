import java.util.*;

public class StackListt {
    private StackNode top;
    int count;

    public StackListt() {
        top = null;
        count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean push(String data) {
        StackNode node = new StackNode(data);
        node.tail = top;
        top = node;
        count++;
        return true;
    }

    public boolean pop() {
        if (!isEmpty()) {
            top = top.tail;
            count--;
            return true;
        }
        return false;
    }

    public String peek() {
        if (!isEmpty()) {
            return top.data;
        }
        return null;
    }

    public void display() {
        if (!isEmpty()) {
            StackNode temp = top;
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.tail;
            }
        } else {
            System.out.println("Stack is empty");
        }
    }

    public int getSize() {
        return count;
    }
    
    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        StackListt stack = new StackListt();
        while (true) {
            System.out.println("--- StackList Menu ---");
            System.out.println("[1] Push");
            System.out.println("[2] Pop");
            System.out.println("[3] Peek");
            System.out.println("[4] Display");
            System.out.println("[X] Exit");
            System.out.print("Select an option: ");

            String choice = scan.nextLine().toUpperCase();
            switch (choice) {
                case "1":
                    System.out.print("Enter value to push: ");
                    String value = scan.nextLine();
                    if (stack.push(value)) {
                        System.out.println("Pushed successfully!");
                    } else {
                        System.out.println("Failed to push.");
                    }
                    break;
                case "2":
                    if (stack.pop()) {
                        System.out.println("Popped successfully!");
                    } else {
                        System.out.println("Stack is empty!");
                    }
                    break;
                case "3":
                    String top = stack.peek();
                    if (top != null) {
                        System.out.println("Top of the stack: " + top);
                    } else {
                        System.out.println("Stack is empty!");
                    }
                    break;
                case "4":
                    stack.display();
                    break;
                case "X":
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}