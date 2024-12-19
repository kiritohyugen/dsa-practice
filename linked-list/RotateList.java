class ListNode{
    int val;
    ListNode next;

    ListNode(){}

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        ListNode s = head;
        int size = 0;
        while(s != null){
            size++;
            s = s.next;
        }

        if(size == 0 || head == null) return head;

        int effectiveK = k%size;
        int pos = size - effectiveK;
        if(effectiveK == 0 ) return head;

        ListNode p = head;
        int index = 1;
        while( index != pos ){
            p = p.next;
            index++;
        }
        ListNode tail = p;

        ListNode newHead = tail.next;
        ListNode curr = newHead;
        while( curr.next != null){
            curr = curr.next;
        }
        curr.next = head;


        tail.next = null;

    return newHead;
    }

    public void printList(ListNode node){
        ListNode curr = node;
        while(curr != null){
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println(" null ");
    }
    
}

class Main{
    public static void main(String[] args) {
        RotateList sol = new RotateList();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        System.out.println(" Before Rotation ");
        sol.printList(node1);
        System.out.println(" After Rotation ");
        sol.printList(sol.rotateRight(node1, 2));



        
    }
}
