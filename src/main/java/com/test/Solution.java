package com.test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Arrays;
//import org.apache.commons.lang.ArrayUtils;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.text.DecimalFormat;
import com.test.util.*;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
public class Solution {
    public static void main(String[] args) throws InterruptedException{
        MaxHeap a=new MaxHeap(10);
        a.insert(1);
        a.insert(2);
        a.insert(3);
        a.insert(4);
        a.insert(5);
        a.insert(6);
        a.insert(7);
        a.insert(8);
        a.insert(9);
        a.insert(10);
        a.delete();
        System.out.println(a.get());
        //List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        /*
        int[] arr={1024,512,256,128,64,32,16,8,4,2,1};
        Solution test=new Solution();
        SegmentTreeNode temp=test.build(arr,0,arr.length-1);
        System.out.println(test.sum(temp,1,8));*/
        //Solution test=new Solution();
        //int[] nums={3,3,5,5,5,5,1,1,1,1,2,2,2,2};
        //System.out.println(test.singleNumber(nums));
        //System.out.println(1);
        //单线程版
        //int length = 1000;
        //int[] data = (new Data(length)).getData();
        //printArr(data);
        //System.out.println();
        //mergeSort(data);
        //printArr(data);

        ////多线程版
        //int length = 1000;
        //int[] data = (new Data(length)).getData();
        //printArr(data);
        //System.out.println();
        //// mergeSort(data);
        ////在这里修改
        //int center = data.length/2;
//
        //int[] tmp = new int[data.length];
        //CountDownLatch latch = new CountDownLatch(2);//CountDownLatch能够使一个线程在等待另
        ////外一些线程完成各自工作之后，再继续执行
        //new Thread(new Runnable(){
        //    @Override
        //    public void run() {
        //        mergeSort(data,tmp,0,center);
        //        latch.countDown();
        //    }
        //}).start();

        //new Thread(new Runnable(){
//
        //    @Override
        //    public void run() {
        //        mergeSort(data,tmp,center+1,data.length-1);
        //        latch.countDown();
        //    }
        //}).start();
//
        //latch.await();
//
        //merge(data, tmp, 0, center+1, data.length-1);

        //printArr(data);
        //System.out.println();
        //verify(data);
    }
    //递归
    private static void mergeSort(int[] nums,int[] tmp,int left,int right){
        if(left<right){
            int center = (left+right)/2;
            mergeSort(nums,tmp,left,center);
            mergeSort(nums,tmp,center+1,right);
            merge(nums,tmp,left,center+1,right);
        }
    }

    //合并
    private static void merge(int[] nums,int[] tmp,int leftPos, int rightPos, int rightEnd){
        int leftEnd = rightPos-1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        while(leftPos<=leftEnd&&rightPos<=rightEnd){
            if(nums[leftPos]<nums[rightPos])
                tmp[tmpPos++]=nums[leftPos++];
            else
                tmp[tmpPos++]=nums[rightPos++];
        }
        while(leftPos<=leftEnd)
            tmp[tmpPos++]=nums[leftPos++];

        while(rightPos<=rightEnd)
            tmp[tmpPos++]=nums[rightPos++];

        for(int i = 0;i<numElements;i++,rightEnd--)
            nums[rightEnd]=tmp[rightEnd];
    }
    public static void mergeSort(int[] nums){
        int[] tmp = new int[nums.length];
        mergeSort(nums,tmp,0,nums.length-1);
    }

    //打印
    public static void printArr(int[] arr) {
        for(int i : arr){
            System.out.print(i+" ");
        }
    }




    //
    public int singleNumber(int[] nums) {
        int a=0;
        int b=0;
        int c=0;
        for(int i:nums){
            a=~b&~c&(a^i);
            b=~a&~c&(b^i);
            c=~a&~b&(c^i);
        }
        System.out.println(1);
        return a;
    }
    //public SegmentTreeNode build(int[] arr,int start, int end) {
    //    // write your code here
    //    if(start==end){
    //        SegmentTreeNode cru=new SegmentTreeNode(start,end);
    //        cru.sum=arr[start];
    //        return cru;
    //    }else if(start<end){
    //        SegmentTreeNode cru=new SegmentTreeNode(start,end);
    //        cru.left=build(arr,start,(start + end) / 2);
    //        cru.right=build(arr,(start + end) / 2+1,end);
    //        cru.sum=cru.left.sum+cru.right.sum;
    //        return cru;
    //    }
    //    return null;
    //}
    //public int sum(SegmentTreeNode temp,int start, int end){
    //    if (start > end)
    //        return 0;
    //    if (temp.start == start && temp.end == end) {
    //        return temp.sum;
    //    }
    //    return sum(temp.left,start,Math.min(end,temp.left.end))
    //            + sum(temp.right,Math.max(start,temp.right.start),end);
    //}
    public static void verify(int[] nums) {
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                System.out.println("排序失败");
                return;
            }

        }
        System.out.println("排序成功");
    }
}
/**
 * 产生随机数据
 */
class Data{
    int length;
    int[] data;

    public Data(int length){
        this.length = length;
        data = new int[length];
    }

    public int[] getData(){

        Random random = new Random(System.currentTimeMillis());
        for(int i=0;i<length;i++){
            data[i]=random.nextInt(2*length);
        }
        return data;
    }


}

class test1{
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int cru=startFuel;
        if(cru>=target){
            return 0;
        }
        if(stations==null||stations.length<1){
            System.out.println(1);
            return -1;
        }
        MaxHeap maxfuel=new MaxHeap(stations.length);
        int ret=0;
        for(int i=0;i<stations.length;i++){
            if(cru>=target){
                System.out.println(2);
                return ret;
            }
            if(cru>=stations[i][0]){
                maxfuel.insert(stations[i][1]);
            }else{
                for(int j=maxfuel.getSize();j>0;j--){
                    int temp1=maxfuel.pop();
                    cru+=temp1;
                    System.out.println(i+":"+cru+":"+temp1);
                    ret++;
                    if(cru>=target){
                        System.out.println(3);
                        return ret;
                    }
                    if(cru>=stations[i][0]){
                        maxfuel.insert(stations[i][1]);
                        break;
                    }
                }
                if(cru<stations[i][0]){
                    System.out.println(4);
                    return -1;
                }
            }
        }
        if(cru<target&&maxfuel.getSize()>0){
            for(int j=maxfuel.getSize();j>0;j--){
                cru+=maxfuel.pop();
                ret++;
                if(cru>=target){
                    System.out.println(5);
                    return ret;
                }
            }
        }
        System.out.println(6);
        return -1;
    }
}
