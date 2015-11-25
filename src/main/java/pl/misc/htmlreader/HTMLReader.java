package pl.misc.htmlreader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The <code>HTMLReader</code> class find those tags
 * which the user want to find.
 * 
 * @author  Pallav Jha(pallav_kumar71 at yahoo dot com)
 */
public class HTMLReader {
	public static void main(String args[]) throws IOException {
		File file  = new File("/home/pallav/Eclipse Projects/workspace_imguploadimg/HTMLReader/src/stack.html");
		System.out.println(file.exists());
		Scanner sc = new Scanner(file);
		String str = "";
		List<String> imgList = new ArrayList<String>();
		while(sc.hasNext()){
			str = str + sc.nextLine()+"\n";
		}
		//System.out.println(str);
		char[] cbuf = str.toCharArray();
		for(int i =0;i<cbuf.length;i++){
			if(cbuf[i]=='<' && cbuf[i+1]=='i' && cbuf[i+2]=='m' && cbuf[i+3]=='g')
			{
				for(int j=i;j<cbuf.length;j++)
				{
					if(cbuf[j] == '>')
					{
						char[] tempCharArr = new char[(j-i)+1];
						System.arraycopy(cbuf, i, tempCharArr, 0, (j-i));
						imgList.add(new String(tempCharArr));
						i = j;
						break;
					}
				}
			}
		}
		System.out.println(imgList.size()+" image(s) found.");
		for(String s : imgList){
			System.out.println(s);
		}
	}
}
