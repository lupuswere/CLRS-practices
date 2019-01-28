package net.lilifei.algorithm.dataStructure;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Lifei on 15/5/10.
 */
public class LinkedListNodeTest {

    @Test
    public void testGenerateLinkedList() throws Exception {
        int[] testCase = {2, 4, 5, 0};
        LinkedListNode l1 = new LinkedListNode(2);
        LinkedListNode l2 = new LinkedListNode(4);
        LinkedListNode l3 = new LinkedListNode(5);
        LinkedListNode l4 = new LinkedListNode();
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        LinkedListNode actual = LinkedListNode.generateLinkedList(testCase);
        assertTrue(actual.equals(l1));
    }

    @Test
    public void testGenerateIntArray() throws Exception {
        LinkedListNode l1 = new LinkedListNode(2);
        LinkedListNode l2 = new LinkedListNode(4);
        LinkedListNode l3 = new LinkedListNode(5);
        LinkedListNode l4 = new LinkedListNode();
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        int[] expected = {2, 4, 5, 0};
        int[] actual = LinkedListNode.generateIntArray(l1);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testEquals() throws Exception {
        LinkedListNode l1 = new LinkedListNode(2);
        LinkedListNode l2 = new LinkedListNode(2);
        LinkedListNode l3 = new LinkedListNode(3);
        assertTrue(l1.equals(l2));
        assertTrue(!l1.equals(l3));
    }

    @Test
    public void testEqualsIntegerArray() throws Exception {
        LinkedListNode l1 = new LinkedListNode(2);
        LinkedListNode l2 = new LinkedListNode(4);
        LinkedListNode l3 = new LinkedListNode(5);
        LinkedListNode l4 = new LinkedListNode();
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        int[] testCase1 = {2, 4, 5, 0};
        int[] testCase2 = {2, 4, 5, 1};
        int[] testCase3 = {3, 4, 5, 0};
        int[] testCase4 = {4, 4, 5, 0};
        int[] testCase5 = {2, 4, 5};
        int[] testCase6 = {2, 4, 5, 0, 1};
        int[] testCase7 = {2, 3, 5};
        int[] testCase8 = {2, 4, 5, 1, 1};
        assertTrue(l1.equalsIntegerArray(testCase1));
        assertTrue(!l1.equalsIntegerArray(testCase2));
        assertTrue(!l1.equalsIntegerArray(testCase3));
        assertTrue(!l1.equalsIntegerArray(testCase4));
        assertTrue(!l1.equalsIntegerArray(testCase5));
        assertTrue(!l1.equalsIntegerArray(testCase6));
        assertTrue(!l1.equalsIntegerArray(testCase7));
        assertTrue(!l1.equalsIntegerArray(testCase8));
    }

    @Test
    public void testCompareTo() throws Exception {
        LinkedListNode l1 = new LinkedListNode(2);
        LinkedListNode l2 = new LinkedListNode(3);
        LinkedListNode l3 = new LinkedListNode(1);
        assertTrue(l1.compareTo(l2) < 0);
        assertTrue(l1.compareTo(l3) > 0);
    }
}