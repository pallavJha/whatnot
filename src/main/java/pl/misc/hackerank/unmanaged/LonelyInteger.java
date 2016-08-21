package pl.misc.hackerank.unmanaged;

import java.util.Arrays;
import java.util.Scanner;

public class LonelyInteger {

    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int res;
        
        int _a_size = Integer.parseInt(in.nextLine());
        int[] _a = new int[_a_size];
        int _a_item;
        String next = in.nextLine();
        String[] next_split = next.split(" ");
        
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(next_split[_a_i]);
            _a[_a_i] = _a_item;
        }
        
        res = lonelyinteger(_a);
        System.out.println(res);
    }
    static int lonelyinteger(int[] a) 
    {
        if(a.length==1)
        {
            return a[0];
        }
        Arrays.sort(a);
        if(a[0]!=a[1])
        {
            return a[0];
        }
        
        for(int i = 1; i < a.length-1 ; i++)
        {
            if(a[i]!=a[i+1]&& a[i]!=a[i-1])
            {
                return a[i];
            }
            
        }
        if(a[a.length-1]!=a[a.length-2])
        {
            return a[a.length-1];
        }
        return 0;
    }

}
