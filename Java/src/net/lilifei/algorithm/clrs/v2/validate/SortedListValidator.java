package net.lilifei.algorithm.clrs.v2.validate;

import net.lilifei.algorithm.clrs.v2.validate.Exception.ValidationFailedException;

import java.util.Comparator;
import java.util.List;

public class SortedListValidator {

    public <T> void validate(final List<T> object, final Comparator<T> helper) {
        if (object == null || object.isEmpty() || object.size() == 1) {
            return;
        }
        for (int i = 0; i < object.size() - 1; i++) {
            final T current = object.get(i);
            final T next = object.get(i + 1);
            if (current != null && next != null) {
                if (helper.compare(current, next) > 0) {
                    final String errorMessage = String.format("List not properly sorted!, " +
                            "Object %s at %d is bigger the next object %s",
                            current, i, next);
                    throw new ValidationFailedException(errorMessage);
                }
            }
        }
    }
}
