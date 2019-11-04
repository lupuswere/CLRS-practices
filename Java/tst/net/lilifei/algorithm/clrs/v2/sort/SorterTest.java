package net.lilifei.algorithm.clrs.v2.sort;

import net.lilifei.algorithm.clrs.v2.generate.DataObjectGenerator;
import net.lilifei.algorithm.clrs.v2.generate.ListConfiguration;
import net.lilifei.algorithm.clrs.v2.generate.ObjectGenerator;
import net.lilifei.algorithm.clrs.v2.generate.RandomListGenerator;
import net.lilifei.algorithm.clrs.v2.model.DataObject;
import net.lilifei.algorithm.clrs.v2.model.DataObjectComparator;
import net.lilifei.algorithm.clrs.v2.validate.SortedListValidator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Comparator;
import java.util.List;

public class SorterTest {

    private static final int NUMBER_OF_ELEMENTS = 10000;

    private Sorter sorter;

    private static List<DataObject> listToSort;

    private Comparator<DataObject> comparator;

    private SortedListValidator sortedListValidator;

    @BeforeAll
    public static void setUpAll() {
        final ObjectGenerator<DataObject> dataObjectObjectGenerator = new DataObjectGenerator();
        final RandomListGenerator<DataObject> listGenerator = new RandomListGenerator<>();
        listToSort = listGenerator.generate(dataObjectObjectGenerator, ListConfiguration.of(NUMBER_OF_ELEMENTS));
    }

    @BeforeEach
    public void setUp() {
        comparator = new DataObjectComparator();
        sortedListValidator = new SortedListValidator();
    }

    @Test
    public void sort_insertionSort() {
        sorter = new InsertionSorter();
        final Instant before = Instant.now();
        final List<DataObject> result = sorter.sort(listToSort, comparator);
        final Instant after = Instant.now();

        sortedListValidator.validate(result, comparator);
        System.out.println("Insertion sort used " + Duration.between(before, after).toMillis() + " ms.");
    }

    @Test
    public void sort_bubbleSort() {
        sorter = new BubbleSorter();
        final Instant before = Instant.now();
        final List<DataObject> result = sorter.sort(listToSort, comparator);
        final Instant after = Instant.now();

        sortedListValidator.validate(result, comparator);
        System.out.println("Bubble sort used " + Duration.between(before, after).toMillis() + " ms.");
    }

    @Test
    public void sort_selectionSort() {
        sorter = new SelectionSorter();
        final Instant before = Instant.now();
        final List<DataObject> result = sorter.sort(listToSort, comparator);
        final Instant after = Instant.now();

        sortedListValidator.validate(result, comparator);
        System.out.println("Selection sort used " + Duration.between(before, after).toMillis() + " ms.");
    }
}
