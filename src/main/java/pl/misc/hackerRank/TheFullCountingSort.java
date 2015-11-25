package pl.misc.hackerRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class StringCollection
{
    ArrayList<String> stringlist;
    
    public StringCollection() {
        super();
        stringlist=new ArrayList<String>();
    }

    public ArrayList<String> getStringlist() {
        return stringlist;
    }

    
}
public class TheFullCountingSort 
{

    public static void main(String[] args) 
    {
        int arraySize,temp,halfSize;
        Scanner sc = new Scanner(System.in);
        arraySize=sc.nextInt();
        ArrayList<String> tempList=null;
        int buffer[] = new int[100];
        StringCollection stringCollection[] = new StringCollection[100];
        for(int i=0;i<100;i++)
        {
            stringCollection[i]=new StringCollection();
        }
        halfSize=arraySize/2;
        long startTime = System.currentTimeMillis();
        for(int i=0;i<arraySize;i++)
        {
            temp=sc.nextInt();
            ++buffer[temp];
            if(i>=arraySize/2)
            {
                stringCollection[temp].getStringlist().add(sc.next());
            }
            else
            {   
                sc.next();
                stringCollection[temp].getStringlist().add("-");
            }
        }
        
        for(int i=0;i<buffer.length;i++)
        {
            if(buffer[i]>0)
            {
                tempList=stringCollection[i].getStringlist();
                for(String s : tempList)
                {
                    System.out.print(s+" ");
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println((endTime-startTime)/1000);
    }

}
