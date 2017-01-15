package solutions;

import java.util.Scanner;

/**
 * Created by yael on 15/01/17.
 */
public class MathSolutions {

    /**
     * calculating number of possible handshakes between n people.
     * We could just call calcNchooseK(n,2) but this is more efficient. Since n choose k can be pretty expensive.
     * It caused a runtime error when running the tests. ( https://www.hackerrank.com/challenges/handshake )
     * @param n
     * @return
     */
    public static int numberOfHandShakes(int n){
        return n > 0 ? (n*(n-1))/2 : 0;
    }

    public static void main(String[] args){
        calcNumberRoutes();
    }

    /**
     * Trick here was that (a*b) % m = (a % m) * (b % m)
     * https://www.hackerrank.com/challenges/connecting-towns
     * Gandalf is travelling from Rohan to Rivendell to meet Frodo but there is no direct route from Rohan (T1) to Rivendell (Tn).
     * But there are towns T2,T3,T4...Tn-1 such that there are N1 routes from Town T1 to T2, and in general, Ni routes from Ti to Ti+1 for i=1 to n-1 and 0 routes for any other Ti to Tj for j ≠ i+1
     * Find the total number of routes Gandalf can take to reach Rivendell from Rohan.
     */
    private static void calcNumberRoutes(){
        Scanner sc = new Scanner(System.in);
        int numberOfTestCase = Integer.parseInt(sc.nextLine());
        int i = 0;
        int mod = 1234567;
        while (i < numberOfTestCase){
            String s = sc.nextLine();
            int numberOfTowns = Integer.valueOf(s);
            String s2 = sc.nextLine();
            String[] arr = s2.split(" ");

            int numberOfChoices = 1;
            for(int j = 0; j < numberOfTowns-1; j++){
                numberOfChoices = (numberOfChoices % mod) * (Integer.valueOf(arr[j])% mod);
            }
            System.out.println(numberOfChoices% mod);
            i++;
        }
    }

}
