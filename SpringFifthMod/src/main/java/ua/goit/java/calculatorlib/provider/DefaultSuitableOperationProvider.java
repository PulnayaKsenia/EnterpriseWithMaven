package ua.goit.java.calculatorlib.provider;

import ua.goit.java.calculatorlib.exception.UnsupportedTypeException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import ua.goit.java.calculatorlib.operations.unary.Operation;

public class DefaultSuitableOperationProvider implements SuitableOperationProvider {
    @Override
    public Operation getSuitableOperation(List<String> inputData, List<Operation> supportedOperations)
            throws UnsupportedTypeException, UnsupportedOperationException {

        List<Operation> tmpResult;

        tmpResult = supportedOperations.stream()
                .filter(so -> so.getOperationSymbol().equals(inputData.get(0)))
                .collect(Collectors.toList());

        if (tmpResult.size() == 0) throw new UnsupportedOperationException("Operation: " + inputData.get(0));

        Optional<Operation> result = tmpResult.stream()
                .filter(so -> so.isTypeSupportedByOperation(inputData))
                .findFirst();

        return result.orElseThrow(() -> new UnsupportedTypeException());
    }
}
