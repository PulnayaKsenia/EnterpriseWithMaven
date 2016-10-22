package ua.goit.firstmodule;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TimeForList {
    private List<Integer> list;
    private int counter;

    public TimeForList(ArrayList<Integer> arrayList, int counter) {
        this.list = arrayList;
        this.counter = counter;
    }

    public TimeForList(LinkedList<Integer> linkedList, int counter) {
        this.list = linkedList;
        this.counter = counter;
    }

    private final int DIMENSION = 100;
    private long sum;

    public long listAdd() {
        long adding = 0;

        for (int j = 0; j < DIMENSION; j++) {
            long startTimeAdd = System.nanoTime();

            for (int i = 0; i < counter; i++) {
                list.add(i, 1);
            }
            long endTimeAdd = System.nanoTime();
            sum = endTimeAdd - startTimeAdd;
            adding += sum;
        }
        return adding / DIMENSION;
    }

    public long listGet() {
        long getting = 0;

        for (int j = 0; j < DIMENSION; j++) {
            long startTimeGet = System.nanoTime();

            for (int i = 0; i < counter; i++) {
                list.get(5);
            }
            long endTimeGet = System.nanoTime();
            sum = endTimeGet - startTimeGet;
            getting += sum;
        }
        return getting / DIMENSION;
    }

    public long listContains() {
        long containing = 0;

        for (int j = 0; j < DIMENSION; j++) {
            long startTimeContains = System.nanoTime();

            for (int i = 0; i < counter; i++) {
                list.contains(8);
            }
            long endTimeContains = System.nanoTime();
            sum = endTimeContains - startTimeContains;
            containing += sum;
        }
        return containing / DIMENSION;
    }

    public long listIteratorAdd() {
        long iteratorAdding = 0;

        for (int j = 0; j < DIMENSION; j++) {
            long startTimeIteratorAdd = System.nanoTime();

            for (int i = 0; i < counter; i++) {
                list.listIterator().add(i);
            }
            long endTimeIteratorAdd = System.nanoTime();
            sum = endTimeIteratorAdd - startTimeIteratorAdd;
            iteratorAdding += sum;
        }
        return iteratorAdding / DIMENSION;
    }

    public long listRemove() {
        long removing = 0;

        for (int j = 0; j < DIMENSION; j++) {
            long startTimeRemove = System.nanoTime();
            list.remove(j);

            long endTimeRemove = System.nanoTime();
            sum = endTimeRemove - startTimeRemove;
            removing += sum;
        }
        return removing / DIMENSION;
    }

    public long listIteratorRemove() {
        long iteratorRemoving = 0;

        for (int j = 0; j < DIMENSION; j++) {
            Iterator<Integer> iterator = list.iterator();

            long startTimeIteratorRemove = System.nanoTime();

            if (iterator.next() > 10) {
                iterator.remove();
            }
            long endTimeIteratorRemove = System.nanoTime();
            sum = endTimeIteratorRemove - startTimeIteratorRemove;
            iteratorRemoving += sum;
        }
        return iteratorRemoving / DIMENSION;
    }

    public String tableResultList() {
        return String.format("%-6s%-7s%-10s%-8s%-14s%-14s%n",
                listAdd(), listGet(), listContains(), listRemove(), listIteratorAdd(), listIteratorRemove());
    }
}
