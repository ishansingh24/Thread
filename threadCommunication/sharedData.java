public class sharedData {
    private int data;
    private boolean hasData;

    public synchronized void produce(int data) 
    {
        while(hasData)
        {
            try{
                wait();
            }
            catch(InterruptedException e)
            {
                System.err.println("Thread was interrupted: " + e.getMessage());
                Thread.currentThread().interrupt(); // Restore the interrupted status
            }
        
        }

        this.data = data;
        hasData = true;
        System.out.println(data +" is produced by "+Thread.currentThread().getName());
        notifyAll();
    }

    public synchronized void  consume()
    {
        while(!hasData)
        {
            try{
                wait();
            }
            catch(InterruptedException e)
            {
                System.err.println("Thread was interrupted: " + e.getMessage());
                Thread.currentThread().interrupt(); // Restore the interrupted status
            }
        
        }

        int value = this.data;
        hasData = false;
        System.out.println(value +" is consumed by "+ Thread.currentThread().getName());
        notifyAll();
    }

}
