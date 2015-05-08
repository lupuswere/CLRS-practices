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
    int startOfAs = 100;
    int gapOfAs = 10;
    @Before
    public void setUp() throws Exception {
        Random rd = new Random();
        this.As = new int[this.countOfAs][this.lengthOfA];
        this.expectedIndices = new int[this.countOfAs];
        this.targets = new int[this.countOfAs];
        for(int i = 0; i < this.countOfAs; i++) {
            int[] A = this.As[i];
            for(int j = 0; j < this.lengthOfA; j++) {
                if(j == 0) {
                    A[j] = rd.nextInt(this.startOfAs) - 100; // range(-100, 0);
                } else {
                    A[j] = A[j - 1] + rd.nextInt(gapOfAs) + 1;
                }
            }
            Arrays.sort(A);
            int indexToBeReturned = rd.nextInt(this.lengthOfA / 3 + this.lengthOfA);
            if (indexToBeReturned >= this.lengthOfA) {
                this.expectedIndices[i] = -1;
                this.targets[i] = A[0] - 1;
            } else {
                this.expectedIndices[i] = indexToBeReturned;
                this.targets[i] = A[indexToBeReturned];
            }
        }
    }

    @Test
    public void testBinarySearchIterative() throws Exception {
        for (int i = 0; i < countOfAs; i++) {
            int actual =  Search.binarySearch(this.As[i], this.targets[i], false);
            assertEquals(this.expectedIndices[i], actual);
        }
    }

    @Test
    public void testBinarySearchRecursive() throws Exception {
        for (int i = 0; i < countOfAs; i++) {
            int actual = Search.binarySearch(this.As[i], this.targets[i], true);
            assertEquals(this.expectedIndices[i], actual);
        }
    }

    @Test
    public void testRandomSearch() throws Exception {
        for (int i = 0; i < countOfAs; i++) {
            int actual = Search.randomSearch(this.As[i], this.targets[i]);
            assertEquals(this.expectedIndices[i], actual);
        }
    }
}