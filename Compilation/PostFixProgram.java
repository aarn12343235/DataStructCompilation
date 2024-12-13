import java.util.Scanner;

public class PostFixProgram{
   public static ConvertToPostFix ip;
   public static Evaluate e;
   public static Scanner scan = new Scanner(System.in);
   
   public static String converted = "";
   
   public static void main(String... args){  
    
      System.out.println("Enter infix: ");
      String infix = scan.nextLine();
      System.out.println("Infix created!\n");
      
      ip = new ConvertToPostFix(infix);
      
      while(true){
         
         displayUserChoice();
         String choice = getUserChoice();
         processUserChoice(choice);
         
         if(choice.equals("X"))
            break;  
      }
      
      System.out.println("Exiting.....");
      System.out.println("Bye!");
   
      
   }
   
   public static void displayUserChoice(){
      System.out.println("-----PostFix Program Menu------");
      System.out.println("[1] Convert Infix To PostFix");
      System.out.println("[2] Evaluate PostFix ");
      System.out.println("[X] Exit");
      System.out.print("Select a choice: ");
   
   }
   
   public static String getUserChoice(){
      while(!scan.hasNextLine()){
         System.out.println("Not a valid input");
         scan.next();
      }
      String choice = scan.nextLine().toUpperCase();
      return choice;
   }
   
   public static void processUserChoice(String choice){
      switch(choice){
         case "1":
            converted = ip.convert();
            e = new Evaluate(converted);
            System.out.println("Result: " + converted);
           
            break;
         case "2":
            if (converted.isEmpty()) 
               System.out.println("No postfix expression to evaluate. Please convert first.");
            else 
               System.out.println("Evaluated: " + e.getResult());
            break;
         case "X":
            break;
         default:
            System.out.println("Invalid! Please Try Again!");
      }
   }
}