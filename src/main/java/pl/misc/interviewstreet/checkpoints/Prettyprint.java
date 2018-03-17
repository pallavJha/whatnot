package pl.misc.interviewstreet.checkpoints;

/**
 * Interviewstreet Prettyprint Solution
 *
 * @author Pallav Jha
 * @apiNote https://www.interviewbit.com/problems/prettyprint/
 * @since 17/3/18
 */
public class Prettyprint {

    /**
     * Print concentric rectangular pattern in a 2d matrix.
     * Let us show you some examples to clarify what we mean.
     * <p>
     * Example 1:
     * <p>
     * Input: A = 4.
     * Output:
     * <p>
     * <pre>
     * 4 4 4 4 4 4 4
     * 4 3 3 3 3 3 4
     * 4 3 2 2 2 3 4
     * 4 3 2 1 2 3 4
     * 4 3 2 2 2 3 4
     * 4 3 3 3 3 3 4
     * 4 4 4 4 4 4 4
     * </pre>
     * Example 2:
     * <p>
     * Input: A = 3.
     * Output:
     * <p>
     * <pre>
     * 3 3 3 3 3
     * 3 2 2 2 3
     * 3 2 1 2 3
     * 3 2 2 2 3
     * 3 3 3 3 3
     * </pre>
     * The outermost rectangle is formed by A, then the next outermost is formed by A-1 and so on.
     * <p>
     * You will be given A as an argument to the function you need to implement, and you need to return a 2D array.* @param A
     *
     * @param A number
     * @return arr
     */
    public int[][] prettyPrint(int A) {
        int limit = 2 * A - 1;
        int[][] arr = new int[limit][limit];
        for (int i = 0; i < limit; i++) {
            for (int j = 0; j < limit; j++) {
                if (i + j < (limit - 1)) {
                    arr[i][j] = A - (i < j ? i : j);
                } else {
                    arr[i][j] = (i > j ? i : j) - (limit - 1 - A);
                }
            }
        }
        return arr;
    }
}
