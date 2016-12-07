package rule30;

/**
 * Created by Juril on 12/7/2016.
 */
public class RuleThirtyRun extends Thread{
    int start, end, grid[][];
    public RuleThirtyRun(int start, int end, int[][] grid) {
        this.start = start;
        this.end = end;
        this.grid = grid;
    }

    public void run() {
        if(start != 0){
            start -= 1;
        }
        //System.out.println("length:" + grid.length);
        if(start!=0) start-=1;
        for (int row = start + 1; row < end; row++) {
            for (int col = 0; col < grid.length - 1; col++) {
                if (col - 1 < 0) {
                    if ((grid[row - 1][col] == 1 && grid[row - 1][col + 1] == 1) || (grid[row - 1][col] == 1 && grid[row - 1][col + 1] == 0) || (grid[row - 1][col] == 0 && grid[row - 1][col + 1] == 1)) {
                        grid[row][col] = 1;
                        //System.out.println("LALALALA");
                    }
                }
                if (col + 1 == end) {
                    if ((grid[row - 1][col] == 0 && grid[row - 1][col - 1] == 1) || (grid[row - 1][col] == 1 && grid[row - 1][col - 1] == 0)) {
                        grid[row][col] = 1;
                       // System.out.println("WTFFFF");
                    }
                }
                if (col - 1 >= 0 && col + 1 != end) {
                    if ((grid[row - 1][col - 1] == 1 && grid[row - 1][col] == 0 && grid[row - 1][col + 1] == 0) || (grid[row - 1][col - 1] == 0 && grid[row - 1][col] == 1 && grid[row - 1][col + 1] == 1) || (grid[row - 1][col - 1] == 0 && grid[row - 1][col] == 1 && grid[row - 1][col + 1] == 0) || (grid[row - 1][col - 1] == 0 && grid[row - 1][col] == 0 && grid[row - 1][col + 1] == 1)) {
                        grid[row][col] = 1;
                        //System.out.println("SAON JUD");
                    }

                }

            }
        }
    }

    public void display(){

    }
}
