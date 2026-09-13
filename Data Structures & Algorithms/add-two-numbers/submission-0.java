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
    public void displayList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // displayList(l1);
        // ListNode l1Reversed = reverseList(l1);
        // displayList(l1Reversed);

        ListNode answer = new ListNode();
        ListNode tempAnswer = answer;
        ListNode l1temp = l1;
        ListNode l2temp = l2;
        int carry = 0;
        while (l1temp != null && l2temp != null) {
            int sum = l1temp.val + l2temp.val + carry;
            int rem = sum % 10;
            ListNode newNode = new ListNode(rem, null);
            carry = (sum - rem) / 10;
            tempAnswer.next = newNode;
            tempAnswer = newNode;

            l1temp = l1temp.next;
            l2temp = l2temp.next;
        }

        while (l1temp != null) {
            int sum = l1temp.val + carry;
            int rem = sum % 10;
            ListNode newNode = new ListNode(rem, null);
            carry = (sum - rem) / 10;
            tempAnswer.next = newNode;
            tempAnswer = newNode;

            l1temp = l1temp.next;
        }

        while (l2temp != null) {
            int sum = l2temp.val + carry;
            int rem = sum % 10;
            ListNode newNode = new ListNode(rem, null);
            carry = (sum - rem) / 10;
            tempAnswer.next = newNode;
            tempAnswer = newNode;

            l2temp = l2temp.next;
        }
        if(carry!=0){
            ListNode newNode = new ListNode(carry,null);
            tempAnswer.next = newNode;
            tempAnswer = newNode;
        }

        return answer.next;
    }
}