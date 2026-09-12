/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void display(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void reorderList(ListNode head) {
        // ------------- Time Complexity -> O(n) | Space Complexity -> O(n) --------------
        // HashMap<Integer, ListNode> map = new HashMap<>();
        // int length = 0;
        // ListNode temp = head;
        // while(temp!=null){
        //     map.put(length++,temp);
        //     temp = temp.next;
        // }
        // int i = 1;
        // int j = length - 1;
        // temp = head;
        // int q = 1;
        // while(i<=j){
        //     if(q==0){
        //         ListNode newNode = map.get(i);
        //         temp.next = newNode;
        //         temp = newNode;
        //         i++;
        //         q = 1;
        //     }else{
        //         ListNode newNode = map.get(j);
        //         temp.next = newNode;
        //         temp = newNode;
        //         j--;
        //         q = 0;
        //     }
        // }
        // temp.next = null;

        // ------------- Time Complexity -> O(n) | Space Complexity -> O(1) --------------

        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode prevSlow = head;
        ListNode fast = head;
        ListNode midNode;
        ListNode temp;
        while (fast != null && fast.next != null) {
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prevSlow.next = null;
        midNode = slow;
        // display(head);
        // display(midNode);

        // reversing
        // display(head);
        // display(midNode);

        temp = midNode;
        ListNode before = null;
        ListNode after = null;
        while (temp != null) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
        midNode = before;
        // display(head);
        // display(midNode);

        // Linking
        ListNode keeptrack1 = head.next;
        ListNode keeptrack2 = midNode;
        temp = head;
        while (keeptrack1 != null) {
            temp.next = keeptrack2;
            temp = keeptrack2;
            keeptrack2 = keeptrack2.next;
            temp.next = keeptrack1;
            temp = keeptrack1;
            keeptrack1 = keeptrack1.next;
        }
        while (keeptrack2 != null) {
            temp.next = keeptrack2;
            temp = keeptrack2;
            keeptrack2 = keeptrack2.next;
        }
        temp.next = null;
    }
}
