package telran.numbers.model;

import telran.numbers.task.OneGroupSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorGroupSum extends GroupSum{
    //TODO Homework use ExecutorService
    public ExecutorGroupSum(int[][] numberGroups) {
        super(numberGroups);
    }

    @Override
    public int computeSum() {

        List<OneGroupSum> groups = Arrays.stream(numberGroups)
                .map(OneGroupSum::new)
                .toList();

        ExecutorService pool = Executors.newWorkStealingPool();
        for (OneGroupSum group: groups) {
            pool.execute(group);
        }
        pool.shutdown();
        try {
            pool.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return groups.stream().mapToInt(OneGroupSum::getSum).sum();
    }
}
