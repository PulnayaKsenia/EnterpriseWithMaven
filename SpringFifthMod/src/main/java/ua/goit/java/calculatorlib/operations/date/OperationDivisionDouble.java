package ua.goit.java.calculatorlib.operations.date;

import ua.goit.java.calculatorlib.operations.unary.Operation;

import java.util.List;


public class OperationDivisionDouble implements Operation {
    private final String operatorSymbol = "/";
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
            Double.parseDouble(inputData.get(1));
            Double.parseDouble(inputData.get(2));
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    @Override
    public String perform(List<String> inputData) {
        double valLeft = Double.parseDouble(inputData.get(1));
        double valRight = Double.parseDouble(inputData.get(2));
        Double result = valLeft / valRight;
        return String.format("%,.2f / %,.2f = %,.2f", valLeft, valRight, result);
    }
}
