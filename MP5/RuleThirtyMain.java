package rule30;

/**
 * Created by Juril on 12/7/2016.
 */
import java.util.Scanner;

public class RuleThirtyMain {
    public static void main(String[] args) {
        long startTime, endTime;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter grid size: ");
        int size1 = in.nextInt();

        startTime = System.currentTimeMillis();
        RuleThirty rule1 = new RuleThirty(size1);
        endTime = System.currentTimeMillis();
        long result = endTime - startTime;
        startTime = System.currentTimeMillis();
        RuleThirtyThreaded rule2 = new RuleThirtyThreaded(size1);
        endTime = System.currentTimeMillis();
        System.out.println("Time consumed in non-threaded: " + result + "ms");
        System.out.println("Time consumed in threaded: " + (endTime - startTime) + "ms");
    }
}
