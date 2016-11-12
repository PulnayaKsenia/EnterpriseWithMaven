package ua.goit.java.calculatorlib.operations.date;


import ua.goit.java.calculatorlib.operations.unary.Operation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.util.List;

public class OperationAdditionDate implements Operation {
    private final String operatorSymbol = "+";
    private final int correctLengthOfInputArray = 3;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

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
            LocalDate.parse(inputData.get(1), formatter);
            LocalDate.parse(inputData.get(2), formatter);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    @Override
    public String perform(List<String> inputData) {
        LocalDate valLeft = LocalDate.parse(inputData.get(1), formatter);
        LocalDate valRight = LocalDate.parse(inputData.get(2), formatter);

        LocalDate result = valLeft.plusDays(valRight.getLong(ChronoField.EPOCH_DAY));

        return String.format("%s + %s = %s", valLeft.format(formatter),
                valRight.format(formatter), result.format(formatter));
    }
}
