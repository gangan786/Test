package com.meizhuo.DesignPatterns.DesignPatterns_4;

import java.util.ArrayList;

/**
 * 模拟文档类型
 */

public class WordDocument implements Cloneable {
    private String mText;//文本
    private ArrayList<String> imageArray = new ArrayList<>();//图片名列表

    public WordDocument() {
        System.out.println("WordDocument构造函数");
    }

    @Override
    protected WordDocument clone() throws CloneNotSupportedException {
        WordDocument wordDocument = (WordDocument) super.clone();
        wordDocument.mText = this.mText;
        wordDocument.imageArray = (ArrayList<String>) this.imageArray.clone();
        return wordDocument;
    }

    public String getmText() {
        return this.mText;
    }

    public void setmText(String mText) {
        this.mText = mText;
    }

    public ArrayList<String> getImageArray() {
        return this.imageArray;
    }

    public void addImage(String image) {
        this.imageArray.add(image);
    }

    /**
     * 打印文档内容
     */
    public void showDocument() {
        System.out.println("----------word content start-----------");
        System.out.println(mText);
        for (String image : imageArray) {
            System.out.println("image name : " + image);
        }
        System.out.println("----------word content end-----------");
    }

}
