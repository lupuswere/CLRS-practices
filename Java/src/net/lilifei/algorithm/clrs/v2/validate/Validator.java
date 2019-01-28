package net.lilifei.algorithm.clrs.v2.validate;

public interface Validator<T, H> {

    void validate(final T object,
                  final H helper);
}
