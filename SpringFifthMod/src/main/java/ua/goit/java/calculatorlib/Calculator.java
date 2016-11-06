package ua.goit.java.calculatorlib;

import ua.goit.java.calculatorlib.operations.unary.Operation;
import ua.goit.java.calculatorlib.provider.SuitableOperationProvider;

import java.util.List;

public interface Calculator {
    String calculate(String expression);

    void setSupportedOperations(List<Operation> supportedOperations);

    List<Operation> getSupportedOperations();

    void addToSupportedOperations(Operation operation);

//    void setInputReader(InputReader inputReader);
//
//    void setOutputWriter(OutputWriter outputWriter);

    void setSuitableOperationProvider(SuitableOperationProvider suitableOperationProvider);
}
