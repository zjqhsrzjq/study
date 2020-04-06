package com.example.george.study.service.commonStudy;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author George
 * @date 2020/4/6 下午4:07
 */
@Component
public class CommonDataType {

    public void dataType(){
        int a1 =1;
        Integer a2 =1;
        System.out.println(a2.equals(a1));
        long b1 = 2;
        Long b2 = 2L;
        System.out.println(b2.equals(b1));
        double c1 = 2.1;
        Double c2 = 2.1;
        System.out.println(0.7*3 == c1);
        float d1 = 2.32f;
        Float d2 = 2.32F;
        System.out.println(d1+d2);
        byte e1 = 'a';
        Byte e2 ='c';
        System.out.println(e1+e2);
        short f1 ='吧';
        Short f2 = 2000;
        char g1 = 'a';
        Character g2 = 'a';
        boolean h1 = true;
        Boolean h2 = false;
    }

    public void compare(){
        int a= 255;
        int b= 255;
        Integer aa= 5;
        Integer bb= 5;
        Integer cc= new Integer(5);
        Integer aaa= 128;
        Integer bbb= 128;

        Object t1 = new Object();
        Object t2 = new Object();

        String str1="test";
        String str2 = new String("test") ;
        String str3 ;
        str3 =str1;

        System.out.println(a==b); /** true **/
        System.out.println(aa==bb);/** true **/
        /** Integer在常量池中存储范围是[-128,127]，超过范围会new一个对象来保存值 */
        System.out.println(aa==cc);/* false **/
        System.out.println(aaa==bbb);/** false **/
        System.out.println(aaa.equals(bbb));/** true **/

        System.out.println("Object:"+ Boolean.toString(t1.equals(t2)));

        System.out.println(str1==str2);/* false **/
        System.out.println(str1==str3);/** true **/
        System.out.println(str1.equals(str2));/** true **/

    }

//
//    final class test123{
//        String name = "1";
//        Integer age =1;
//    }
//
//    void test1(){
//        final test123 ttt = new test123();
//        ttt.name = "name";
//        ttt.age =2;
//        ttt = new test123();
//        final int[] ccc = {1,2,3,4};
//        ccc[3] = 5;
//        ccc = new int[]{1,2,3,4};
//    }

}
