package rule30;

/**
 * Created by Juril on 12/7/2016.
 */
public class RuleThirtyThreaded {
    private final static int THREAD_COUNT = 10;

    public RuleThirtyThreaded(int size){
        int col, row, grid[][];
        grid = new int[size][size];
        for (row = 0; row < size; row++) {
            for (col = 0; col < size; col++)
                grid[row][col] = 0;
        }
        grid[0][size / 2] = 1;
        RuleThirtyRun[] worker = new RuleThirtyRun[THREAD_COUNT];

        int workersPerThread = size / THREAD_COUNT;
        int start = 0;
        int end = (start + workersPerThread) -1;

        for (int i = 0; i < THREAD_COUNT; i++) {
            if (i == THREAD_COUNT - 1) {
                end = size;
            }
            worker[i] = new RuleThirtyRun(start, end, grid);
            start = end;
            end = start + workersPerThread;
        }

        for (int i = 0; i < THREAD_COUNT; i++) {
            worker[i].start();
            while (worker[i].isAlive()) {
                try {
                    worker[i].join();
                } catch (InterruptedException e) {
                    System.err.println("thread interrupted: " + e.getMessage());
                }
            }
        }
        for (row = 0; row < grid.length; row++) {
            for (col = 0; col < grid.length; col++)
                System.out.print(grid[row][col]);
            System.out.println();
        }
    }
}
