package conc3;

import java.util.*;

public class semaphore
{

    public int count = 0;

    public semaphore(int init_val)
    {
        count = init_val;
    }

    public synchronized void P() throws InterruptedException //acquire
    {
        count = count - 1;
        if(count<0) wait();
    }

    public synchronized void V() //release
    {
        count = count + 1;
        notify();
    }
}
