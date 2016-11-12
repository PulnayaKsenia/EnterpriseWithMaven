package ua.goit.java.test;

public class Test {
    private String name;
    private int age;

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printHello() {
        System.out.println("Hello ! " + name + " Age !" + age);
    }
}
