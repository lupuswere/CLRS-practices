package net.lilifei.dataStructure;

import org.junit.Test;

import java.util.Arrays;

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
        int[] expectedInt = {15, 6, 9, 4, 7, 5, 7};
        ForTest[] before = new ForTest[7];
        ForTest[] expected = new ForTest[7];
        for (int i = 0; i < 7; i++) {
            before[i] = new ForTest(beforeInt[i]);
            expected[i] = new ForTest(expectedInt[i]);
        }
        Heap.minHeapify(before, 0, 7);
        assertTrue(Arrays.equals(before, expected));

    }

    @Test
    public void testMaxHeapify1() throws Exception {
        int[] beforeInt = {4, 15, 9, 6, 7, 5, 7};
        int[] expectedInt = {15, 6, 9, 4, 7, 5, 7};
        Heap.minHeapify(beforeInt, 0, 7);
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
        Heap.maxHeapify(before, 0, 7);
        assertArrayEquals(expected, before);

    }

    @Test
    public void testMinHeapify1() throws Exception {
        int[] beforeInt = {16, 8, 11, 11, 12, 18, 12};
        int[] expectedInt = {8, 11, 11, 16, 12, 18, 12};
        Heap.maxHeapify(beforeInt, 0, 7);
        assertArrayEquals(expectedInt, beforeInt);
    }

    @Test
    public void testMaxHeapifyIterative() throws Exception {
        int[] beforeInt = {4, 15, 9, 6, 7, 5, 7};
        int[] expectedInt = {15, 6, 9, 4, 7, 5, 7};
        ForTest[] before = new ForTest[7];
        ForTest[] expected = new ForTest[7];
        for (int i = 0; i < 7; i++) {
            before[i] = new ForTest(beforeInt[i]);
            expected[i] = new ForTest(expectedInt[i]);
        }
        Heap.minHeapify(before, 0, 7);
        assertArrayEquals(expected, before);
    }

    @Test
    public void testMaxHeapifyIterative1() throws Exception {
        int[] beforeInt = {4, 15, 9, 6, 7, 5, 7};
        int[] expectedInt = {15, 6, 9, 4, 7, 5, 7};
        Heap.minHeapify(beforeInt, 0, 7);
        assertArrayEquals(expectedInt, beforeInt);
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
        return super.equals(this.getValue() == o.getValue());
    }
}