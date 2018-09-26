package com.meizhuo.CrazyJava._9.LinkList;


public class LinkList<T> {
    //先定义一个内部类Node，Node代表链表节点
    private class Node {
        private T data;//保存节点数据
        private Node next;//保存下一个节点的引用

        public Node() {
            //无参的构造方法
        }

        public Node(T data, Node next) {
            //初始化全部属性的构造器
            this.data = data;
            this.next = next;
        }
    }

    private Node header;//保存头部节点,以下变量都定义为私有
    private Node tail;//保存尾部节点
    private int size;//保存链表长度

    public LinkList() {
        //创建空链表
        header = null;
        tail = null;
    }

    public LinkList(T element) {
        header.data = element;
        header.next = null;
//        header=new Node(element,null);//这是是书上的方式，不过我觉得上面的两行代码系统开销会更少，但是可读性会差一点
        tail = header;
        size++;
    }

    //返回链表的长度
    public int length() {
        return size;
    }

    //获取链表索引处的元素
    public T get(int index) {
        return getNodeByIndex(index).data;
    }

    //根据索引index获取指定位置的节点
    private Node getNodeByIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
        Node current = header;
        for (int i = 0; i <= index && current.next != null; i++, current = current.next) {
            if (i == index) {
                return current;
            }
        }
        return null;
    }

    //查找链表中指定元素的索引
    public int locate(T element) {
        Node current = header;
        for (int i = 0; i < size && current.next != null; current = current.next, i++) {
            if (element.equals(current.data)) {
                return i;
            }
        }
        return -1;
    }

    //向链表中的指定位置插入一个元素
    public void insert(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
        //如果是空链表则创建一个
        if (header == null) {
            add(element);
        } else {
            if (index == 0) {
                addAtHeader(element);
            } else {
                //获取索引前一个节点
                Node pre = getNodeByIndex(index - 1);
                pre.next = new Node(element, pre.next);
                size++;
            }
        }

    }

    //采用头插法为链表添加节点
    public void addAtHeader(T element) {
        //创建新节点,并把新节点变为头节点
        header = new Node(element, header);
        //如果插入之前是空链表
        if (tail == null) {
            tail = header;
        }
        size++;
    }

    //采用插尾法为链表添加新节点
    public void add(T element) {
        if (header == null) {
            header = new Node(element, null);
            tail = header;
        } else {
            //创建新节点
            Node newNode = new Node(element, null);
            //将原来的尾节点指向新节点
            tail.next = newNode;
            //将新节点变为新的尾节点
            tail = newNode;
        }
        size++;
    }

    //删除链表中指定索引的元素
    public T delete(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
        Node del = null;
        if (index == 0) {
            del = header;
            header = header.next;

        } else {
            Node pre = getNodeByIndex(index - 1);
            del = pre.next;
            pre.next = del.next;
            del.next = null;
        }
        size--;
        return del.data;
    }

    //删除链表中最后一个元素
    public T remove() {
        return delete(size - 1);
    }

    //判断链表是否为空链表
    public boolean empty() {
        return size == 0;
    }

    //清空链表
    public void clean() {
        header = null;
        tail = null;
        size = 0;
    }

    @Override
    public String toString() {
        if (empty()) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (Node current = header; current != null; current = current.next) {
            stringBuilder.append(current.data.toString() + " ,");
        }
        int len = stringBuilder.length();
        return stringBuilder.delete(len - 2, len).append("]").toString();

    }






    public LinkList<Integer> delete(LinkList<Integer> list, Integer min, Integer start) {
         Node current= (Node) list.header;
        while (current.next!=null){
            if (current.data!=min){
                current=current.next;
            }else break;
        }
        System.out.println(current.data);
        return null;
    }

}




















