package ua.goit.secondmodule;

import java.util.ArrayList;
import java.util.List;

public class ExecutorImplement<T> implements Executor<T> {
    private static final Validator<Object> DEFAULT_VALIDATOR = value -> true;

    private List<TaskAndValidator<T>> tasks = new ArrayList<>();
    private List<T> validResults = new ArrayList<>();
    private List<T> invalidResults = new ArrayList<>();

    private boolean executed = false;

    @Override
    public void addTask(Task<? extends T> task) {
        checkExecuted();
        addTask(task, DEFAULT_VALIDATOR);
    }

    @Override
    public void addTask(Task<? extends T> task, Validator<? super T> validator) {
        checkExecuted();
        tasks.add(new TaskAndValidator<T>(task, validator));
    }

    @Override
    public void execute() {

        for (TaskAndValidator<T> taskAndValidator : tasks) {
            Task<? extends T> task = taskAndValidator.task;
            task.execute();
            if (taskAndValidator.validator.isValid(task.getResult())) {
                validResults.add(task.getResult());
            } else {
                invalidResults.add(task.getResult());
            }
        }
        executed = true;
    }

    @Override
    public List<T> getValidResults() {
        checkNotExecuted();
        return validResults;
    }

    @Override
    public List<T> getInvalidResults() {
        checkNotExecuted();
        return invalidResults;
    }

    private void checkExecuted() {
        if (executed) {
            throw new IllegalStateException("ua.goit.secondmodule.Executor already executed!");
        }
    }

    private void checkNotExecuted() {
        if (!executed) {
            throw new IllegalStateException("ua.goit.secondmodule.Executor not executed!");
        }
    }

    private static class TaskAndValidator<T> {
        private Task<? extends T> task;
        private Validator<? super T> validator;

        public TaskAndValidator(Task<? extends T> task, Validator<? super T> validator) {
            this.task = task;
            this.validator = validator;
        }
    }
}
