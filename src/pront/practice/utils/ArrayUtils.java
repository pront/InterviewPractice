package pront.practice.utils;

import java.util.*;

/**
 * Created by prontidis on 30/06/2014.
 */
public class ArrayUtils {

    public static void main(String[] args) {
//        int[] b = genSortedArray(10);
//        int[] a = genSortedArray(15, b.length);
//        a = mergeArrays(a, b, 15);
//        System.out.println("a:" + Arrays.toString(a));

//        String[] strings = {};
//        Arrays.sort(strings, new AnagramComparator());

//        int max = 14;
//        int a[] = genArray(10, 0, max);
//        System.out.println(Arrays.toString(a));
//        System.out.println("firstMissing using HashMap: " + firstMissingWithHash(a, max));
//        System.out.println("firstMissing using Array: " + firstMissingWithArr(a, max));
//        System.out.println("firstUnique by index: " + firstUniquebyIndex(a));
//        System.out.println("firstUnique by value: " + firstUniqueByValue(a));

//        fibonacciSeries(max);
//        System.out.println();
//        for (int i = 0; i < max; i++) System.out.print(fibRecursive(i) + " ");

//        findLargest(a, 4);
//
//        lexicographicNumbers(111, 1);

        int arr[] = {0 , 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 19, 18, 17, 16, 15};
        printUniquePairsSumBruteForce(arr, 10);
        printUniquePairsSumBSearch(arr, 10);
        printUniquePairsSumLinear(arr, 10);
    }

    public static int[] genArray(int size, int min, int max) {
        Random rand = new Random();
        int arr[] = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = rand.nextInt((max - min) + 1) + min;
        return arr;
    }

    public static int[] genSortedArray(int size) {
        Random rand = new Random();

        int min = 0;
        int max = 30;

        int arr[] = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = rand.nextInt((max - min) + 1) + min;
        Arrays.sort(arr);
        return arr;
    }

    public static int[] genSortedArray(int size, int padding) {
        Random rand = new Random();

        int min = 0;
        int max = 30;

        int arr[] = new int[size + padding];
        for (int i = 0; i < size; i++)
            arr[i] = rand.nextInt((max - min) + 1) + min;
        Arrays.sort(arr);

        for (int i = size; i < size + padding; i++)
            arr[i] = Integer.MAX_VALUE;

        return arr;
    }

    /**
     * @parameter lastA indicated the last valid element of A
     */
    public static int[] mergeArrays(int a[], int b[], int lastA) {
        System.out.println("a:" + Arrays.toString(a));
        System.out.println("b:" + Arrays.toString(b));

        int indexA = lastA - 1;
        int indexB = b.length - 1;
        int mergedIdx = a.length - 1;

        while (indexA >= 0 && indexB >= 0) {
            if (a[indexA] < b[indexB]) {
                a[mergedIdx] = b[indexB];
                indexB--;
            } else {
                a[mergedIdx] = a[indexA];
                indexA--;
            }
            mergedIdx--;
        }

        while (indexB >= 0) {
            a[mergedIdx] = b[indexB];
            mergedIdx--;
            indexB--;
        }

        return a;
    }


    public static class AnagramComparator implements Comparator<String> {

        @Override
        public int compare(String str1, String str2) {
            return StringUtils.sort(str1).compareTo(StringUtils.sort(str2));

        }

    }

    public static Integer firstUniquebyIndex(int arr[]) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int curr : arr) {
            Integer count = map.get(curr);
            map.put(curr, (count != null) ? count++ : 1);
        }

        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == 1)
                return arr[i];
        }
        return null;
    }

    public static Integer firstUniqueByValue(int arr[]) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int curr : arr) {
            Integer count = map.get(curr);
            map.put(curr, (count != null) ? ++count : 1);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (map.get(arr[i]) < min && map.get(arr[i]) == 1)
                min = arr[i];
        }
        return min;
    }


    public static Integer firstMissingWithHash(int arr[], int max) {
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for (int i : arr) map.put(i, true);

        for (int i = 0; i < max; i++) {
            if (map.get(i) == null)
                return i;
        }
        return null;
    }

    public static Integer firstMissingWithArr(int arr[], int max) {
        boolean[] hashMap = new boolean[max + 1];

        for (int i = 0; i < hashMap.length; i++) hashMap[i] = false;
        for (int curr : arr) hashMap[curr] = true;

        for (int i = 0; i < max; i++) {
            if (hashMap[i] == false)
                return i;
        }
        return null;
    }

    public static void fibonacciSeries(int maxElements) {
        int arr[] = new int[maxElements];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }

        for (int i : arr) System.out.print(i + " ");
    }

    public static int fibRecursive(int n) {
        if (n == 0 || n == 1) return n;
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    public static void findLargest(int arr[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                pq.add(arr[i]);
            } else {
                if (arr[i] > pq.peek()) {
                    pq.poll();
                    pq.add(arr[i]);
                }
            }
        }
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    public static void lexicographicNumbers(int N, int k) {
        if (k > N) {
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (k <= N) {
                System.out.println(k);

                k *= 10;
                lexicographicNumbers(N, k);
                k /= 10;
                k++;
                if (k % 10 == 0) return;
            }
        }
    }

    public static void printUniquePairsSumBruteForce(int arr[], int K) {
        System.out.println("============================================");
        for (int i = 0; i < arr.length; ++i) { // O(N^2 / 2) --> O( N^2 )
            for (int j = i + 1; j < arr.length; ++j) {
                if(arr[i] + arr[j] == K) {
                    System.out.print("(" + i + "," + j + ")  ");
                }
            }
        }
        System.out.println();
    }

    public static void printUniquePairsSumBSearch(int arr[], int K) {
        System.out.println("============================================");
        Arrays.sort(arr); // O( Nlog(N) )

        for (int i = 0; i < arr.length; ++i) { // O( Nlog(N) )
            int idx = Arrays.binarySearch(arr, K - arr[i]);
            if(idx >= 0 && idx != i) {
                System.out.print("(" + i + "," + idx + ")  ");
            }
        }
        System.out.println();
    }

    public static void printUniquePairsSumLinear(int arr[], int k){
        System.out.println("============================================");
        Map<Integer, Integer> pairs = new HashMap<Integer, Integer>();

        for(int i=0;i<arr.length;i++){

            if(pairs.containsKey(arr[i])) {
                System.out.print("(" + arr[i] + "," + pairs.get(arr[i]) + ")  ");
            }
            else {
                pairs.put(k - arr[i], arr[i]);
            }
        }
        System.out.println();
    }
}
