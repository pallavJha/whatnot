package pl.misc.interviewbit.binary.search;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * interviewbit MatrixSearch solution
 * <p>Write an efficient algorithm that searches for a value in an m x n matrix.</p>
 * <p>
 * <p>This matrix has the following properties:</p>
 * <p>
 * <ol>
 * <li>Integers in each row are sorted from left to right.</li>
 * <li>The <strong>first integer</strong> of each row is greater than or equal to the <strong>last integer</strong> of the previous row.</li>
 * </ol>
 * <p>
 * <p><strong>Example:</strong></p>
 * <p>
 * <p>Consider the following matrix:</p>
 * <p>
 * <div><pre><code>[
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * </code></pre>
 * </div>
 * <p>
 * <p>Given <code>target = 3</code>, return <code>1</code> ( 1 corresponds to true )</p>
 * <p>
 * <p>Return <code>0 / 1</code> ( 0 if the element is not present, 1 if the element is present ) for this problem</p>
 * <p>
 */
public class MatrixSearch {

    public static int matrixSearch(ArrayList<ArrayList<Integer>> A, int target) {


        int r = A.size();
        int c = A.get(0).size();
        int low = 0;
        int high = r * c - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int[] indices = get2DIndicesFrom1DIndex(mid, r, c);

            int currentElem = A.get(indices[0]).get(indices[1]);
            if (currentElem == target) {
                return 1;
            } else {
                if (target < currentElem) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return 0;
    }

    private static int[] get2DIndicesFrom1DIndex(int index, int r, int c) {
        return new int[]{index / c, index % c};
    }

    public static void main(String[] args) {
        ArrayList<Integer> a1 = new ArrayList<>(Arrays.asList(1));

        ArrayList<ArrayList<Integer>> all = new ArrayList<>();
        all.add(a1);

        System.out.println(matrixSearch(all, 1));
    }

    private MatrixSearch() {

    }
}
