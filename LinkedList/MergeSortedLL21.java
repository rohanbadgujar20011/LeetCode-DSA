package LinkedList;

public class MergeSortedLL21 {

    // Method to merge two sorted linked lists
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to simplify the logic for the head of the result list
        ListNode result = new ListNode(0);
        ListNode temp = result; // Pointer to build the new list

        // Loop through both lists until one becomes null
        while (list1 != null && list2 != null) {
            if (list1.value < list2.value) {
                // If current node of list1 is smaller, add it to the result
                temp.next = new ListNode(list1.value);
                list1 = list1.next; // Move to next node in list1
            } else {
                // If current node of list2 is smaller or equal, add it to the result
                temp.next = new ListNode(list2.value);
                list2 = list2.next; // Move to next node in list2
            }
            temp = temp.next; // Move temp pointer to the newly added node
        }

        // If there are remaining nodes in list1, append them
        if (list1 != null) {
            temp.next = list1;
        }
        // If there are remaining nodes in list2, append them
        else if (list2 != null) {
            temp.next = list2;
        }

        // Return the head of the merged list, skipping the dummy node
        return result.next;
    }

    public static void main(String[] args) {
        // First sorted linked list: 1 -> 1 -> 5
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(5);

        // Second sorted linked list: 2 -> 4 -> 6
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        // Create an object of MergeSortedLL21 to call the instance method
        MergeSortedLL21 obj = new MergeSortedLL21();

        // Merge the two sorted linked lists
        ListNode merged = obj.mergeTwoLists(l1, l2);

        // Print the merged list: should print 1 1 2 4 5 6
        while (merged != null) {
            System.out.print(merged.value + " ");
            merged = merged.next;
        }
    }
}
