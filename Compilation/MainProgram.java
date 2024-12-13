import java.util.Scanner;

public class MainProgram {
   public static Scanner scan = new Scanner(System.in);
   
   public static void main(String... args) {
      while (true) {
         displayMainMenu();
         String choice = getUserChoice();
         processMainChoice(choice);
         
         if (choice.equals("X"))
            break;
      }
      System.out.println("Exiting.....");
      System.out.println("Bye!");
   }
   
   public static void displayMainMenu() {
      System.out.println("-----Main Program Menu------");
      System.out.println("[1] Minor Programs");
      System.out.println("[2] Major Programs");
      System.out.println("[X] Exit");
      System.out.print("Select a choice: ");
   }
   
   public static void displayMinorProgramsMenu() {
      System.out.println("-----Minor Programs Menu------");
      System.out.println("[1] Sum and Product");
      System.out.println("[2] Odd and Even Separation");
      System.out.println("[3] No Duplicate Numbers");
      System.out.println("[4] Largest and Smallest Numbers");
      System.out.println("[X] Return to Main Menu");
      System.out.print("Select a choice: ");
   }
   
   public static void displayMajorProgramsMenu() {
      System.out.println("-----Major Programs Menu------");
      System.out.println("[1] Queue Node");
      System.out.println("[2] Queue Array");
      System.out.println("[3] Node List");
      System.out.println("[4] Infix to Postfix");
      System.out.println("[5] Stack Array");
      System.out.println("[6] Stack List");
      System.out.println("[X] Return to Main Menu");
      System.out.print("Select a choice: ");
   }
   
   public static String getUserChoice() {
      while (!scan.hasNextLine()) {
         System.out.println("Not a valid input");
         scan.next();
      }
      
      String choice = scan.nextLine().toUpperCase();
      return choice;
   }
   
   public static void processMinorProgramChoice(String choice) {
      switch (choice) {
         case "1":
            SumProduct.main();
            break;
         case "2":
            OddEven.main();
            break;
         case "3":
            NoDuplicate.main(null);
            break;
         case "4":
            LargestSmallest.main(null);
            break;
         case "X":
            break;
         default:
            System.out.println("Invalid! Please Try Again!");
      }
   }
   
   public static void processMajorProgramChoice(String choice) {
      switch (choice) {
         case "1":
            QueueList.main();
            break;
         case "2":
            QueueArray.main();
            break;
         case "3":
            NodeList.main();
            break;
         case "4":
            PostFixProgram.main();
            break;
         case "5":
            StackArray.main();
            break;
         case "6":
            StackListt.main();
            break;
         case "X":
            break;
         default:
            System.out.println("Invalid! Please Try Again!");
      }
   }
   
   public static void processMainChoice(String choice) {
      switch (choice) {
         case "1":
            while (true) {
               displayMinorProgramsMenu();
               String minorChoice = getUserChoice();
               processMinorProgramChoice(minorChoice);
               
               if (minorChoice.equals("X"))
                  break;
            }
            break;
         case "2":
            while (true) {
               displayMajorProgramsMenu();
               String majorChoice = getUserChoice();
               processMajorProgramChoice(majorChoice);
               
               if (majorChoice.equals("X"))
                  break;
            }
            break;
         case "X":
            break;
         default:
            System.out.println("Invalid! Please Try Again!");
      }
   }
}