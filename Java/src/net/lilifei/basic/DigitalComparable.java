package net.lilifei.basic;

/**
 * Created by Lifei on 15/5/15.
 */
public interface DigitalComparable<T> {
    public int compareDigitTo(T o, int digit);

    public int dNum();

}
