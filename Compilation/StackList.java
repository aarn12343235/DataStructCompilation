public class StackList{
   private String data;
   private StackNode top;
   int count;
   
   public StackList(){
      top = null;
      count = 0;
   } 
   public boolean isEmpty(){
      return count == 0;
   }
   public boolean push(String data){
      StackNode node = new StackNode(data);
      node.tail = top;
      top = node;
      count++;
      return true;
   }
   
   public String pop(){
      if(!isEmpty()){
         String data = top.data;
         top = top.tail;
         count--;
         return data;
      }
      return null;
   }
   public String peek(){
      if(!isEmpty()){
         return top.data;
      }
      return null;
   }
   public void display(){
      if(!isEmpty()){
         StackNode temp = top;
         while(temp != null){
            System.out.println(temp.data);
            temp = temp.tail;
         } 
      }
      else
         System.out.println("Stack is empty");
   }
   public int getSize(){
      if(!isEmpty()){
         return count;
      }
      return 0;
   }   
}