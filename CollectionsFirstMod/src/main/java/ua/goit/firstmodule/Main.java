package ua.goit.firstmodule;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;


public class Main {
    private static final int VALUE10K = 100;
    private static final int VALUE100K = 1000;
    private static final int VALUE1000K = 10000;

    public static void main(String[] args) throws IOException {
        TimeForList timeForArray10k = new TimeForList(new ArrayList<>(), VALUE10K);
        TimeForList timeForLinked10k = new TimeForList(new LinkedList<>(), VALUE10K);

        TimeForSet timeForTree10k = new TimeForSet(new TreeSet<>(), VALUE10K);
        TimeForSet timeForHash10k = new TimeForSet(new HashSet<>(), VALUE10K);

        String table10k = String.format("%-12s%-6s%-7s%-10s%-8s%-14s%-14s%n",
                "FOR 10K", "add", "get", "contains", "remove", "iterator.add", "iterator.remove");
        String result10k = ("--------------------------------------------------------------------------\n" +
                "ArrayList   " + timeForArray10k.tableResultList() + "\n" +
                "LinedList   " + timeForLinked10k.tableResultList() + "\n" +
                "TreeSet     " + timeForTree10k.tableResultSet() + "\n" +
                "HashSet     " + timeForHash10k.tableResultSet() + "\n" +
                "..........................................................................\n");

        TimeForList timeForArray100k = new TimeForList(new ArrayList<>(), VALUE100K);
        TimeForList timeForLinked100k = new TimeForList(new LinkedList<>(), VALUE100K);

        TimeForSet timeForTree100k = new TimeForSet(new TreeSet<>(), VALUE100K);
        TimeForSet timeForHash100k = new TimeForSet(new HashSet<>(), VALUE100K);

        String table100k = String.format("%-12s%-6s%-7s%-10s%-8s%-14s%-14s%n",
                "FOR 100K", "add", "get", "contains", "remove", "iterator.add", "iterator.remove");
        String result100k = ("--------------------------------------------------------------------------\n" +
                "ArrayList   " + timeForArray100k.tableResultList() + "\n" +
                "LinedList   " + timeForLinked100k.tableResultList() + "\n" +
                "TreeSet     " + timeForTree100k.tableResultSet() + "\n" +
                "HashSet     " + timeForHash100k.tableResultSet() + "\n" +
                "..........................................................................\n");

        TimeForList timeForArray1000k = new TimeForList(new ArrayList<>(), VALUE1000K);
        TimeForList timeForLinked1000k = new TimeForList(new LinkedList<>(), VALUE1000K);

        TimeForSet timeForTree1000k = new TimeForSet(new TreeSet<>(), VALUE1000K);
        TimeForSet timeForHash1000k = new TimeForSet(new HashSet<>(), VALUE1000K);

        String table1000k = String.format("%-12s%-6s%-7s%-10s%-8s%-14s%-14s%n",
                "FOR 1000K", "add", "get", "contains", "remove", "iterator.add", "iterator.remove");
        String result1000k =("--------------------------------------------------------------------------\n" +
                "ArrayList   " + timeForArray1000k.tableResultList() + "\n" +
                "LinedList   " + timeForLinked1000k.tableResultList() + "\n" +
                "TreeSet     " + timeForTree1000k.tableResultSet() + "\n" +
                "HashSet     " + timeForHash1000k.tableResultSet() + "\n" +
                "..........................................................................");

        File file = new File("comparisonTable3.txt");

        if (file.createNewFile()) {
            System.out.println("New file is created!");
        } else {
            System.out.println("File already exists!");
        }

        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(table10k + result10k + table100k + result100k +table1000k + result1000k);
        fileWriter.close();
    }
}
