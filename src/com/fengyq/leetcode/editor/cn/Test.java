package com.fengyq.leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        HashMap<String, Object> jsonMap = new HashMap<>();
        HashMap<String, Object> aMap = new HashMap<>();
        HashMap<String, String> bMap = new HashMap<>();
        bMap.put("c", "1");
        aMap.put("d", "2");
        aMap.put("b", bMap);
        jsonMap.put("a", aMap);
        jsonMap.put("e", "3");

        System.out.println("input = " + jsonMap);
        System.out.println("output = " + new Test().jsonFlatten(jsonMap));
    }

    HashMap<String, String> jsonFlatten(Object input) {
        backtrack(input, new LinkedList<>());
        return output;
    }

    HashMap<String, String> output = new HashMap<>();

    void backtrack(Object input, LinkedList<String> track) {
        if (input instanceof String) {
            output.put(track.stream().collect(Collectors.joining()), (String) input);
            return;
        }

        for (Map.Entry<String, Object> stringObjectEntry : ((HashMap<String, Object>) input).entrySet()) {
            track.add(stringObjectEntry.getKey());
            backtrack(stringObjectEntry.getValue(), track);
            track.removeLast();
        }
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
        for (int i = removeElement(nums, 0); i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
