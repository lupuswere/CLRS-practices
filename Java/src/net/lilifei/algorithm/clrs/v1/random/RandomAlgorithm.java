package net.lilifei.algorithm.clrs.v1.random;

import java.util.Arrays;

/**
 * Created by Lifei on 15/5/8.
 */
public class RandomAlgorithm {
    /**
     * Generate an different permutation from a given array
     *
     * @param A : the original array
     * @return : the new permutation
     */
    public static <T extends Object> T[] permuteWithoutIdentity(T[] A) {
        T[] ans = Arrays.copyOf(A, A.length);
        java.util.Random rd = new java.util.Random();
        int len = ans.length;
        for(int i = 0; i < len; i++) {
            int index = rd.nextInt(len - i) + i;
            T tmp = A[i];
            A[i] = A[index];
            A[index] = tmp;
        }
        return ans;
    }

    /**
     * Generate an different permutation from a given array
     *
     * @param A : the original array
     * @return : the new permutation
     */
    public static int[] permuteWithoutIdentity(int[] A) {
        int[] ans = Arrays.copyOf(A, A.length);
        java.util.Random rd = new java.util.Random();
        int len = ans.length;
        for(int i = 0; i < len; i++) {
            int index = rd.nextInt(len - i) + i;
            int tmp = A[i];
            A[i] = A[index];
            A[index] = tmp;
        }
        return ans;
    }
}
