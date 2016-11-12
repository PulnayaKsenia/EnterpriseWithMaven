package ua.goit.java.calculatorlib.operations.date;

import ua.goit.java.calculatorlib.operations.unary.Operation;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.StringJoiner;

public class OperationSubtractionDate implements Operation {
    private final String operatorSymbol = "-";
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

        Period period = Period.between(valLeft, valRight);

        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();

        StringJoiner stringJoiner = new StringJoiner(",");
        if (days != 0) stringJoiner.add(days + " day(s)");
        if (months != 0) stringJoiner.add(months + " month(s)");
        if (years != 0) stringJoiner.add(years + " year(s)");
        if (stringJoiner.length() == 0) stringJoiner.add("0");

        return String.format("%s - %s = %s", valLeft.format(formatter),
                valRight.format(formatter), stringJoiner.toString().replace("-", ""));
    }
}
