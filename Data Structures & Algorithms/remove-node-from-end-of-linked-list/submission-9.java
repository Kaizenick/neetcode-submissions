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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //  --------------------- Time:  O(n) --------------------
        // --------------------- Space:  O(1) --------------------
        // Optimal but not the cleanest! Many Special cases!

        // int length = 0;
        // ListNode temp = head;
        // while (temp != null) {
        //     length++;
        //     temp = temp.next;
        // }
        // if (length == 1) {
        //     head = null;
        //     return head;
        // }

        // if (length == 2) {
        //     if (n == 2) {
        //         head = head.next;
        //         return head;
        //     } else {
        //         head.next = null;
        //         return head;
        //     }
        // }
        // if (length == n) {
        //     head = head.next;
        //     return head;
        // }

        // int toBeRemoved = length - n;
        // // System.out.println(length);
        // // System.out.println(toBeRemoved);
        // int index = 1;
        // temp = head;
        // while (index != toBeRemoved) {
        //     temp = temp.next;
        //     index++;
        // }
        // temp.next = temp.next.next;
        // return head;

        //  --------------------- Time:  O(n) --------------------
        // --------------------- Space:  O(1) --------------------

        ListNode dummy = new ListNode(0,null);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        for(int i = 0; i<=n; i++){
            fast = fast.next;
        }
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        System.out.println(slow.val);
        slow.next = slow.next.next;
        return dummy.next;
    }
}
