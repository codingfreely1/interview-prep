package solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

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

    private static Map<Character,Integer> opPriorityMap = new HashMap<>();
    static {
        opPriorityMap.put('*', 1);
        opPriorityMap.put('/', 1);
        opPriorityMap.put('+', 0);
        opPriorityMap.put('-', 0);
    }

    private static class EquationParser {
        int curIndex = -1;
        String s;

        public EquationParser(String s) {
            this.s = s;
        }

        double getNextVal() {
            StringBuilder sb = new StringBuilder();
            curIndex++;
            while (curIndex == 0 || (hasNext() && !opPriorityMap.keySet().contains(s.charAt(curIndex)))) {
                sb.append(s.charAt(curIndex));
                curIndex++;
            }
            return Double.valueOf(sb.toString());
         }
        char getNextOperator() {
            //curIndex++;
            return s.charAt(curIndex);
        }

        boolean hasNext(){
            return curIndex < s.length();
        }
    }


    public static Double calculate(String eq) {
        Stack<Double> values = new Stack<>();
        Stack<Character> operators = new Stack<>();
        EquationParser parser = new EquationParser(eq);
        if(parser.hasNext()){
            values.push(parser.getNextVal());
        } else {
            return null;
        }

        while(parser.hasNext()) {
            char op = parser.getNextOperator();
            double secondVal = parser.getNextVal();

            if(opPriorityMap.get(op) == 1 ){
                //do operation and push res to operand stack
                double firstVal = values.pop();
                values.push(doAction(op, firstVal, secondVal));
            }
            else if(opPriorityMap.get(op) == 0){
                //wait with operation do operation and push res to operand stack
                operators.push(op);
                values.push(secondVal);
            }
        }

        while(!operators.isEmpty()){
            double firstVal = values.pop();
            double secVal = values.pop();
            char op = operators.pop();
            values.push(doAction(op, firstVal, secVal));
        }

        return values.pop();
    }


    private static Double doAction(char op, double firstVal, double secondVal){
        if(op == '+'){
            return firstVal+secondVal;
        }
        if(op == '*'){
            return firstVal*secondVal;
        }
        if(op == '-'){
            return secondVal-firstVal;
        }
        if(op == '/'){
            return firstVal/secondVal;
        }
        return null;
    }

    public static boolean patternMatching(String pattern, String value) {
        String a;
        String b;
        for(int aEnds = 1;  aEnds <= value.length() ; aEnds++) {
            for(int bStart = aEnds ; bStart <= value.length()  ; bStart++) {
                a = value.substring(0, aEnds);
                b = value.substring(bStart, value.length()); //must start with bStart and not aEnds e.g catcatgo - be doesn't start right after a ends.
                if(isAMatch(a, b, pattern, value)) {
                    System.out.println("string : " + value + " pattern : " + pattern + " found a match for a = " + (a.isEmpty() ? "\"\"" : a) + " and b = " + (b.isEmpty() ? "\"\"" : b));
                    return true;
                }
                if(isAMatch(b, a, pattern, value)) { //we can replace because we are looking to validate the pattern for two sub strings. a , b are just name.
                    System.out.println("string : " + value + " pattern : " + pattern + " found a match for a = " + (b.isEmpty() ? "\"\"" : b) + " and b = " + (a.isEmpty() ? "\"\"" : a));
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isAMatch(String a, String b, String pattern, String value) {
        if(a.isEmpty() && b.isEmpty()){
            return value.isEmpty();
        }

        int matchSize = 0;
        for(int i = 0 ; i < pattern.length() ; i++) {
            char cur = pattern.charAt(i);
            if(cur == 'a') {
                if(compareSubString(matchSize, value, a)){
                    matchSize += a.length();
                } else {
                    return false;
                }
            } else if(cur == 'b') {
                if(compareSubString(matchSize, value, b)){
                    matchSize += b.length();
                } else {
                    return false;
                }
            } else {
                //error - handle
            }
        }
        return matchSize == value.length();
    }

    private static boolean compareSubString(int inx, String value, String subString) {
        if(inx + subString.length() > value.length()){
            return false;
        }
        return value.substring(inx, inx + subString.length()).equals(subString);
    }

}
