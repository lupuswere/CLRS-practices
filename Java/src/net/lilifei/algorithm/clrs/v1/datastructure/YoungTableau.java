package net.lilifei.algorithm.clrs.v1.datastructure;

import java.util.Arrays;

/**
 * Created by Lifei on 15/5/10.
 */
public class YoungTableau {
    public int[][] data;

    public YoungTableau(int[] rawData, int m, int n) {
        this.data = initializeYoungTableau(rawData, m, n);
    }

    /**
     * 6-3 b)
     *
     * @param rawData
     * @param m
     * @param n
     * @return
     */
    public static int[][] initializeYoungTableau(int[] rawData, int m, int n) {
        if (rawData == null || rawData.length == 0 || rawData.length > m * n) {
            return null;
        }
        Arrays.sort(rawData);
        int[][] data = new int[m][n];
        for (int a = 0; a < m; a++) {
            for (int b = 0; b < n; b++) {
                data[a][b] = Integer.MAX_VALUE;
            }
        }
        int i = 0, j = 0;
        int rawDataLen = rawData.length;
        //TODO
        return data;
    }
}
