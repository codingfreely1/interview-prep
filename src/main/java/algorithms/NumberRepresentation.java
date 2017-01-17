package algorithms;

import org.junit.Assert;

import java.security.InvalidParameterException;
import java.util.Arrays;

/**
 * Created by yael on 17/01/17.
 */
public class NumberRepresentation {

    private final static int ASCII_DIFF_CHAR_BASE_16 = 55;

    static String convertDecimalToBase(int base, int decimal) {
        Assert.assertTrue(decimal >= 0);
        if(decimal == 0){
            return "0";
        }
        int intVal = decimal;
        int res;

        StringBuilder sb = new StringBuilder();
        while (intVal > 0) {
            //first calc res then change intVal.
            res = intVal % base;
            intVal = intVal/base;
            sb.append(convertBaseValToString(base,res));
        }
        return sb.reverse().toString();
    }

    private static String convertBaseValToString(int base, int val){
        if(val >= base){
            throw new InvalidParameterException("all values should be smaller than base value");
        }
        if(base == 16 && (val >=10 && val <= 15)) {
            char c = (char)(val + ASCII_DIFF_CHAR_BASE_16);
            return String.valueOf(c);//returns one of 'A'-'F'
        }
        return String.valueOf(val);
    }

    private static int charToInt(char c){
        if(c>= '0' && c<='9'){
            return (int) c -'0';
        } else if(c>= 'A' && c<='F'){
            return c - ASCII_DIFF_CHAR_BASE_16;
        }
        throw new InvalidParameterException("unsupported char");
    }

    static int fromBaseToDecimal(String strRep, int base) {
        int res = 0;
        int basePower = 1;
        for(int i = strRep.length() -1 ; i >=0; i--) {
            int val = charToInt(strRep.charAt(i));
            res += val*basePower;
            basePower = basePower * base;
        }
        return res;
    }

    static int convertTwsComplementToDecimal(String twosComp) {

        boolean negative = twosComp.charAt(0) == '1';
        StringBuilder sb = new StringBuilder();
        boolean res = false;
        String strToConvert = twosComp.substring(1,twosComp.length());

        //step 1: negating all bits. step 2: adding one.
        //This loop does both steps - already taking the plus one into account.
        if(negative) {
            for(int i = twosComp.length() -1 ; i > 0; i--) {
                char cur = twosComp.charAt(i);
                    if(res ||  i == twosComp.length()-1){
                        sb.append(String.valueOf(cur));
                        if(cur == '0'){
                            res = true;
                        } else {
                            res = false;
                        }
                    } else{
                        sb.append(cur == '0' ? "1": "0");
                    }
            }
            strToConvert = res ? sb.append("1").reverse().toString() : sb.reverse().toString();
        }
        return fromBaseToDecimal(strToConvert, 2) * (negative ? -1:1);
    }

    static String convertDecimalToTwosComplement(int decimal, int numBits) {
        int powerBits = (int)Math.pow(2,numBits);
        int maxValid = powerBits -1;
        int minValid = -1* powerBits;
        if(decimal < minValid || decimal > maxValid) {
            throw new InvalidParameterException("decimal is out of valid range.");
        }
        int decimalValueToConvert;
        if(decimal >= 0) {
            decimalValueToConvert = decimal;
        } else{
            decimalValueToConvert = powerBits - Math.abs(decimal);
        }
        String converted = convertDecimalToBase(2, decimalValueToConvert);
        int padZeros = numBits - converted.length();
        char[] zeros = new char[padZeros];
        Arrays.fill(zeros, '0');
        return new String(zeros) + converted;
    }
}
