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
    public void reorderList(ListNode head) {
        HashMap<Integer, ListNode> map = new HashMap<>();
        int length = 0;
        ListNode temp = head;
        while(temp!=null){
            map.put(length++,temp);
            temp = temp.next;
        }
        int i = 1;
        int j = length - 1;
        temp = head;
        int q = 1;
        while(i<=j){
            if(q==0){
                ListNode newNode = map.get(i);
                temp.next = newNode;
                temp = newNode;
                i++;
                q = 1;
            }else{
                ListNode newNode = map.get(j);
                temp.next = newNode;
                temp = newNode;
                j--;
                q = 0;
            }
        }
        temp.next = null;
    }
}
