package q5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class FindKthSmallest {

	// TO-DO
	public static int random(int start, int end) {
		//return (new Random()).nextInt(end - start) + start;
		Random random = new Random();
		return random.nextInt(end - start + 1) + start;
	}

	public static int[] rearrange(int[] a, int pivot, int start, int end) {
		int eq = 0;
		int[] rearran = new int[a.length];
		int i = 0, j = rearran.length - 1;
		for (int x = 0; x < a.length; x++) {
			if (a[x] == pivot) {
				eq++;
			} else if (a[x] < pivot) {
				rearran[i++] = a[x];
			} else {
				rearran[j--] = a[x];
			}
		}
		j = i;
		for (int x = 0; x < eq; x++) {
			rearran[i++] = pivot;
		}
		i--;
		for (int x = 0; x < a.length; x++) {
			a[x] = rearran[x];
		}
		int[] ret = { j, i };
		return ret;
	}

	// sort 5 numbers using bubble sort and return median
		int brute(int[] a, int start, int end) {
			if (start == end) {
				return a[end];
			}
			for (int i = start; i <= end; i++) {
				for (int j = i; j > start; j--) {
					if (a[j] < a[j - 1]) {
						int temp = a[j];
						a[j] = a[j - 1];
						a[j - 1] = temp;
					}
				}
			}

			return a[(start + end) / 2];
		}


	public static int select(int[] a, int k, int start, int end) {
		// if (a.length < 5) {
		// return brute(a, 0, a.length - 1);
		// }
		int i = random(start, end);
		int[] p = rearrange(a, a[i], 0, a.length - 1);
		System.out.println(start+" "+end+" -> "+i+" "+p[0]+" "+p[1]);
		if (k < p[0]){
			System.out.println("left");
			return select(a, k, start, p[0] - 1);
		}else if (k > p[0] && k < p[1]){
			return a[k];
		}else{
			return select(a, k, p[1] + 1,end);
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		// Scanner s = new Scanner(System.in);
		Scanner s = new Scanner(new FileInputStream(new File("sappu.txt")));
		// get the value of k
		int k = Integer.parseInt(s.nextLine());

		// make an array of 2k size
		int[] inputs = new int[2 * k];

		// read and store 1st k elements
		for (int i = 0; i < k; i++) {
			inputs[i] = Integer.parseInt(s.nextLine());
		}

		// boolean to read inputs
		boolean input = true;

		// while there are inputs
		int ksmall = 0;
		while (input) {
			int count = k;

			// while elements are not k
			while (count != inputs.length) {

				// read k elements or less
				int in = Integer.parseInt(s.nextLine());

				// if input input is -1, break, and set boolean false
				if (in == -1) {
					input = false;
					break;
				}

				inputs[count++] = in;

			}
			// call the function
			ksmall = select(inputs, k, 0, count - 1);
		}
		System.out.println(ksmall);
		s.close();
	}
}