package q4;

import java.util.Scanner;

/**
 * Class Karray is a class that has instances of an array. This class is used as
 * the sizes of arrays is varied and dynamic.
 * 
 * @author Sapna Ganesh sg1368
 * 
 */
class Karray {
	int a[];

	Karray(int[] a) {
		this.a = a;
	}

	/**
	 * method that returns string to print
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < a.length; i++) {
			sb.append(a[i] + " ");
		}
		return sb.toString();
	}
}

/**
 * Class merge merges sorted arrays and prints the resultant sorted array
 * 
 * @author Sapna Ganesh sg1368
 * 
 */
public class Merge {
	/**
	 * merge sort uses divide and conquer approach to sort already sorted arrays
	 * into one big sorted array
	 * 
	 * @param k
	 * @param start
	 * @param end
	 * @return
	 */
	public static Karray mergeSort(Karray[] k, int start, int end) {
		if (start == end) {
			return k[start];
		}

		int mid = (end + start) / 2;

		Karray kl = mergeSort(k, start, mid);
		Karray kr = mergeSort(k, mid + 1, end);
		return merge(kl, kr);
	}

	/**
	 * merge 2 arrays into a single sorted array
	 * 
	 * @param kl
	 * @param kr
	 * @return
	 */
	public static Karray merge(Karray kl, Karray kr) {
		int[] c = new int[kl.a.length + kr.a.length];

		int i = 0;
		int j = 0;

		for (int k = 0; k < c.length; k++) {

			if (i >= kl.a.length) {
				c[k] = kr.a[j++];
			} else if (j >= kr.a.length) {
				c[k] = kl.a[i++];
			} else if (kl.a[i] <= kr.a[j]) {
				c[k] = kl.a[i++];
			} else if (kl.a[i] > kr.a[j]) {
				c[k] = kr.a[j++];
			}
		}
		Karray temp = new Karray(c);
		return temp;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int total = Integer.parseInt(s.nextLine());
		Karray[] ka = new Karray[total];

		for (int x = 0; x < total; x++) {
			String str = s.nextLine();
			int t = Integer.parseInt(str);
			int[] a = new int[t];
			String st = s.nextLine();
			String[] parts = st.split(" ");
			for (int i = 0; i < t; i++) {
				a[i] = Integer.parseInt(parts[i]);
			}
			ka[x] = new Karray(a);
		}

		/*
		 * int[] a = { 1, 2, 3, 4, 5, 6 }; int[] b = { 10, 23, 43, 49, 55 };
		 * int[] c = { 22, 23, 24, 25, 26, 27 }; int[] d = { 9 };
		 * 
		 * ka[0] = new Karray(a); ka[1] = new Karray(b); ka[2] = new Karray(c);
		 * ka[3] = new Karray(d);
		 */
		Karray sorted = mergeSort(ka, 0, total - 1);

		System.out.println(sorted);

	}

}
