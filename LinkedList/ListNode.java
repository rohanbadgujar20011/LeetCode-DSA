package LinkedList;

public class ListNode {
    int value;
    ListNode next;

    ListNode() {}
    ListNode(int value, ListNode node) {
        this.value = value;
        this.next = node;
    }

    ListNode(int value) {
        this.value = value;
    }
}