/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // Handle the edge case where the original list is empty.
        if (head == null) {
            return null;
        }

        // A map to store the mapping from original nodes to their corresponding copies.
        Map<Node, Node> originalToCopy = new HashMap<>();

        // --- First Pass: Create all new nodes and store the mapping ---
        // Iterate through the original list and create a new node for each.
        Node current = head;
        while (current != null) {
            // Create a new node with the same value.
            Node newNode = new Node(current.val);
            // Store the mapping from the original node to the new node in the map.
            originalToCopy.put(current, newNode);
            current = current.next;
        }

        // --- Second Pass: Set the next and random pointers for the new nodes ---
        // Iterate through the original list again to set the pointers of the new nodes.
        current = head;
        while (current != null) {
            // Get the copy of the current node from the map.
            Node copiedNode = originalToCopy.get(current);

            // Set the 'next' pointer of the copied node.
            // It should point to the copy of the original next node.
            // If current.next is null, map.get(null) returns null, which is correct.
            copiedNode.next = originalToCopy.get(current.next);

            // Set the 'random' pointer of the copied node.
            // It should point to the copy of the original random node.
            // If current.random is null, map.get(null) returns null, which is correct.
            copiedNode.random = originalToCopy.get(current.random);

            // Move to the next node in the original list.
            current = current.next;
        }

        // The head of the copied list is the copy of the original head.
        // We can get this from our map.
        return originalToCopy.get(head);
    }

        
    
}