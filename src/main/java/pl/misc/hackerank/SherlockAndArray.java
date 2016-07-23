package pl.misc.hackerank;

import java.util.Scanner;

public class SherlockAndArray {

    public static void main(String[] args) 
    {
        int noOfTestcases, arraySize;
        Scanner sc = new Scanner(System.in);
        noOfTestcases = sc.nextInt();
        Integer arr[][] = new Integer[noOfTestcases][];
        for(int i= 0 ; i< noOfTestcases ; i++)
        {
            arraySize=sc.nextInt();
            arr[i] = new Integer[arraySize];
            for(int j = 0 ; j < arraySize ; j++)
            {
                arr[i][j]= sc.nextInt();
            }
            
        }
        for(int j = 0 ; j < noOfTestcases ; j++)
        {
            calculateSum(arr[j]);;
        }
     }
    public static void calculateSum(Integer arr[])
    {
        boolean calculatedForTheFirstTime = false;
        if(arr.length==1)
        {
            System.out.println("YES");
        }
        else
        {
            int sumLeft = 0, sumRight =0,i;
            for( i=1;i<arr.length-1;i++)
            {
                if(!calculatedForTheFirstTime)
                {
                    for(int j = 0; j<= i-1 ; j++)
                    {
                        sumLeft+=arr[j];
                    }
                    for(int j = i+1; j<=arr.length-1 ; j++)
                    {
                        sumRight+=arr[j];
                    }
                    calculatedForTheFirstTime =true;
                }
                else
                {
                    sumLeft=sumLeft+arr[i-1];
                    sumRight=sumRight-arr[i];
                    
                }
                if(sumLeft==sumRight)
                {
                    System.out.println("YES");
                    break;
                }
                
            }
            if(i==arr.length-1)
            {
                System.out.println("NO");
            }
        }
    }

}
