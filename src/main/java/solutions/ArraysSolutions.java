package solutions;

import model.Range;

/**
 * Created by yael on 04/02/17.
 */
public class ArraysSolutions {

    public static Range findLongestIncreasingRange(int[] arr){
        if(arr.length == 0) {
            return null;
        }

        Range res = new Range(0,0);
        int s =0;
        int e = 0;

        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > arr[i-1]){
                e++;
            } else {
                if( (e-s) > (res.end - res.start)){
                    res.start = s;
                    res.end = e;
                }
                s = i;
                e = i;
            }
        }
        return res;
    }

    public static boolean isCircularArray(int[] arr) {
        int startInx = 0;
        int stepsCount = 0;
        int curInx = 0;
        int n = arr.length;
        while(stepsCount < n) {
            curInx = (curInx + arr[curInx])%n;
            stepsCount++;
            if(curInx == startInx && stepsCount < n) {
                return false;// circle is not passing all elements
            }

        }
        return curInx == startInx;
    }


}
