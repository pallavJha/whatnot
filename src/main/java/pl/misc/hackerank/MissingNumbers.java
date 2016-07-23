/*Numeros, The Artist, had two lists A and B, such that, B was a permutation of A.
Numeros was very proud of these lists. Unfortunately, while transporting them from
one exhibition to another, some numbers from List A got left out. Can you find out the numbers missing from A?
Notes
If a number occurs multiple times in the lists,
you must ensure that the frequency of that number
in both the lists is the same. 
If that is not the case, then it is also a missing number.
You have to print all the missing numbers in ascending order.
Print each missing number once, even if it is missing multiple times.
The difference between maximum and minimum number in the list B is less than or equal to 100.
Input Format 
There will be four lines of input:

n - the size of the first list 
This is followed by n space separated integers that make up the first list. 
m - the size of the second list 
This is followed by m space separated integers that make up the second list.

Output Format 
Output the missing numbers in ascending order

Constraints 
1<= n,m <= 1000010 
1 <= x <= 10000 , x ∈ B 
Xmax - Xmin < 101

Sample Input

10
203 204 205 206 207 208 203 204 205 206
13
203 204 204 205 206 207 205 208 203 206 205 206 204
Sample Output

204 205 206
Explanation 
204 is present in both the arrays. Its frequency in A is 2, while its frequency in B is 3. Similarly, 205 and 206 occur twice in A, but thrice in B. So, these three numbers are our output. Rest of the numbers have same frequency in both the lists.*/
package pl.misc.hackerank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MissingNumbers {

    public static void main(String[] args) 
    {
        Scanner sc =new Scanner(System.in);
        int numInA, numInB, val, occurenceInA, occurenceInB, j=0;
        numInA = sc.nextInt();
        int a[] = new int[numInA];
        ArrayList<Integer> missingA = new ArrayList<Integer>();
        for(int i=0;i<numInA;i++)
        {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        numInB = sc.nextInt();
        int b[] = new int[numInB];
        for(int i=0;i<numInB;i++)
        {
            b[i] = sc.nextInt();
        }
        Arrays.sort(b);
        Map<Integer, Integer> mapA = new HashMap<Integer, Integer>();
        for(int i=0;i<numInA;i++)
        {
            if(mapA.get(a[i])==null)
            {
                mapA.put(a[i],1);
            }
            else
            {
                val = mapA.get(a[i]);
                mapA.put(a[i], ++val);
            }
        }
        Map<Integer, Integer> mapB = new HashMap<Integer, Integer>();
        for(int i=0;i<numInB;i++)
        {
            if(mapB.get(b[i])==null)
            {
                mapB.put(b[i],1);
            }
            else
            {
                val = mapB.get(b[i]);
                mapB.put(b[i], ++val);
            }
        }
        Set<Integer> mapBKeySet = mapB.keySet();
        ArrayList<Integer> mapBKeyList = new ArrayList<Integer>(mapBKeySet);
        for(int i=0; i< mapBKeyList.size();i++)
        {
           
            if(mapA.get(mapBKeyList.get(i))==null)
            {
                //System.out.print(mapBKeyList.get(i)+" ");
                missingA.add(mapBKeyList.get(i));
            }
            else
            {
                occurenceInA = mapA.get(mapBKeyList.get(i));
                occurenceInB = mapB.get(mapBKeyList.get(i));
                if(occurenceInB > occurenceInA)
                {
                  //System.out.print(mapBKeyList.get(i)+" ");
                  missingA.add(mapBKeyList.get(i));
                }
            }
        }
        Collections.sort(missingA);
        for(int i=0;i<missingA.size();i++)
        {
            System.out.print(missingA.get(i)+" ");
        }
    }
}
