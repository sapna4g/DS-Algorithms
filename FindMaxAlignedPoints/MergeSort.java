package q3;

/**
 * Merge sort implemented to sort lines
 * 
 * @author Sapna Ganesh sg1368
 * 
 */

public class MergeSort {
	public static void mergeSort(Line[] a, int start, int end) {
		if (start < end) {
			int mid = start + (end - start) / 2;
			mergeSort(a, start, mid);
			mergeSort(a, mid + 1, end);
			merge(a, start, mid, end);
		}
	}

	public static void merge(Line a[], int start, int mid, int end) {
		int i = start;
		int j = mid + 1;
		Line[] c = new Line[end - start + 1];
		for (int k = 0; k < c.length; k++) {

			if (i > mid) {
				c[k] = a[j++];
			} else if (j > end) {
				c[k] = a[i++];
			} else if (a[i].compareTo(a[j]) == -1 || a[i].compareTo(a[j]) == 0) {
				c[k] = a[i];
				i++;
			} else if (a[i].compareTo(a[j]) == 1) {
				c[k] = a[j];
				j++;
			}
		}
		int y = 0;
		for (start = start; start <= end; start++) {
			a[start] = c[y++];
		}
	}
	/*
	 * public static void main(String args[]) { Line[] a = { 1, 4, 3, 7, 4, 9,
	 * 8, 3 }; mergeSort(a, 0, a.length - 1); for (int i = 0; i < a.length; i++)
	 * { System.out.print(a[i] + " "); } }
	 */
}