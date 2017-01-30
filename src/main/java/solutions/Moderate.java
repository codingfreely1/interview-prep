package solutions;

/**
 * Created by yael on 19/01/17.
 */
public class Moderate {

    /**
     * O(n^2)
     * @param arr
     * @return
     */
    public static int findMaxContiguousSum(int [] arr){
        int sumMax = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < 0) { continue; }
            for (int j = i; j < arr.length; j++) {
                int candidate = calcSum(arr, i, j);
                if(candidate > sumMax){
                    sumMax = candidate;
                }
            }
        }
        return sumMax;
    }

    /**
     *
     * @param arr
     * @return
     */
    public static int findMaxContiguousSumOptimized(int [] arr){
        int sumMax = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum > sumMax){
                sumMax = sum;
            }else if(sum < 0){
                sum = 0;
            }
        }
        return sumMax;
    }

    private static int calcSum(int[] arr, int start, int end){
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum+=arr[i];
        }
        return sum;
    }

    public static int[] subSort(int[] arr){
        int[] res = {-1,-1};
        int leftSortedEnd = 0;
        int rightSortedEnd = arr.length-1;

        while(leftSortedEnd+1 <arr.length && arr[leftSortedEnd] <=arr[leftSortedEnd+1]) {
            leftSortedEnd++;
        }

        if(leftSortedEnd+1 == arr.length-1) {
            return res;// array is sorted.
        }

        while(rightSortedEnd -1  >= 0 && arr[rightSortedEnd] >= arr[rightSortedEnd-1]){
            rightSortedEnd--;
        }

        int maxLeft = arr[leftSortedEnd];
        int minRight = arr[rightSortedEnd];

        while( !(maxLeft < minRight)){
            leftSortedEnd--;
            maxLeft = arr[leftSortedEnd];
        }

        int unsortedStart = leftSortedEnd +1;
        int unsortedEnd = rightSortedEnd - 1;

        while(unsortedStart < unsortedEnd){
            while(leftSortedEnd>= 0 && arr[unsortedStart] < arr[leftSortedEnd]) {
                leftSortedEnd--;
            }

            while(rightSortedEnd < arr.length &&arr[unsortedStart]>arr[rightSortedEnd]) {
                rightSortedEnd++;

            }
            unsortedStart++;
        }
        res[0] = leftSortedEnd+1;
        res[1] = rightSortedEnd-1;
        return res;
    }

    public static int countFactZeros(int num) {
        System.out.println(num);
        int count = 0;
        if(num < 0){
            return -1;
        }
        for (int i = 5; num / i > 0 ; i*=5) {
            System.out.println(num/i);
            count += num / i;
            System.out.println(i);
        }
        System.out.println("returning " + count);
        return count;
    }

    public static long factorsOf5(long i) {
       long count = 0;
       while (i % 5 == 0){
           System.out.println(i);
           count++;
           i = i/5;
       }
       return count;
    }

    public static int countFactZeros2(long num){
        int count = 0;
        for (long i = 2; i <= num ; i++) {
            count+=factorsOf5(i);
        }
        return count;
    }

    public static int compute(String equation) {

        int subIndex = equation.indexOf("-");
        boolean add = false;
        if(subIndex == -1) {
            subIndex = equation.indexOf("+");
            add = true;
        }
        if(subIndex != -1) {
            int a =  compute(equation.substring(0, subIndex));
            int b = compute(equation.substring(subIndex +1, equation.length()));
            return add ? a+b : a-b;
        }

        subIndex = equation.indexOf("/");
        boolean multiply = false;
        if(subIndex == -1) {
            subIndex = equation.indexOf("*");
            multiply = true;
        }
        if(subIndex != -1) {
            int a =  compute(equation.substring(0, subIndex));
            int b = compute(equation.substring(subIndex +1, equation.length()));
            return multiply ? a*b : a/b;
        }

        return Integer.valueOf(equation);
    }

}
