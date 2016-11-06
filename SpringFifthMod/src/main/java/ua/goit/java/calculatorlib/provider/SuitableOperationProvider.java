package ua.goit.java.calculatorlib.provider;

import ua.goit.java.calculatorlib.exception.UnsupportedTypeException;
import ua.goit.java.calculatorlib.operations.unary.Operation;

import java.util.List;

public interface SuitableOperationProvider {
    Operation getSuitableOperation(List<String> inputData, List<Operation> supportedOperations)
            throws UnsupportedTypeException, UnsupportedOperationException;
}
