package com.meizhuo.PointToOffer;

/**
 * @Classname LinkNode
 * @Description 单向链表节点
 * @Date 2019/7/22 10:54
 * @Created by Gangan
 */
public class LinkNode<V> {

    public V value;

    public LinkNode<V> nextNode;

    public LinkNode(V value, LinkNode<V> nextNode) {
        this.value = value;
        this.nextNode = nextNode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LinkNode) {
            LinkNode node= (LinkNode) obj;
            if (node == this) {
                return true;
            } else {
                if (this.value.equals(node.value) && this.nextNode == node.nextNode) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "LinkNode{" +
                "value=" + value +
                '}';
    }
}
