package com.meizhuo.CrazyJava._10.LinkStack;

public class LinkStack<T> {
    //以私有内部类定义链表节点
    private class Node {
        //保存数据
        private T data;
        //保存下一个节点引用
        private Node next;

        public Node() {
            //无参构造方法
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node top;//保存头节点

    private int size;//保存链表长度

    public LinkStack() {
        //创建空链表
        top = null;
    }

    public LinkStack(T data) {
        top = new Node(data, null);
        size++;
    }

    //返回链栈的长度
    public int length() {
        return size;
    }

    //进栈
    public void push(T data) {
        top = new Node(data, top);
        size++;
    }

    //出栈
    public T pop() {
        Node old = top;
        top = top.next;
        old.next = null;
        size--;
        return old.data;
    }

    //访问栈顶元素但不删除
    public T peek() {
        return top.data;
    }

    //判断链栈是否为空
    public boolean empty() {
        return size == 0;
    }

    //清空链栈
    public void clean() {
        top = null;
        size = 0;
    }

    @Override
    public String toString() {
        if (empty()) {
            return "[]";
        } else {
            StringBuilder stringBuilder = new StringBuilder("[");
            for (Node current = top; current != null; current = current.next) {
                stringBuilder.append(current.data.toString() + ", ");
            }
            int len = stringBuilder.length();
            return stringBuilder.delete(len - 2, len).append("]").toString();
        }
    }

}


























