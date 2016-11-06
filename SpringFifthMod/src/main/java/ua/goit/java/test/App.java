package ua.goit.java.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext(
//                "Spring-Module.xml");
//
//        Test obj = (Test) context.getBean("helloBean");
//        obj.printHello();

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Test obj = (Test) context.getBean("helloBean");

        obj.printHello();

    }
}
