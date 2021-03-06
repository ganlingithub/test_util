package com.test;
import com.test.util.SegmentTree;
import com.test.util.SegmentTreeNode;
import com.test.util.IntegerFunc;
public class SegmentTreeTest {
    public static void main(String[] args){
        IntegerFunc func = (n1,n2)->{
            return n1>n2?n1:n2;
        };
        int[] nums={1,2,3,4,5,6};
        SegmentTree tree=new SegmentTree();
        SegmentTreeNode root=tree.build(0,nums.length-1,nums,func);
        System.out.println(tree.query(root,0,nums.length-1,func,Integer.MIN_VALUE));
    }
}
