package pl.misc.hackerank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class NvsNLogN {

    public static void main(String[] args) throws IOException 
    {
        File file = new File("res.txt");
       /* if (!file.exists()) {
            file.createNewFile();
        }
        BufferedWriter bw = new BufferedWriter(fw);
        for(int i=0;i<Integer.MAX_VALUE;i++)
        {
            bw.write(i+", "+i*Math.log(i)/Math.log(2)+"\r\n");
        }
        bw.close();*/
        FileWriter fw = new FileWriter(file);

        Reader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        while(br.ready()) {
            fw.write(br.readLine().replaceAll("//", "////"));
        }

        fw.close();
        br.close();
        fr.close();
    }
}
