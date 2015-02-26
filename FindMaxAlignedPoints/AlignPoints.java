package q3;

import java.util.Scanner;

/**
 * @file AlignPoints.java
 * 
 *       This file takes points as input and prints the line on which if folded,
 *       maximum points overlap.
 * 
 * @author Sapna Ganesh sg1368
 */
public class AlignPoints {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int total = Integer.parseInt(s.nextLine());
		Point[] a = new Point[total];

		for (int x = 0; x < total; x++) {
			String str = s.nextLine();
			String[] parts = str.split(" ");
			a[x] = new Point(Integer.parseInt(parts[0]),
					Integer.parseInt(parts[1]));
		}

		int n = a.length;
		// number of lines is n choose 2.
		Line[] l = new Line[n * (n - 1) / 2];
		int k = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				l[k++] = new Line(a[i], a[j]);
			}
		}
		// sort lines based on slope and intercept
		MergeSort.mergeSort(l, 0, l.length - 1);
		// determine which line occurs most
		int maxCount = Line.maxCount(l);
		System.out.println(maxCount);
	}
}
