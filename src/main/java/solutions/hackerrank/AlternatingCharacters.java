package solutions.hackerrank;

import java.util.Scanner;

/**
 * Created by yael on 31/01/17.
 * Solution for https://www.hackerrank.com/challenges/alternating-characters
 */
public class AlternatingCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numStrings = Integer.valueOf(sc.nextLine());
        for(int i = 0; i < numStrings ;i++) {
            System.out.println(numCharToDelete(sc.nextLine()));
        }
    }

    private static int numCharToDelete(String s){
        int count = 0;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i-1) == s.charAt(i)) {
                count += 1;
            }
        }
        return count;
    }
}
