package net.lilifei.algorithm.clrs.v1.model;

import net.lilifei.algorithm.clrs.v1.basic.DigitalComparable;

import java.util.ArrayList;

public class DigitalNumber implements DigitalComparable<DigitalNumber> {
    private ArrayList<Integer> data;

    public DigitalNumber(int num) {
        this.data = new ArrayList<Integer>();
        while (num > 0) {
            this.data.add(num % 10);
            num = num / 10;
        }
    }

    @Override
    public int compareDigitTo(DigitalNumber o, int digit) {
        int left = (digit - 1) < this.data.size() ? this.data.get(digit - 1) : 0;
        int right = (digit - 1) < o.data.size() ? o.data.get(digit - 1) : 0;
        return left - right;
    }

    @Override
    public int dNum() {
        return this.data.size();
    }

    public static int turnToInt(DigitalNumber num) {
        ArrayList<Integer> data = num.data;
        int res = 0;
        for (int i = data.size() - 1; i >= 0; i--) {
            res = res * 10 + data.get(i);
        }
        return res;
    }

    public static DigitalNumber[] turnToDigitalNumbers(int[] num) {
        DigitalNumber[] res = new DigitalNumber[num.length];
        for (int i = 0; i < num.length; i++) {
            res[i] = new DigitalNumber(num[i]);
        }
        return res;
    }

    public static int[] turnToInts(DigitalNumber[] num) {
        int[] res = new int[num.length];
        for (int i = 0; i < num.length; i++) {
            res[i] = DigitalNumber.turnToInt(num[i]);
        }
        return res;
    }
}
