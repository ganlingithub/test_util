package com.test.util;

public class MaxHeap {
    private int[] a;//模拟大顶锥 //a[0]为空
    private int n;//堆中允许存储的最大容量
    private int count;//当前的最大容量
    public MaxHeap(int n) {
        this.n =n;
        a = new int[n+1];
        count =0;
    }
    public int getSize(){
        return count;
    }
    public int pop(){
        int temp=count==0?0:a[1];
        delete();
        return temp;
    }
    public int get(){
        return a[1];
    }
    public boolean insert(int num){
        if(count>=n){
            return false;
        }
        count++;
        if(num>a[1]){
            a[count]=a[1];
            a[1]=num;
            bottom_adjust();
        }else{
            a[count]=num;
        }
        return true;
    }
    public boolean delete(){
        if(count==0){
            return false;
        }
        a[1]=a[count];
        count--;
        top_adjust();
        return true;
    }
    public void bottom_adjust(){
        int i=count;
        while(i>1&&a[i]>a[i/2]){
            swap(i,i/2);
            i=i/2;
        }
    }
    public void top_adjust(){
        int i=1;
        int max=1;
        while(true){
            if(2*i<=count&&a[i]<a[2*i])max=2*i;
            if(2*i+1<=count&&a[max]<a[2*i+1])max=2*i+1;
            if(max==i){
                break;//说明当前节点大于左右子节点，不需要再堆化，直接退出
            }
            swap(i,max);
            i=max;
        }
    }
    //交换两个元素
    private void swap(int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] =tmp;
    }
}
