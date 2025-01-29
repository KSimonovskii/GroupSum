package telran.numbers.model;

import telran.numbers.task.OneGroupSum;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamGroupSum extends GroupSum{
    public ParallelStreamGroupSum(int[][] numberGroups) {
        super(numberGroups);
    }

    @Override
    public int computeSum() {

        List<OneGroupSum> groups = getListOfGroups();

        groups.parallelStream()
                .forEach(OneGroupSum::run);

        return groups.stream()
                .mapToInt(OneGroupSum::getSum)
                .sum();
    }
}
