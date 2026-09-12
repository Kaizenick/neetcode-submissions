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
        ListNode temp = head;
        int index = 0;
        while(temp!=null){
            map.put(index,temp);
            index++;
            temp = temp.next;
        }
        int i = 1;
        int j = index - 1;
        int q = 1;
        ListNode traveller = head;
        while(i<=j){
            if(q%2==0){
                traveller.next = map.get(i);
                traveller = traveller.next;
                i++;
                q = 1;
            }else{
                traveller.next = map.get(j);
                traveller = traveller.next;
                j--;
                q = 0;
            }
        }
        traveller.next = null;
    }
}
