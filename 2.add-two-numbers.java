/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    ListNode headNode=null;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0, null);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry, ListNode prevNode) {
        if (l1 == null && l2 == null && carry == 0)
            return headNode;
        int l1Value = 0;
        int l2Value = 0;
        if (l1 != null)
            l1Value = l1.val;
        if (l2 != null)
            l2Value = l2.val;
        int tempSum = l1Value + l2Value + carry;
        int sum = 0;
        if (tempSum >= 10) {
            sum = tempSum - 10;
            carry = tempSum / 10;
        } else {
            sum = tempSum;
            carry = 0;
        }
        ListNode curNode=new ListNode(sum);
        if(prevNode==null)
            headNode=curNode;
        else{
            prevNode.next=curNode;
        }
        return addTwoNumbers(null == l1 ? null : l1.next, null == l2 ? null : l2.next, carry, curNode);
    }
}
// @lc code=end
