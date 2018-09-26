package com.meizhuo.CrazyJava._11.ArrayBinTree;

import java.util.Arrays;

public class ArrayBinTree<T> {

    private Object datas[];//用数组来记录该树的所有节点
    private int DEFAULT_DEEP = 8;//默认树的深度
    private int deep;//保存树的深度
    private int arraySize;//数组长度

    public ArrayBinTree() {
        //以默认深度创建二叉树
        this.deep = DEFAULT_DEEP;
        this.arraySize = (int) (Math.pow(2, deep) - 1);
        datas = new Object[arraySize];
    }

    public ArrayBinTree(int deep) {
        //以指定深度创建二叉树
        this.deep = deep;
        this.arraySize = (int) (Math.pow(2, deep) - 1);
        datas = new Object[arraySize];
    }

    public ArrayBinTree(int deep, T data) {
        //以指定深度,指定节点创建二叉树
        this.deep = deep;
        this.arraySize = (int) (Math.pow(2, deep) - 1);
        datas = new Object[arraySize];
        datas[0] = data;
    }

    /**
     * 为指定节点添加子节点
     *
     * @param index  需添加子节点的父节点的索引
     * @param data   新节点
     * @param isLeft 是否为左节点
     */
    public int add(int index, T data, boolean isLeft) {
        if (datas[index] == null) {
            throw new RuntimeException(index + "处节点为空，无法添加子节点");
        }
        if (index*2+1>=arraySize){
            throw new RuntimeException("树底层的数组已满，树越界异常");
        }
        if (isLeft){
            //添加左节点
            datas[index*2+1]=data;
            return index*2+1;
        }else {
            //添加右节点
            datas[index*2+2]=data;
            return index*2+2;
        }
    }

    /**
     * 判断二叉树是否为空
     * @return
     */
    public boolean empty(){
        return datas[0]==null;
    }

    /**
     * 返回根节点
     * @return
     */
    public T root(){
        return (T) datas[0];
    }

    /**
     * 返回指定节点（非根节点）的父节点
     * @param index
     * @return
     */
    public T parent(int index){
        return (T) datas[(index-1)/2];
    }

    /**
     * 返回指定节点的左节点，不存在时返回null
     * @param index
     * @return
     */
    public T left(int index){
        if (index*2+1>arraySize){
            throw new RuntimeException("该节点为叶子节点，无子节点");
        }
        return (T) datas[index*2+1];
    }

    public T right(int index){
        if (index*2+1>arraySize){
            throw new RuntimeException("该节点为叶子节点，无子节点");
        }
        return (T) datas[index*2+2];
    }

    /**
     * 返回树的深度
     * @return
     */
    public int deep(){
        return deep;
    }

    /**
     * 返回指定节点的索引
     * @param data
     * @return
     */
    public int pos(T data){
        for (int i = 0; i < arraySize; i++) {
            if (datas[i].equals(data)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return Arrays.toString(datas);
    }
}




















