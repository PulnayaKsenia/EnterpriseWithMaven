package ua.goit.thirdmodone;

import java.util.ArrayList;
import java.util.List;

public class Starter {
    private static final SemaphoreImplement semaphore = new SemaphoreImplement(4);
    public static List<Integer> elements = new ArrayList<>();

    public static void starter(int SIZE) throws InterruptedException {
        for (int i = 1; i <= SIZE; i++) {
            Thread thread = new Thread(new Worker(semaphore));
            thread.start();
        }
    }

    public static List<Integer> getElements() {
        return elements;
    }

    public static void main(String[] args) throws InterruptedException {
        starter(8);
        getElements();
    }
}
