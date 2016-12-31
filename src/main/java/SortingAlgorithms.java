import java.util.List;

/**
 * Created by yael on 31/12/16.
 */
public class SortingAlgorithms {

    public static void bubbleSort(List<Comparable> arr) {
        int numIter = arr.size() -1;
        for (int i = numIter; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if(arr.get(j).compareTo(arr.get(j+1)) > 0) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    private static void swap(List<Comparable> arr, int inx1, int inx2){
        Comparable comparable = arr.get(inx1);
        arr.set(inx1, arr.get(inx2));
        arr.set(inx2, comparable);
    }

}
