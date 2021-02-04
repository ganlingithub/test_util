package com.test.util;

public interface IntegerFunc {
    Integer comput(Integer num1,Integer nums2);
    default String getInfo(){
        return "两数处理函数" ;
    }

}
