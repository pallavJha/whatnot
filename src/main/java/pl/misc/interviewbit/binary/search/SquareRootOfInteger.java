package pl.misc.interviewbit.binary.search;

/**
 * <h3>Interviewbit Square Root of Integer solution</h3>
 * <p>Implement int <code>sqrt(int x)</code>.</p>
 * <p>
 * <p>Compute and return the <strong>square root of <code>x</code></strong>.</p>
 * <p>
 * <p>If <code>x</code> is not a perfect square, return <code>floor(sqrt(x))</code></p>
 * <p>
 * <p><strong>Example :</strong></p>
 * <p>
 * <div><pre class="highlight"><code>Input : 11
 * Output : 3
 * </code></pre>
 * </div>
 * <p>
 * <p><strong>DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY</strong></p>
 * <p>
 */
public class SquareRootOfInteger {

    public static int getSquareRoot(final long A) {

        if (A == 1) {
            return 1;
        }

        long low = 1;
        long high = A / 2 + 1;
        while (low <= high) {
            long mid = (low + high) / 2;
            long currentElem = mid;

            long currentElemSq = currentElem * currentElem;
            long currentDiff = Math.abs(currentElemSq - A);

            long prevElemSq = 0;
            long prevDiff = Integer.MAX_VALUE;
            if (mid > 1) {
                long prevElem = mid - 1;
                prevElemSq = prevElem * prevElem;
                prevDiff = Math.abs(prevElemSq - A);
            }

            long nextElemSq = 0;
            long nextDiff = Integer.MAX_VALUE;
            if (mid < A / 2 - 1) {
                long nextElem = mid + 1;
                nextElemSq = nextElem * nextElem;
                nextDiff = Math.abs(nextElemSq - A);
            }

            if (currentElemSq == A) {
                return (int) currentElem;
            }

            if (currentDiff <= prevDiff && currentDiff <= nextDiff) {
                return currentElem * currentElem > A ? (int) (currentElem - 1) : (int) currentElem;
            }

            if (prevDiff < nextDiff) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(getSquareRoot(930675566));
    }
}
