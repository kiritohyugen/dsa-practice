// 21. Merge Two Sorted Lists
// Solved
// Easy
// Topics
// Companies
// You are given the heads of two sorted linked lists list1 and list2.

// Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

// Return the head of the merged linked list.

 

// Example 1:


// Input: list1 = [1,2,4], list2 = [1,3,4]
// Output: [1,1,2,3,4,4]
// Example 2:

// Input: list1 = [], list2 = []
// Output: []
// Example 3:

// Input: list1 = [], list2 = [0]
// Output: [0]
 

// Constraints:

// The number of nodes in both lists is in the range [0, 50].
// -100 <= ListNode.val <= 100
// Both list1 and list2 are sorted in non-decreasing order.


class ListNode{

    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
    

}

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        ListNode f = list1;
        ListNode s = list2;

        while( f != null && s != null){
            if(f.val < s.val){
                curr.next = f;
                curr = f;
                f = f.next;
            }else{
                 curr.next = s;
                curr = s;
                s = s.next;
            }
        }

        if(f == null){
            curr.next = s;
        }else{
            curr.next = f;
        }

        return dummy.next;
        
    }

    public void printList(ListNode head){
        ListNode curr = head;
        while(curr != null){
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.print(" null ");
    }
}


class Main{
    public static void main(String[] args) {

        MergeTwoSortedLists sol = new MergeTwoSortedLists();

        ListNode nodev1 = new ListNode(1);
        ListNode nodev2 = new ListNode(2);
        ListNode nodev3 = new ListNode(4);

        nodev1.next = nodev2;
        nodev2.next = nodev3;

        System.err.println("Printing list one : ");
        sol.printList(nodev1);

        ListNode nodeV1 = new ListNode(1);
        ListNode nodeV2 = new ListNode(3);
        ListNode nodeV3 = new ListNode(4);

        nodeV1.next = nodeV2;
        nodeV2.next = nodeV3;

        System.err.println("Printing list two : ");
        sol.printList(nodeV1);


        System.err.println("Printing merged : ");
        sol.printList(sol.mergeTwoLists(nodev1, nodeV1));
        
    }
}