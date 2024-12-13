import java.util.Scanner;

public class SumProduct {
   public static void main(String... args) {
      Scanner scan = new Scanner(System.in);
      
      int sum = 0, product = 1, counter = 0;
      
      System.out.println("Enter 10 integers:");
      
      while (counter < 10) {
         int input = scan.nextInt();
         
         if (input > 0) {
            sum += input;
            product *= input;
            counter++;
         }
      }
      
      System.out.println("Sum: " + sum + " Product: " + product);
   }
}