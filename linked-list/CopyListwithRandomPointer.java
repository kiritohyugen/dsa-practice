// Definition for a Node

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    // Constructor for Node
    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    // Helper method to print the list
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            int randomVal = (curr.random != null) ? curr.random.val : -1;
            System.out.println("Node value: " + curr.val + ", Random value: " + randomVal);
            curr = curr.next;
        }
    }
}

public class CopyListwithRandomPointer {
    public Node copyRandomList(Node head) {

        Node curr = head;
        Map <Node,Node> refMap = new HashMap<>();

        while(curr != null){
            refMap.put(curr,new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while(curr != null){
            Node currNode = refMap.get(curr);
            currNode.next = refMap.get(curr.next);
            currNode.random = refMap.get(curr.random);
            curr = curr.next;
        }

        return refMap.get(head);
        
    }}

class Main {
    public static void main(String[] args) {
        // Create a test linked list with random pointers
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.next = node2;
        node2.next = node3;

        node1.random = node3; // 1's random points to 3
        node2.random = node1; // 2's random points to 1
        node3.random = null;  // 3's random is null

        System.out.println("Original list:");
        Node.printList(node1);

        // Copy the list using CopyListwithRandomPointer
        CopyListwithRandomPointer solution = new CopyListwithRandomPointer();
        Node copiedList = solution.copyRandomList(node1);
        
        // Verify original list remains unchanged
        System.out.println("\nOriginal list after copying:");
        Node.printList(node1);
    }
}
