package ua.goit.java;

import ua.goit.java.calculatorlib.Calculator;
import ua.goit.java.calculatorlib.StandardCalculatorImpl;
import ua.goit.java.calculatorlib.operations.addition.OperationAdditionDouble;
import ua.goit.java.calculatorlib.operations.addition.OperationAdditionFloat;
import ua.goit.java.calculatorlib.operations.addition.OperationAdditionInteger;
import ua.goit.java.calculatorlib.operations.addition.OperationAdditionLong;
import ua.goit.java.calculatorlib.operations.subtraction.OperationSubtractionDouble;
import ua.goit.java.calculatorlib.operations.subtraction.OperationSubtractionFloat;
import ua.goit.java.calculatorlib.operations.subtraction.OperationSubtractionInteger;
import ua.goit.java.calculatorlib.operations.subtraction.OperationSubtractionLong;
import ua.goit.java.calculatorlib.operations.unary.OperationLogarithmDouble;
import ua.goit.java.calculatorlib.provider.DefaultSuitableOperationProvider;

import java.util.Scanner;

public class AppExample {
    public static void main(String[] args) {
        Calculator calc = new StandardCalculatorImpl(new DefaultSuitableOperationProvider());
        calc.addToSupportedOperations(new OperationAdditionInteger());
        calc.addToSupportedOperations(new OperationAdditionDouble());
        calc.addToSupportedOperations(new OperationAdditionFloat());
        calc.addToSupportedOperations(new OperationAdditionLong());

        calc.addToSupportedOperations(new OperationSubtractionDouble());
        calc.addToSupportedOperations(new OperationSubtractionFloat());
        calc.addToSupportedOperations(new OperationSubtractionInteger());
        calc.addToSupportedOperations(new OperationSubtractionLong());

        calc.addToSupportedOperations(new OperationLogarithmDouble());

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String expression = scanner.nextLine();
            if (expression.equals("exit")) break;
            System.out.println(calc.calculate(expression));
        }
    }
}


