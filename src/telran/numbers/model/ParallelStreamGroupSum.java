package telran.numbers.model;

import telran.numbers.task.OneGroupSum;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStreamGroupSum extends GroupSum{
    // TODO Homework use parallel streams
    public ParallelStreamGroupSum(int[][] numberGroups) {
        super(numberGroups);
    }

    @Override
    public int computeSum() {

        List<OneGroupSum> groups = Arrays.stream(numberGroups)
                .map(OneGroupSum::new)
                .toList();

        groups.parallelStream()
                .forEach(OneGroupSum::run);

        return groups.stream()
                .mapToInt(OneGroupSum::getSum)
                .sum();
    }
}
