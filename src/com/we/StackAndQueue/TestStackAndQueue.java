package com.we.StackAndQueue;

import java.util.Random;

public class TestStackAndQueue {

    public static void main(String[] args) {
//        testArrayStack();

//        testArrayQueue();

//        testLoopQueue();

        queuePK();
    }

    public static void testArrayStack() {
        //1、基本使用
        ArrayStack<Integer> arrayStack = new ArrayStack<>(5);
        for (int i = 0; i < 10; i++) {
            arrayStack.push(i);
        }
        arrayStack.push(100);
        arrayStack.pop();

        System.out.print(arrayStack);
        System.out.print(arrayStack.peek());

        //2、括号匹配

    }

    public static void testArrayQueue() {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(5);
        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue(i);
            System.out.print(arrayQueue);

            if (i % 3 == 2) {
                arrayQueue.dequeue();
                System.out.print(arrayQueue);
            }
        }
    }

    public static void testLoopQueue() {
        LoopQueue<Integer> loopQueue = new LoopQueue(10);
        for (int i = 0; i < 10; i++) {
            loopQueue.enqueue(i);
//            System.out.print(loopQueue);

//            if (i % 3 == 2) {
//                loopQueue.dequeue();
//                System.out.print(loopQueue);
//            }
        }
        System.out.print(loopQueue);
    }

    public static void queuePK() {
        int opCount = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue();
        double arrayTime = testQueue(arrayQueue, opCount);
        System.out.print("ArrayQueueTime: " + arrayTime + "s \n");


        LoopQueue<Integer> loopQueue = new LoopQueue();
        double loopTime = testQueue(loopQueue, opCount);
        System.out.print("LoopQueueTime: " + loopTime + "s");
    }

    private static double testQueue(Queue<Integer> queue, int opCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            queue.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

}

