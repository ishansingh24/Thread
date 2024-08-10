class Main {

    private static long fact(long ele) {
        long result = 1;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            
            System.err.println("Thread was interrupted: " + e.getMessage());
            Thread.currentThread().interrupt(); // Restore the interrupted status
        }
        for (long i = 1; i <= ele; i++) {  // Start i at 1
            result *= i;
        }
        return result;
    }


    public static void main(String[] args) {

        Runnable at1 = new Runnable() {
            @Override
            public void run() {
                for (long i = 0; i < 10; i++) {
                    long result = fact(i);
                    System.out.println(result);
                }
            }
        };
        Thread t1 = new Thread(at1);
        Thread t2 = new Thread(at1);  // Create a Thread with the Runnable
        Thread t3 = new Thread(at1); 
        t1.start();  // Start the thread
        t2.start();
        t3.start();
        try {
            t1.join(); 
            t2.join(); // Wait for the thread to finish
            t3.start();
        } catch (InterruptedException e) {
            // Handle the InterruptedException
            System.err.println("Thread was interrupted: " + e.getMessage());
            Thread.currentThread().interrupt(); // Restore the interrupted status
        }
        System.out.println("hello mother fucker");
    }
}

