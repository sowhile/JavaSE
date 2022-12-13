package com.wangda.chapter10;

public class test {
}

class Sample {
    static {
        System.out.println("Sample静态代码块");//1
    }
    {
        System.out.println("Sample普通代码块");//2 5
    }

    Sample(String s) {
        System.out.println(s);
    }

    Sample() {
        System.out.println("Sample默认构造函数被调用");
    }
}

class Test {
    Sample sam1 = new Sample("sam1成员初始化");//6
    static Sample sam = new Sample("静态成员sam初始化 ");//3

    static {
        System.out.println("static块执行");//4
        if (sam == null) System.out.println("sam is null");
    }

    Test()//构造器
    {
        System.out.println("Test默认构造函数被调用");//7
    }

    //主方法
    public static void main(String str[]) {
        Test a = new Test();//无参构造器
    }

}



