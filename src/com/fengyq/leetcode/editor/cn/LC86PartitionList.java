//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。 
//
// 你应当 保留 两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [2,1], x = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 200] 内 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
//
// Related Topics 链表 双指针 👍 787 👎 0


package com.fengyq.leetcode.editor.cn;

import java.util.List;

public class LC86PartitionList {
    public static void main(String[] args) {
        Solution solution = new LC86PartitionList().new Solution();
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
    class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode dummy1 = new ListNode(-1), dummy2 = new ListNode(-1);
            ListNode p1=dummy1,p2=dummy2,p=head;
            while (p != null) {
                if(p.val < x) {
                    p1.next = p;
                    p1=p1.next;
                }else {
                    p2.next = p;
                    p2=p2.next;
                }

                p=p.next;
            }

            p1.next=null;
            p2.next=null;

            p1.next=dummy2.next;
            return dummy1.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}