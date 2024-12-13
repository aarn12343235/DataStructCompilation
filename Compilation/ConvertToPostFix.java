public class ConvertToPostFix{
   private String infix;
   
   public ConvertToPostFix(String data){
      infix = data;
   }
   
   private int getPrec(char o){
      if( o == '*' || o == '/')
         return 2;
      if( o == '+' || o == '-')
         return 1;
      return -1;
   }
   
   public String convert(){
      StackList stack = new StackList();
      String result = "";
      
      for(int i = 0; i < infix.length(); i++){
         char c = infix.charAt(i);
         
         if(Character.isDigit(c)){
            result += c;
         }
         else if(c == '('){
            stack.push( c + "");
         }
         else if (c == ')'){
            while(!stack.peek().equals("("))
               result += stack.pop(); 
            stack.pop();
         }
         else{
            while(!stack.isEmpty() && getPrec(c) <= getPrec(stack.peek().charAt(0))){
               result += stack.pop();
            }
            stack.push(c + "");
         }
      }
      while(!stack.isEmpty()){
         result += stack.pop() + "";
      }
      return result;
   }
}