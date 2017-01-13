package solutions;

/**
 * Created by yael on 12/01/17.
 */
public class ThreadsAndLocksSolutions {

    public static String fizzBuzz(int num){
        StringBuilder sb = new StringBuilder();
        if(isDividedBy(num, 3)) {
            sb.append("Fizz");
        }
        if(isDividedBy(num, 5)){
            sb.append("Buzz");
        }
        return sb.toString();
    }

    private static boolean isDividedBy(int num, int divider) {
        return (num % divider) == 0;
    }
}
