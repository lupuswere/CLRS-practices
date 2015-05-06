package net.lilifei.basic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Lifei on 15/5/5.
 */
public class SortTest{
    @org.junit.Test
    public void testInsertSort() throws Exception {
        int[] expecteds = {-2, 0, 2, 3, 3, 5, 9, 11, 11, 50};
        int[] actuals = {9, 11, 3, 5, 2, 3, 50, 11, 0, -2};
        Sort.insertSort(actuals);
        assertEquals(expecteds, actuals);
    }
}