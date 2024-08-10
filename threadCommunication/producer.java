public class producer implements Runnable {
    private sharedData resource; 

    public producer(sharedData resource)
    {
        this.resource = resource;
    }
    @Override
    public void run()
    {
        for(int i = 0; i < 10; i++)
        {
            resource.produce(i);
        }
    }
}
