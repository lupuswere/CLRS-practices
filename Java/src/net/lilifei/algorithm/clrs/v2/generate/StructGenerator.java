package net.lilifei.algorithm.clrs.v2.generate;

public interface StructGenerator<T, O, C extends Configuration> extends Generator {

    T generate(final ObjectGenerator<O> objectGenerator,
               final C configuration);
}
