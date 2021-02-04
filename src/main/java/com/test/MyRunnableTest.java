package com.test;

import com.test.util.MyRunnable;

public class MyRunnableTest {
    public static void main(String[] args){

        MyRunnable myRunnable1=new MyRunnable("Runnable1");
        MyRunnable myRunnable2=new MyRunnable("Runnable2");
        MyRunnable myRunnable3=new MyRunnable("Runnable3");

        Thread myThread1=new Thread(myRunnable1);
        myThread1.start();
        System.out.println("myThread1 id ="+myThread1.getId());
        Thread myThread2=new Thread(myRunnable2);
        myThread2.start();
        System.out.println("myThread1 id ="+myThread2.getId());
        Thread myThread3=new Thread(myRunnable3);
        myThread3.start();
        System.out.println("myThread1 id ="+myThread3.getId());
    }

}
