package net.lilifei.algorithm.clrs.v2.validate.Exception;

public class ValidationFailedException extends RuntimeException {

    public ValidationFailedException(final String message) {
        super(message);
    }
}
