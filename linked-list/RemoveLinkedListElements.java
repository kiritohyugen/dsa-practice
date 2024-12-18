// 203. Remove Linked List Elements
// Solved
// Easy
// Topics
// Companies
// Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

 

// Example 1:


// Input: head = [1,2,6,3,4,5,6], val = 6
// Output: [1,2,3,4,5]
// Example 2:

// Input: head = [], val = 1
// Output: []
// Example 3:

// Input: head = [7,7,7,7], val = 7
// Output: []
 

// Constraints:

// The number of nodes in the list is in the range [0, 104].
// 1 <= Node.val <= 50
// 0 <= val <= 50
// Seen this question in a real interview before?
// 1/5
// Yes
// No
// Accepted
// 1.3M
// Submissions
// 2.5M
// Acceptance Rate
// 50.5%

  class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }


public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while(curr != null){
            if(curr. val == val){
                prev.next = curr.next;
                curr = curr.next;
            }else{
            prev = curr;
            curr = curr.next;
            }

        }

        return dummy.next;
        
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
        RemoveLinkedListElements solution = new RemoveLinkedListElements();

        // Test Case 1: Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        solution.printList(head);

        int n = 1;
        ListNode newHead = solution.removeElements(head, n);

        System.out.println("List after removing " + n + " :");
        solution.printList(newHead);
    }
}
