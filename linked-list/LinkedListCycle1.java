// 141. Linked List Cycle
// Solved
// Easy
// Topics
// Companies
// Given head, the head of a linked list, determine if the linked list has a cycle in it.

// There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

// Return true if there is a cycle in the linked list. Otherwise, return false.

 

// Example 1:


// Input: head = [3,2,0,-4], pos = 1
// Output: true
// Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
// Example 2:


// Input: head = [1,2], pos = 0
// Output: true
// Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
// Example 3:


// Input: head = [1], pos = -1
// Output: false
// Explanation: There is no cycle in the linked list.
 

// Constraints:

// The number of the nodes in the list is in the range [0, 104].
// -105 <= Node.val <= 105
// pos is -1 or a valid index in the linked-list.
 

// Follow up: Can you solve it using O(1) (i.e. constant) memory?



import java.util.HashMap;


class ListNode{
    int val;
    ListNode next;

    public ListNode(int x) {
        this.val = x;
        this.next=null;
    }

    
}

public class LinkedListCycle1{
    public boolean hasCycle(ListNode head) {
        HashMap<ListNode,Integer> map = new HashMap<>();
        ListNode curr = head;
        boolean hasCycle = false;
        while(curr != null && curr.next !=null){
            if(map.containsKey(curr)){
                hasCycle = true;
                break;
            }
            map.put(curr,curr.val);
            curr = curr.next;
        }

        return hasCycle;
    }

    public boolean hasCycleV2(ListNode head){

        if(head == null || head.next == null ) return false;
        ListNode slow = head;
        ListNode fast = head;
        

        while(fast != null && fast.next != null ){

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){
                return true;
            }
            

        }

        return false;

    }

}

    
class Main{
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);


        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        LinkedListCycle1 obj = new LinkedListCycle1();
        boolean result = obj.hasCycle(node1);
        System.out.println("Has Cycle: " + result); // Expected: true

        boolean resultV2 = obj.hasCycleV2(node1);
        System.out.println("Has Cycle V2: " + resultV2); // Expected: true

  // Create a linked list for testing: 1 -> 2 -> 3 -> 4 (no cycle)
  ListNode node5 = new ListNode(1);
  ListNode node6 = new ListNode(2);
  ListNode node7 = new ListNode(3);
  ListNode node8 = new ListNode(4);

  node5.next = node6;
  node6.next = node7;
  node7.next = node8;
  // No cycle in this list

  boolean result2 = obj.hasCycle(node5);
  System.out.println("Has Cycle: " + result2); // Expected: false

  boolean resultV22 = obj.hasCycleV2(node5);
  System.out.println("Has Cycle V22 : " + resultV22); // Expected: false

    }
}    