package com.meizhuo.DataStructure;

import java.util.Arrays;

public class LoopQueue<T> {
    //默认长度
    public static final int DEFAULT_SIZE = 10;

    private int front;//记录头节点
    private int rear;//记录尾节点，指向尾节点的下一个节点
    private int capacity;
    private int flag = -1;//用于标志队列是否已满
    private Object[] elementData;

    public LoopQueue() {
        //默认长度创建循环队列
        this.capacity = DEFAULT_SIZE;
        elementData = new Object[this.capacity];
    }

    public LoopQueue(T element) {
        //以一个初始元素创建循环队列
        this();
        elementData[0] = element;
    }

    public LoopQueue(T element, int size) {
        //以指定容量创建循环队列
        this.capacity = size;
        elementData = new Object[size];
        elementData[0] = element;
        rear++;
    }

    //获取循环队列的大小
    public int length() {
        if (empty()) {
            return 0;
        }
        return rear > front ? rear - front : capacity - front - rear;
    }

    //插入队列
    public void add(T element) {
        if (flag == 1) {
            throw new IndexOutOfBoundsException("队列已满异常");
        }
        elementData[rear++] = element;
        rear = rear == capacity ? 0 : rear;//如果是达到尾部了就把他指向空的头部

        //用于标志队列是否已满
        if (front == rear && elementData[rear] != null) {
            flag = 1;
        }
    }

    //移除队列
    public T remove() {
        if (flag == 0) {
            throw new IndexOutOfBoundsException("空队列异常!");
        }
        T old = (T) elementData[front];
        elementData[front++] = null;
        front = front == capacity ? 0 : front;

        //用于标志是否为空队列
        if (front == rear && elementData[rear] == null) {
            flag = 0;
        }
        return old;
    }

    //清空队列
    public void clear() {
        Arrays.fill(elementData, null);
        front = 0;
        rear = 0;
        flag = 0;
    }

    private boolean isFull() {
        return front == rear && elementData[rear] != null;
    }

    private boolean empty() {
        return front == rear && elementData[rear] == null;
    }

    @Override
    public String toString() {
        if (empty()) {
            return "[]";
        } else {
            if (front < rear) {//常规情况
                StringBuilder stringBuilder = new StringBuilder("[");
                for (int i = front; i < rear; i++) {
                    stringBuilder.append(elementData[i].toString() + ", ");
                }
                int len = stringBuilder.length();
                System.out.println("队头索引为：" + front + "队尾索引为：" + rear);
                return stringBuilder.delete(len - 2, len).append("]").toString();
            } else {
                StringBuilder stringBuilder = new StringBuilder("[");
                for (int i = front; i < capacity; i++) {
                    stringBuilder.append(elementData[i].toString() + ", ");
                }
                for (int i = 0; i < rear; i++) {
                    stringBuilder.append(elementData[i].toString() + ", ");
                }
                int len = stringBuilder.length();
                System.out.println("队头索引为：" + front + "队尾索引为：" + rear);
                return stringBuilder.delete(len - 2, len).append("]").toString();
            }
        }
    }
}





























