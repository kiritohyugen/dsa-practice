import java.util.Stack;

class Node{
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}

public class FlattenaMultilevelDoublyLinkedList {
    
        public Node flatten(Node head) {

        Stack<Node> nl = new Stack<>();

        Node lc = head;

        while(lc != null ){
            if(lc.child != null ){
                if(lc.next != null){
                nl.add(lc.next);
                }
                lc.next = lc.child;
                lc.child.prev = lc;
                lc.child = null;
            }

// not actually required -> lc != null || nl.size() != 0
            if(lc.next == null && nl.size() != 0){
                Node tmp =  nl.pop();
                lc.next = tmp;
                tmp.prev = lc;
            }

            lc = lc.next;
        }
       
        return head;
    }

    public void printList(Node node){
        Node curr = node;
        while(curr != null){
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println(" null ");
    }
    public void printMultilevelList(Node node) {
        if (node == null) {
            return;
        }
    
        Node curr = node;
        while (curr != null) {
            System.out.print(curr.val);
    
            // If the current node has a child, indicate it
            if (curr.child != null) {
                System.out.print(" -> [Child: ");
                printMultilevelList(curr.child);
                System.out.print("]");
            }
    
            curr = curr.next;
    
            if (curr != null) {
                System.out.print(" -> ");
            }
        }
    }
    
}

class Main {
    public static void main(String[] args) {
        // Create a sample multilevel doubly linked list
        Node head = new Node();
        head.val = 1;

        Node second = new Node();
        second.val = 2;

        Node third = new Node();
        third.val = 3;

        Node child1 = new Node();
        child1.val = 4;

        Node child2 = new Node();
        child2.val = 5;

        // Link the nodes
        head.next = second;
        second.prev = head;

        second.next = third;
        third.prev = second;

        second.child = child1;

        child1.next = child2;
        child2.prev = child1;

        // Print the original list structure
        System.out.println("Original List:");
        FlattenaMultilevelDoublyLinkedList solution = new FlattenaMultilevelDoublyLinkedList();
        solution.printMultilevelList(head);

        // Flatten the list
        Node flattenedHead = solution.flatten(head);

        // Print the flattened list
        System.out.println("\nFlattened List:");
        solution.printMultilevelList(flattenedHead);
    }
}
