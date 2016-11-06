package ua.goit.java.calculatorlib.exception;

public class UnsupportedOperationException extends CalculatorException {
    public UnsupportedOperationException(){
    }
    public UnsupportedOperationException(String message){
        super(message);
    }
}
