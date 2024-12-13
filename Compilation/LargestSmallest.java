import java.util.Scanner;

public class LargestSmallest {
   public static void main(String[] args) {
      Scanner keyboard = new Scanner(System.in);
      
      System.out.println("Enter 3 numbers:");
      
      int x = keyboard.nextInt();
      int y = keyboard.nextInt();
      int z = keyboard.nextInt();
      
      // Find the largest number
      int largest = findLargest(x, y, z);
      
      // Find the smallest number
      int smallest = findSmallest(x, y, z);
      
      System.out.println("Largest number: " + largest);
      System.out.println("Smallest number: " + smallest);
   }
   
   public static int findLargest(int a, int b, int c) {
      return Math.max(Math.max(a, b), c);
   }
   
   public static int findSmallest(int a, int b, int c) {
      return Math.min(Math.min(a, b), c);
   }
}