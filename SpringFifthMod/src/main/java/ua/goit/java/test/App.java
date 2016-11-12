package ua.goit.java.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "Spring-Module.xml");

        Test obj = (Test) context.getBean("helloBean");
        obj.printHello();

        context = new AnnotationConfigApplicationContext(AppConfig.class);
        obj = (Test) context.getBean("helloBean");

        obj.printHello();
    }
}
