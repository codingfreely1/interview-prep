import java.util.List;

/**
 * Created by yael on 30/12/16.
 */
public class SearchAlgorithms {

    public static <T extends Comparable<T>> boolean binarySearch(List<T> arr, T c){
        if(arr.isEmpty()) {
            return false;
        }
        //size >= 1
        int midInx = (int) Math.floor((arr.size()-1)/2);
        if(arr.get(midInx).compareTo(c) < 0){
            return binarySearch(arr.subList(midInx+1, arr.size()),c);
        } else if(arr.get(midInx).compareTo(c) > 0){
            return binarySearch(arr.subList(0,midInx),c);
        } else {
            System.out.println("found it");
            return true;
        }
    }

    public static <T extends Comparable<T>> int binarySearch(List<T> arr, T c, int start, int end){
        if(arr.isEmpty()) {
            return -1;
        }
        //size >= 1
        int midInx = start + (((end-start)-1)/2);
        if(arr.get(midInx).compareTo(c) < 0){
            return binarySearch(arr,c, midInx+1, end);
        } else if(arr.get(midInx).compareTo(c) > 0){
            return binarySearch(arr,c, start, midInx);
        } else {
            System.out.println("found it in inx : " + midInx);
            return midInx;
        }
    }

    public static int binarySearch(int[] arr, int val) {
        int mid, cur;
        int start = 0;
        int end = arr.length;

        while((end-start) >= 1) {
            mid = ((end - start) / 2) + start;
            cur = arr[mid];
            if(cur == val) {
                return mid;
            } else if (cur > val) {
                end = mid;
            } else { //cur < val
                start = mid + 1;
            }
        }

        return -1;//not found.
    }
}
