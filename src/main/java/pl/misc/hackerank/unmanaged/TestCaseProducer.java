package pl.misc.hackerank.unmanaged;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class TestCaseProducer {

    public static void main(String[] args) throws IOException 
    {
        File file = new File("test case.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(1001+"\r\n");
        Set<Integer> ser =new HashSet<Integer>();
        for(int i=1;i<=1001;i++)
        {
            ser.add(i);
        }
        ArrayList<Integer> aList  = new ArrayList<Integer>(ser);
        long seed = System.nanoTime();
        Collections.shuffle(aList, new Random(seed));
        for(int i=0;i<=1000;i++)
        {
            bw.write(aList.get(i)+" ");
        }
        bw.close();
    }
    
}
