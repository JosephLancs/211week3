package conc3;

import java.util.*;

public class user implements Runnable
{	
  private semaphore semaphoreIm;
  private int id;
  private int num_elements;
  public Buffer buf;
    
  public user(int i, int el, Buffer b, semaphore semaphoreIm)	        			//User arguments: User ID, number of elements to add, and buffer
  {id = i; num_elements = el; buf = b; this.semaphoreIm = semaphoreIm;}

  public void add_elements()
  {   //Add element to buffer, element value iterates from 0, 1, 2 .... num_elements
	int n = 0;
	System.out.println(Thread.currentThread().getName() + " is waiting for permit");
	try
	{
	    semaphoreIm.P();
	    System.out.println(Thread.currentThread().getName()+ " has got permit");
	    while (num_elements > 0)
	    {
	      buf.add(n, id);							
	      n++;
	      num_elements--;
	    }
	}
	catch (InterruptedException e)
	{
		
	}
	System.out.println(Thread.currentThread().getName()+
            " has released permit");
	semaphoreIm.V();
  }
  
  public void run()
  {
    add_elements();
  }
}  