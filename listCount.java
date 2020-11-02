package conc3;

import java.util.*;

public class listCount {

public static void main(String[] args)
  {
   Scanner scanner = new Scanner(System.in);
   semaphore semaphoreIm = new semaphore(1);
   int num_users = 0;
   int elements = 0;
   int bufferSize = 0;
		
   System.out.println("Enter number of users:");			//Specify number of users			
   String Snum_users = scanner.nextLine();
   num_users = Integer.parseInt(Snum_users);
  			
   System.out.println("Enter number of elements per user:");		//Specify number of elements submitted per user	
   String Selements = scanner.nextLine();
   elements = Integer.parseInt(Selements);

   long start_time = System.currentTimeMillis();

   bufferSize = elements * num_users;
   Buffer b; 	
   b = new Buffer(bufferSize);						//Create buffer
	
   //Create X users that will concurrently add elements to the Buffer object b
   //This can be performed by using an add() method within the Buffer class that needs to be completed.

   List<user> users = new LinkedList<user>();
   List<Thread> threads = new LinkedList<Thread>();

   for (int i = 0; i < num_users; i++)
   {
      users.add(new user(i, elements, b, semaphoreIm));
      threads.add(new Thread(users.get(i)));
      threads.get(i).start();
   }
   /**for(user u : users)
   {
      threads.add(new Thread(u));
      threads.getLast().start();
   }*/
   for (int i = 0; i < num_users; i++)
   {
      try
      {
         threads.get(i).join();
      }
      catch (InterruptedException e)
      {

      }
   }

   b.finalSummation();							//Calculate SUM of elements in buffer

   long end_time = System.currentTimeMillis();
      
   System.out.println("Time to complete: " + (end_time - start_time));
  }
}

