package solutions;

import org.junit.Test;
import solutions.threadtest.FooGood;
import solutions.threadtest.FooNoGood;
import solutions.threadtest.TestThread;
import solutions.threadtest.SomeClass;

import java.util.function.Consumer;

/**
 * Created by yael on 12/01/17.
 */
public class ThreadsAndLocksSolutionsTest {

    /**
     * thread 2 will wait till thread 1 finishes before entering the method.
     */
    @Test
    public void testingOneInstanceOneSynchronizedMethod(){
        SomeClass instance = new SomeClass();
        runTwoThreadsAndWaitTillFinish(instance::method1, instance::method1, 2000);
    }

    /**
     * thread 2 will not wait till thread 1 finishes before entering the method because the locks are different.
     * one for each instance.
     */
    @Test
    public void testingTwoInstancesOneSynchronizedMethod(){
        SomeClass instance1 = new SomeClass();
        SomeClass instance2 = new SomeClass();
        runTwoThreadsAndWaitTillFinish(instance1::method1, instance2::method1, 1000);
    }

    /**
     * thread 2 will wait till thread 1 finishes before entering the method because the lock is the same.
     */
    @Test
    public void testingOneInstanceTwoSynchronizedMethods(){
        SomeClass instance = new SomeClass();
        runTwoThreadsAndWaitTillFinish(instance::method1, instance::method2, 2000);
    }

    /**
     * thread 2 will wait till thread 1 finishes before entering the method.
     */
    @Test
    public void testingOneStaticSynchronizedFunction(){
        runTwoThreadsAndWaitTillFinish(SomeClass::synchronizedFunction1, SomeClass::synchronizedFunction1, 2000);
    }

    /**
     * thread 2 will wait till thread 1 finishes before entering the method even though the call if to a different
     * function because the lock is the same lock. associated with the class.
     */
    @Test
    public void testingTwoStaticSynchronizedFunction(){
        runTwoThreadsAndWaitTillFinish(SomeClass::synchronizedFunction1, SomeClass::synchronizedFunction2, 2000);
    }

    /**
     * thread 2 will not wait because it is not a synchronized function. doesn't wait for any lock.
     */
    @Test
    public void testingOneStaticSynchronizedOneRegularFunction(){
        runTwoThreadsAndWaitTillFinish(SomeClass::synchronizedFunction1, SomeClass::notSynchronized, 1000);
    }

    /**
     * thread 2 will not wait for thread 1 to finish because the locks are different.
     * One is associated with the class and the other with the instance.
     */
    @Test
    public void testingOneStaticSynchronizedOneSynchronizedMethodFunction(){
        SomeClass someInstance = new SomeClass();
        runTwoThreadsAndWaitTillFinish(SomeClass::synchronizedFunction1, someInstance::method1, 1000);
    }

    private void runTwoThreadsAndWaitTillFinish(Consumer<Object> synchronizedFunction1, Consumer<Object> synchronizedFunction2, int waitTime){
        Thread testThread1 = new Thread(new TestThread(synchronizedFunction1));
        Thread testThread2 = new Thread(new TestThread(synchronizedFunction2));

        testThread1.start();
        testThread2.start();

        //suspending process termination so I can see the printouts.
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * A no good solution for q 15.15 - One thread was suppose to call first() , second thread was suppose to call second() but only after
     * previous finished executing first but unlocking failed.
     */
    @Test
    public void testUnlockingLockFromDifferentThreads(){
            FooNoGood foo = new FooNoGood();

            Thread[] threads = { new Thread(new TestThread(foo::first)),
                    new Thread(new TestThread(foo::second)),
                    new Thread(new TestThread(foo::third))};

            for(Thread t: threads){
                t.start();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        System.out.println("second and third weren't called since the unlocking of second failed.");
    }

    /**
     * A working solution for q 15.15 - using semaphores. the main thread is lockign second and third. and first thread is releasing second and second thread
     * is releasing third.
     */
    @Test
    public void testUnlockingLockUsingSemaphores(){
        FooGood foo = new FooGood();

        Thread[] threads = { new Thread(new TestThread(foo::first)),
                new Thread(new TestThread(foo::second)),
                new Thread(new TestThread(foo::third))};

        for(Thread t: threads){
            t.start();
        }

        try {
            Thread.sleep(1600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Testing multi threaded FizzBuzz problem.
     */
    @Test
    public void testMultiThreadedFizzBuzz(){
        ThreadsAndLocksSolutions.multiThreadedFizzBuzz(50);
    }
}
