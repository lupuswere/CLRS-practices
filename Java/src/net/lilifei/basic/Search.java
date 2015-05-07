package net.lilifei.basic;

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
        };
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
        if(start <= end) {
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
}
