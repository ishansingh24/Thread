public class Main {
    public static void main(String[] args) throws InterruptedException {
        sharedData sd = new sharedData();
        Thread producerThread = new Thread(new producer(sd),"thread-1");
        Thread consumerThread = new Thread(new consumer(sd),"thread-2");
        producerThread.start();
        consumerThread.start();
    } 
}
