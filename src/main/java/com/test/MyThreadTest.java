package com.test;

import com.test.util.MyThread;

public class MyThreadTest {
    public static void main(String[] args){
        MyThread myThread1=new MyThread("线程1");
        MyThread myThread2=new MyThread("线程2");
        MyThread myThread3=new MyThread("线程3");

        myThread1.start();
        myThread2.start();
        myThread3.start();

        System.out.println("myThread1 id ="+myThread1.getId());
        System.out.println("myThread1 id ="+myThread2.getId());
        System.out.println("myThread1 id ="+myThread3.getId());


    }

}
