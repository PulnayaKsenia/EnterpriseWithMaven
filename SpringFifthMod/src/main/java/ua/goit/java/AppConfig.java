package ua.goit.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ua.goit.java.calculatorlib.Calculator;
import ua.goit.java.calculatorlib.StandardCalculatorImpl;
import ua.goit.java.calculatorlib.operations.addition.OperationAdditionDouble;
import ua.goit.java.calculatorlib.operations.addition.OperationAdditionFloat;
import ua.goit.java.calculatorlib.operations.addition.OperationAdditionInteger;
import ua.goit.java.calculatorlib.operations.addition.OperationAdditionLong;
import ua.goit.java.calculatorlib.operations.date.OperationAdditionDate;
import ua.goit.java.calculatorlib.operations.date.OperationDivisionDouble;
import ua.goit.java.calculatorlib.operations.date.OperationMultiplicationDouble;
import ua.goit.java.calculatorlib.operations.date.OperationSubtractionDate;
import ua.goit.java.calculatorlib.operations.subtraction.OperationSubtractionDouble;
import ua.goit.java.calculatorlib.operations.subtraction.OperationSubtractionFloat;
import ua.goit.java.calculatorlib.operations.subtraction.OperationSubtractionInteger;
import ua.goit.java.calculatorlib.operations.subtraction.OperationSubtractionLong;
import ua.goit.java.calculatorlib.operations.unary.Operation;
import ua.goit.java.calculatorlib.operations.unary.OperationLogarithmDouble;
import ua.goit.java.calculatorlib.provider.DefaultSuitableOperationProvider;
import ua.goit.java.calculatorlib.provider.SuitableOperationProvider;

import java.util.List;

@Configuration
public class AppConfig {

    @Bean(name = "calculator")
    @Scope("prototype")
    public Calculator getCalculator(List<Operation> operations) {
        Calculator calculator = new StandardCalculatorImpl(suitableOperationProvider());
        calculator.setSupportedOperations(operations);
        return calculator;
    }

    @Bean
    public SuitableOperationProvider suitableOperationProvider() {
        return new DefaultSuitableOperationProvider();
    }


    @Bean(name = "operationSubtractionDate")
    public Operation getOperationSubtractionDate() {
        return new OperationSubtractionDate();
    }

    @Bean(name = "operationAdditionDate")
    public Operation getOperationAdditionDate() {
        return new OperationAdditionDate();
    }

    @Bean(name = "operationDivisionDouble")
    public Operation getOperationDivisionDouble() {
        return new OperationDivisionDouble();
    }

    @Bean(name = "operationMultiplicationDouble")
    public Operation getOperationMultiplicationDouble() {
        return new OperationMultiplicationDouble();
    }

    @Bean(name = "operationSubtractionDouble")
    public Operation getOperationSubtractionDouble() {
        return new OperationSubtractionDouble();
    }

    @Bean(name = "operationSubtractionFloat")
    public Operation getOperationSubtractionFloat() {
        return new OperationSubtractionFloat();
    }

    @Bean(name = "operationSubtractionLong")
    public Operation getOperationSubtractionLong() {
        return new OperationSubtractionLong();
    }

    @Bean(name = "operationSubtractionInteger")
    public Operation getOperationSubtractionInteger() {
        return new OperationSubtractionInteger();
    }

    @Bean(name = "operationAdditionDouble")
    public Operation getOperationAdditionDouble() {
        return new OperationAdditionDouble();
    }

    @Bean(name = "operationAdditionFloat")
    public Operation getOperationAdditionFloat() {
        return new OperationAdditionFloat();
    }

    @Bean(name = "operationAdditionLong")
    public Operation getOperationAdditionLong() {
        return new OperationAdditionLong();
    }

    @Bean(name = "operationAdditionInteger")
    public Operation getOperationAdditionInteger() {
        return new OperationAdditionInteger();
    }


    @Bean(name = "operationLogarithmDouble")
    public Operation getOperationLogarithmDouble() {
        return new OperationLogarithmDouble();
    }

}
