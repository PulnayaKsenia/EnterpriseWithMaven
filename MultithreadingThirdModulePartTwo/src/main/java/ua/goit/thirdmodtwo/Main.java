package ua.goit.thirdmodtwo;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] value = {-1, 0, -8, 4, 20, -12, 8, -5, 16, 17, -9, -10, 8};
        int threads = 5;

        SquareSum counter =  new SquareSumImplement();
        Long result = counter.getSquareSum(value, threads);
        System.out.println("Array: " + Arrays.toString(value) + ". Square sum: " + result);
    }
}
