package solutions;

import solutions.fizzbuzz.FizzBuzzThread;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * Created by yael on 12/01/17.
 */
public class ThreadsAndLocksSolutions {

    /**
     * q. 15.7
     * @param max
     */
    public static void multiThreadedFizzBuzz(int max){

        FizzBuzzThread.setMax(max);

        Thread[] threads = { getFizzBuzzThread((i) -> isDividedBy(3).test(i) && !isDividedBy(5).test(i), "Fizz"),
                getFizzBuzzThread((i) -> !isDividedBy(3).test(i) && isDividedBy(5).test(i) ,"Buzz"),
                getFizzBuzzThread((i) -> isDividedBy(3).test(i) && isDividedBy(5).test(i), "FizzBuzz"),
                getFizzBuzzThread((i)-> !isDividedBy(3).test(i) && !isDividedBy(5).test(i), "") };

        for(Thread t: threads){
            t.start();
        }

        while(Arrays.stream(threads).anyMatch(Thread::isAlive)){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static Thread getFizzBuzzThread(Predicate<Integer> predicate, String resMessage){
        return new Thread(new FizzBuzzThread(predicate, resMessage));
    }

    private static Predicate<Integer> isDividedBy(int divider) {
        return (i)-> (i % divider == 0);
    }
}
