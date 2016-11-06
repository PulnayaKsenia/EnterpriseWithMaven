package ua.goit.java.calculatorlib.operations.unary;

import java.util.List;

public interface Operation {
    String getOperationSymbol();

    boolean isTypeSupportedByOperation(List<String> inputData);

    String perform(List<String> inputData);
}
