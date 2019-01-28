package net.lilifei.algorithm.v1.datastructure;

/**
 * Created by Lifei on 15/5/10.
 */
public class LinkedListNode implements Comparable<LinkedListNode> {
    public int val;
    public LinkedListNode next;

    public LinkedListNode() {
        this.val = 0;
    }

    public LinkedListNode(int val) {
        this.val = val;
    }

    @Override
    public int compareTo(LinkedListNode o) {
        return this.val - o.val;
    }

    public static LinkedListNode generateLinkedList(int[] list) {
        if (list == null || list.length == 0) {
            return null;
        }
        LinkedListNode head = new LinkedListNode(list[0]);
        LinkedListNode cur = head;
        if (list.length == 1) {
            return head;
        }
        for (int i = 1; i < list.length; i++) {
            LinkedListNode newNode = new LinkedListNode(list[i]);
            cur.next = newNode;
            cur = cur.next;
        }
        return head;
    }

    public static int[] generateIntArray(LinkedListNode head) {
        LinkedListNode cur = head;
        int count = 0;
        while(cur != null) {
            cur = cur.next;
            count++;
        }
        int[] res = new int[count];
        cur = head;
        int i = 0;
        while(cur != null) {
            res[i] = cur.val;
            i++;
            cur = cur.next;
        }
        return res;
    }

    public boolean equals(LinkedListNode node) {
        return this.val == node.val;
    }

    public boolean equalsIntegerArray(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }
        int count = 0;
        int lenA = A.length;
        LinkedListNode cur = this;
        for (int i = 0; i < A.length; i++) {
            if(cur == null || cur.val != A[i]) {
                return false;
            }
            cur = cur.next;
        }
        return cur == null;
    }
}
