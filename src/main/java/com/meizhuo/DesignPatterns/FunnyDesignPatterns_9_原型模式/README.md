# 原型模式
这就是一个拷贝对象要用到的方式，并不是有多高明，技术难点在于对于复杂对象的深拷贝，这里简单实现了拷贝功能

原型模式其实就是从一个对象再创建另外一个可定制的对象，而且不需要知道任何创建的细节

不用重新初始化对象，而是动态的获取对象运行时的状态，对性能是有显著提高对于那些初始化耗时较长资源消耗大的类来说

~~~java
public class WorkExperience implements Cloneable {

    @Getter
    @Setter
    private String workDate;

    @Getter
    @Setter
    private String company;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "WorkExperience{" +
                "workDate='" + workDate + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
~~~

~~~java
public class Resume implements Cloneable {

    private String name;
    private String sex;
    private String age;

    private WorkExperience workExperience;

    public Resume(String name) {
        this.name = name;
        workExperience = new WorkExperience();
    }

    private Resume(WorkExperience work) {
        try {
            this.workExperience = (WorkExperience) work.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    public void setWorkExperience(String workDate, String company) {
        workExperience.setWorkDate(workDate);
        workExperience.setCompany(company);
    }

    public void setPersonalInfo(String sex, String age) {
        this.sex = sex;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", workExperience=" + workExperience +
                '}';
    }

    @Override
    protected Object clone() {
        Resume resume = new Resume(this.workExperience);
        resume.name = this.name;
        resume.sex = this.sex;
        resume.age = this.age;
        return resume;
    }
}
~~~

~~~java
public class Client {
    public static void main(String[] args) {
        Resume gangan = new Resume("Gangan");
        gangan.setPersonalInfo("男", "22");
        gangan.setWorkExperience("1998-2000", "XX公司");

        Resume clone1 = (Resume) gangan.clone();
        clone1.setWorkExperience("2000-2002", "YY公司");

        Resume clone2 = (Resume) gangan.clone();
        clone2.setWorkExperience("2002-2004", "ZZ公司");

        System.out.println(gangan);
        System.out.println("----------------------------------");
        System.out.println(clone1);
        System.out.println("----------------------------------");
        System.out.println(clone2);

    }
}
~~~

