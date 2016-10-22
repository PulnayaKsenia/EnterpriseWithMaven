import org.junit.Assert;
import org.junit.Test;
import ua.goit.secondmodule.ExecutorImplement;
import ua.goit.secondmodule.Task;

public class Tests {

    @Test
    public void testExecutorWithoutValidator() throws Exception {
        ExecutorImplement<Integer> numberExecutor = new ExecutorImplement<>();
        numberExecutor.addTask(new TaskImplement(-2, 4));

        numberExecutor.execute();

        Assert.assertEquals("Wrong valid results sizes", 1, numberExecutor.getValidResults().size());
        Assert.assertEquals("Wrong invalid results sizes", 0, numberExecutor.getInvalidResults().size());
        Assert.assertEquals("Wrong execution result", Integer.valueOf(2), numberExecutor.getValidResults().get(0));
    }

    @Test
    public void testExecuteWithValidator() throws Exception {
        ExecutorImplement<Integer> numberExecutor = new ExecutorImplement<>();
        numberExecutor.addTask(new TaskImplement(2, -3), result -> result >= 0);

        numberExecutor.execute();

        Assert.assertEquals("Wrong valid results sizes", 0, numberExecutor.getValidResults().size());
        Assert.assertEquals("Wrong invalid results sizes", 1, numberExecutor.getInvalidResults().size());
        Assert.assertEquals("Wrong execution result", Integer.valueOf(-1), numberExecutor.getInvalidResults().get(0));
    }

    @Test
        public void testExecutor() throws Exception {
        ExecutorImplement<Integer> numberExecutor = new ExecutorImplement<>();
        numberExecutor.addTask(new TaskImplement(2, -4));
        numberExecutor.addTask(new TaskImplement(2, 4), result -> result >= 0);
        numberExecutor.addTask(new TaskImplement(2, -4),  result -> result >= 0);
        numberExecutor.addTask(new TaskImplement(Integer.MAX_VALUE, 1), result -> result >= 0);

        numberExecutor.execute();

        Assert.assertEquals("Wrong valid results sizes", 2, numberExecutor.getValidResults().size());
        Assert.assertEquals("Wrong invalid results sizes", 2, numberExecutor.getInvalidResults().size());

        Assert.assertEquals("Wrong execution result", Integer.valueOf(-2), numberExecutor.getValidResults().get(0));
        Assert.assertEquals("Wrong execution result", Integer.valueOf(6), numberExecutor.getValidResults().get(1));

        Assert.assertEquals("Wrong execution result", Integer.valueOf(-2), numberExecutor.getInvalidResults().get(0));

        Assert.assertEquals("Wrong execution result", Integer.valueOf(Integer.MIN_VALUE), numberExecutor.getInvalidResults().get(1));
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

