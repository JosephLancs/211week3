package conc3;

import java.util.*;

public class Buffer 						//Provides data and operations onto the fixed-length queue
 {     									
  private LinkedList<Object> buf_list;		
  private int elements;						//Number of elements currently on the queue
  private int buf_size;						//Maximum number of elements allowed on queue
  

  public Buffer(int n)						//Queue creation, with n indicating the maximum capacity
   {
     buf_list = new LinkedList<Object>();
     elements = 0;
     buf_size = n;
   }

  public void add(int n, int userID)						//Add element to queue
   {	

      buf_list.add(n);
      elements++;
      System.out.println("User " + userID + " adds element " + elements + "/" + buf_size);
   }

  public void finalSummation()				
   {								//Calculates the total sum of element value within the buffer
    int sum = 0;
     
    for (int i = 0; i < buf_size; i++)
    {
       sum = sum + (int)buf_list.get(i);
    }
    System.out.println("--------------------------");
    System.out.println("Count total: " + sum); 
    System.out.println("--------------------------");
    }
 }	
