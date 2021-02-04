package com.test.util;

public class Soultion135 {
    public int candy(int[] ratings) {
        if(ratings.length<=1){
            return ratings.length==1?1:0;
        }
        int sum=ratings.length;
        int[] cru=new int[ratings.length];
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                cru[i]=cru[i-1]+1;
            }
        }
        for(int i=ratings.length-2;i>-1;i--){
            if(ratings[i]>ratings[i+1]&&cru[i]<=cru[i+1]){
                cru[i]=cru[i+1]+1;
            }
            sum+=cru[i+1];
        }
        return sum+cru[0];
    }
}
