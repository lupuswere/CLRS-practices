package net.lilifei.algorithm.clrs.v2.generate;

import net.lilifei.algorithm.clrs.v2.model.DataObject;

import java.util.concurrent.ThreadLocalRandom;

public class DataObjectGenerator implements ObjectGenerator<DataObject> {

    @Override
    public DataObject generate() {
        final ThreadLocalRandom random = ThreadLocalRandom.current();
        return DataObject.builder().value(random.nextInt(100)).build();
    }
}
