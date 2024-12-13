import java.util.*;

public class StackArray {
   private String[] s;
   private int count;

   public StackArray(int size) {
      s = new String[size];
      count = 0;
   }

   public StackArray() {
      this(10);
   }

   private boolean isEmpty() {
      return count == 0;
   }

   private boolean isFull() {
      return count == s.length;
   }

   public boolean push(String val) {
      if (!isFull()) {
         s[count++] = val;
         return true;
      }
      return false;
   }

   public boolean pop() {
      if (!isEmpty()) {
         s[count - 1] = null;
         count--;
         return true;
      }
      return false;
   }

   public String peek() {
      if (!isEmpty()) {
         return s[count - 1];
      }
      return null;
   }

   public void display() {
      if (!isEmpty()) {
         for (int i = count - 1; i >= 0; i--) {
            System.out.println("[" + s[i] + "]");
         }
      } else {
         System.out.println("Stack is Empty");
      }
   }
   
   public static void main(String... args){
    
      Scanner scan = new Scanner(System.in);
      StackArray stack = new StackArray();
      while (true) {
         System.out.println("--- StackArray Menu ---");
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
                  System.out.println("Stack is full!");
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