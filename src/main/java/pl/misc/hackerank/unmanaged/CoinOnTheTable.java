package pl.misc.hackerank.unmanaged;

import java.util.Scanner;

public class CoinOnTheTable {

    static int n,m,k, asteriskI, asteriskJ, posI = 0, posJ = 0, distanceCoveredActual = 0, minimumDistance = 0, arr[][];
    static boolean flagForLoop = true, cannotReach = false, reached = false;
    public static void calculateActualDistance()
    {
        while(true)
        {
            // 82 R 76 L 85 U 68 D 42 *

            switch (arr[posI][posJ]) {
                case 82:  
                    if(posJ != m-1)
                    {   
                        distanceCoveredActual++;
                        posJ++;
                    }
                    else
                    {
                        cannotReach = true;
                        flagForLoop = false;
                    }
                    break;
                    
                case 76:  
                    if(posJ != 0)
                    {
                        distanceCoveredActual++;
                        posJ--;
                    }
                    else
                    {
                        cannotReach = true;
                        flagForLoop = false;
                    }
                    break;
                    
                case 85:  
                    if(posI != 0)
                    {
                        distanceCoveredActual++;
                        posI--;
                    }
                    else
                    {
                        cannotReach = true;
                        flagForLoop = false;
                    }
                    break;
                    
                case 68:  
                    if(posI != n-1)
                    {
                        distanceCoveredActual++;
                        posI++;
                    }
                    else
                    {
                        cannotReach = true;
                        flagForLoop = false;
                    }
                    break;
                    
                case 42: 
                    distanceCoveredActual++;
                    reached = true;
                    flagForLoop = false;
                    break;
                
            }
        }
    }
    
    public static void calculateMinimumDistance()
    {
        minimumDistance = asteriskI + asteriskJ;
    }
    
    @SuppressWarnings("resource")
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n][];
        for(int i = 0; i < n ; i++)
        {
            arr[i] = new int[m];
            for(int j = 0; j < m ; j++)
            {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 42) {
                    asteriskI = i;
                    asteriskJ = j;
                }
            }
        }
        if(k < minimumDistance)
        {
            System.out.println(-1);
        }
        else if(minimumDistance <= k && distanceCoveredActual >= k)
        {
            
        }
    }

}
