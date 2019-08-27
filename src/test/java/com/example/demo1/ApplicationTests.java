package com.example.demo1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

//    @Test
//    public void contextLoads() {
//    }


      //第一种方法
    public static void main(String[] args) {
        for (int i = 0; i <3 ; i++) {
            MyThread thread = new MyThread();
            thread.start();
        }
    }

    public static  class MyThread extends  Thread {
        @Override
        public void run() {
            for (int i = 0; i <5 ; i++) {
                System.out.println(getName() + i +"    ");
            }
        }
    }

//    public static void main(String[] args) {
//
//        new Thread(new Myrunable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 100; i++) {
//                    System.out.println(i);
//                }
//            }
//        }, "窗口一").start();
//
//
//       new Thread(new Myrunable(){
//            @Override
//            public void run() {
//                for (int i = 100; i >10 ; i--) {
//                    System.out.println(i);
//                }
//            }
//        },"窗口二").start();
//
//        Myrunable myrunable = new Myrunable();
//        Thread thread1 = new Thread(myrunable,"窗口三");
//        Thread thread2 = new Thread(myrunable,"窗口四");
//        thread1.start();
//        thread2.start();
//    }
}
//class Myrunable implements Runnable {
//
//    private int tick = 200;
//    Object obj = new Object();
//    @Override
//    public void run() {
//        while(true) {
//            synchronized(obj) {
//                if (tick > 0) {
//                    try {
//                        Thread.sleep(10);
//                    } catch (Exception e) {
//                    }
//                    System.out.println(Thread.currentThread().getName() + "...銷售：" + (tick--) + "号票");
//                } else {
//                    break;
//                }
//            }
//        }
//    }
//}
