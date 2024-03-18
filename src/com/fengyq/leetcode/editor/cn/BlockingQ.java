package com.fengyq.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQ<T> {
    private Queue<T> queue = new LinkedList<>();
    private int capacity = Integer.MAX_VALUE;

    public BlockingQ(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void enqueue(T item) throws InterruptedException {
        while (queue.size() == capacity) {
            wait();
        }
        queue.add(item);
        notifyAll();
    }

    public synchronized T dequeue() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        T item = queue.poll();
        notifyAll();
        return item;
    }

    public static void main(String[] args) {
        BlockingQ<Integer> blockingQ = new BlockingQ<>(5);

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.printf("Producing: %d\n",i);
                    blockingQ.enqueue(i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Integer item = blockingQ.dequeue();
                    System.out.printf("Consuming: %d\n",item);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
