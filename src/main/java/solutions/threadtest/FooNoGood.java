package solutions.threadtest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yael on 16/01/17.
 */
public class FooNoGood {
    private ReentrantLock lockSecond;
    private ReentrantLock lockThird;

    public FooNoGood(){
        lockSecond = new ReentrantLock();
        lockThird = new ReentrantLock();
        System.out.println("locking second and third in thread " + Thread.currentThread().getName());
        lockSecond.lock();
        lockThird.lock();
    }

    public void first(Object o){
        System.out.println("In first. unlocking second in " + Thread.currentThread().getName());
        try{
           lockSecond.unlock();
        }  catch (IllegalMonitorStateException e) {
           System.out.println("In first. As expected - unlocking of second failed because we cannot lock in one thread and unlock in other thread.");
        }
    }

    public void second(Object o){
        System.out.println("In second. trying to lock second in " + Thread.currentThread().getName());
        lockSecond.lock();
        System.out.println("In second. unlocking third in " + Thread.currentThread().getName());
        try{
            lockThird.unlock();
        }  catch (IllegalMonitorStateException e) {
            System.out.println("In second. As expected - an exception thrown because we cannot lock in one thread and unlock in other thread.");
        }
    }

    public void third(Object o){
        lockThird.lock();
        System.out.println("In third. in " + Thread.currentThread().getName());
    }
}
