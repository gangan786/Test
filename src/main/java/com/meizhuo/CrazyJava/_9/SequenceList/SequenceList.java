package com.meizhuo.CrazyJava._9.SequenceList;

import java.util.Arrays;

public class SequenceList<T> {
    private static final int DEFAULE_SIZE = 16;

    private int capacity;//保存数组的长度

    private Object elementData[];//定义一个数组保存顺序线性表的元素

    private int size = 0;//保存顺序线性表中元素的个数

    //以默认长度创建空顺序线性表
    public SequenceList() {
        capacity = DEFAULE_SIZE;
        elementData = new Object[capacity];
    }

    //以一个初始化元素创建顺序线性表
    public SequenceList(T element) {
        this();
        size++;
        elementData[0] = element;
    }

    //以指定长度，初始化元素创建顺序线性表
    public SequenceList(int initSize, T element) {
        capacity = 1;
        while (capacity > initSize) {
            capacity <<= 1;
        }
        elementData = new Object[capacity];
        elementData[0] = element;
        size++;
    }

    //获取顺序线性表的长度
    public int length() {
        return size;
    }

    //获取索引处的元素
    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
        return (T) elementData[index];
    }

    //查找指定元素的索引
    public int locate(T element) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    //向顺序线性表中指定索引插入一个元素
    public void insert(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("顺序线性表索引越界");
        }
        ensureCapacity(index + 1);
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > capacity) {
            while (capacity < minCapacity) {
                capacity <<= 1;
            }
            elementData = Arrays.copyOf(elementData, capacity);
        }
    }

    //在顺序线性表的后面插入元素
    public void add(T element) {
        insert(size, element);
    }

    //删除指定索引处的元素
    public T delete(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("顺序线性表索引越界");
        }
        Object oldElement = elementData[index];
        int numMove = size - index - 1;
        System.arraycopy(elementData, index + 1, elementData, index, numMove);
        elementData[--size] = null;
        return (T) oldElement;

    }

    //删除线性表中最后一个元素
    public T remove() {
        return delete(size - 1);
    }


    //判断顺序线性表是否为空
    public boolean empty() {
        return size == 0;
    }

    //清空线性表
    public void clear() {
        Arrays.fill(elementData, null);
        size = 0;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            StringBuilder stringBuilder = new StringBuilder("[");
            for (int i = 0; i < size; i++) {
                stringBuilder.append(elementData[i].toString() + ", ");
            }
            int len = stringBuilder.length();
            return stringBuilder.delete(len - 2, len).append("]").toString();
        }
    }
}




























