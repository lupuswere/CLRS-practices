package net.lilifei.basic;

import net.lilifei.dataStructure.Heap;
import net.lilifei.dataStructure.LinkedListNode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Lifei on 15/5/5.
 */
public class Sort {
    /**
     * 2.1 : Insert Sort
     *
     * @param A : the array of Integer that is to be sorted
     */
    public static void insertSort(int[] A) {
        if (A == null || A.length < 2) {
            return;
        }
        for (int j = 1; j < A.length; j++) {
            int key = A[j];
            int i = j - 1;
            while (i >= 0 && A[i] > key) {
                A[i + 1] = A[i];
                i--;
            }
            A[i + 1] = key;
        }
    }

    /**
     * 2.1-2 : Insert Sort (Descending Order)
     *
     * @param A : the array of Integer that is to be sorted
     */
    public static void insertSortDescending(int[] A) {
        if (A == null || A.length < 2) {
            return;
        }
        for (int j = 0; j < A.length; j++) {
            int key = A[j];
            int i = j - 1;
            while (i >= 0 && A[i] < key) {
                A[i + 1] = A[i];
                i--;
            }
            A[i + 1] = key;
        }
    }

    /**
     * 2.3.1 : Merge Sort
     *
     * @param A : the array of Integer that is to be sorted
     */
    public static void mergeSort(int[] A) {
        mergeSort(A, 0, A.length - 1);
    }

    /**
     * The private function wrapped up by Merge Sort
     *
     * @param A : the array of Integer that is to be sorted
     * @param p : the start index of the array
     * @param r : the end index of the array
     */
    private static void mergeSort(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(A, p, q);
            mergeSort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    /**
     * The merge process function
     *
     * @param A : the array of Integer that is to be sorted
     * @param p : the start index of the array
     * @param q : the divide index of the array
     * @param r : the end index of the array
     */
    private static void merge(int[] A, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];
        for (int i = 0; i < n1; i++) {
            L[i] = A[p + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = A[q + j + 1];
        }
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        for (int k = p; k <= r; k++) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
        }
    }

    /**
     * 2.3-2 Merge Sort Without Using Sentinels
     *
     * @param A : the array of Integer that is to be sorted
     */
    public static void mergeSortWithoutSentinels(int[] A) {
        mergeSortWithoutSentinels(A, 0, A.length - 1);
    }

    /**
     * The private function wrapped up by Merge Sort Without Using Sentinels
     *
     * @param A : the array of Integer that is to be sorted
     * @param p : the start index of the array
     * @param r : the end index of the array
     */
    private static void mergeSortWithoutSentinels(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSortWithoutSentinels(A, p, q);
            mergeSortWithoutSentinels(A, q + 1, r);
            mergeWithoutSentinels(A, p, q, r);
        }
    }

    /**
     * The merge process function without using sentinels
     *
     * @param A : the array of Integer that is to be sorted
     * @param p : the start index of the array
     * @param q : the divide index of the array
     * @param r : the end index of the array
     */
    private static void mergeWithoutSentinels(int[] A, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = A[p + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = A[q + j + 1];
        }
        int i = 0;
        int j = 0;
        for (int k = p; k <= r; k++) {
            if (i >= n1) {
                while (j < n2) {
                    A[k] = R[j];
                    j++;
                    k++;
                }
                break;
            } else if (j >= n2) {
                while (i < n1) {
                    A[k] = L[i];
                    i++;
                    k++;
                }
                break;
            }
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
        }
    }

    /**
     * Insert Sort Recursive Version
     *
     * @param A : the array of Integer that is to be sorted
     */
    public static void insertSortRecursive(int[] A) {
        insertSortRecursive(A, A.length - 1);
    }

    /**
     * Helper function of insertSortRecursive
     *
     * @param A   : the array of Integer that is to be sorted
     * @param end : end index of unsorted part
     */
    private static void insertSortRecursive(int[] A, int end) {
        if (end <= 0) {
            return;
        }
        insertSortRecursive(A, end - 1);
        int i = end - 1;
        int key = A[end];
        while (i >= 0 && A[i] > key) {
            A[i + 1] = A[i];
            i--;
        }
        A[i + 1] = key;
    }

    /**
     * 2.3-7 : Two Sum
     *
     * @param A      : the set of Integer
     * @param target : the sum of two Integers
     * @return : whether there are two Integers whose sum is the target
     */
    public static boolean twoSum(int[] A, int target) {
        if (A == null || A.length == 0) {
            return false;
        }
        Arrays.sort(A); // O(nlogn)
        int start = 0;
        int end = A.length - 1;
        while (start < end) {
            int sum = A[start] + A[end];
            if (sum > target) {
                end--;
            } else if (sum < target) {
                start++;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 2-4 : Inversion
     *
     * @param A : an array of Integers
     * @return : the count of inversions in the array
     */
    public static int countOfInversions(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int[] B = Arrays.copyOf(A, A.length);
        return countOfInversions(B, 0, B.length - 1);
    }

    /**
     * Helper function of countOfInversions
     *
     * @param A : an array of Integers
     * @param p : the start index of the part to be counted
     * @param r : the end index of the part to be counted
     * @return : the count of inversions in the part
     */
    private static int countOfInversions(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            int left = countOfInversions(A, p, q);
            int right = countOfInversions(A, q + 1, r);
            int merge = mergeCounts(A, p, q, r);
            return left + right + merge;
        } else {
            return 0;
        }
    }

    private static int mergeCounts(int[] A, int p, int q, int r) {
        int count = 0;
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];
        for (int i = 0; i < n1; i++) {
            L[i] = A[p + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = A[q + j + 1];
        }
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        for (int k = p; k <= r; k++) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
                count += n1 - i;
            }
        }
        return count;
    }

    /**
     * 6.4 : Heap Sort
     *
     * @param A : the array of Integer that is to be sorted
     */
    public static void heapSort(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        int lenA = A.length;
        Heap.buildMaxHeap(A);
        int heapSize = lenA;
        for (int i = lenA - 1; i >= 1; i--) {
            int tmp = A[0];
            A[0] = A[i];
            A[i] = tmp;
            heapSize--;
            Heap.maxHeapify(A, 0, heapSize);
        }
    }

    /**
     * 6.5-8 : MERGE K SORTED LISTS
     *
     * @param lists : the list of k sorted lists
     * @return : the head of the new list
     */
    public static LinkedListNode mergeKSortedLists(LinkedListNode[] lists) throws Exception {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int k = lists.length;
        LinkedListNode[] heap = new LinkedListNode[k];
        for (int i = 0; i < k; i++) {
            heap[i] = lists[i];
        }
        Heap.buildMinHeap(heap);
        int heapSize = k;
        LinkedListNode head = null;
        LinkedListNode cur = head;
        while (heapSize > 0) {
            LinkedListNode newNode = Heap.heapExtractMin(heap, heapSize);
            heapSize--;
            LinkedListNode newList = newNode.next;
            newNode.next = null;
            if (cur == null) {
                head = newNode;
                cur = head;
            } else {
                cur.next = newNode;
                cur = cur.next;
            }
            if (newList != null) {
                Heap.minHeapInsert(heap, newList, heapSize);
                heapSize++;
            }
        }
        return head;
    }

    /**
     * 7.1 : QUICKSORT
     *
     * @param A : the array of Integer that is to be sorted
     */
    public static void quickSort(int[] A) {
        quickSort(A, 0, A.length - 1);
    }

    /**
     * 7.1 : QUICKSORT
     *
     * @param A : the array of Integer that is to be sorted
     * @param p : start index
     * @param r : end index
     */
    public static void quickSort(int[] A, int p, int r) {
        if (p < r) {
            int q = partition(A, p, r);
            quickSort(A, p, q - 1);
            quickSort(A, q + 1, r);
        }
    }

    /**
     * 7.1 : PARTITION
     *
     * @param A : the array of Integer that is to be sorted
     * @param p : start index
     * @param r : end index
     * @return : partition index
     */
    private static int partition(int[] A, int p, int r) {
        int x = A[r];
        int i = p - 1; //i is the end index of the small area
        for (int j = p; j <= (r - 1); j++) {
            if (A[j] <= x) {
                i++;
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
        int tmp = A[i + 1];
        A[i + 1] = A[r];
        A[r] = tmp;
        return i + 1;
    }

    /**
     * 7.1-2 : PARTITION-NEW
     *
     * @param A : the array of Integer that is to be sorted
     * @param p : start index
     * @param r : end index
     * @return : partition index
     */
    private static int partitionNew(int[] A, int p, int r) {
        int x = A[r];
        int i = p - 1; //i is the end index of the small area
        boolean identical = true;
        for (int j = p; j <= (r - 1); j++) {
            if (identical && x != A[j]) {
                identical = false;
            }
            if (A[j] < x) {
                i++;
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
        int tmp = A[i + 1];
        A[i + 1] = A[r];
        A[r] = tmp;
        if (identical) {
            return (p + r) / 2;
        }
        return i + 1;
    }

    /**
     * 7.3 : RANDOMIZED-QUICKSORT
     *
     * @param A : the array of Integer that is to be sorted
     */
    public static void randomizedQuickSort(int[] A) {
        randomizedQuickSort(A, 0, A.length - 1);
    }

    /**
     * 7.3 : RANDOMIZED-QUICKSORT
     *
     * @param A : the array of Integer that is to be sorted
     * @param p : the start index
     * @param r : the end index
     */
    public static void randomizedQuickSort(int[] A, int p, int r) {
        if (p < r) {
            int q = randomizedPartition(A, p, r);
            randomizedQuickSort(A, p, q - 1);
            randomizedQuickSort(A, q + 1, r);
        }
    }

    /**
     * 7.3 : RANDOMIZED-PARTITION
     *
     * @param A : the array of Integer that is to be sorted
     * @param p : the start index
     * @param r : the end index
     * @return : the index of partition
     */
    private static int randomizedPartition(int[] A, int p, int r) {
        Random rd = new Random();
        int i = rd.nextInt(r - p + 1) + p;
        int tmp = A[i];
        A[i] = A[r];
        A[r] = tmp;
        return partition(A, p, r);
    }

    /**
     * 7-1 : HOARE-PARTITION
     *
     * @param A : the original array
     * @param p : the start index
     * @param r : the end index
     * @return : the partition index
     */
    public static int hoarePartition(int[] A, int p, int r) {
        int x = A[p];
        int i = p - 1;
        int j = r + 1;
        while (true) {
            do {
                j--;
            } while (A[j] > x);
            do {
                i++;
            } while (A[i] < x);
            if (i < j) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            } else {
                return j;
            }
        }
    }

    /**
     * 7-3 Stooge Sort
     *
     * @param A : the original array
     */
    public static void stoogeSort(int[] A) {
        stoogeSort(A, 0, A.length - 1);
    }

    /**
     * 7-3 Stooge Sort
     *
     * @param A : the original array
     * @param i : the start index
     * @param j : the end index
     */
    public static void stoogeSort(int[] A, int i, int j) {
        if (A[i] > A[j]) {
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }
        if ((i + 1) >= j) {
            return;
        }
        int k = (j - i + 1) / 3;
        stoogeSort(A, i, j - k);
        stoogeSort(A, i + k, j);
        stoogeSort(A, i, j - k);
    }

    /**
     * 7-4 : QUICKSORT', used tail recursion to use constant space on stack
     *
     * @param A : the original array
     */
    public static void quickSortTailRecursion(int[] A) {
        quickSortTailRecursion(A, 0, A.length - 1);
    }

    /**
     * 7-4 : QUICKSORT', used tail recursion to use constant space on stack
     *
     * @param A : the original array
     * @param p : the start index
     * @param r : the end index
     */
    public static void quickSortTailRecursion(int[] A, int p, int r) {
        while (p < r) {
            int q = partition(A, p, r);
            quickSortTailRecursion(A, p, q - 1);
            p = q + 1;
        }
    }

    /**
     * 7-6 a) : FUZZY SORT
     *
     * @param I : the array of Intervals
     * Reference : http://www.fongboy.com/classes/cs180/hw3-sol.pdf
     */
    public static void fuzzySort(Interval[] I) {
        fuzzySort(I, 0, I.length - 1);
    }

    public static void fuzzySort(Interval[] I, int p, int r) {
        if (p < r) {
            Interval q = fuzzyPartition(I, p, r);
            fuzzySort(I, p, q.getLeft());
            fuzzySort(I, q.getRight(), r);
        }
    }

    private static Interval fuzzyPartition(Interval[] I, int p, int r) {
        int x = I[r].getLeft();
        int i = p - 1;
        for (int j = p; j <= (r - 1); j++) {
            if (I[j].getLeft() <= x) {
                i++;
                Interval tmp = I[i];
                I[i] = I[j];
                I[j] = tmp;
            }
        }
        Interval tmp = I[i + 1];
        I[i + 1] = I[r];
        I[r] = tmp;
        int q = p - 1;
        for (int k = p; k <= i; k++) {
            if (I[k].getRight() >= x) {
                q++;
                Interval tmp2 = I[k];
                I[k] = I[q];
                I[q] = tmp2;
            }
        }
        for (int l = p; l <= q; l++) {
            Interval tmp3 = I[l];
            I[l] = I[i - l + p];
            I[i - l + p] = tmp3;
        }
        return new Interval(i - q + p - 1, i + 2);
    }
    //Killer adversary : always find minimum in the partition
}
