package net.lilifei.algorithm.clrs.v1.model;

import java.util.HashMap;

/**
 * Created by Lifei on 15/5/16.
 */
public class Kettle {
    private int val;

    public Kettle(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public int compare(Kettle kettle) {
        return this.getVal() - kettle.getVal();
    }

    /**
     * 8-4 a) : WATER JUGS
     *
     * @param rks : the red kettles
     * @param bks : the blue kettles
     * @return : the matches represented in HashMap
     */
    public static HashMap<RedKettle, BlueKettle> findMatches(RedKettle[] rks, BlueKettle[] bks) {
        HashMap<RedKettle, BlueKettle> res = new HashMap<RedKettle, BlueKettle>();
        for (int i = 0; i < rks.length; i++) {
            for (int j = 0; j < bks.length; j++) {
                if(rks[i].compare(bks[j]) == 0) {
                    res.put(rks[i], bks[j]);
                }
            }
        }
        return res;
    }
}

