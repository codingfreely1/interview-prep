package solutions.fizzbuzz;

import java.util.function.Predicate;

/**
 * Created by yael on 13/01/17.
 */
public class FizzBuzzThread implements Runnable {
    private static final Object lock = new Object();
    private static Integer current = 0;
    private static int max = 10;
    private Predicate<Integer> predicate;
    private String resMessage;

    public FizzBuzzThread(Predicate<Integer> predicate, String resMessage) {
        this.predicate = predicate;
        this.resMessage = resMessage;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (lock) {
                if(current > max){
                    return;
                }

                if(predicate.test(current)){
                    System.out.println(current + " " + resMessage);
                    current += 1;
                }
            }
        }
    }

    public static void setMax(int max) {
        FizzBuzzThread.max = max;
    }
}
