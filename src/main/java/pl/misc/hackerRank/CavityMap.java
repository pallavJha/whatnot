/*
You are given a square map. Each cell of the map has a value in it denoting the depth of the appropriate
area. We will call a cell of the map a cavity if and only if this cell is not on the border of the map 
and each cell adjacent to it has strictly smaller depth.
Two cells are adjacent if they have a common side.
You need to find all the cavities on the map and depict them with character X .
Input Format
The first line contains an integer , denoting the size of the map. Each of the following lines contains positive
digits without spaces. A digit (1-9) denotes the depth of the appropriate area.
Output Format
Output lines, denoting the resulting map. Each cavity should be replaced with character X .
Sample Input
4
1112
1912
1892
1234
Sample Output
1112
1X12
18X2
1234
*/

package pl.misc.hackerRank;

import java.util.Scanner;

public class CavityMap {

    public static void main(String[] args) 
    {
        int mapSize;
        Scanner sc = new Scanner(System.in);
        mapSize = sc.nextInt();
        String[] map = new String[mapSize];
        for(int i= 0; i<mapSize;i++)
        {
            map[i] = sc.next();
        }
        for(int i =1 ; i < mapSize-1 ; i++)
        {
            for(int j = 1 ; j < mapSize-1; j++)
            {
                if(checkCavity(map, i, j))
                {
                    char[] chars = map[i].toCharArray();
                    chars[j] = 'X';
                    map[i] = new String(chars);
                }
                
            }
        }
        for(int i= 0; i<mapSize;i++)
        {
            System.out.println(map[i]);
        }
        
    }
    public static boolean checkCavity(String[] map, int i, int j)
    {
        char up = map[i-1].charAt(j);
        char down = map[i+1].charAt(j);
        char left = map[i].charAt(j-1);
        char right = map[i].charAt(j+1);
        char toCheck = map[i].charAt(j);
        if(up=='X'||down=='X'||left=='X'||right=='X')
        {
            return false;
        }
        else if( toCheck>up && toCheck>down && toCheck>left && toCheck>right)
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }

}
