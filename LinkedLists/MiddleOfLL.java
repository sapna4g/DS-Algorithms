public class MiddleOfLL {
	public static int middleElem(LinkedList l) {
		// 2 pointers, second moves 2 times first
		Node temp = l.head;
		Node temp2 = l.head;
		while (temp2.next != null) {
			temp2 = temp2.next;
			// for even nodes
			if (temp2.next != null) {
				temp2 = temp2.next;
				temp = temp.next;
			}
		}
		return temp.value;

	}

	public static void main(String args[]) {
		LinkedList l = new LinkedList();
		// l.add(3);
		// l.add(1);
		l.add(6);
		l.add(4);
		l.add(3);
		l.add(3);

		int m = middleElem(l);
		System.out.println(m);
	}

}
