/*
for i = 1 to M do
    for j = 1 to N do
        if j % B[i] == 0 then
            A[j] = A[j] * C[i]
        endif
    end do
end do
*/
package pl.misc.hackerank.unmanaged;

import java.util.Scanner;

public class SherlockAndQueries {

    public static void main(String[] args) 
    {
        int n,m;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        long a[] = new long[n];
        long b[] = new long[m];
        long c[] = new long[m];
        for(int i = 0 ; i < n ; i++)
        {
            a[i] = sc.nextLong();
        }
        for(int i = 0 ; i < m ; i++)
        {
            b[i] = sc.nextLong();
        }
        for(int i = 0 ; i < m ; i++)
        {
            c[i] = sc.nextLong();
        }
        for(int i= 0 ; i < m ; i++)
        {
            for(int j= (int)(b[i]-1) ; j < n ; j+=b[i])
            {
                a[j] = ((a[j]%1000000007L) * (c[i]%1000000007L))%1000000007L;
            }
        }
        for(int i = 0 ; i < n ; i++)
        {
            System.out.print(a[i]+ " ");
        }        
    }
    public static long mod(long a)
    {
        while(a>=1000000007L)
        {
            a=a-1000000007L;
        }
        return a;
    }

}
