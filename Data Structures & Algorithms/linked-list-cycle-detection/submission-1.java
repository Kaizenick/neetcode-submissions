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
    public boolean hasCycle(ListNode head) {
        // --------------- Time: O(n) & Space O(n) -----------------
        //     HashSet<ListNode> set = new HashSet<>();
        //     ListNode temp = head;
        //     while(temp!=null){
        //         if(set.contains(temp)){
        //             return true;
        //         }else{
        //             set.add(temp);
        //             temp = temp.next;
        //         }
        //     }
        //     return false;

        // --------------- Time: O(n) & Space O(1) -----------------
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}
