package ua.goit.thirdmodone;

public class SemaphoreImplement implements Semaphore{
    private final Object lock = new Object();

    private volatile int permits;

    public SemaphoreImplement(int permits) {
        this.permits = permits;
    }

    @Override
    public void acquire() throws InterruptedException {
        synchronized (lock) {
            while (permits == 0) {
                lock.wait();
            }
            permits--;
        }
    }

    @Override
    public void acquire(int permits) throws InterruptedException {
        synchronized (lock) {
            while (this.permits < permits) {
                lock.wait();
            }
            this.permits--;
        }
    }

    @Override
    public void release() throws InterruptedException {
        synchronized (lock) {
            permits++;
            lock.notify();
        }
    }

    @Override
    public void release(int permits) throws InterruptedException {
        synchronized (lock) {
            this.permits += permits;
            for (int i = 0; i < permits; i++) {
                lock.notify();
            }
        }
    }

    @Override
    public int getAvailablePermits() {
        return permits;
    }
}
