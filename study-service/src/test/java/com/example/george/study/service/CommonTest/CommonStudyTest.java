package com.example.george.study.service.CommonTest;

import org.junit.Test;

/**
 * @author George
 * @date 2020/4/6 下午10:11
 */
public class CommonStudyTest {

    class Father{}
    class Child extends Father{
        void test(){
           System.out.println(super.getClass().getCanonicalName());
           System.out.println(getClass().getCanonicalName());
           System.out.println(getClass().getSuperclass().getCanonicalName());
        }
    }

    @Test
    public void test(){
        Child child = new Child();
        child.test();
    }

    @Test
    public void test1(){
        String a ="Hello";
        System.out.println(a);
        System.out.println(a.hashCode());
        a=a.concat("World");
        System.out.println(a);
        System.out.println(a.hashCode());
    }

    @Test
    public void test2(){
        StringBuffer b =new StringBuffer();
        System.out.println(b);
        System.out.println(b.hashCode());
        b=b.append("hello world");
        System.out.println(b);
        System.out.println(b.hashCode());
    }

    @Test
    public void test3(){
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        System.out.println(sb);
        System.out.println(sb.hashCode());
        sb.append("World");
        System.out.println(sb);
        System.out.println(sb.hashCode());
    }

    @Test
    public void test4(){
        System.out.println(test4Method());
    }

    private Integer test4Method(){
        Integer a =1;
        try{
            System.out.println("try");
            return a-1;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("finally");
            a=1;
        }
        return a;
    }

    @Test
    public void test5() throws Exception {
        Object a = new Object();
        System.out.println(System.currentTimeMillis());
        a.wait(2000);
        System.out.println(System.currentTimeMillis());
        a=5;

    }

}
