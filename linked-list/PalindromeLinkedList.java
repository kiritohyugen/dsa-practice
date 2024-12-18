// 234. Palindrome Linked List
// Solved
// Easy
// Topics
// Companies
// Given the head of a singly linked list, return true if it is a 
// palindrome
//  or false otherwise.

 

// Example 1:


// Input: head = [1,2,2,1]
// Output: true
// Example 2:


// Input: head = [1,2]
// Output: false
 

// Constraints:

// The number of nodes in the list is in the range [1, 105].
// 0 <= Node.val <= 9
 

// Follow up: Could you do it in O(n) time and O(1) space?
// Seen this question in a real interview before?
// 1/5
// Yes
// No
// Accepted
// 2.2M
// Submissions
// 4M
// Acceptance Rate
// 54.6%  
  
  class  ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        
        if(head.next == null) return true;//The number of nodes in the list is in the range [1, 105].


        //find size n
        // reverse from 0 to n?
        //n == even 0 to n/2-1 and n/2 to n-1 (ex:4)
        //n == odd 0 to n/2-1   and n/2+1 to n-1 (ex:5)
        //compare values from start to end on both lists 

        int size = 0;
        ListNode curr  = head;
        while(curr != null){
            size++;
            curr=curr.next;
        }

        int leftEnd =  size/2-1;
        //revcerse from 0 to leftend

        int index = 0;
        ListNode prev = null;
        curr = head;
        ListNode next = null;
        while(index != leftEnd+1){

            System.out.println("index : " + index + " , leftEnd+1 : " + leftEnd+1);
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            index++;


        }

        ListNode left = prev;
        ListNode right = (size%2==0) ? curr : curr.next;


        while(right != null){
            if(left.val != right.val) return false;
            left=left.next;
            right = right.next;
        }

        return true;
        
        
        
        
        
    }

    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public ListNode createList(int[] values) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }
        return dummy.next; // Return the head of the list
    }
}

class Main{
    public static void main(String[] args) {
        PalindromeLinkedList solution = new PalindromeLinkedList();
        
        // Test case 1: Palindrome list
        int[] values1 = {1, 2, 2, 1};
        ListNode head1 = solution.createList(values1);
        solution.printList(head1);
        System.out.println("Is palindrome? " + solution.isPalindrome(head1)); // Output: true
        
        // Test case 2: Non-palindrome list
        int[] values2 = {1, 2};
        ListNode head2 = solution.createList(values2);
        solution.printList(head2);
        System.out.println("Is palindrome? " + solution.isPalindrome(head2)); // Output: false
        
        // Test case 3: Single-node list
        int[] values3 = {1};
        ListNode head3 = solution.createList(values3);
        solution.printList(head3);
        System.out.println("Is palindrome? " + solution.isPalindrome(head3)); // Output: true
    }
}