package solutions.threadtest;

/**
 * Created by yael on 12/01/17.
 */
public class SomeClass {

    public static synchronized void synchronizedFunction1(Object o){
        printAndSleep("static synchronized 1");
    }

    public static synchronized void synchronizedFunction2(Object o){
        printAndSleep("static synchronized 2");
    }

    public static void notSynchronized(Object o){
        printAndSleep("static not synchronized");
    }

    public synchronized void method1(Object o){
       printAndSleep("method 1");
    }

    public synchronized void method2(Object o){
       printAndSleep("method 2");
    }

    private static void printAndSleep(String methodName){
        System.out.println(Thread.currentThread().getName() +  " in " + methodName);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +  " exiting " + methodName);
    }
}
