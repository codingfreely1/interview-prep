package algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yael on 15/01/17.
 */
public class MathAlgorithms {

    private static Map<Integer,Long> factorial = new HashMap<>();
    static {
        factorial.put(0, 1L);
        factorial.put(1, 1L);
    }

    public static long calcNchooseK(int n, int k){
        if(k == 0 || n == k)  {
            return 1;
        }
        long up = calcFactorial(n);
        long down = (calcFactorial(n-k) * calcFactorial(k));
        return ( up/down );
    }

    public static long calcFactorial(int n){
        if(n < 0) {
            return 1;
        }
        if(factorial.get(n) == null) {
            factorial.put(n, calcFactorial(n-1)*n);
        }
        return factorial.get(n);
    }

    static long calcFactorialIteratively(int n){
        if(n < 0) {
            return 1;
        }

        long previous = 1;
        for (int i = 2; i <= n; i++) {

            if(factorial.get(i) == null) {
               factorial.put(i, previous * i);
            }
            previous = factorial.get(i);

        }

        return factorial.get(n);
    }
}
