
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

         
         ListNode prev = null;
         ListNode curr = head;
         ListNode next = null;
         
         while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
         }

         return prev;
    }
}

class Main {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ReverseLinkedList list = new ReverseLinkedList();
        System.out.println("Before Reversing");
        printList(node1);
                System.out.println("After Reversing");
                printList(list.reverseList(node1));
        
        
            }
        
            private static void printList(ListNode node1) {
                // TODO Auto-generated method stub
                ListNode curr = node1;
                while(curr != null){
                    System.out.print(curr.val + " -> ");
                    curr = curr.next;
                }
                System.out.println("null");
            }
}
