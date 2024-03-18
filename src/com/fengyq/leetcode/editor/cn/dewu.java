package com.fengyq.leetcode.editor.cn;

import java.util.ArrayList;

public class dewu {
    //0->1->2->3
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] nums = list.stream().mapToInt(Integer::intValue).toArray();

        QuickSortUtil quickSortUtil = new QuickSortUtil();
        quickSortUtil.quickSort(nums, 0, nums.length - 1);

        ListNode res = new ListNode(-1), dummy = res;
        for (int i = 0; i < nums.length; i++) {
            dummy.next = new ListNode(nums[i]);
            dummy = dummy.next;
        }

        return res;
    }


    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    class QuickSortUtil {
        int partition(int[] nums, int left, int right) {
            int pivotIdx = left, pivotEle = nums[left];
            while (left <= right) {
                while (left <= right && nums[left] <= pivotEle) {
                    left++;
                }
                while (left <= right && nums[right] >= pivotEle) {
                    right--;
                }
                if (left > right) {
                    break;
                }
                swap(nums, left, right);
            }
            swap(nums, pivotIdx, right);
            return right;
        }

        void quickSort(int[] nums, int left, int right) {
            if (left >= right) {
                return;
            }
            int p = partition(nums, left, right);
            quickSort(nums, left, p - 1);
            quickSort(nums, p + 1, right);
        }
    }
}
