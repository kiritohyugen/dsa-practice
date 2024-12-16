


// Definition for singly-linked list node
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class IntersectionofTwoLinkedLists {
    // Method to find the intersection node of two linked lists
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Edge case: If either list is null, no intersection
        if (headA == null || headB == null) return null;

        // Initialize two pointers
        ListNode pointerA = headA;
        ListNode pointerB = headB;

        // Traverse the lists
        while (pointerA != pointerB) {
            // If pointerA reaches the end of list A, redirect it to headB
            pointerA = (pointerA == null) ? headB : pointerA.next;

            // If pointerB reaches the end of list B, redirect it to headA
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }

        // Return the intersection node or null if no intersection
        return pointerA;
    }

    public static void main(String[] args) {
        // Create two linked lists with an intersection
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);

        // Create the intersection node
        ListNode intersection = new ListNode(8);
        intersection.next = new ListNode(4);
        intersection.next.next = new ListNode(5);

        // Connect the lists to the intersection node
        headA.next.next = intersection;
        headB.next.next.next = intersection;

        // Instantiate the solution and find the intersection
        IntersectionofTwoLinkedLists solution = new IntersectionofTwoLinkedLists();
        ListNode result = solution.getIntersectionNode(headA, headB);

        // Output the result
        if (result != null) {
            System.out.println("Intersection at node with value: " + result.val);
        } else {
            System.out.println("No intersection.");
        }
    }
}
