package com.meizhuo.PointToOffer;

import lombok.Data;
import org.junit.Test;

/**
 * @Classname No18
 * @Description 链表删除操作
 * @Date 2019/6/30 11:16
 * @Created by Gangan
 */
public class No18 {

    public LinkNode head;

    /**
     * O(1)级别删除指定链表节点
     *
     * @param deleteNode
     */
    public void deleteNode(LinkNode deleteNode) {
        if (deleteNode.nextNode != null) {
            deleteNode.value = deleteNode.nextNode.value;
            deleteNode.nextNode = deleteNode.nextNode.nextNode;
        } else if (head == deleteNode) {
            head = null;
        } else {
            //删除节点为尾结点，遍历
            LinkNode curNode = head;
            while (curNode.nextNode != deleteNode) {
                curNode = curNode.nextNode;
            }
            curNode.nextNode = null;
        }
    }

    /**
     * 从头结点开始删除重复节点
     */
    public void deleteDupliaction() {
        if (head == null && head.nextNode == null) {
            return;
        }
        LinkNode curNode = head;
        LinkNode preNode = null;
        while (curNode != null) {
            LinkNode nextNode = curNode.nextNode;
            boolean needDel = false;
            if (nextNode != null && curNode.value == nextNode.value) {
                needDel = true;
            }

            if (needDel) {
                LinkNode delNode = curNode;
                int value = delNode.value;
                while (delNode != null && delNode.value == value) {
                    nextNode = delNode.nextNode;
                    delNode.nextNode = null;
                    delNode = nextNode;
                }
                if (preNode == null) {
                    head = nextNode;
                } else {
                    preNode.nextNode = nextNode;
                }
                curNode = nextNode;

            } else {
                preNode = curNode;
                curNode = nextNode;
            }
        }
    }

    @Data
    class LinkNode {
        public int value;
        public LinkNode nextNode;

        public LinkNode(int value, LinkNode nextNode) {
            this.value = value;
            this.nextNode = nextNode;
        }
    }

    @Test
    public void test() {
        LinkNode node7 = new LinkNode(5, null);
        LinkNode node6 = new LinkNode(4, node7);
        LinkNode node5 = new LinkNode(4, node6);
        LinkNode node4 = new LinkNode(3, node5);
        LinkNode node3 = new LinkNode(3, node4);
        LinkNode node2 = new LinkNode(2, node3);
        head= new LinkNode(1, node2);

        //deleteDupliaction();
        deleteNode(node3);


    }


}
