public class ListNode {
    String[] data;
    ListNode next;

    public ListNode(String[] data) {
        this.data = data;
        this.next = null;
    }

    public ListNode(String[] data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    public ListNode() {
        this.data = null;
        this.next = null;
    }

}