package pl.misc.hackerank.graph;

/**
 * @author Pallav Jha
 * @since 20/4/18
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class BeautifulNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            int n = Integer.parseInt(br.readLine().trim());

            int out_ = solve(n);
            System.out.println(out_);
            System.out.println("");
        }

        wr.close();
        br.close();
    }
    static int solve(int n){
        if (n == 1) {
            return 5;
        }
        if (n == 2) {
            return 15;
        }
        long[] arr = new long[]{5L,4L,3L,2L,1L};
        for (int i = 3 ;i <= n ;i++) {
            for(int j = 0; j < 5 ; j++) {
                arr[j] = sumArr(arr, j);
                arr[j] = arr[j] % 1000000007L;
            }
        }
        long total = sumArr(arr, 0);
        return (int)(total % 1000000007L);
    }
    static long sumArr(long[] arr, int from) {
        long sum =0L;
        for (int i = from ; i < arr.length;i++) {
            sum += arr[i];
        }
        return sum;
    }

}
