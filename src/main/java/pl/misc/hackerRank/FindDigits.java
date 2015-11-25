/*Problem Statement
You are given a number N. Find the digits in this number that exactly divide N and display their count.
For N = 24, there are 2 digits - 2 & 4. Both these digits exactly divide 24. So our answer is 2.
Note
If the same number is repeated twice at different positions, it should be counted twice, 
e.g., For N=122, 2 divides 122 exactly and occurs at ones' and tens' position. 
So it should be counted twice. So for this case, our answer is 3.
Division by 0 is undefined.
Input Format
The first line contains T (number of test cases) followed by T lines (each containing an integer N).

Constraints 
1 <=T <= 15 
0 < N < 1010
Output Format
For each test case, display the count of digits in N that exactly divide N in separate line.
Sample Input
2
12
1012
Sample Output
2
3
Explanation
2 digits in the number 12 divide the number exactly.
Digits at tens' place, 1, divides 12 exactly in 12 parts, and digit at ones' place,
2 divides 12 equally in 6 parts.
1 divides 1012 at two places and 2 divides it at one place. Divide by 0 is an 
undefined behaviour and it will not be counted.*/
package pl.misc.hackerRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindDigits 
{
    public static void main(String args[])
    {
        int noOfTestCases, testCase, count=0, divisor;
        String temp;
        List<String> testCases = new ArrayList<String>();
        Scanner in = new Scanner(System.in);
        noOfTestCases = in.nextInt();
        for(int i=0;i<noOfTestCases;i++)
        {
            temp=in.next();
            testCases.add(temp);
        }
        for(int i = 0 ; i<testCases.size();i++)
        {
            testCase = Integer.parseInt(testCases.get(i));
            for(int j = 0 ; j<testCases.get(i).length();j++)
            {
                divisor = Character.getNumericValue(testCases.get(i).charAt(j));
                if(divisor!=0)
                {
                    if(testCase%divisor==0)
                    {
                        count++;
                    }
                }
            }
            System.out.println(count);
            count=0;
        }
    }
}
