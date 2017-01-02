import java.util.*;

/**
 * Created by yael on 31/12/16.
 */
public class SortingAlgorithms {

    //---- Bubble Sort----//
    public static <T extends Comparable<T>> void bubbleSort(List<T> arr) {
        int numIter = arr.size() -1;
        for (int i = numIter; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if(arr.get(j).compareTo(arr.get(j+1)) > 0) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    private static <T extends Comparable<T>> void swap(List<T> arr, int inx1, int inx2){
        T comparable = arr.get(inx1);
        arr.set(inx1, arr.get(inx2));
        arr.set(inx2, comparable);
    }

    //---- Merge Sort----//
    public static <T extends Comparable<T>> List<T> mergeSort(List<T> list) {
        if(list.isEmpty() || list.size() == 1){
            return list;
        }

        int mid = (list.size()-1) / 2;
        List<T> leftList = list.subList(0, mid + 1);
        List<T> rightList = list.subList(mid + 1, list.size());

        return merge(mergeSort(leftList), mergeSort(rightList));
    }

    public static <T extends Comparable<T>> List<T> merge(List<T> list1, List<T> list2) {
        int i= 0;
        int j = 0;

        List <T> res = new ArrayList<>(list1);

        while (j < res.size()) {
            while(i < list2.size() && res.get(j).compareTo(list2.get(i)) > 0 ) {
                res.add(j, list2.get(i));
                j++;
                i++;
            }
            if(i == list2.size()) {
                return res;
            }
            j++;
        }

        while (i < list2.size()) {
            res.add(list2.get(i));
            i++;
        }

        return res;
    }

    public static void mergeSort(int[] arr) {
        int[] helper = new int[arr.length];
        mergeSort(arr, helper, 0, arr.length -1);
    }

    private static void mergeSort(int[] arr, int[] helper, int low, int high) {
         if(low >= high) {
            return;
        }
        int mid = (low + high)/2;
        mergeSort(arr, helper, low, mid);
        mergeSort(arr, helper, mid+1, high);
        merge(arr, helper, low, mid , high);
    }

    private static void merge(int[] arr, int[] helper, int low, int mid, int high) {

        for (int i = low; i <= high ; i++) {
            helper[i] = arr[i];
        }

        int i = low;
        int j = low;
        int k = mid + 1;
        while (i <= high) {
            if(j <= mid & k <= high) {
                if(helper[j] < helper[k]) {
                    arr[i] = helper[j];
                    j++;
                } else {
                    arr[i] = helper[k];
                    k++;
                }
            } else if(j <= mid) {
                arr[i] = helper[j];
                j++;
            } else if(k <= high) {
                arr[i] = helper[k];
                k++;
            }
            i++;
        }
    }

    //---- Radix Sort----//
    public static void radixSort(List<Integer> list, int maxDigits) {
        Map<Integer, List<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < maxDigits; i++) {
            insert(list, i, hashMap);
            collect(list, hashMap);
        }
    }

    private static void insert(List<Integer> list, int position, Map<Integer, List<Integer>> map) {
        for (Integer i : list) {
            int digit = getDigitAtPosition(i, position);
            if(map.get(digit) == null) {
                map.put(digit, new ArrayList<>());
            }
            map.get(digit).add(i);
        }
    }

    private static void collect(List<Integer> list, Map<Integer, List<Integer>> map) {
        list.clear();
        for (int i = 0; i < 10; i++) {
            if(map.get(i) != null) {
                list.addAll(map.get(i));
            }
        }
        map.clear();
    }

    public static int getDigitAtPosition(int number, int position){
        return (int)(number/Math.pow(10, position))%10;
    }

    //---- Quick Sort----//
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int lowEnd = low;
        int j = low;
        int pivot = high;
        while (j < high) {
            if (arr[j] < arr[pivot]) {
                swap(arr, lowEnd, j);
                lowEnd++;
            }
            j++;
        }
        swap(arr, lowEnd, pivot);
        return lowEnd;
    }

    public static void swap(int[] arr, int inx1, int inx2) {
        if(inx1 != inx2 ) {
            arr[inx1] = arr[inx1] + arr[inx2];
            arr[inx2] = arr[inx1] - arr[inx2];
            arr[inx1] = arr[inx1] - arr[inx2];
        }
    }
}