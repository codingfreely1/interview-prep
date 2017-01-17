package solutions.hackerrank;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by yael on 17/01/17.
 * Solving hackerrank challenge.  https://www.hackerrank.com/challenges/jesse-and-cookies
 */
public class JesseAndCookies {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner sc = new Scanner(System.in);

        String[] firstLine = sc.nextLine().split(" ");
        int n = Integer.valueOf(firstLine[0]);
        int k = Integer.valueOf(firstLine[1]);
        String[] secondLine = sc.nextLine().split(" ");
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(int i = 0; i< secondLine.length ; i++ ){
            int cur = Integer.valueOf(secondLine[i]);
            priorityQueue.add(cur);
        }

        int steps = 0;
        while(priorityQueue.peek() < k && priorityQueue.size() >= 2){
            int newCookie = priorityQueue.poll() + 2 * priorityQueue.poll();
            priorityQueue.add(newCookie);
            steps++;
        }
        System.out.println(priorityQueue.isEmpty() ? -1 : priorityQueue.peek() < k ? -1 : steps);
    }
}