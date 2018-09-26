package com.meizhuo.CrazyJava._9.DulLinkList;

public class DulLinkList<T> {
    //创建双向节点
    private class Node {
        private T data;//保存节点数据
        private Node prv;//保存当前节点的前一个节点
        private Node next;//保存当前节点的下一个节点

        public Node() {
            //无参构造方法
        }

        public Node(T element, Node prv, Node next) {
            this.data = element;
            this.prv = prv;
            this.next = next;
        }

    }

    private Node header;//保存头节点
    private Node tail;//保存尾节点
    private int size;//保存链表长度

    public DulLinkList() {
        //无参构造方法，创建空链表
        header = null;
        tail = null;
    }

    public DulLinkList(T element) {
        header = new Node(element, null, null);//只有一个节点，header和tail都指向该节点
        tail = header;
        size++;
    }

    //返回链表的长度
    public int size() {
        return size;
    }

    //获取链表中索引为index处的元素
    public T get(int index) {
        return getNodeByIndex(index).data;
    }

    private Node getNodeByIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
        if (index <= size / 2) {
            //从头节点开始查找
            Node current = header;
            for (int i = 0; i <= size / 2 && current != null; current = current.next, i++) {
                if (i == index) {
                    return current;
                }
            }
        } else {
            //从尾节点开始找
            Node current = tail;
            for (int i = size - 1; i > size / 2 && current != null; current = current.prv, i--) {
                if (i == index) {
                    return current;
                }
            }
        }
        return null;
    }

    //查找链表中指定元素的索引
    public int locate(T element) {
        Node current = header;
        for (int i = 0; i < size || current != null; current = current.next, i++) {
            if (current.data.equals(element)) {
                return i;
            }
        }
        return -1;
    }

    //向链表中指定位置插入一个元素
    public void insert(T element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
        if (header == null) {
            add(element);
        } else {
            if (index == 0) {
                //在头节点插入数据
                addAtHeader(element);
            } else if (index < size) {
                Node prv = getNodeByIndex(index - 1);
                Node next = prv.next;
                Node newNode = new Node(element, prv, next);
                prv.next = newNode;
                next.prv = newNode;
                size++;
            } else if (index == size) {
                add(element);
            }
        }

    }

    //向头部添加节点
    public void addAtHeader(T element) {
        Node newNode = new Node(element, null, header);
        if (header == null) {
            header = newNode;
            tail = header;
        } else {
            header.prv = newNode;
            header = newNode;
        }
        size++;
    }

    //向尾部添加节点
    public void add(T element) {
        if (header == null) {
            //如果该链表还是空链表
            header = new Node(element, null, null);
            tail = header;
        } else {
            Node newNode = new Node(element, tail, null);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    //删除链表中指定索引处的节点
    public T delete(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
        Node del = null;
        if (index == 0) {
            //删除头节点
            del = header;
            header = header.next;
            //释放新的header节点的prv引用
            header.prv = null;
        } else {
            Node prv = getNodeByIndex(index - 1);
            del = prv.next;
            prv.next = del.next;
            if (del.next != null) {
                del.next.prv = prv;
            }
            del.next = null;
            del.prv = null;
        }
        size--;
        return del.data;
    }

    //删除链表中最后一个元素
    public T remove() {
        return delete(size - 1);
    }

    //判断是否为空链表
    public boolean empty() {
        return size == 0;
    }

    //清空链表
    public void clear() {
        header = null;
        tail = null;
        size = 0;
    }

    @Override
    public String toString() {
        if (empty()) {
            return "[]";
        } else {
            StringBuilder stringBuilder = new StringBuilder("[");
            for (Node current = header; current != null; current = current.next) {
                stringBuilder.append(current.data.toString() + " ,");
            }
            int len = stringBuilder.length();
            return stringBuilder.delete(len - 2, len).append("]").toString();
        }
    }

    public String reverseToString() {
        if (empty()) {
            return "[]";
        } else {
            StringBuilder stringBuilder = new StringBuilder("[");
            for (Node current = tail; current != null; current = current.prv) {
                stringBuilder.append(current.data.toString() + " ,");
            }
            int len = stringBuilder.length();
            return stringBuilder.delete(len - 2, len).append("]").toString();
        }
    }
}

















