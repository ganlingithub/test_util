package com.test.util;

public class SegmentTreeNode {
    public int start,end,val;
    public SegmentTreeNode left, right;
    public SegmentTreeNode(int start, int end,int val) {
        this.start = start;
        this.end = end;
        this.val=val;
        this.left = this.right = null;
    }
    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.val=val;
        this.left = this.right = null;
    }
}
/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, max;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int max) {
 *         this.start = start;
 *         this.end = end;
 *         this.max = max
 *         this.left = this.right = null;
 *     }
 * }
 */
