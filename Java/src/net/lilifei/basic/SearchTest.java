package net.lilifei.basic;

import org.junit.Before;
import org.junit.Test;
import net.lilifei.basic.Search;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Lifei on 15/5/7.
 */
public class SearchTest {
    int[][] As;
    int[] targets;
    int[] expectedIndices;
    int lengthOfA = 100;
    int countOfAs = 100;
    int rangeOfAs = 200;
    @Before
    public void setUp() throws Exception {
        Random rd = new Random();
        this.As = new int[this.countOfAs][this.lengthOfA];
        this.expectedIndices = new int[this.countOfAs];
        this.targets = new int[this.countOfAs];
        for(int i = 0; i < this.countOfAs; i++) {
            int[] A = this.As[i];
            for(int j = 0; j < this.lengthOfA; j++) {
                A[j] = rd.nextInt(this.rangeOfAs) - 100; // Range (-100, 100)
            }
            Arrays.sort(A);
            int indexToBeReturned = rd.nextInt(this.lengthOfA / 3 + this.lengthOfA);
            if (indexToBeReturned >= this.lengthOfA) {
                this.expectedIndices[i] = -1;
                this.targets[i] = this.rangeOfAs + 2;
            } else {
                this.expectedIndices[i] = indexToBeReturned;
                this.targets[i] = A[indexToBeReturned];
            }
        }
    }

    @Test
    public void testBinarySearchIterative() throws Exception {
        for (int i = 0; i < countOfAs; i++) {
            assertEquals(this.expectedIndices[i], Search.binarySearch(this.As[i], this.targets[i], false));
        }
    }

    @Test
    public void testBinarySearchRecursive() throws Exception {
        for (int i = 0; i < countOfAs; i++) {
            assertEquals(this.expectedIndices[i], Search.binarySearch(this.As[i], this.targets[i], true));
        }
    }
}