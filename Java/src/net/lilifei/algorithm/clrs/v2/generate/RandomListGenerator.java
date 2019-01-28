package net.lilifei.algorithm.clrs.v2.generate;

import java.util.ArrayList;
import java.util.List;

public class RandomListGenerator<T> implements StructGenerator<List<T>, T, ListConfiguration> {

    @Override
    public List<T> generate(final ObjectGenerator<T> objectGenerator,
                            final ListConfiguration configuration) {
        final List<T> result = new ArrayList<>();
        final int numberOfElements = configuration.getNumberOfElements();
        for (int i = 0; i < numberOfElements; i++) {
            final T element = objectGenerator.generate();
            result.add(element);
        }
        return result;
    }
}
