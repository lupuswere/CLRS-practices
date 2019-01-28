package net.lilifei.algorithm.clrs.v2.sort;

import net.lilifei.algorithm.clrs.v2.generate.DataObjectGenerator;
import net.lilifei.algorithm.clrs.v2.generate.ListConfiguration;
import net.lilifei.algorithm.clrs.v2.generate.ObjectGenerator;
import net.lilifei.algorithm.clrs.v2.generate.RandomListGenerator;
import net.lilifei.algorithm.clrs.v2.model.DataObject;
import net.lilifei.algorithm.clrs.v2.model.DataObjectComparator;
import net.lilifei.algorithm.clrs.v2.validate.SortedListValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

public class InsertSorterTest {

    private static final int NUMBER_OF_ELEMENTS = 5;

    private InsertSorter<DataObject> insertSorter;

    private List<DataObject> listToSort;

    private Comparator<DataObject> comparator;

    private SortedListValidator<DataObject> sortedListValidator;

    @BeforeEach
    public void setUp() {
        comparator = new DataObjectComparator();
        final ObjectGenerator<DataObject> dataObjectObjectGenerator = new DataObjectGenerator();
        final RandomListGenerator<DataObject> listGenerator = new RandomListGenerator<>();
        listToSort = listGenerator.generate(dataObjectObjectGenerator, ListConfiguration.of(NUMBER_OF_ELEMENTS));
        sortedListValidator = new SortedListValidator<>();

        insertSorter = new InsertSorter<>();
    }

    @Test
    public void sort_case1() {
        final List<DataObject> result = insertSorter.sort(listToSort, comparator);

        sortedListValidator.validate(result, comparator);
    }
}
