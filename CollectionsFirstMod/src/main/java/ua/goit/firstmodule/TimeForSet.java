package ua.goit.firstmodule;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TimeForSet {
    private Set<Integer> set;
    private int counter;

    public TimeForSet(TreeSet<Integer> treeSet, int counter) {
        this.set = treeSet;
        this.counter = counter;
    }

    public TimeForSet(HashSet<Integer> hashSet, int counter) {
        this.set = hashSet;
        this.counter = counter;
    }

    private final int DIMENSION = 100;
    private long sum;

    public long setAdd() {
        long adding = 0;

        for (int j = 0; j < DIMENSION; j++) {
            long startTimeAdd = System.nanoTime();

            for (int i = 0; i < counter; i++) {
                if (i > 0) set.add(i);
            }
            long endTimeAdd = System.nanoTime();
            sum = endTimeAdd - startTimeAdd;
            adding += sum;
        }
        return adding / DIMENSION;
    }

    public long setContains() {
        long containing = 0;

        for (int j = 0; j < DIMENSION; j++) {
            long startTimeContains = System.nanoTime();

            for (int i = 0; i < counter; i++) {
                if (i == 10) set.contains(i);
            }
            long endTimeContains = System.nanoTime();
            sum = endTimeContains - startTimeContains;
            containing += sum;
        }
        return containing / DIMENSION;
    }

    public long setRemove() {
        long removing = 0;

        for (int j = 0; j < DIMENSION; j++) {
            long startTimeRemove = System.nanoTime();

            for (int i = 0; i < counter; i++) {
                if (i % 2 == 0)set.remove(i);
            }
            long endTimeRemove = System.nanoTime();
            sum = endTimeRemove - startTimeRemove;
            removing += sum;
        }
        return removing / DIMENSION;
    }

    public String tableResultSet() {
        return String.format("%-6s%-7s%-10s%-8s%-14s%-14s%n",
                setAdd(), "-", setContains(), setRemove(), "-", "-");
    }
}
