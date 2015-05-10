package net.lilifei.dataStructure;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Lifei on 15/5/8.
 */
public class HeapTest {

    @Test
    public void testParent() throws Exception {
        int[] parentOfI = {-1, 0, 0, 1, 1, 2, 2};
        for (int i = 0; i < parentOfI.length; i++) {
            assertEquals(parentOfI[i], Heap.parent(i));
        }
    }

    @Test
    public void testLeft() throws Exception {
        int[] leftOfI = {1, 3, 5};
        for (int i = 0; i < leftOfI.length; i++) {
            assertEquals(leftOfI[i], Heap.left(i));
        }
    }

    @Test
    public void testRight() throws Exception {
        int[] rightOfI = {2, 4, 6};
        for (int i = 0; i < rightOfI.length; i++) {
            assertEquals(rightOfI[i], Heap.right(i));
        }
    }

    @Test
    public void testMaxHeapify() throws Exception {
        int[] beforeInt = {4, 15, 9, 6, 7, 5, 7};
        int[] expectedInt = {15, 7, 9, 6, 4, 5, 7};
        ForTest[] before = new ForTest[7];
        ForTest[] expected = new ForTest[7];
        for (int i = 0; i < 7; i++) {
            before[i] = new ForTest(beforeInt[i]);
            expected[i] = new ForTest(expectedInt[i]);
        }
        Heap.maxHeapify(before, 0, 7);
        for (int i = 0; i < 7; i++) {
            assertTrue(expected[i].equals(before[i]));
        }
    }

    @Test
    public void testMaxHeapify1() throws Exception {
        int[] beforeInt = {4, 15, 9, 6, 7, 5, 7};
        int[] expectedInt = {15, 7, 9, 6, 4, 5, 7};
        Heap.maxHeapify(beforeInt, 0, 7);
        assertArrayEquals(expectedInt, beforeInt);
    }

    @Test
    public void testMinHeapify() throws Exception {
        int[] beforeInt = {16, 8, 11, 11, 12, 18, 12};
        int[] expectedInt = {8, 11, 11, 16, 12, 18, 12};
        ForTest[] before = new ForTest[7];
        ForTest[] expected = new ForTest[7];
        for (int i = 0; i < 7; i++) {
            before[i] = new ForTest(beforeInt[i]);
            expected[i] = new ForTest(expectedInt[i]);
        }
        Heap.minHeapify(before, 0, 7);
        for (int i = 0; i < 7; i++) {
            assertTrue(expected[i].equals(before[i]));
        }
    }

    @Test
    public void testMinHeapify1() throws Exception {
        int[] beforeInt = {16, 8, 11, 11, 12, 18, 12};
        int[] expectedInt = {8, 11, 11, 16, 12, 18, 12};
        Heap.minHeapify(beforeInt, 0, 7);
        assertArrayEquals(expectedInt, beforeInt);
    }

    @Test
    public void testMaxHeapifyIterative() throws Exception {
        int[] beforeInt = {4, 15, 9, 6, 7, 5, 7};
        int[] expectedInt = {15, 7, 9, 6, 4, 5, 7};
        ForTest[] before = new ForTest[7];
        ForTest[] expected = new ForTest[7];
        for (int i = 0; i < 7; i++) {
            before[i] = new ForTest(beforeInt[i]);
            expected[i] = new ForTest(expectedInt[i]);
        }
        Heap.maxHeapifyIterative(before, 0, 7);
        for (int i = 0; i < 7; i++) {
            assertTrue(expected[i].equals(before[i]));
        }
    }

    @Test
    public void testMaxHeapifyIterative1() throws Exception {
        int[] beforeInt = {4, 15, 9, 6, 7, 5, 7};
        int[] expectedInt = {15, 7, 9, 6, 4, 5, 7};
        Heap.maxHeapifyIterative(beforeInt, 0, 7);
        assertArrayEquals(expectedInt, beforeInt);
    }

    @Test
    public void testBuildMaxHeap() throws Exception {
        int countOfTestCases = 10;
        int lengthOfTestCase = 100;
        int rangeOfTestCase = 100;
        Random rd = new Random();
        for (int i = 0; i < countOfTestCases; i++) {
            int[] tmpTestCase = new int[lengthOfTestCase];
            for (int j = 0; j < lengthOfTestCase; j++) {
                tmpTestCase[j] = rd.nextInt(rangeOfTestCase);
            }
            ForTest[] testCase = ForTest.turn(tmpTestCase);
            Heap.buildMaxHeap(testCase);
            assertTrue(Heap.isMaxHeap(testCase, lengthOfTestCase));
        }
    }

    @Test
    public void testBuildMaxHeap1() throws Exception {
        int countOfTestCases = 10;
        int lengthOfTestCase = 100;
        int rangeOfTestCase = 100;
        Random rd = new Random();
        for (int i = 0; i < countOfTestCases; i++) {
            int[] testCase = new int[lengthOfTestCase];
            for (int j = 0; j < lengthOfTestCase; j++) {
                testCase[j] = rd.nextInt(rangeOfTestCase);
            }
            Heap.buildMaxHeap(testCase);
            assertTrue(Heap.isMaxHeap(testCase, lengthOfTestCase));
        }
    }

    @Test
    public void testIsMaxHeap() throws Exception {
        int[] tmp1 = {4, 15, 9, 6, 7, 5, 7};
        int[] tmp2 = {15, 7, 9, 6, 4, 5, 7};
        ForTest[] testCase1 = ForTest.turn(tmp1);
        ForTest[] testCase2 = ForTest.turn(tmp2);
        assertTrue(!Heap.isMaxHeap(testCase1, 7));
        assertTrue(Heap.isMaxHeap(testCase2, 7));
    }

    @Test
    public void testIsMaxHeap1() throws Exception {
        int[] testCase1 = {4, 15, 9, 6, 7, 5, 7};
        int[] testCase2 = {15, 7, 9, 6, 4, 5, 7};
        assertTrue(!Heap.isMaxHeap(testCase1, 7));
        assertTrue(Heap.isMaxHeap(testCase2, 7));
    }

    @Test
    public void testIsMinHeap() throws Exception {
        int[] tmp1 = {16, 8, 11, 11, 12, 18, 12};
        int[] tmp2 = {8, 11, 11, 16, 12, 18, 12};
        ForTest[] testCase1 = ForTest.turn(tmp1);
        ForTest[] testCase2 = ForTest.turn(tmp2);
        assertTrue(!Heap.isMinHeap(testCase1, 7));
        assertTrue(Heap.isMinHeap(testCase2, 7));
    }

    @Test
    public void testIsMinHeap1() throws Exception {
        int[] testCase1 = {16, 8, 11, 11, 12, 18, 12};
        int[] testCase2 = {8, 11, 11, 16, 12, 18, 12};
        assertTrue(!Heap.isMinHeap(testCase1, 7));
        assertTrue(Heap.isMinHeap(testCase2, 7));
    }

    @Test
    public void testHeapExtractMax() throws Exception {
        int[] tmp = {15, 7, 9, 6, 4, 5, 7};
        ForTest[] testCase = ForTest.turn(tmp);
        ForTest max = Heap.heapExtractMax(testCase, 7);
        assertTrue(max.getValue() == 15 && Heap.isMaxHeap(testCase, 7));
    }

    @Test
    public void testHeapExtractMax1() throws Exception {
        int[] testCase = {15, 7, 9, 6, 4, 5, 7};
        int max = Heap.heapExtractMax(testCase, 7);
        assertTrue(max == 15 && Heap.isMaxHeap(testCase, 7));
    }

    @Test
    public void testHeapIncreaseKey() throws Exception {
        int[] testCase = {15, 7, 9, 6, 4, 5, 7};
        Heap.heapIncreaseKey(testCase, 3, 10);
        assertTrue(Heap.isMaxHeap(testCase, 7));
    }

    @Test
    public void testMaxHeapInsert() throws Exception {
        int[] testCase = {15, 7, 9, 6, 4, 5, 7, 0};
        Heap.maxHeapInsert(testCase, 16, 7);
        assertTrue(Heap.heapMaximum(testCase, 8) == 16 && Heap.isMaxHeap(testCase, 8));
    }

    @Test
    public void testHeapExtractMin() throws Exception {
        int[] tmp = {8, 11, 11, 16, 12, 18, 12};
        ForTest[] testCase = ForTest.turn(tmp);
        ForTest min = Heap.heapExtractMin(testCase, 7);
        assertTrue(min.getValue() == 8 && Heap.isMinHeap(testCase, 7));
    }

    @Test
    public void testHeapExtractMin1() throws Exception {
        int[] testCase = {8, 11, 11, 16, 12, 18, 12};
        int min = Heap.heapExtractMin(testCase, 7);
        assertTrue(min == 8 && Heap.isMinHeap(testCase, 7));
    }

    @Test
    public void testHeapDecreaseKey() throws Exception {
        int[] testCase = {8, 11, 11, 16, 12, 18, 12};
        Heap.heapDecreaseKey(testCase, 3, 7);
        assertTrue(Heap.isMinHeap(testCase, 7));
    }

    @Test
    public void testMinHeapInsert() throws Exception {
        int[] testCase = {8, 11, 11, 16, 12, 18, 12, 0};
        Heap.minHeapInsert(testCase, 7, 7);
        assertTrue(Heap.heapMinimum(testCase, 8) == 7 && Heap.isMinHeap(testCase, 8));
    }
}

class ForTest implements Comparable<ForTest> {
    private int value;

    public ForTest(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(ForTest o) {
        return this.getValue() - o.getValue();
    }

    public boolean equals(ForTest o) {
        return this.getValue() == o.getValue();
    }

    public static ForTest[] turn(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        int lenA = A.length;
        ForTest[] res = new ForTest[lenA];
        for (int i = 0; i < lenA; i++) {
            res[i] = new ForTest(A[i]);
        }
        return res;
    }
}