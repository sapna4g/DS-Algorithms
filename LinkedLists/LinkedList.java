public class LinkedList {

	Node head =  null;

	public void add(int value) {
		Node temp = this.head;
		if (this.head == null) {
			this.head = new Node();
			this.head.value = value;
		} else {
			
			while (temp.next != null) {
				temp = temp.next;
				
			}
			temp.next = new Node();
			temp.next.value = value;
		}
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		if (this.head == null) {
			sb.append("empty");
		} else {
			Node temp = this.head;
			while (temp != null) {
				sb.append("-"+temp.value+"-");
				temp = temp.next;
			}
		}
		return sb.toString();
	}

}
