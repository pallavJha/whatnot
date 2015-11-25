/*You are given an integer, N. Write a program to determine if N is an element of the Fibonacci Sequence.
The first few elements of fibonacci sequence are 0,1,1,2,3,5,8,13....
A fibonacci sequence is one where every element is a sum of the previous two elements in the sequence.
The first two elements are 0 and 1.
Formally:
fib0 = 0 
fib1 = 1 
fibn = fibn-1 + fibn-2 ∀ n > 1
Input Format 
The first line contains T, number of test cases. 
T lines follows. Each line contains an integer N.
Output Format 
Display IsFibo if N is a fibonacci number and IsNotFibo if it is not a fibonacci number.
The output for each test case should be displayed on a new line.
Constraints 
1 <= T <= 105 
1 <= N <= 1010
Sample Input
3
5
7
8
Sample Output
IsFibo
IsNotFibo
IsFibo*/
package pl.misc.hackerRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IsFibo {

    public static void main(String[] args) 
    {
        Long noOfCases, temp;
        boolean status = false;
        Scanner in = new Scanner(System.in);
        noOfCases = in.nextLong();
        List<Long> testCases = new ArrayList<Long>();
        for(int i=0;i<noOfCases;i++)
        {
            temp=in.nextLong();
            testCases.add(temp);
        }
        long first=0, second=1, third=0;
        for(int i=0;i<testCases.size();i++)
        {
            temp=testCases.get(i);
            if(temp == 0 || temp == 1)
            {
                status = true;
            }
            while(third<=temp&&status==false)
            {
                third=first+second;
                second=first+second;
                first=second-first;
                if(third==temp)
                {
                    status = true;
                }
                
            }
            if(status)
            {
                System.out.println("IsFibo");
            }
            else
            {
                System.out.println("IsNotFibo");
            }
            status = false;
            first=0; second=1; third=0;
        }
        
    }

}
