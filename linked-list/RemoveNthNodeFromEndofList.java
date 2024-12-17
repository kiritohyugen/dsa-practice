class ListNodeV4 {
    int val;
    ListNodeV4 next;

    ListNodeV4(int val) {
        this.val = val;
        this.next = null;
    }
}

public class RemoveNthNodeFromEndofList {

    public ListNodeV4 removeNthFromEnd(ListNodeV4 head, int n) {
        // Create a dummy node to handle edge cases like removing the head node
        ListNodeV4 dummy = new ListNodeV4(0);
        dummy.next = head;
        ListNodeV4 fast = dummy;
        ListNodeV4 slow = dummy;

        // Move the fast pointer 'n + 1' steps ahead to maintain a gap of 'n' nodes
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }

        // Move both fast and slow pointers until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove the nth node from the end
        slow.next = slow.next.next;

        return dummy.next; // Return the modified list (dummy.next skips dummy)
    }

    // Helper function to print the linked list
    public void printList(ListNodeV4 head) {
        ListNodeV4 current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndofList solution = new RemoveNthNodeFromEndofList();

        // Test Case 1: Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null
        ListNodeV4 head = new ListNodeV4(1);
        head.next = new ListNodeV4(2);
        head.next.next = new ListNodeV4(3);
        head.next.next.next = new ListNodeV4(4);
        head.next.next.next.next = new ListNodeV4(5);

        System.out.println("Original List:");
        solution.printList(head);

        // Remove the 2nd node from the end: Expected result 1 -> 2 -> 3 -> 5 -> null
        int n = 2;
        ListNodeV4 newHead = solution.removeNthFromEnd(head, n);

        System.out.println("List after removing " + n + "th node from end:");
        solution.printList(newHead);
    }
}
