package com.meizhuo.CrazyJava._10.SequenceStack;

import java.util.Arrays;

public class SequenceStack<T> {
    //默认栈的容量
    private static final int DEFAULT_SIZE = 10;
    //保存数组的容量
    private int capacity;
    //当容量不够时，每次扩容的容量
    private int capacityIncrement;
    //保存元素的数组
    private Object[] elementData;
    //保存栈的长度
    private int size = 0;

    //以默认长度创建空顺序栈
    public SequenceStack() {
        capacity = DEFAULT_SIZE;
        elementData = new Object[capacity];
    }

    //以一个初始化元素来创建空顺序栈
    public SequenceStack(T elememt) {
        this();
        elementData[0] = elememt;
        size++;
    }

    //以指定容量的数组来创建顺序栈
    public SequenceStack(T element, int capacity) {
        this.capacity = capacity;
        elementData = new Object[this.capacity];
        elementData[0] = element;
        size++;
    }

    //以指定容量的数组,扩容个容量来创建顺序栈
    public SequenceStack(T element, int capacity, int capacityIncrement) {
        this.capacity = capacity;
        this.capacityIncrement = capacityIncrement;
        elementData = new Object[this.capacity];
        elementData[0] = element;
        size++;
    }

    //获取顺序栈的大小
    public int length() {
        return size;
    }

    //入栈
    public void push(T element) {
        ensureCapacity(size + 1);
        elementData[size++] = element;//size++ 操作骚
    }

    //保证底层的数组有足够的容量存储
    private void ensureCapacity(int minCapacity) {
        if (capacityIncrement > 0) {
            while (minCapacity > capacity) {
                capacity += capacityIncrement;
            }
        } else {
            while (minCapacity > capacity) {
                capacity <<= 1;
            }
        }
        elementData = Arrays.copyOf(elementData, capacity);
    }

    //出栈
    public T pop() {
        T del = (T) elementData[size - 1];
        elementData[size--] = null;
        return del;
    }

    //返回栈顶元素
    public T peek() {
        return (T) elementData[size - 1];
    }

    //判断顺序栈是否为空栈
    public boolean empty() {
        return size == 0;
    }

    //清空顺序栈
    public void clean() {
        Arrays.fill(elementData, null);
        size = 0;
    }

    @Override
    public String toString() {
        if (empty()) {
            return "[]";
        } else {
            StringBuilder stringBuilder = new StringBuilder("[");
            for (int i = size - 1; i >= 0; i--) {
                stringBuilder.append(elementData[i].toString() + ", ");
            }
            int len = stringBuilder.length();
            return stringBuilder.delete(len - 2, len).append("]").toString();
        }
    }

}

























