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
        HashMap<Node, Node> map = new HashMap<>();
        if(head==null){
            return null;
        }
        Node newHead = new Node(head.val);
        map.put(head, newHead);

        Node temp = head;
        Node newTemp = newHead;

        while (temp.next != null) {
            temp = temp.next;
            Node newNode = new Node(temp.val);
            map.put(temp, newNode);
            newTemp.next = newNode;
            newTemp = newNode;
        }

        temp = head;
        newTemp = newHead;
        while (temp != null) {
            newTemp.random = map.get(temp.random);
            temp = temp.next;
            newTemp = newTemp.next;
        }
        return newHead;
    }
}
