package ua.goit.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.goit.java.calculatorlib.Calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Calculator calculator = context.getBean(Calculator.class);
        runMainMethod(calculator);
    }

    public static String runMainMethod(Calculator calculator) {
        System.out.println("Enter date in next format 'day.month.year'\n" +
                "for adding or subtracting dates enter 'operation,day.month.year(later),day.month.year(earlier)'\n" +
                "or enter 'Exit' for exit:");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String expression = scanner.nextLine();
            if (expression.equals("Exit")) break;
            System.out.println(calculator.calculate(expression));
        }

        return null;
    }
}
