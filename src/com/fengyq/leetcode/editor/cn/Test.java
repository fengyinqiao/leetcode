package com.fengyq.leetcode.editor.cn;

public class Test {
    public static void main(String[] args) {

    }

    //27. 移除元素
    public int removeElement(int[] nums, int val) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }

        return i;
    }

    //26. 删除有序数组中的重复项
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }

        return i + 1;
    }

    //283. 移动零
    public void moveZeroes(int[] nums) {
        for (int i= removeElement(nums,0); i < nums.length; i++) {
            nums[i]=0;
        }
    }
}
