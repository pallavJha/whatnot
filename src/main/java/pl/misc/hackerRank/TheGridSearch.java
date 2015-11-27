package pl.misc.hackerRank;

import java.util.Scanner;

public class TheGridSearch {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int noOfTestCases = in.nextInt();
        boolean[] output = new boolean[noOfTestCases];
        for (int i = 0 ; i < noOfTestCases ; i++) {
            /**
             * Input for parent String Array
             */
            int R = in.nextInt();
            int C = in.nextInt();
            String G[] = new String[R];
            for (int j = 0 ; j < R ; j++) {
                G[j] = in.next();
            }
            /**
             * Conversion of parent to char 
             * 2D array from 1D String array
             */
            char[][] arr = new char[R][C];
            for (int j = 0 ; j < R ; j++) {
                for (int k = 0 ; k < C ; k++) {
                    arr[j][k] = G[j].charAt(k);
                }
            }
            /**
             * Input for subs String Array
             */
            int r = in.nextInt();
            int c = in.nextInt();
            String P[] = new String[r];
            for (int j = 0 ; j < r ; j++) {
                P[j] = in.next();
            }
            /**
             * Conversion of subString to char 
             * 2D array from 1D String array
             */
            char[][] smallArr = new char[r][c];
            for (int j = 0 ; j < r ; j++) {
                for (int k = 0 ; k < c ; k++) {
                    smallArr[j][k] = P[j].charAt(k);
                }
            }
            output[i] = find(arr, smallArr, R, C, r, c);
        }
        for (int i = 0 ; i < noOfTestCases ; i++) {
            System.out.println(output[i] == true ? "YES" : "NO");
        }
    }

    public static boolean find(char[][] parent, char child[][], int R, int C, int r, int c) {
        boolean found = false;

        for (int i = 0 ; i < R ; i++) 
        {
            for (int j = 0 ; j < C ; j++) 
            {
                if ((parent[i][j] == child[0][0]) && (i + r - 1 <= R) && (j + c - 1 <= C)) 
                {
                    outer:
                    for (int l = i ; l < i + r && l < R ; l++) 
                    {
                        for (int m = j ; m < j + c && m < C ; m++) 
                        {
                            if (parent[l][m] != child[l - i][m - j]) 
                            {
                                break outer;
                            }
                            if (parent[l][m] == child[l - i][m - j] && (l + 1 == i + r) && (m + 1 == j + c)) 
                            {
                                found = true;
                            }
                        }
                    }
                }
                if (found)
                {
                    break;
                }
            }
            if (found) 
            {
                break;
            }
        }
        return found;
    }
}
