package ua.goit.thirdmodtwo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SquareSumImplement implements SquareSum {
    @Override
    public long getSquareSum(int[] values, int numberOfThreads) {
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        int part = values.length/numberOfThreads;
        List<Long> callable = new ArrayList<>();
        Phaser phaser = new Phaser(1);

        int start = 0;
        int finish = part;
        for (int i = 0; i < numberOfThreads; i++){
            if (i+1 == numberOfThreads) finish = values.length;
            Future<Long> future = executorService.submit(new AreaCounter(values, start, finish, callable, phaser));

            try{
                Long x = future.get();
                System.out.println("Sum: " + x);
            } catch (InterruptedException | ExecutionException e){
                e.printStackTrace();
            }

            phaser.register();
            start = start + part;
            finish = finish + part;
        }

        phaser.arriveAndAwaitAdvance();
        phaser.arriveAndDeregister();
        executorService.shutdown();

        long result = 0;
        for(Long number : callable){
            result += number;
        }

        return result;
    }
}
