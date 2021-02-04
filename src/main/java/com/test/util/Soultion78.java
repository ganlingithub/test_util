package com.test.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Soultion78 {
    List<List<Integer>> ret=new ArrayList<>();
    //保存输入参数
    int[] arr;
    int[] retnum;
    public List<List<Integer>> subsets(int[] nums) {
        arr=nums;
        retnum=new int[nums.length];
        List<Integer> temp=new LinkedList<>();
        ret.add(temp);
        backtrack(0,1);
        return ret;
    }
    //生成第idx个数字
    void backtrack(int idx,int len){
        //idx大于n时不执行
        if (idx >= arr.length) return;
        //按col遍历
        for(int i=idx;i<arr.length;i++){
            place(idx,i);
            System.out.println(len+":"+idx+":"+arr[i]);
            addSolution(len);
            backtrack(i+1,len+1);
        }
    }

    public void place(int idx,int i){
        retnum[idx]=arr[i];
        //numv[i]=1;
    }
    //将满足条件的方法添加到ret列表
    public void addSolution(int idx){
        List<Integer> temp=new LinkedList<>();
        for(int i=0;i<idx;i++){
            temp.add(retnum[i]);
        }

        ret.add(temp);
    }
}
