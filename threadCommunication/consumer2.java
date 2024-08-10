public class consumer2 implements Runnable{
    private sharedData resource; 

    public consumer2(sharedData resource)
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