package pl.misc.htmlreader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Image MIME Type Complete List 
 * 
 * @author pallav
 */
public class ImgTypeFinder {
	public static void main(String args[]) throws IOException {

		URL postURL = new URL(
				"http://www.sitepoint.com/web-foundations/mime-types-complete-list/");

		InputStream inputStream = postURL.openStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(
				inputStream));
		String line;
		StringBuilder sb = new StringBuilder("");
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		String str = sb.toString();
		int pp = 0;
		List<String> stringList = new ArrayList<String>();
		List<String> typeList = new ArrayList<String>();
		StringBuilder typeSb = new StringBuilder();
		int startIndex = str.indexOf("<table");
		int endIndex = str.indexOf("</table");
		str = str.substring(startIndex, endIndex);
		// System.out.println(str);
		char[] cbuf = str.toCharArray();
		for (int i = 0; i < cbuf.length; i++) {
			if (cbuf[i] == 'i' && cbuf[i + 1] == 'm' && cbuf[i + 2] == 'a'
					&& cbuf[i + 3] == 'g' && cbuf[i + 4] == 'e'
					&& cbuf[i + 5] == '/') {
				for (int j = i; j < cbuf.length; j++) {
					if (cbuf[j] == '<') {
						char[] tempCharArr = new char[(j - i) + 1];
						System.arraycopy(cbuf, i, tempCharArr, 0, (j - i));
						stringList.add(new String(tempCharArr));
						if(cbuf[i-52] == '>'){
							pp = i -51;
						}
						
						for(int k=pp;k<j;k++){
							if(cbuf[k]!='<'){
								typeSb.append(cbuf[k]);
							}
							else{
								typeList.add(typeSb.toString());
								typeSb = new StringBuilder();
								break;
							}
						}
						i = j;
						break;
					}
				}
			}
		}
		System.out.println(stringList.size() + " image(s) found.");
		for (String s : stringList) {
			System.out.println(s);
		}
		for(int i = 0;i<stringList.size();i++){
			System.out.println(typeList.get(i)+" "+stringList.get(i));
		}
	}
}
