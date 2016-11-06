package ua.goit.java.calculatorlib.operations.subtraction;


import ua.goit.java.calculatorlib.operations.unary.Operation;

import java.util.List;

public class OperationSubtractionInteger implements Operation {
    private final String operatorSymbol = "-";
    private final int correctLengthOfInputArray = 3;

    @Override
    public String getOperationSymbol() {
        return operatorSymbol;
    }

    @Override
    public boolean isTypeSupportedByOperation(List<String> inputData) {
        if (inputData.size() != correctLengthOfInputArray) {
            return false;
        }

        try {
            Integer.parseInt(inputData.get(1));
            Integer.parseInt(inputData.get(2));
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    @Override
    public String perform(List<String> inputData) {
        int valLeft = Integer.parseInt(inputData.get(1));
        int valRight = Integer.parseInt(inputData.get(2));
        Double result = Double.valueOf(valLeft) - Double.valueOf(valRight);
        return String.format("%d - %d = %,.2f", valLeft, valRight, result);
    }

}
