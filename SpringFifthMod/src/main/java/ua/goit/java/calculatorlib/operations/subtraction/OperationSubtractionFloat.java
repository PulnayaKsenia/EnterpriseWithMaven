package ua.goit.java.calculatorlib.operations.subtraction;


import ua.goit.java.calculatorlib.operations.unary.Operation;

import java.util.List;

public class OperationSubtractionFloat implements Operation {
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
            Float.parseFloat(inputData.get(1));
            Float.parseFloat(inputData.get(2));
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    @Override
    public String perform(List<String> inputData) {
        float valLeft = Float.parseFloat(inputData.get(1));
        float valRight = Float.parseFloat(inputData.get(2));
        Double result = Double.valueOf(valLeft) - Double.valueOf(valRight);
        return String.format("%,.2f - %,.2f = %,.2f", valLeft, valRight, result);
    }

}
