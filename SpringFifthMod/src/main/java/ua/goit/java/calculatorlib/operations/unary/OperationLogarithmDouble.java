package ua.goit.java.calculatorlib.operations.unary;

import java.util.List;

public class OperationLogarithmDouble implements Operation {
    private final String operatorSymbol = "log";
    private final int correctLengthOfInputArray = 2;

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
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    @Override
    public String perform(List<String> inputData) {
        double val = Double.parseDouble(inputData.get(1));
        Double result = Math.log(val);
        return String.format("Log(%,.2f) = %,.2f", val, result);
    }

}
