class ListNode{
    int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 
}

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode oddStart = head;
        ListNode oddCurr = head;
        ListNode evenStart = head.next;
        ListNode evenCurr = head.next;

        ListNode curr = head.next.next;
        int counter = 3;

        while (curr != null) {
            if (counter % 2 == 0) {
                evenCurr.next = curr;
                evenCurr = curr;
            } else {
                oddCurr.next = curr;
                oddCurr = curr;
            }
            curr = curr.next;
            counter++;
        }

        evenCurr.next = null;

        oddCurr.next = evenStart;

        return oddStart;

    } 

    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

class Main{
    public static void main(String[] args) {
        OddEvenLinkedList solution = new OddEvenLinkedList();

        // Test Case 1: Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        solution.printList(head);

        // Remove the 2nd node from the end: Expected result 1 -> 2 -> 3 -> 5 -> null
        int n = 2;
        ListNode newHead = solution.oddEvenList(head);

        System.out.println("List after sorting list  :");
        solution.printList(newHead);
    }
}
