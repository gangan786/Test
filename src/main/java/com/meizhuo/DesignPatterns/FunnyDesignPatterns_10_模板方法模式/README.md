# 模板方法模式

场景：有一份试题作业，每个人都要抄下来完成，并写出对应答案

## v1

抽象出题目，这样就不用每个类重复写同一份题目

~~~java
public class TestPaper {

    public void testQuestion1(){
        System.out.println("如何增强党的执政本领？\n a 增强学习本领 b 增强依法执政本领 c 增强改革创新本领 d 增强群众工作本领");
    }

    public void testQuestion2(){
        System.out.println("毛泽东思想的灵魂？\n a 实事求是 b 群众路线 c 独立自主 d 氪金至上");
    }

    public void testQuestion3(){
        System.out.println("三大改造中三个行业是那指？\n a 农业 b 手工业 c 资本主义工商业 d 餐饮业");
    }

}
~~~

然后每个学生各自实现自己的答案，但答案格式必须是 “ 答案：+‘ 答案 ’ ”

试卷1

~~~java
public class TestPaperA extends TestPaper {
    @Override
    public void testQuestion1() {
        super.testQuestion1();
        System.out.println("答案：abcd");
    }

    @Override
    public void testQuestion2() {
        super.testQuestion2();
        System.out.println("答案：abc");
    }

    @Override
    public void testQuestion3() {
        super.testQuestion3();
        System.out.println("答案：abc");
    }
}
~~~

试卷2

~~~java
public class TestPaperB extends TestPaper {
    @Override
    public void testQuestion1() {
        super.testQuestion1();
        System.out.println("答案：abc");
    }

    @Override
    public void testQuestion2() {
        super.testQuestion2();
        System.out.println("答案：abcd");
    }

    @Override
    public void testQuestion3() {
        super.testQuestion3();
        System.out.println("答案：cd");
    }
}
~~~

可以看到两份试卷中还是有重复的部分，说明抽象层的TestPaper还是不够完善，重复的语句包括调用父类的方法和输出答案

客户端

~~~java
public class Client {

    public static void main(String[] args) {
        TestPaper paperA = new TestPaperA();
        paperA.testQuestion1();
        paperA.testQuestion2();
        paperA.testQuestion3();

        System.out.println("-----------------------------");
        TestPaper paperB = new TestPaperB();
        paperB.testQuestion1();
        paperB.testQuestion2();
        paperB.testQuestion3();
    }

}
~~~

输出结果

~~~
如何增强党的执政本领？
 a 增强学习本领 b 增强依法执政本领 c 增强改革创新本领 d 增强群众工作本领
答案：abcd
毛泽东思想的灵魂？
 a 实事求是 b 群众路线 c 独立自主 d 氪金至上
答案：abc
三大改造中三个行业是那指？
 a 农业 b 手工业 c 资本主义工商业 d 餐饮业
答案：abc
-----------------------------
如何增强党的执政本领？
 a 增强学习本领 b 增强依法执政本领 c 增强改革创新本领 d 增强群众工作本领
答案：abc
毛泽东思想的灵魂？
 a 实事求是 b 群众路线 c 独立自主 d 氪金至上
答案：abcd
三大改造中三个行业是那指？
 a 农业 b 手工业 c 资本主义工商业 d 餐饮业
答案：cd
~~~

使用模板方法改造后：

## v2

~~~java
public abstract class TestPaper {

    /**
     * answer for question1
     *
     * @return answer
     */
    public abstract String answer1();

    /**
     * answer for question2
     *
     * @return answer
     */
    public abstract String answer2();

    /**
     * answer for question3
     *
     * @return answer
     */
    public abstract String answer3();

    public void testQuestion1() {
        System.out.println("如何增强党的执政本领？\n a 增强学习本领 b 增强依法执政本领 c 增强改革创新本领 d 增强群众工作本领");
        System.out.println("答案：" + answer1());
    }

    public void testQuestion2() {
        System.out.println("毛泽东思想的灵魂？\n a 实事求是 b 群众路线 c 独立自主 d 氪金至上");
        System.out.println("答案：" + answer2());
    }

    public void testQuestion3() {
        System.out.println("三大改造中三个行业是那指？\n a 农业 b 手工业 c 资本主义工商业 d 餐饮业");
        System.out.println("答案：" + answer3());
    }

}
~~~

可以看到抽象层TestPaper方法中定义了三个与答案对应的抽象方法，并将答案的回答格式控制住了，用户只需传入答案，具体格式不关注

以下是具体试卷的作答

~~~java
public class TestPaperA extends TestPaper {
    @Override
    public String answer1() {
        return "abcd";
    }

    @Override
    public String answer2() {
        return "abc";
    }

    @Override
    public String answer3() {
        return "abc";
    }
}
~~~

~~~java
public class TestPaperB extends TestPaper {
    @Override
    public String answer1() {
        return "bcd";
    }

    @Override
    public String answer2() {
        return "abd";
    }

    @Override
    public String answer3() {
        return "cd";
    }
}
~~~

可以看到上述的每个类不用重新写重复的那部分，只要关注自己的不同点的实现就够了

客户端使用一样

## v3

以下是模板方法概念模型

顶层抽象类，将公共部分抽象出来，并将不同的部分使用多个抽象方法进行抽离，这样具体实现类就可以通过实现预先定义好的接口进行不同逻辑的处理

~~~java
public abstract class AbstractClass {

    /**
     * 不同于公共代码的处理逻辑1
     */
    public abstract void diffOperation1();

    /**
     * 不同于公共代码的处理逻辑2
     */
    public abstract void diffOperation2();

    public void normalOperation() {
        diffOperation1();
        diffOperation2();
        System.out.println("公共代码处理逻辑执行。。。");
    }

}
~~~

具体实现

~~~java
public class ConcreteClassA extends AbstractClass {
    @Override
    public void diffOperation1() {
        System.out.println(this.getClass().getName() + "不同于公共代码逻辑的逻辑1执行");
    }

    @Override
    public void diffOperation2() {
        System.out.println(this.getClass().getName() + "不同于公共代码逻辑的逻辑2执行");
    }
}
~~~

~~~java
public class ConcreteClassB extends AbstractClass {
    @Override
    public void diffOperation1() {
        System.out.println(this.getClass().getName() + "不同于公共代码逻辑的逻辑1执行");
    }

    @Override
    public void diffOperation2() {
        System.out.println(this.getClass().getName() + "不同于公共代码逻辑的逻辑2执行");
    }
}
~~~

客户端

~~~java
public class Client {
    public static void main(String[] args) {
        AbstractClass classA = new ConcreteClassA();
        classA.diffOperation1();
        classA.diffOperation2();
        System.out.println("--------------------------------");
        ConcreteClassB classB = new ConcreteClassB();
        classB.diffOperation1();
        classB.diffOperation2();
    }
}
~~~

## 总结

+ 当我们要完成在某一细节层次一致的一个过程或一系类步骤，但个别步骤在更详细的层次上的实现可能不同时，我们通常考虑用模板方法模式来处理

+ 模板方法模式：定义一个操作中的算法骨架，而将一些步骤延迟到子类中。模板方法使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤

+ 模板方法模式是通过把不变行为搬移到超类，去除子类中重复代码来体现它的优势

+ 模板方法就是提供了一个很好的代码复用平台

+ 当不变的和可变的行为在子类实现中混合在一起的时候，不变的行为就会在子类中重复出现。我们通过模板方法模式把这些不变的行为搬移到单一的地方，这样就帮助子类摆脱重复的不变的行为的纠缠
