package rule30;

/**
 * Created by Juril on 12/7/2016.
 */
import java.util.Scanner;

public class RuleThirty {

	public RuleThirty(int size) {
		int col, row, grid[][];
		grid = new int[size][size];
		for (row = 0; row < size; row++) {
			for (col = 0; col < size; col++)
				grid[row][col] = 0;
		}

		grid[0][size / 2] = 1;
		for (row = 1; row < size; row++) {
			for (col = 0; col < size; col++) {
				if (col - 1 < 0)
					if ((grid[row - 1][col] == 1 && grid[row - 1][col + 1] == 1) || (grid[row - 1][col] == 1 && grid[row - 1][col + 1] == 0) || (grid[row - 1][col] == 0 && grid[row - 1][col + 1] == 1))
						grid[row][col] = 1;
				if (col + 1 == size)
					if ((grid[row - 1][col] == 0 && grid[row - 1][col - 1] == 1) || (grid[row - 1][col] == 1 && grid[row - 1][col - 1] == 0))
						grid[row][col] = 1;
				if (col - 1 >= 0 && col + 1 != size)
					if ((grid[row - 1][col - 1] == 1 && grid[row - 1][col] == 0 && grid[row - 1][col + 1] == 0) || (grid[row - 1][col - 1] == 0 && grid[row - 1][col] == 1 && grid[row - 1][col + 1] == 1) || (grid[row - 1][col - 1] == 0 && grid[row - 1][col] == 1 && grid[row - 1][col + 1] == 0) || (grid[row - 1][col - 1] == 0 && grid[row - 1][col] == 0 && grid[row - 1][col + 1] == 1))
						grid[row][col] = 1;
			}
		}
		for (row = 0; row < size; row++) {
			for (col = 0; col < size; col++)
				System.out.print(grid[row][col]);
			System.out.println();
		}
	}
}