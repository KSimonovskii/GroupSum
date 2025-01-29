package telran.numbers.model;

import telran.numbers.task.OneGroupSum;

import java.util.Arrays;
import java.util.List;

public abstract class GroupSum {
    protected int[][] numberGroups;

    public GroupSum(int[][] numberGroups) {
        this.numberGroups = numberGroups;
    }

    public abstract int computeSum();

    public List<OneGroupSum> getListOfGroups() {
        return Arrays.stream(numberGroups)
                .map(OneGroupSum::new)
                .toList();
    }
}
