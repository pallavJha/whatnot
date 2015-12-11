package pl.misc.sedgewick.chap02;

import org.apache.commons.lang.ArrayUtils;

public class SortComparator {

	public static void main(String[] args) {
		
		String s2 = "NSELWS5F545thFloorUnit2NucleusSoftwareA39BlockASector62NoidaUttarPradeshIndiaAsiaPlanetEarthSolarSystemNearJupiterUniverseasdasgjdgjgjq3gjhaajsdagdghjgWGHJSdjjGdgasjdgjagchjsghjgsvghjsdgfhsfdhsgfgfhjsdgjfgasghjfgfsdgfhjsdgfygfjysdvjxdvjsdbfhjavfjasbdkbasdfvsdjvfjsdvfvasjvdvajfvhjsdvfvajfvjasvdvsdvasvjfvjsdjfasvfjavfvsdfhjasdvfvsvfjsdvjfvhjasdvfsdfvhjasvfjvsdfjvjsdvfbsdvfjsdfvasdvfjvsdjfvjasdvfjvsdjvhj";
		String s1 = "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww";
		
		String s = "ZZYYXXWWVVUUTTSSRRQQPPOONNMMLLKKJJIIHHGGFFEEDDCCBBAA";
		
		Character[] c_arr = ArrayUtils.toObject(s.toCharArray());
		
		long start = System.currentTimeMillis();
		SelectionSort.sort(c_arr);
		long end = System.currentTimeMillis();
		System.out.println("Selection Sort : " + (end - start));

		s = "ZZYYXXWWVVUUTTSSRRQQPPOONNMMLLKKJJIIHHGGFFEEDDCCBBAA";
		c_arr = ArrayUtils.toObject(s.toCharArray());
		
		
		start = System.currentTimeMillis();
		InsertionSort.sort(c_arr);
		end = System.currentTimeMillis();
		System.out.println("Insertion Sort : " + (end - start));
	}
}
