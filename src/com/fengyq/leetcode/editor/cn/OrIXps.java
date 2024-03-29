//
// 运用所掌握的数据结构，设计和实现一个 LRU (Least Recently Used，最近最少使用) 缓存机制 。 
// 
//
// 实现 LRUCache 类： 
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 10⁵ 
// 最多调用 2 * 10⁵ 次 get 和 put 
// 
//
// 
//
// 进阶：是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 
// 注意：本题与主站 146 题相同：https://leetcode-cn.com/problems/lru-cache/ 
//
// Related Topics 设计 哈希表 链表 双向链表 👍 102 👎 0


package com.fengyq.leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class OrIXps {
    public static void main(String[] args) {
        LRUCache solution = new OrIXps().new LRUCache(2);
        System.out.println(solution.get(2));
        solution.put(2, 1);
        solution.put(2, 2);
        System.out.println(solution.get(2));
        solution.put(1, 1);
        solution.put(4, 1);
        System.out.println(solution.get(2));
        System.out.println(solution.map.keySet());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        DLinkedListNode head;
        DLinkedListNode tail;
        int capacity;
        int size;
        Map<Integer, DLinkedListNode> map;

        class DLinkedListNode {
            int key;
            int value;
            DLinkedListNode prev;
            DLinkedListNode next;

            public DLinkedListNode(int key, int value) {
                this.key = key;
                this.value = value;
            }

            public DLinkedListNode() {
            }
        }

        void addToHead(DLinkedListNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        DLinkedListNode removeTail() {
            DLinkedListNode tailPrev = tail.prev;
            removeNode(tailPrev);
            return tailPrev;
        }

        DLinkedListNode removeNode(DLinkedListNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            return node;
        }

        void moveToHead(DLinkedListNode node) {
            removeNode(node);
            addToHead(node);
        }

        public LRUCache(int capacity) {
            head = new DLinkedListNode();
            tail = new DLinkedListNode();
            head.next = tail;
            tail.prev = head;
            this.capacity = capacity;
            size = 0;
            map = new HashMap<>();
        }

        public int get(int key) {
            DLinkedListNode curr = map.get(key);
            if (curr != null) {
                moveToHead(curr);
                return curr.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            DLinkedListNode curr = map.get(key);
            DLinkedListNode desired = new DLinkedListNode(key, value);
            if (curr != null) {
                curr.value = desired.value;
                moveToHead(curr);
                return;
            }

            addToHead(desired);
            map.put(key, desired);
            ++size;
            if (size > capacity) {
                // full
                DLinkedListNode tail = removeTail();
                map.remove(tail.key);
                --size;
            }

        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}