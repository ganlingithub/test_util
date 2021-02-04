package com.test.util;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class Soultion135Test {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 }
        });
    }
    @Parameter // first data value (0) is default
    public /* 不能为 private */ int fInput;

    @Parameter(1)
    public /* 不能为 private */ int fExpected;
    @Test
    public void candy() {
        int[] arr = new int[50000]; //数组长度为50000
        int arrLength = arr.length;
//随机生成数组元素
        Random r = new Random();
        for (int i = 0; i < arrLength; i++) {
            arr[i] = r.nextInt(arrLength);
        }
        int[] arr1={1,0,2};
        int ret=new Soultion135().candy(arr1);
        System.out.println(ret);
    }
}