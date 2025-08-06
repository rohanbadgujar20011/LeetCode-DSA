package LinkedList;

public class ReverseLinkedList206 {

    // Method to reverse the linked list
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null; // Initially, previous node is null (new tail will point to null)

        // Loop until we reach the end of the original list
        while (head != null) {
            ListNode nextNode = head.next; // Save reference to next node before breaking the link

            head.next = prev;              // Reverse the current node's pointer
            prev = head;                   // Move 'prev' to current node (it becomes the new head of reversed part)
            head = nextNode;               // Move to the next node in the original list
        }

        // At the end, 'prev' will be pointing to the new head of reversed list
        return prev;
    }

    public static void main(String[] args) {
        // Build the linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        ListNode current = head;

        for (int i = 2; i <= 5; i++) {
            current.next = new ListNode(i); // Link the next node
            current = current.next;         // Move to the newly created node
        }

        // Reverse the list
        ListNode result = reverseList(head);

        // Print the reversed linked list: 5 -> 4 -> 3 -> 2 -> 1
        while (result != null) {
            System.out.println(result.value); // Print current node value
            result = result.next;             // Move to next node
        }
    }
}
