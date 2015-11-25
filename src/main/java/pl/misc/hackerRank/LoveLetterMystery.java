package pl.misc.hackerRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoveLetterMystery {

    public static void main(String[] args) 
    {
        Long noOfCases, noOfOperations=0L;
        int start, end;
        String temp;
        int firstChar, secondChar;
        Scanner sc = new Scanner(System.in);
        noOfCases=sc.nextLong();
        List<String> stringList = new ArrayList<String>();
        for(long i = 0L ; i<noOfCases;i++)
        {
            temp=sc.next();
            stringList.add(temp);
        }
        for(int i=0;i<stringList.size();i++)
        {
            temp=stringList.get(i);
            if(palindromCheck(temp))
            {
                System.out.println(noOfOperations);
                continue;
            }
            for(int j=0;j<temp.length();j++)
            {
                start=j;
                end=temp.length()-j-1;
                
                firstChar=temp.charAt(start);
                secondChar=temp.charAt(end);
                if(firstChar==secondChar)
                {
                    if(end-start==2)
                    {
                        break;
                    }
                    if(end-start==1)
                    {
                        break;
                    }
                    continue;
                    
                }
                else
                {
                    noOfOperations+=Math.abs(firstChar-secondChar);
                }
                if(end-start==2)
                {
                    break;
                }
                if(end-start==1)
                {
                    break;
                }
            }
            System.out.println(noOfOperations);
            noOfOperations=0L;
        }
    }

    public static boolean palindromCheck(String str) {
        String reverse = "";
        for (int i = str.length() - 1 ; i >= 0 ; i--)
            reverse = reverse + str.charAt(i);

        if (str.equals(reverse))
            return true;
        else
            return false;
    }

}
