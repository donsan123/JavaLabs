 import java.util.*;
public class Queue
{
   ArrayList<Integer> list;
   public Queue()
   {
     list = new ArrayList<Integer>();
   }
   public void enqueue(Integer num)
   {
      list.add(num);
   }
   public Integer dequeue()
   {
     return list.remove(0);
   }
   public String toString()
   {
     String s = "";
     Queue copy = new Queue();
     boolean b = false;
     while(!b)
     {
       try
       {
          int num = this.dequeue();
          copy.enqueue(num);
          s = s + " " + num;
       }
       catch(Exception e)
       {
          b = true;
       }
     }
     //System.out.println(copy.list+ "&&&&");
     restore(copy);
     return s;
   }
   public int getMax()
   {
     Queue copy = new Queue();
     boolean b= false;
     int max = 0;
     while(!b)
     {
       try
       {
          int num = this.dequeue();
          if(num > max)
             max = num;
          copy.enqueue(num);   
          
       }
       catch(Exception e)
       {
         b = true;
       }
     }
     restore(copy);
     return max;
   }
   public void restore(Queue q)
   {
      boolean b = false;
      while(!b)
      {
         try
         {
            this.enqueue(q.dequeue());
         }
         catch(Exception e)
         {
            b = true;
         }
      }
   }
    public int getMin()
   {
    	Queue copy = new Queue();
        boolean b= false;
        int min = this.dequeue();
        copy.enqueue(min);
        while(!b)
        {
          try
          {
             int num = this.dequeue();
             if(num < min) {
                min = num;
             } 
             
             copy.enqueue(num);                
          }
          catch(Exception e)
          {
            b = true;
          }
        }
        restore(copy);
        return min;
   }
   public void reverse()
   {
	   Stack<Integer> stack = new Stack();
	   Boolean b = false;
	   while(!b) {
		   try {
			   int n = this.dequeue();
			   stack.push(n);
		   } catch (Exception e) {
			   b = true;
		   }
	   }
		   b = false;
		   while(!b) {
			   try {
				   int m = stack.pop();
				   enqueue(m);
			   } catch (Exception e){
				   b = true;
			   }
		   }
	   }
   
   public double getAverage()
   {
	   double sum = 0;
	   double average = 0;
	   int count = 0;
	   Queue copy = new Queue();
	   boolean b = false;
	   while(!b) {
		   try {
			   int n = this.dequeue();
			   copy.enqueue(n);
			   sum = sum + n;
			   count++;
		   } catch (Exception e) {
			   b = true;
		   }
	   }
	   restore(copy);
	   System.out.println(sum + " " +count);
	   average = sum / count;
       return average;        
   }
   public boolean isSorted()
   {
	   Queue q = new Queue();
	   boolean b = false;
	   boolean sorted = true;
	   while(!b) {
		   try {
			   int n1 = this.dequeue();
			   int n2 = this.dequeue();
			   q.enqueue(n1);
			   q.enqueue(n2);
			   if(n1 > n2) 
				   sorted = false;
		   }
		   catch (Exception e){
			   b = true;
		   }
	   }
	   restore(q);
      return sorted;         
   }

   
   
   
   }
class Driver
{
   public static void main(String[] args)
   {
     Queue m = new Queue();
     m.enqueue(10);
     m.enqueue(12);
     m.enqueue(15);
     m.enqueue(7);
     m.enqueue(100);
     m.enqueue(22);
     System.out.println(m);
     
     System.out.println(m.getMax());
     System.out.println(m);
     System.out.println(m.getAverage());
     System.out.println(m.getMin());
     System.out.println(m);
     m.reverse();
     System.out.println(m);
     m.isSorted();
     System.out.println(m.isSorted());

     //add your code here to test the methods that you implemented. 
           
   }
}