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

}
