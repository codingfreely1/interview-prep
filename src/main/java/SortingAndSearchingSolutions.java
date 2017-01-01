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
    public static <T extends Comparable<T>> void mergeBIntoA (List<T> a, List<T> b) {
        int i = b.size() -1;
        int j = a.size() - b.size() -1;
        int k = a.size() -1;
        while(k >= 0) {
            if(i >= 0 && j >= 0){
                if(a.get(j).compareTo(b.get(i)) > 0){
                    a.set(k,a.get(j));
                    j--;
                } else {
                    a.set(k,b.get(i));
                    i--;
                }
            } else if (i>=0) {
                a.set(k,b.get(i));
                i--;
            } else if(j>=0){
                a.set(k,a.get(j));
                j--;
            }
            k--;
        }
    }
}
