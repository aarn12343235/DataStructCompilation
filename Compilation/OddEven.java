import java.util.Scanner;

public class OddEven {
   public static void main(String... args) {
      Scanner scan = new Scanner(System.in);
      
      int[] arr = new int[10];
      int[] even = new int[10];
      int[] odd = new int[10];
      int isEven = 0, isOdd = 0;
      
      System.out.println("Enter 10 integers: ");
      
      for (int i = 0; i < 10; i++) {
         int input = scan.nextInt();
         arr[i] = input;
         
         if (input % 2 == 0)
            even[isEven++] = input;
         else
            odd[isOdd++] = input;
      }
      
      // Print input array
      System.out.print("Input: " + arr[0]);
      for (int i = 1; i < arr.length; i++)
         System.out.print("," + arr[i]);
      
      // Print even and odd numbers side by side
      System.out.println("\n\nOutput:\n\nEven\tOdd");
      for (int i = 0; i < Math.max(isEven, isOdd); i++) {
         if (i < isEven && i < isOdd)
            System.out.println(even[i] + "\t\t" + odd[i]);
         else if (i < isEven)
            System.out.println(even[i] + "\t\t-");
         else
            System.out.println("-\t\t" + odd[i]);
      }
   }
}