package telran.numbers;

import telran.numbers.model.ExecutorGroupSum;
import telran.numbers.model.GroupSum;
import telran.numbers.model.ParallelStreamGroupSum;
import telran.numbers.model.ThreadGroupSum;
import telran.numbers.test.GroupSumPerfomanceTest;

import java.util.Random;

public class GroupSumAppl {
    private static final int N_GROUPS = 10_000;
    private static final int NUMBERS_PER_GROUP = 10_000;
    private static final int[][] numbers = new int[N_GROUPS][NUMBERS_PER_GROUP];
    private static Random random = new Random();

    public static void main(String[] args) {
        fillArray();

        GroupSum threadGroupSum = new ThreadGroupSum(numbers);
        GroupSum executorGroupSum = new ExecutorGroupSum(numbers);
        GroupSum streamGroupSum = new ParallelStreamGroupSum(numbers);

        new GroupSumPerfomanceTest("ThreadGroupSum", threadGroupSum).runTest();
        new GroupSumPerfomanceTest("ExecutorGroupSum", executorGroupSum).runTest();
        new GroupSumPerfomanceTest("StreamGroupSum", streamGroupSum).runTest();
    }

    private static void fillArray(){
        for (int i = 0; i < N_GROUPS; i++) {
            for (int j = 0; j < NUMBERS_PER_GROUP; j++) {
                numbers[i][j] = random.nextInt();
            }
        }
    }
}
