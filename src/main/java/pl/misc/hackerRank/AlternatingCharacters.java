/*Problem Statement
Shashank likes strings in which consecutive characters are different.
For example, he likes ABABA, while he doesn't like ABAA. 
Given a string containing characters A and B only,
he wants to change it into a string he likes.
To do this, he is allowed to delete the characters in the string.
Your task is to find the minimum number of required deletions.
Input Format 
The first line contains an integer T i.e. the number of test cases. 
Next T lines contain a string each.
Output Format 
Print minimum number of required steps for each test case.
Constraints
1≤T≤10 
1≤lengthofString≤105 
Sample Input
5
AAAA
BBBBB
ABABABAB
BABABA
AAABBB
Sample Output
3
4
0
0
4
*/
package pl.misc.hackerRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlternatingCharacters {

    public static void main(String[] args) 
    {
        Long noOfCases, noOfDelete=0L;
        String temp;
        StringBuilder temp2;
        Scanner sc = new Scanner(System.in);
        noOfCases=sc.nextLong();
        List<StringBuilder> stringList = new ArrayList<StringBuilder>();
        for(long i = 0L ; i<noOfCases;i++)
        {
            temp=sc.next();
            stringList.add(new StringBuilder(temp));
        }
        for(int i = 0 ; i<stringList.size();i++)
        {
            temp2=stringList.get(i);
            for(int j=0;j<temp2.length();)
            {
                if(temp2.length()==1||j==temp2.length()-1)
                {
                    break;
                }
                if(temp2.charAt(j)==temp2.charAt(j+1))
                {
                    temp2=temp2.deleteCharAt(j+1);
                    noOfDelete++;
                    continue;
                }
                j++;
            }
            System.out.println(noOfDelete);
            noOfDelete=0L;
        }
        
        
    }

}
