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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode sortedList = new ListNode();
        ListNode head = sortedList;
        while(temp1!=null && temp2!=null){
            ListNode newNode = new ListNode();
            if(temp1.val<=temp2.val){
                newNode.val = temp1.val;
                temp1 = temp1.next;
            }else{
                newNode.val = temp2.val;
                temp2 = temp2.next;
            }
            sortedList.next = newNode;
            sortedList = sortedList.next;
        }

        while(temp1!=null){
            ListNode newNode = new ListNode();
            newNode.val = temp1.val;
            temp1 = temp1.next;
            sortedList.next = newNode;
            sortedList = sortedList.next;
        }
        while(temp2!=null){
            ListNode newNode = new ListNode();
            newNode.val = temp2.val;
            temp2 = temp2.next;
            sortedList.next = newNode;
            sortedList = sortedList.next;
        }
        return head.next;
    }
}