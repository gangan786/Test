package com.meizhuo.temp;

import java.awt.List;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class No27 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/
    static ListNode partition(ListNode head, int m) {

        ListNode curBig = null;
        ListNode curSmall = null;
        ListNode birRoot = null;
        ListNode smallRoot=null;

        while (head != null) {
            if (head.val > m) {
                ListNode node = new ListNode(head.val);
                if (curBig == null) {
                    curBig = node;
                    birRoot=curBig;
                } else {
                    curBig.next = node;
                }
            } else {
                ListNode node = new ListNode(head.val);
                if (curSmall == null) {
                    curSmall = node;
                    smallRoot = curSmall;
                } else {
                    curSmall.next = node;
                }
            }
            head = head.next;
        }

        if (curSmall != null) {
            curSmall.next = curBig;
            return smallRoot;
        } else {
            return birRoot;
        } 


    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ListNode head = null;
        ListNode node = null;
        int m = in.nextInt();
        while (in.hasNextInt()) {
            int v = in.nextInt();
            if (head == null) {
                node = new ListNode(v);
                head = node;
            } else {
                node.next = new ListNode(v);
                node = node.next;
            }
        }
        head = partition(head, m);
        if (head != null) {
            System.out.print(head.val);
            head = head.next;
            while (head != null) {
                System.out.print(",");
                System.out.print(head.val);
                head = head.next;
            }
        }
        System.out.println();
    }
}
