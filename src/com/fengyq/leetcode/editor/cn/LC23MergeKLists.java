package com.fengyq.leetcode.editor.cn;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

//0->2->4
//1->3->5
public class LC23MergeKLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(0,new ListNode(2,new ListNode(4)));
        ListNode l2 = new ListNode(1,new ListNode(3,new ListNode(5)));
        ListNode[] lists=new ListNode[]{l1,l2};
        ListNode merged=mergeKLists(lists);
        while(merged!=null) {
            System.out.println(merged.val);
            merged=merged.next;
        }
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0) {
            return null;
        }
        PriorityQueue<ListNode> pq=new PriorityQueue<>((o1, o2) -> o1.val-o2.val);
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        while(!pq.isEmpty()) {
            ListNode peek=pq.poll();
            curr.next=peek;
            if (peek.next!=null) {
                pq.add(peek.next);
            }
            curr=curr.next;
        }
        return dummy.next;
    }

}
