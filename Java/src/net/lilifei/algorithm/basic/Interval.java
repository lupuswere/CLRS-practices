package net.lilifei.algorithm.basic;

/**
 * Created by Lifei on 15/5/12.
 */
public class Interval implements Comparable<Interval>{
    private int left;
    private int right;

    public Interval(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    @Override
    public int compareTo(Interval o) {
        return this.getLeft() - o.getLeft();
    }
}
