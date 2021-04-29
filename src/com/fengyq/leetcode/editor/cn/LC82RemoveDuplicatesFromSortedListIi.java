//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 返回同样按升序排列的结果链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序排列 
// 
// Related Topics 链表 
// 👍 588 👎 0


package com.fengyq.leetcode.editor.cn;

//java:删除排序链表中的重复元素 II
public class LC82RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        Solution solution = new LC82RemoveDuplicatesFromSortedListIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

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
    //1 2 3 3 4 4 5
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode(0, head);
            ListNode curr = dummy;
            while (curr.next != null && curr.next.next != null) {
                ListNode nxt = curr.next;
                if (nxt.val != nxt.next.val) {
                    curr = curr.next;
                } else {
                    while (nxt.next != null && nxt.val == nxt.next.val) {
                        nxt = nxt.next;
                    }
                    curr.next = nxt.next;
                }
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}