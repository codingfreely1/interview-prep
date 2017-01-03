package solutions;

import algorithms.SearchAlgorithms;
import datastructures.Listy;
import jdk.nashorn.internal.runtime.BitVector;

import java.util.List;

/**
 * Created by yael on 01/01/17.
 */
public class SortingAndSearchingSolutions {

    /**
     * 10.1 Sorted Merge. (page 149)
     * @param a
     * @param b
     * @param <T>
     */
    public static <T extends Comparable<T>> void mergeBIntoA(List<T> a, List<T> b) {
        int i = b.size() -1;
        int j = a.size() - b.size() -1;
        int k = a.size() -1;
        while(i >= 0) {
            if( a.get(j).compareTo(b.get(i)) > 0 ){
                a.set(k, a.get(j));
                j--;
            } else {
                a.set(k, b.get(i));
                i--;
            }
            k--;
        }

    }

    public static void mergeBIntoA(int[] a, int[] b){
        int bInx = b.length - 1;
        int aInx = a.length - b.length -1;
        int aCurInx = a.length -1;

        while(bInx >= 0){
            if(a[aInx] > b[bInx]) {
                a[aCurInx] = a[aInx];
                aInx--;
            } else {
                a[aCurInx] = b[bInx];
                bInx--;
            }
            aCurInx--;
        }
    }

    /**
     * 10.8 Find Duplicates. (page 151)
     * @param arr
     */
    public static void findDuplicates(int[] arr){
        BitVector bitVector = new BitVector(32000);
        for (int i = 0; i < arr.length; i++) {
            if(bitVector.isSet(arr[i]-1)){
                System.out.println(arr[i] + " is duplicate");
            } else {
                bitVector.set(arr[i]-1);
            }
        }
    }

    /**
     * 10.4 Sorted Search, No Size. (page 150)
     * @param positiveAndSortedList
     * @param x
     * @return
     */
    public static int sortedSearchNoSize(Listy positiveAndSortedList, int x){
        int limit = 0;
        int i = 0;
        while(positiveAndSortedList.elementAt(limit) != -1 && positiveAndSortedList.elementAt(i) < x) {
            limit = (int) Math.pow(2,i);
            i++;
        }
        System.out.println("calling binary search with limit " + limit);
        return SearchAlgorithms.binarySearch(positiveAndSortedList.getArrayList(), x, 0, limit);
    }
}
