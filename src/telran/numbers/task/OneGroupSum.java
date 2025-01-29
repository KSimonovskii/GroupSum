package telran.numbers.task;

import java.util.Arrays;
import java.util.concurrent.Callable;

public class OneGroupSum implements Runnable {

    private int[] group;
    private int sum;

    public OneGroupSum(int[] group) {
        this.group = group;
    }

    public int getSum() {
        return sum;
    }

    @Override
    public void run() {
        sum = Arrays.stream(group).sum();
    }
}
