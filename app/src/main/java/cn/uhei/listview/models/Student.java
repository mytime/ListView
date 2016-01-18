package cn.uhei.listview.models;

/**
 * 自定义列表数据模型.
 */
public class Student {
    private String name;
    private int age;

    //构造函数的主要作用是传递参数
    //1直接使用输出的对象所在内存地址，
    public Student(String name,int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    //2 把label转成字符串后输出
    // return 哪个值，ListView就显示那个只
    @Override
    public String toString() {
        return name;
    }
}
