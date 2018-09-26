package com.meizhuo.CrazyJava._10.LinkQueue;

public class LinkQueue<T> {

    //节点
    private class Node {
        private T data;
        private Node next;

        public Node() {
            //无参构造
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

    }

    private Node front;//头节点
    private Node rear;//尾节点
    private int size;//记录长度

    /**
     * 无参构造
     */
    public LinkQueue() {
        front = null;
        front = null;
    }

    /**
     * 以指定节点创建对链
     *
     * @param data
     */
    public LinkQueue(T data) {
        front = new Node(data, null);
        rear = front;
        size++;
    }

    /**
     * 返回长度
     *
     * @return 返回队链的长度
     */
    public int size() {
        return size;
    }

    /**
     * 将新元素加入队列
     *
     * @param data
     */
    public void add(T data) {
        if (empty()) {
            front = new Node(data, null);
            rear = front;
        } else {
            Node newNode = new Node(data, null);
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    /**
     * 移除队列front端的节点
     *
     * @return 返回移除的元素
     */
    public T remove() {
        if (empty()) {
            throw new RuntimeException("空队列异常");
        } else {
            Node old = front;
            front = front.next;
            old.next = null;
            size--;
            return old.data;
        }
    }

    /**
     * 返回队列中最后一个元素
     *
     * @return T
     */
    public T element() {
        return rear.data;
    }

    /**
     * 清空元素
     */
    public void clean() {
        front = null;
        rear = null;
        size = 0;
    }

    @Override
    public String toString() {
        if (empty()) {
            return "[]";
        } else {
            StringBuilder stringBuilder = new StringBuilder("[");
            for (Node current = front; current != null; current = current.next) {
                stringBuilder.append(current.data.toString() + ", ");
            }
            int len = stringBuilder.length();
            return stringBuilder.delete(len - 2, len).append("]").toString();
        }
    }

    /**
     * 判断是否为空链队列
     *
     * @return
     */
    private boolean empty() {
        return size == 0;
    }

}
