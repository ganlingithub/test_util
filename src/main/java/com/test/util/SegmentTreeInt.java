package com.test.util;

import java.util.Arrays;

public class SegmentTreeInt {
    int n, t[];
    IntegerFunc sfunc;
    //The procedure for constructing the Segment Tree from a given array a[] looks like this:
    // it is a recursive function with the parameters a[] (the input array), v (the index of the current vertex),
    // and the boundaries tl and tr of the current segment. In the main program this function will be called with
    // the parameters of the root vertex: v=1, tl=0, and tr=n−1.
    public SegmentTreeInt(int a[], int v, int tl, int tr,IntegerFunc func,int def_val) {
        sfunc=func;
        n=a.length;
        t=new int[4*n];
        Arrays.fill(t, def_val);
        build(a,v,tl,tr);
    }
    void build(int a[], int v, int tl, int tr) {
        if (tl == tr) {
            t[v] = a[tl];
        } else {
            int tm = (tl + tr) / 2;
            build(a, v*2, tl, tm);
            build(a, v*2+1, tm+1, tr);
            t[v] = sfunc.comput(t[v*2],t[v*2+1]);
        }
    }
    //Further the function for answering sum queries is also a recursive function,
    // which receives as parameters information about the current vertex/segment
    // (i.e. the index v and the boundaries tl and tr) and also the
    // information about the boundaries of the query, l and r. In order to simplify
    // the code, this function always does two recursive calls, even if only one is necessary - in
    // that case the superfluous recursive call will have l>r, and this can easily be caught
    // using an additional check at the beginning of the function.
    int query(int v, int tl, int tr, int l, int r) {
        if (l > r)
            return 0;
        if (l == tl && r == tr) {
            return t[v];
        }
        int tm = (tl + tr) / 2;
        return sfunc.comput(query(v*2, tl, tm, l, Math.min(r, tm)) ,query(v*2+1, tm+1, tr, Math.max(l, tm+1), r));
    }
    //Finally the update query.
    // The function will also receive information about the current vertex/segment,
    // and additionally also the parameter of the update query (i.e. the position of the element and its new value).
    void update(int v, int tl, int tr, int pos, int new_val) {
        if (tl == tr) {
            t[v] = new_val;
        } else {
            int tm = (tl + tr) / 2;
            if (pos <= tm)
                update(v*2, tl, tm, pos, new_val);
            else
                update(v*2+1, tm+1, tr, pos, new_val);
            t[v] = sfunc.comput(t[v*2] , t[v*2+1]);
        }
    }
}