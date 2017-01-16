package solutions.threadtest;

import java.util.concurrent.Semaphore;

/**
 * Created by yael on 16/01/17.
 */
public class FooGood {
    private Semaphore sem2;
    private Semaphore sem3;

    public FooGood(){
        sem2 = new Semaphore(1);
        sem3 = new Semaphore(1);

        System.out.println("acquiring semaphore 2 and 3" + Thread.currentThread().getName());
        try {
            sem2.acquire();
            sem3.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void first(Object o){
        System.out.println("In first. doing some work.. " + Thread.currentThread().getName());
        try { //To make the output more meaningful
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("In first. releasing sem2 " + Thread.currentThread().getName());
        sem2.release();
    }

    public void second(Object o){
        System.out.println("In second. trying to acquire sem2 " + Thread.currentThread().getName());
        try {
            sem2.acquire();
            System.out.println("In second. sem2 acquired. doing some work.." + Thread.currentThread().getName());
            Thread.sleep(500);
            sem2.release();
            System.out.println("In second. releasing sem2 " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sem3.release();
        System.out.println("In second. releasing sem3 " + Thread.currentThread().getName());
    }

    public void third(Object o){
        System.out.println("In third. trying to acquire sem3 " + Thread.currentThread().getName());
        try {
            sem3.acquire();
            System.out.println("In third. sem3 acquired. doing some work.. " + Thread.currentThread().getName());
            Thread.sleep(100);
            sem3.release();
            System.out.println("In third. sem3 released " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
