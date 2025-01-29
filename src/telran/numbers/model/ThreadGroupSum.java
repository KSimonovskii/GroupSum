package telran.numbers.model;

import telran.numbers.task.OneGroupSum;

import java.util.Arrays;
import java.util.List;

public class ThreadGroupSum extends GroupSum {

    //TODO Homeworks, use pure Threads
    public ThreadGroupSum(int[][] numberGroups) {
        super(numberGroups);
    }

    @Override
    public int computeSum() {
        List<OneGroupSum> groups = getListOfGroups();

        List<Thread> threads = groups.stream()
                .map(Thread::new)
                .toList();

        threads.forEach(Thread::start);

        for (Thread thread: threads) {
            try {
                thread.join();
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }

        return groups.stream()
                .mapToInt(OneGroupSum::getSum).sum();
    }
}
