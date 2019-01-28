package net.lilifei.algorithm.clrs.v1.datastructure;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Lifei on 15/5/11.
 */
public class DnaryHeapTest {

    @Test
    public void testParent() throws Exception {
        int i1 = 9, d1 = 4, expected1 = 2;
        int i2 = 14, d2 = 4, expected2 = 3;
        int i3 = 12, d3 = 5, expected3 = 2;
        assertEquals(expected1, DnaryHeap.parent(i1, d1));
        assertEquals(expected2, DnaryHeap.parent(i2, d2));
        assertEquals(expected3, DnaryHeap.parent(i3, d3));
    }

    @Test
    public void testNthChild() throws Exception {
        int i1 = 2, d1 = 4, n1 = 3, expected1 = 11;
        int i2 = 4, d2 = 4, n2 = 1, expected2 = 17;
        int i3 = 3, d3 = 5, n3 = 3, expected3 = 18;
        assertEquals(expected1, DnaryHeap.nthChild(i1, n1, d1));
        assertEquals(expected2, DnaryHeap.nthChild(i2, n2, d2));
        assertEquals(expected3, DnaryHeap.nthChild(i3, n3, d3));
    }

    @Test
    public void testIsMaxDnaryHeap() throws Exception {
        int[] testCase1 = {16, 11, 7, 12, 10, 6, 7, 8, 9};
        int[] testCase2 = {16, 11, 7, 12, 10, 6, 7, 12, 9};
        int[] testCase3 = {20, 19, 18, 16, 12, 17, 11, 9, 16, 17, 15, 13, 13, 15, 14, 9, 11, 7, 6, 8, 9};
        int[] testCase4 = {20, 19, 18, 16, 12, 17, 11, 9, 16, 17, 15, 13, 13, 15, 14, 9, 11, 7, 6, 8, 13};
        assertTrue(DnaryHeap.isMaxDnaryHeap(testCase1, 4, testCase1.length));
        assertTrue(!DnaryHeap.isMaxDnaryHeap(testCase2, 4, testCase2.length));
        assertTrue(DnaryHeap.isMaxDnaryHeap(testCase3, 4, testCase3.length));
        assertTrue(!DnaryHeap.isMaxDnaryHeap(testCase4, 4, testCase4.length));
    }

    @Test
    public void testBuildMaxHeap() throws Exception {
        Random rd = new Random();
        int[] testCase = new int[100];
        for (int i = 0; i < testCase.length; i++) {
            testCase[i] = rd.nextInt(200) - 100;
        }
        DnaryHeap.buildMaxHeap(testCase, 6);
        assertTrue(DnaryHeap.isMaxDnaryHeap(testCase, 6, 100));
    }

    @Test
    public void testExtractMax() throws Exception {
        Random rd = new Random();
        int[] testCase = new int[100];
        for (int i = 0; i < testCase.length; i++) {
            testCase[i] = rd.nextInt(200) - 100;
        }
        DnaryHeap.buildMaxHeap(testCase, 5);
        int max = DnaryHeap.extractMax(testCase, 5, 100);
        assertTrue(DnaryHeap.isMaxDnaryHeap(testCase, 5, 99));
    }

    @Test
    public void testHeapIncreaseKey() throws Exception {
        int[] testCase = {19, 15, 17, 11, 9, 6, 11, 12, 13, 15, 10, 2, 5, 7, 8, 9, 10, 2, 5, 4, 3};
        DnaryHeap.heapIncreaseKey(testCase, 4, 2, 20);
        assertTrue(testCase[0] == 20);
        assertTrue(DnaryHeap.isMaxDnaryHeap(testCase, 4, testCase.length));
    }

    @Test
    public void testMaxHeapInsert() throws Exception {
        int[] testCase = {19, 15, 17, 11, 9, 6, 11, 12, 13, 15, 10, 2, 5, 7, 8, 9, 10, 2, 5, 4, 0};
        DnaryHeap.maxHeapInsert(testCase, 4, 20, testCase.length - 1);
        assertTrue(DnaryHeap.isMaxDnaryHeap(testCase, 4, testCase.length));
    }
}