public class consumer implements Runnable{
    private sharedData resource; 

    public consumer(sharedData resource)
    {
        this.resource = resource;
    }
    @Override
    public void run()
    {
        for(int i = 0; i < 10; i++)
        {
            resource.consume();
        }
        
    }
}
