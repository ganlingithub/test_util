package com.test.util;

public class SegmentTree {
    public SegmentTreeNode build(int start, int end,int[] nums,IntegerFunc func) {
        // write your code here
        if(start==end){
            SegmentTreeNode cru=new SegmentTreeNode(start,end,nums[start]);
            return cru;
        }else if(start<end){
            SegmentTreeNode cru=new SegmentTreeNode(start,end);
            cru.left=build(start,(start + end) / 2,nums,func);
            cru.right=build((start + end) / 2+1,end,nums,func);
            cru.val=func.comput(cru.left.val,cru.right.val);
            return cru;
        }
        return null;
    }
    public int query(SegmentTreeNode root, int start, int end,IntegerFunc func,Integer init_val) {
        // write your code here
        if (start <= root.start && root.end <= end) {
            return root.val;
        }
        int mid = root.start + (root.end - root.start) / 2;
        // 给结果赋初值
        int ans = init_val;//Integer.MIN_VALUE;;
        // 如果查询区间和左边节点区间有交集,则寻找查询区间在左边区间上的最大值
        if (mid >= start) {
            ans = func.comput(ans, query(root.left, start, end,func,init_val));
        }
        // 如果查询区间和右边节点区间有交集,则寻找查询区间在右边区间上的最大值
        if (mid + 1 <= end) {
            ans = func.comput(ans, query(root.right, start, end,func,init_val));
        }
        return ans;
    }
}

