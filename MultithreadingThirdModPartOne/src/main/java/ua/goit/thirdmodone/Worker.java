package ua.goit.thirdmodone;

public class Worker implements Runnable {
    Starter starter = new Starter();
    private volatile static int counter;
    private Semaphore semaphore;

    public Worker(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            int threadIndex = counter;
            System.out.println("Start of thread # " + threadIndex);
            semaphore.acquire();

            starter.elements.add(++counter);

            System.out.println("Counter = " + counter + ". Available permits: " + semaphore.getAvailablePermits());

            semaphore.release();
            System.out.println("End of thread # " + threadIndex);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



