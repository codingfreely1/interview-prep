package algorithms;

/**
 * Created by yael on 31/12/16.
 */
public class BitManipulation {

    public static int repeatedArithmeticShift(int x, int count) {
        for (int i = 0; i < count; i++) {
            x >>=1; //Arithmetic shift by 1
        }
        return x;
    }

    public static int repeatedLogicalShift(int x, int count) {
        for (int i = 0; i < count; i++) {
            x >>>=1; //Logical shift by 1
        }
        return x;
    }

    public static int getBit(int num, int i){
        int mask = (int)Math.pow(2, i);
        return (num & mask) >> i ;
    }

    public static boolean getBit_BookImplementation(int num, int i){
        return (num & (1 << i)) != 0;
    }

    public static int setBit(int num, int i){
        return (num | (1<<i));
    }

    public static int clearBit(int num, int i){
        return num & (~(1<<i));
    }

    public static int updateBit(int num, int i, boolean val ){
        int res = clearBit(num, i);
        int intVal = val ? 1 : 0 ;
        return res | (intVal << i);
    }
}
