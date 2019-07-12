package com.meizhuo.PointToOffer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Classname No41
 * @Description 数据流中的中位数
 * @Date 2019/7/12 12:01
 * @Created by Gangan
 */
public class No41 {

    //生成最大堆
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11, new maxHeapComparator());
    //生成最小堆
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(11, new minHeapComparator());

    //初始化堆的大小，防止NullPointerException
    int maxSize = 0;
    int minSize = 0;

    /**
     * 平衡两堆元素的数目
     */
    public void reshapeHeapSize() {
        if (this.maxHeap.size() == this.minHeap.size() + 2) {
            this.minHeap.add(this.maxHeap.poll());
        }
        if (this.minHeap.size() == this.maxHeap.size() + 2) {
            this.maxHeap.add(this.minHeap.poll());
        }
    }

    public void insert(Integer num) {

        if (this.maxHeap.isEmpty()) {
            this.maxHeap.add(num);
        } else {
            if (this.maxHeap.peek() > num) {
                this.maxHeap.add(num);
            } else {
                if (this.minHeap.isEmpty()) {
                    this.minHeap.add(num);
                } else {
                    if (this.minHeap.peek() <= num) {
                        this.minHeap.add(num);
                    } else {
                        //这里的情况是：maxHeap.peek()<=num && minHeap.peek()>num
                        //感觉这段代码没必要，插到minHeap也没关系
                        this.maxHeap.add(num);
                    }
                }
            }
        }
        reshapeHeapSize();
    }

    public Double getMedian() {
        if (!maxHeap.isEmpty()) {
            maxSize = this.maxHeap.size();
        }
        if (!minHeap.isEmpty()) {
            minSize = this.minHeap.size();
        }
        if (maxSize + minSize == 0) {
            throw new RuntimeException();
        }
        Integer maxHeapNum = this.maxHeap.peek();
        Integer minHeapNum = this.minHeap.peek();
        if (((maxSize + minSize) % 2) == 0) {
            return (double) ((maxHeapNum + minHeapNum)) / 2;
        } else {
            return (double) (maxSize > minSize ? maxHeapNum : minHeapNum);
        }
    }

    public class minHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    public class maxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }


}
