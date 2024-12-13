import java.util.*;

public class Evaluate{
   private String postfix;
   
   public Evaluate(String p){
      postfix = p;
   }
   
   public double getResult(){
      StackList stack = new StackList();
      double ans = 0;
      
      for(int i = 0; i < postfix.length(); i++){
         char ch = postfix.charAt(i);
         if(Character.isDigit(ch)){
            stack.push(ch + "");
         }
         else{
            double val2 = Double.parseDouble(stack.pop());
            double val1 = Double.parseDouble(stack.pop());
            
            switch(ch){
               case '*':
                  ans = val1 * val2;
                  break;
               case '/':
                  ans = val1/val2;
                  break;
               case '+':
                  ans = val1 + val2;
                  break;
               case '-':
                  ans = val1 - val2;
                  break;
            }
            stack.push(ans + "");
         }
         
      }
      return Double.parseDouble(stack.pop());
   }
}