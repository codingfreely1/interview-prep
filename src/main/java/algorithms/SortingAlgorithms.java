package algorithms;

import util.Utils;

import java.util.*;
import java.util.stream.IntStream;

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

    public static void insertionSort(int[] arr) {
        for (int i = 1 ; i< arr.length; i++){
            int curVal = arr[i];
            int k = i;
            while( (k > 0)  && ( arr[k-1] > curVal) ) {
                arr[k] = arr[--k];//Important : first subtract then use k.
            }
            arr[k] = curVal;
        }
    }

    public static void insertionSort(List<Integer> arr) {
        for (int i = 1 ; i< arr.size(); i++){
            int curVal = arr.get(i);
            int k = i;
            while( (k > 0)  && ( arr.get(k-1) > curVal) ) {
                arr.set(k, arr.get(--k));//Important : first subtract then use k.
            }
            arr.set(k, curVal);
        }
    }

    public static void bucketSort(List<Integer> list){
        final int numBuckets = 5;
        int max = list.stream().max(Integer::compareTo).orElse(list.size());
        int min = list.stream().min(Integer::compareTo).orElse(0);
        int rangePerBucket = ((max - min) / numBuckets) + 1;
        Map<Integer, List<Integer>> buckets = new HashMap<>();

        insertIntoBuckets(list, buckets, rangePerBucket, min);
        sortAndCollect(buckets, numBuckets, list);
    }

    private static void printBuckets(String header, Map<Integer, List<Integer>> buckets, int numBuckets) {
        System.out.println(header);
        IntStream.range(0,numBuckets).forEach(i -> {if(buckets.get(i) != null) {
            System.out.println("bucket #" + i + ": " +Utils.listWithCommaSeparator(buckets.get(i)));
        }});
    }

    private static void insertIntoBuckets(List<Integer> arr, Map<Integer, List<Integer>> buckets, int range, int min){
        for(int i = 0 ; i< arr.size() ; i++) {
            int bucketKey = (arr.get(i) - min) / range;
            if(buckets.get(bucketKey) == null){
                buckets.put(bucketKey, new ArrayList<>());
            }
            buckets.get(bucketKey).add(arr.get(i));
        }
    }

    private static void sortAndCollect(Map<Integer, List<Integer>> buckets, int numBuckets, List<Integer> list){
        list.clear();
        printBuckets("before sorting", buckets, numBuckets);
        for(int i = 0 ; i< numBuckets; i++) {
            List<Integer> listInBucket = buckets.get(i);
            if(listInBucket != null){
                insertionSort(list);
                list.addAll(listInBucket);
            }
        }
        printBuckets("after sorting", buckets, numBuckets);
    }

    public static void quickSortBook(int[] arr, int left, int right) {
        int index = partitionBook(arr, left, right);
        if(left < index-1) {
            quickSortBook(arr, left,index -1);
        }
        if(index < right) {
            quickSortBook(arr, index, right);
        }
    }

    private static int partitionBook(int[] arr, int left, int right) {
        int start = left;
        int end = right;
        int pivot = arr[(left+right)/2];

        System.out.println("left: " + left + " right: " + right);
        IntStream.rangeClosed(left,right).forEach(i -> System.out.print((arr[i] +",")));
        System.out.println("\npivot " + pivot);

        while(left <= right){
           while(arr[left] < pivot){
               left++;
           }
           while(arr[right] > pivot){
               right--;
           }

           if(left<=right){
               swap(arr, left, right);
               left++;
               right--;
           }
       }
        System.out.println("returning " + left);
        IntStream.rangeClosed(start,end).forEach(i -> System.out.print((arr[i] +",")));
        System.out.println();
        IntStream.range(0,10).forEach(i -> System.out.print((arr[i] +",")));
        System.out.print("\n\n");

        return left;
    }
}