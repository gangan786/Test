package com.meizhuo.PointToOffer;

/**
 * @Classname No37
 * @Description 序列化及反序列化二叉树
 * @Date 2019/7/6 21:33
 * @Created by Gangan
 */
public class No37 {

    public String serialize(BinaryTreeNode rootNode) {
        StringBuilder result = new StringBuilder();
        if (rootNode == null) {
            result.append(",&");
            return result.toString();
        }
        result.append(rootNode.value + ",");
        result.append(serialize(rootNode.leftNode));
        result.append(serialize(rootNode.rightNode));
        return result.toString();

    }

    int index = -1;

    public BinaryTreeNode deSerialize(String result) {
        index++;
        int length = result.length();
        if (index >= length) {
            return null;
        }

        String[] strings = result.split(",");
        BinaryTreeNode newNode = null;
        if (!"&".equals(strings[index])) {
            newNode = new BinaryTreeNode(Integer.valueOf(strings[index]), null, null);
            newNode.leftNode = deSerialize(result);
            newNode.rightNode = deSerialize(result);
        }
        return newNode;
    }

}
