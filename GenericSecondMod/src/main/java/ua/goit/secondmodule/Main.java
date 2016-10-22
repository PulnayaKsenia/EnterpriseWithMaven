package ua.goit.secondmodule;

public class Main {
    public static void main(String[] args) {
        ExecutorImplement<Integer> numberExecutor = new ExecutorImplement<>();
        numberExecutor.addTask(new TaskImplement(-2, 4));
        numberExecutor.addTask(new TaskImplement(5, 4), result -> result >= 0);
        numberExecutor.addTask(new TaskImplement(-2, 4),  result -> result >= 0);
        numberExecutor.addTask(new TaskImplement(Integer.MAX_VALUE, 1), result -> result >= 0);

        numberExecutor.execute();

        System.out.println("Valid results: ");
        numberExecutor.getValidResults().forEach(System.out::println);

        System.out.println("Invalid results: ");
        numberExecutor.getInvalidResults().forEach(System.out::println);
    }

    private static class TaskImplement implements Task<Integer> {
        private int firstValue;
        private int secondValue;
        private int result;

        public TaskImplement(int firstValue, int secondValue) {
            this.firstValue = firstValue;
            this.secondValue = secondValue;
        }

        @Override
        public void execute() {
            result = firstValue + secondValue;
        }

        @Override
        public Integer getResult() {
            return result;
        }
    }
}
