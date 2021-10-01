package ListNode;

import java.util.*;
public class ListNode
{
   private int data;
   private ListNode next;
   public ListNode(int data)
   {
      this.data = data;
      
   }
   public ListNode(int data, ListNode next)
   {
     this.data = data;
     this.next = next;
   }
   public int getData()
   {
      return data;
   }
   public ListNode getNext()
   {
      return next;
   }
   public void setData(int data)
   {
     this.data = data;
   }
   public void setNext(ListNode n)
   {
      next = n;
   }   public void reverse() {
	   ListNode num1;
	   ListNode num2;
	   ListNode num3;
	   num1.next;
	   num2.next;
	   num3.next;
   }
}
class LinkedIntList  
{
   private ListNode front;
   private int size = 0;
  // creating a list with the first node having a value
   public LinkedIntList(int value)
   {
      front = new ListNode(value);
   }
   //creating an empty list
   public LinkedIntList()
   {
     front = null; 
   }
   public void add(int value)
   {
     //making a copy of the front of the list
      ListNode curr = front;
      //check to see if the list is empty, if it is update the front node
      if(front == null)
      {
        front = new ListNode(value);
        size++;
        return;
      }
      
      //create a new ListNode
      ListNode n = new ListNode(value);
       //need to find the end of the list and add it to the end
      while(curr.getNext()!= null)
      {
        curr = curr.getNext();
      }
      //addding the node to the end
      curr.setNext(n);
      size++;
   }
   public void add(int index, int value)
   {
      if(index > size)// if the index does not exist in the list
        return;
        //adding it to the begining of the list
      if(index == 0)
      {
         ListNode n = new ListNode(value);
         n.setNext(front);
         front = n;
         size++;
         return;
      }  
     //make a copy of the front node
     ListNode curr = front;
     int i = 0;
     //find the proper index 
     while(curr.getNext() != null && i < index-1)
     {
        curr = curr.getNext();
        i++;
     }  
     //create a new node
     ListNode n = new ListNode(value);
     //n needs to point to current.next
     n.setNext(curr.getNext());
     //current needs to point to n
     curr.setNext(n);
     size++;
      
    
   }
   public int indexOf(int value)
   {
      //if the list is empty
        if(front == null)
            return -1;
        //if removing the first node
        if(value == front.getData())
        {
           front = front.getNext();
        } 
        //node is somewhere in the list   
        ListNode curr = front;
        int index = 0;
        while(curr!= null && index < size)
        {
          if(curr.getData() == value) 
             return index;
          curr = curr.getNext(); 
          index++;  
        }   
        return -1;
   } 
   //removes a value from the list
   public void remove(int value) 
   {
      //empty list
      if(front == null)
          return;
      ListNode pre = front;
      ListNode curr = front;
      while(curr!= null && curr.getData() != value)
      {
         pre = curr;
         curr = curr.getNext();
         
      } 
      pre.setNext(curr.getNext()); 
      size--;  
   }
   //keeps track of the size of the list
   public int size() 
   {
     return size+1;
   }
   public String toString() 
   {
     if(front == null)
        return "";
     ListNode curr = front;
     String s = "[";
     while(curr != null)
     {
        s = s + curr.getData() + " ";
        curr = curr.getNext();
     }   
     return s + "]";
   }
   // returns the data at the given index
   public int get(int pos) 
   {
     if(front == null)
         return -1;
     if (pos > size)
        return -1;    
     //make a copy of the front of the list
     ListNode curr = front;
     int index = 0;
     while(curr!= null && pos != index)
     {
        index++; 
        curr = curr.getNext();    
     } 
     if(curr == null)   
       return -1;
    return curr.getData();   
   }
   public int max()
   {
     ListNode curr = front;
     if(front == null)
       return -1;
     int max = front.getData();
     while(curr != null)
     {
       if (curr.getData () > max)
          max = curr.getData();
       curr = curr.getNext();   
     } 
     return max;  
   }
   public void firstLast()
   {
      if (front == null || front.getNext()== null)
          return;
      ListNode cur = front;
      ListNode pre = front;
      while(cur.getNext()!= null) 
      {
          
         cur = cur.getNext();
      } 
      ListNode n = new ListNode(front.getData());
      n.setNext(null);
      
      cur.setNext(n);
      front = front.getNext();
        
   }
   public void lastFirst()
   {
	   if(front == null || front.getNext() == null) {
		   return;
	   }
	   ListNode curr = front;
	   ListNode pre = front;
	   while(curr.getNext()!= null) {
		   curr = curr.getNext();
	   }
	   ListNode n = new ListNode(curr.getData());
	   ListNode m = new ListNode(pre.getData());
	   n.setNext(null);
	   curr.setNext(m);
	   pre.setData(curr.getData());

   }

 }
class stack{
	ArrayList<String> s;
	int top;
	public stack() {
		s = new ArrayList<String>();
		top = 0;
		}//push adds a token
	public void push(String token) {
		s.add(token);
		top++;
		}//peek looks at the top token
	public String peek() {
		if(!isEmpty()) {
			return s.get(top - 1);
			}
		return null;
		}//checks to make sure if the stack is empty or not
	public boolean isEmpty() {
		return s.size() == 0;
		}//pop removes the top token from the stack
	public String pop() {
		if(!isEmpty()) {
			top--;
			Object o = s.get(top);        
			s.remove(top);       
			return (String) o; 
			}
		return null;
		}   
	public String toString() {
		return s.toString();   
		}
	public void reverse(stack s) {
		Stack n = new Stack();
		while (!s.isEmpty()) {
			String j = s.pop();
			n.push(j);
			n.push(j);
			n.push(j);
		}
		System.out.println(n);
		while(!n.isEmpty()) {
			Object h = n.pop();
			s.push((String) h);
			n.pop();
			n.pop();
		}
	}
}
 class Driver
 {
    public static void main (String[] args)
   {
     //creating an empty list
     LinkedIntList list = new LinkedIntList();
     
     list.add(5);
     System.out.println("***************");
     list.add(7);
     list.add(100);
     list.add(1,1000);
     list.remove(1000);
     list.remove(5);
     int i = list.indexOf(5);
     int j = list.indexOf(1000);
     System.out.println("The index of 100 is : " +i + "\nthe index of 1000 is: "+ j);
     System.out.println(list.get(1)+"******");
     list.add(0, 80);
     list.add(0,999);
     list.add(2000);
     System.out.println(list.size());
     list.add(4,6666);
     System.out.println(list);
     System.out.println(list.max());
     list.firstLast();
     System.out.println(list);
     list.lastFirst();
     System.out.println(list);
     
     LinkedIntList list2 = new LinkedIntList();
     list2.add(5);
     list2.add(6);
     list2.add(7);
     System.out.println(list2);

     
    stack s = new stack();
    s.push("5");
    s.push("6");
    s.push("7");
    System.out.println(s);
    System.out.println(s);
    
    print("Hello", 3);
    printnum(5);
    numofa("Anders", 5);
    
    
   }

 
 //Notes- recursive programming- means that the method will call itself
 //Mainly uses decrease-conquer to find the solution faster
 //the smallest version of the problem is called the base case- as such, the question is, what is the base
 //case of the program
    public static void exp(int base, int ex) {
    	if(ex == 0) {
    	}
    	exp(base,ex);
    }
    //how to print a string n times using recursive programming
    public static void print(String s, int n){
    	//you have to have the base case in the recursion
    	if (n == 0) {
    		return;
    	}
    	System.out.println(s);
    	//must also have recursive formula
    	print(s, n - 1);
    }
    //prints numbers from num to 1
    public static void printnum(int num) {
    	//base case
    	if(num == 0) {
    		return;
    	}
    	System.out.println(num);
    	//recursive formula
    	printnum(num - 1);
    }
    //recursive programming isn't very efficient sometimes
    //returns number of letters "a" in given string
    public static int numofa(String s, int index) {
    	if(index == s.length()) {
    		return 0;
    	}
    	if(s.equals("a")) {
    		return 1 + numofa(s, index + 1);
    	} else {
    		return numofa(s, index + 1);
    	}
    }
 }
