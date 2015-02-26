package q3;

/**
 * @file Line.java
 * 
 *       This class is for the perpendicular bisector lines of the lines joining
 *       any 2 points. Contains methods to compare such lines.
 * 
 * @author Sapna Ganesh sg1368
 */
public class Line {
	Point midpt = new Point(); // mid point through which the line passes
	double slope;
	double intercept;

	/**
	 * Parameterized constructor to initialize the perpendicular bisector
	 * 
	 * @param p1
	 * @param p2
	 */
	Line(Point p1, Point p2) {
		midpt.x = (p1.x + p2.x) / 2;
		midpt.y = (p1.y + p2.y) / 2;
		slope = -(p1.x - p2.x) / (p1.y - p2.y);
		if (Double.isInfinite(slope)) {
			intercept = midpt.x;
		} else {
			intercept = midpt.y - (slope * midpt.x);
		}
	}

	/**
	 * compare lines in order to sort them
	 * 
	 * @param l
	 * @return int
	 */
	public int compareTo(Line l) {

		if (this.slope > l.slope) {
			return 1;
		}
		if (this.slope == l.slope) {
			if (this.intercept > l.intercept) {
				return 1;
			} else if (this.intercept < l.intercept) {
				return -1;
			}
			return 0;
		}
		return -1;
	}

	/**
	 * determines of 2 lines are equal
	 */
	public boolean equals(Object l) {
		Line o = (Line) l;

		return this.slope == o.slope && this.intercept == o.intercept;
	}

	/**
	 * sort lines using mergesort
	 * 
	 * @param l
	 */
	public static void sort(Line[] l) {
		MergeSort.mergeSort(l, 0, l.length);
	}
/**
 * return maximum occurring line
 * @param l
 * @return int
 */
	public static int maxCount(Line[] l) {
		int maxCount = 1;
		int count = 1;

		for (int i = 0; i < l.length - 1; i++) {

			if (l[i + 1].equals(l[i])) {
				count++;
			} else {
				count = 1;
			}

			if (count > maxCount) {
				maxCount = count;
			}
		}

		return maxCount;
	}

}
