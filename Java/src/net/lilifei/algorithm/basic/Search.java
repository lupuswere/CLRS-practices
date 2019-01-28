package net.lilifei.algorithm.basic;

import net.lilifei.algorithm.random.RandomAlgorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Lifei on 15/5/7.
 */
public class Search {
    /**
     * 2.3-5 Binary Search in Sorted Array
     *
     * @param A         : a sorted array
     * @param target    : the integer to be searched for
     * @param recursive : true, use the recursive version; false, use the iterative version
     * @return : the index of the target, if not in the array, return -1
     */
    public static int binarySearch(int[] A, int target, boolean recursive) {
        if (recursive) {
            return binarySearchRecursive(A, target);
        } else {
            return binarySearchIterative(A, target);
        }
    }

    /**
     * Iterative Version of Binary Search in Sorted Array
     *
     * @param A      : a sorted array
     * @param target : the integer to be searched for
     * @return : the index of the target, if not in the array, return -1
     */
    private static int binarySearchIterative(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (target > A[middle]) {
                start = middle + 1;
            } else if (target < A[middle]) {
                end = middle - 1;
            } else {
                return middle;
            }
        }
        ;
        return -1;
    }

    /**
     * Recursive Version of Binary Search in Sorted Array
     *
     * @param A      : a sorted array
     * @param target : the integer to be searched for
     * @return : the index of the target, if not in the array, return -1
     */
    private static int binarySearchRecursive(int[] A, int target) {
        return binarySearchRecursive(A, target, 0, A.length - 1);
    }

    /**
     * Helper function of binarySearchRecursive
     *
     * @param A      : a sorted array
     * @param target : the integer to be searched for
     * @param start  : the start index of the searching part
     * @param end    : the start index of the searching part
     * @return : the index of the target, if not in the array, return -1
     */
    private static int binarySearchRecursive(int[] A, int target, int start, int end) {
        if (start <= end) {
            int middle = (start + end) / 2;
            if (target > A[middle]) {
                return binarySearchRecursive(A, target, middle + 1, end);
            } else if (target < A[middle]) {
                return binarySearchRecursive(A, target, start, middle - 1);
            } else {
                return middle;
            }
        }
        return -1;
    }

    /**
     * 5-2 a) : Search in unsorted array
     *
     * @param A      : the array
     * @param target : the number to be searched for
     * @return : the index of the number, if not in the array, return -1
     */
    public static int randomSearch(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int lenA = A.length;
        boolean[] indices = new boolean[lenA];
        int searchedIndices = 0;
        Random rd = new Random();
        while (searchedIndices < lenA) {
            int index = rd.nextInt(lenA);
            while (indices[index]) {
                index = rd.nextInt(lenA);
            }
            searchedIndices++;
            if (target == A[index]) {
                return index;
            }
            indices[index] = true;
        }
        return -1;
    }

    /**
     * 5-2 a) : Search in unsorted array
     *
     * @param A      : the array
     * @param target : the number to be searched for
     * @return : true : exist; false : not exist
     */
    public static boolean randomSearchBool(int[] A, int target) {
        if (A == null || A.length == 0) {
            return false;
        }
        int lenA = A.length;
        boolean[] indices = new boolean[lenA];
        int searchedIndices = 0;
        Random rd = new Random();
        while (searchedIndices < lenA) {
            int index = rd.nextInt(lenA);
            while (indices[index]) {
                index = rd.nextInt(lenA);
            }
            searchedIndices++;
            if (target == A[index]) {
                return true;
            }
            indices[index] = true;
        }
        return false;
    }

    /**
     * 5-2 e) : Deterministic Search (Brute Force)
     *
     * @param A      : a randomly arranged array
     * @param target : the Integer to be searched for
     * @return : the index of the number, if not in the array, return -1
     */
    public static int deterministicSearch(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int lenA = A.length;
        for (int i = 0; i < lenA; i++) {
            if (A[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 5-2 e) : Deterministic Search (Brute Force)
     *
     * @param A      : a randomly arranged array
     * @param target : the Integer to be searched for
     * @return : true : exist; false : not exist
     */
    public static boolean deterministicSearchBool(int[] A, int target) {
        if (A == null || A.length == 0) {
            return false;
        }
        int lenA = A.length;
        for (int i = 0; i < lenA; i++) {
            if (A[i] == target) {
                return true;
            }
        }
        return false;
    }

    /**
     * Randomly Permute the original array, then random search
     *
     * @param A      : a randomly arranged array
     * @param target : the Integer to be searched for
     * @return : true : exist; false : not exist
     */
    public static boolean scrambleSearch(int[] A, int target) {
        if (A == null || A.length == 0) {
            return false;
        }
        int[] B = Arrays.copyOf(A, A.length);
        RandomAlgorithm.permuteWithoutIdentity(B);
        return randomSearchBool(B, target);
    }
}
