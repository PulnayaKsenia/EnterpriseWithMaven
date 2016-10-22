package ua.goit.secondmodule;

public interface Validator<T> {
    boolean isValid(T result);
}
