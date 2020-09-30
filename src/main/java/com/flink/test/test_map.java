package com.flink.test;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
public class test_map {
    public static void main(String[] args) throws Exception {
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        DataSet<Integer> dataSet = env.fromElements(1, 2, -3, 0, 5, -9, 8);
        DataSet<Integer> dataSet2 = dataSet.map(new Tokenizer());
//        DataSet<Integer> dataSet2 = dataSet.map(i->i * 2);
        dataSet2.print();
    }

    public static class Tokenizer implements MapFunction<Integer, Integer> {
        @Override
        public Integer map(Integer in) {
            return in * 2;
        }
    }
}
