package com.meizhuo.CrazyJava._10.SequenceQueue;

import java.util.Arrays;

public class SequenceQueue<T> {

    private static final int DEFAULT_SIZE = 10;//默认的队列长度
    private Object elementData[];//保存队列数据
    private int capacity;

    private int front = 0;//保存队头的那个下标
    private int rear = 0;//并不是保存队尾的那个下标，这个下标指向的是队尾的下一个的下标（即队尾的下标是rear-1）

    public SequenceQueue() {
        //以默认长度创建顺序队列
        capacity = DEFAULT_SIZE;
        elementData = new Object[capacity];
    }

    public SequenceQueue(T element) {
        //以一个初始化元素创建顺序队列
        this();
        elementData[0] = element;
        rear++;//表明当队列中只有一个元素的时候，该元素就是队头，而紧接着队头的下一个元素就是队尾，即不存在一个元素即使队尾又是队头的情况
    }

    public SequenceQueue(T element, int initSize) {
        //以指定队列长度来创建队列
        capacity = initSize;
        elementData = new Object[capacity];
        elementData[0] = element;
        rear++;
    }

    public int length() {
        return rear - front;
    }

    //插入队列
    public void add(T element) {
        if (rear > capacity - 1) {
            throw new IndexOutOfBoundsException("队列已满的异常");
        }
        elementData[rear++] = element;
    }

    //移除队列
    public T remove() {
        if (empty()) {
            throw new IndexOutOfBoundsException("空队列异常");
        }
        T oldData = (T) elementData[front];
        elementData[front++] = null;
        return oldData;
    }

    //判断是否为空队列
    public boolean empty() {
        return front == rear;
    }

    //返回队列顶元素
    public T element() {
        if (empty()) {
            throw new IndexOutOfBoundsException("空队列异常");
        }
        return (T) elementData[front];
    }

    //清空顺序队列
    public void clear() {
        Arrays.fill(elementData, null);
        front = 0;
        rear = 0;
    }

    @Override
    public String toString() {
        if (empty()) {
            return "[]";
        } else {
            StringBuilder stringBuilder = new StringBuilder("[");
            for (int i = front; i < rear; i++) {//？？？
                stringBuilder.append(elementData[i].toString() + ", ");
            }
            System.out.println("队头索引为：" + front + "队尾索引为：" + rear);
            int len = stringBuilder.length();
            return stringBuilder.delete(len - 2, len).append("]").toString();
        }
    }

}
