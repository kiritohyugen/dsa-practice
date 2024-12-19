class ListNode {
    int val;
    ListNode next;

    // Constructor to create a node
    ListNode() {}

    ListNode(int val) { 
        this.val = val; 
    }

    ListNode(int val, ListNode next) { 
        this.val = val; 
        this.next = next; 
    }
}

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int rem = 0;
        int sum = 0;

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        ListNode f = l1;
        ListNode s = l2;

        while(f != null || s != null || carry != 0){
            sum = getValue(f) + getValue(s) + carry;
            rem = sum % 10; // Remainder is the current digit
            ListNode tmp = new ListNode(rem);
            curr.next = tmp;
            curr = tmp;
            carry = sum / 10; // Carry is the quotient for the next digit

            // Move to the next nodes if they exist
            if(f != null) {
                f = f.next;
            }
            if(s != null) {
                s = s.next; 
            }
        }

        return dummy.next; // Return the actual result without the dummy node
    }

    public int getValue(ListNode node){
        if(node == null) return 0; // If node is null, return 0

        return node.val; // Return the value of the node
    }
}

class Main {
    
    public static void main(String[] args) {
        // Example test case: adding two numbers represented by linked lists
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3))); // 342
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4))); // 465

        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode result = solution.addTwoNumbers(l1, l2);

        // Print result
        while(result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        // Expected output: 7 0 8 (807)
    }

}
