
// Solved
// Medium
// Topics
// Companies
// Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

// There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

// Do not modify the linked list.

 

// Example 1:


// Input: head = [3,2,0,-4], pos = 1
// Output: tail connects to node index 1
// Explanation: There is a cycle in the linked list, where tail connects to the second node.
// Example 2:


// Input: head = [1,2], pos = 0
// Output: tail connects to node index 0
// Explanation: There is a cycle in the linked list, where tail connects to the first node.
// Example 3:


// Input: head = [1], pos = -1
// Output: no cycle
// Explanation: There is no cycle in the linked list.
 

// Constraints:

// The number of the nodes in the list is in the range [0, 104].
// -105 <= Node.val <= 105
// pos is -1 or a valid index in the linked-list.
 

// Follow up: Can you solve it using O(1) (i.e. constant) memory?



class NodeDC{
    int val;
    NodeDC next;

    NodeDC(int val){
        this.val = val;
        this.next= null;
    }
}

public class DetectCycle{

    public NodeDC detectCycle(NodeDC head) {

        if(head == null || head.next == null) return null;

        NodeDC slow = head;
        NodeDC fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast=fast.next.next;
            if(slow == fast){
                // x + k = mL;
                // x = mL-k;
                // Move slow to x , fast is at P (point of collision)
                //When slow travels x , fast travels mL-k, i.e. bot hwill meet at C (Point of starting of Cycle)
                slow = head;

                while (slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }


        return null;
        
        
    }
    
}

 class Main{
    public static void main(String[] args) {

        //Test Cases
        NodeDC node1 = new NodeDC(1);
        NodeDC node2 = new NodeDC(2);
        NodeDC node3 = new NodeDC(3);
        NodeDC node4 = new NodeDC(4);
        NodeDC node5 = new NodeDC(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3;

        DetectCycle dc = new DetectCycle();

       NodeDC cycleStart =  dc.detectCycle(node1);

        if (cycleStart != null) {
            System.out.println("Cycle starts at node with value: " + cycleStart.val);
        } else {
            System.out.println("No cycle detected.");
        }








        NodeDC nodeV1 = new NodeDC(1);
        NodeDC nodeV2 = new NodeDC(2);
        NodeDC nodeV3 = new NodeDC(3);
        NodeDC nodeV4 = new NodeDC(4);
        NodeDC nodeV5 = new NodeDC(5);

        node1.next = nodeV2;
        node2.next = nodeV3;
        node3.next = nodeV4;
        node4.next = nodeV5;
        node5.next = null;

        DetectCycle dc2 = new DetectCycle();

       NodeDC cycleStart2 =  dc2.detectCycle(nodeV1);

        if (cycleStart2 != null) {
            System.out.println("Cycle starts at node with value: " + cycleStart2.val);
        } else {
            System.out.println("No cycle detected.");
        }



        
    }

}