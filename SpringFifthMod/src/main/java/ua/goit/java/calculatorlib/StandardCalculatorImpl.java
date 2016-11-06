package ua.goit.java.calculatorlib;

import ua.goit.java.calculatorlib.exception.UnsupportedTypeException;
import ua.goit.java.calculatorlib.operations.unary.Operation;
import ua.goit.java.calculatorlib.provider.SuitableOperationProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StandardCalculatorImpl implements Calculator {
    public StandardCalculatorImpl(SuitableOperationProvider suitableOpProvider) {
        this.suitableOpProvider = suitableOpProvider;
    }

    private List<Operation> supportedOperations = new ArrayList<>();
    private SuitableOperationProvider suitableOpProvider;


    @Override
    public String calculate(String expression) {
        List<String> inputList = Arrays.asList(expression.split(","));

        Operation suitableOperation;
        try {
            suitableOperation = suitableOpProvider.getSuitableOperation(inputList, supportedOperations);
        } catch (UnsupportedTypeException e) {
            return e.getClass().getSimpleName();
        } catch (UnsupportedOperationException e) {
            return e.getClass().getSimpleName() + "; " +e.getMessage();
        }

        return suitableOperation.perform(inputList);
    }

    @Override
    public List<Operation> getSupportedOperations() {
        return this.supportedOperations;
    }

    @Override
    public void setSupportedOperations(List<Operation> supportedOperations) {
        this.supportedOperations = supportedOperations;
    }

    @Override
    public void addToSupportedOperations(Operation operation) {
        this.supportedOperations.add(operation);
    }

    @Override
    public void setSuitableOperationProvider(SuitableOperationProvider suitableOperationProvider) {
        this.suitableOpProvider = suitableOperationProvider;
    }

}
