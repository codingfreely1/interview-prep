package solutions;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yael on 11/01/17.
 */
public class InterviewQuestionsSolutions {

    //mh interview questions.
    /**
     * return formatted century String for given year.
     * Examples were given : input (2000) output (20th) ,  input (2012) output (21st)
     * @param yearStr
     * @return
     */
    public static String getFormattedCenturyString(String yearStr) {
        int year = Integer.valueOf(yearStr);
        int divider = (int) Math.pow(10,2);
        int century = year / divider;
        if(year % divider > 0){
            century +=1;
        }
        return String.valueOf(century) + getSuffixPerDigit(century%10); //I forgot the modulo in the actual interview.

    }

    private static Map<Integer,String> suffixPerDigit = new HashMap<>();
    static {
        suffixPerDigit.put(0,"th");
        suffixPerDigit.put(1,"st");
        suffixPerDigit.put(2,"nd");
        suffixPerDigit.put(3,"rd");
        suffixPerDigit.put(4,"th");
        suffixPerDigit.put(5,"th");
        suffixPerDigit.put(6,"th");
        suffixPerDigit.put(7,"th");
        suffixPerDigit.put(8,"th");
        suffixPerDigit.put(9,"th");
    }

    private static String getSuffixPerDigit(int digit){
        return suffixPerDigit.get(digit);
    }

    /**
     * The function should return lower case string with _ separator.
     * Examples: Test7Boo -> test7_boo, 1 -> 1 , SubString -> sub_string
     * @param str
     * @return
     */
    public static String toLowerCaseWithUnderscoreDelimiter(String str){
        //String[] subStrings = str.split("[A-Z]"); // the split removes the separator chars.
        String[] subStrings = str.split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])");//didn't get this regex in the interview obviously..
        StringBuilder sb = new StringBuilder();
        for(String s: subStrings){
            sb.append(s.toLowerCase()).append("_");
        }
        sb.replace(sb.length() -1, sb.length(), ""); //to remove the last "_";
        return sb.toString();
    }

    /**
     * The function should returns true if it finds a subset of the array the its sum equals the given sum.
     * Examples were given: [2, 9, 4, 7] sum = 15 should return true cause 2+9+4 = 15
     * @param arr
     * @param sum
     * @return
     */
    public static boolean isSubsetEqualsToSumExist(int[] arr, int sum){
        Assert.assertTrue(sum > 0);
        return subsetEqualsSumHelper(arr, sum, 0, 0); //I might have forgotten to write 'return' :/
    }

    public static boolean subsetEqualsSumHelper(int[] arr, int sum, int curSum, int curInx) {
        if(sum == curSum){
            return true;
        }

        if(curInx >= arr.length) {
            return false;
        }

        boolean isSubsetFound = subsetEqualsSumHelper(arr, sum, curSum + arr[curInx], curInx + 1);
        if(!isSubsetFound){
                isSubsetFound = subsetEqualsSumHelper(arr, sum, curSum, curInx + 1);//I might have forgotten the assignment and just called the function :/
        }
        return isSubsetFound;
    }
    //mh interview questions. - end

}