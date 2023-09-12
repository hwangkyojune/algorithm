package threadTest;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class ThreadTest {
    static int a =0;

    public static void main(String[] args) {
        Thread myTread = new MyThread("dd");
        Thread myTread2 = new MyThread("ss");
        myTread.start();
        myTread2.start();
        try{
            Thread.sleep(10);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        a++;
        System.out.println("a"+a);
        Thread myThread3 = new MyThread("d");
        myThread3.start();


    }

//    @Test
//    public void threadTest(){
//        Thread myThread = new MyThread();
//        myThread.start();
//        System.out.println("main thread");
//        try{
//            Thread.sleep(10000);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//    }
    static class MyThread extends Thread{
        String dis;
        public MyThread(String name){
            this.dis = name;
        }
        @Override
        public void run() {
            for(int i=0;i<100;i++){
//                System.out.println("* "+this.dis);
                a++;
                System.out.println(a+this.dis);
                try{
                    Thread.sleep(10);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

}
