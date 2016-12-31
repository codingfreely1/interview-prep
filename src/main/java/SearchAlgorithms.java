import java.util.List;

/**
 * Created by yael on 30/12/16.
 */
public class SearchAlgorithms {

    public static boolean binarySearch(List<Comparable> arr, Comparable c){
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

    public static int binarySearch(List<Comparable> arr, Comparable c, int start, int end){
        if(arr.isEmpty()) {
            return -1;
        }
        //size >= 1
        int midInx = start + (int) Math.floor(((end-start)-1)/2);
        if(arr.get(midInx).compareTo(c) < 0){
            return binarySearch(arr,c, midInx+1, end);
        } else if(arr.get(midInx).compareTo(c) > 0){
            return binarySearch(arr,c, start, midInx);
        } else {
            System.out.println("found it in inx : " + midInx);
            return midInx;
        }
    }
}
