package com.test.util;
import java.util.*;

public class UF{

    // 节点 x 的根节点是 parent[x]
    private HashMap<String,String> parent;
    //private int[] parent;
    // 新增一个数组记录树的“重量”
    private HashMap<String,Integer> size;
    //private int[] size;
    // 新增一个数组记录权值
    private HashMap<String,Double> num;
    private HashMap<String,Double> den;
    //private double[][] dist;
    //private boolean[] not_zero;
    /* 构造函数，n 为图的节点总数 */
    public UF() {
        parent=new HashMap<>();
        size=new HashMap<>();
        num=new HashMap<>();
        den=new HashMap<>();
    }

    /* 将 p 和 q 连接 */
    public void union(String p, String q,double dis){
        init(q);
        if(dis==0){
            return;
        }
        init(p);
        String rp=find(p); // a/fa=val[a], b/fb=val[b]
        String rq=find(q);
        if (rp.equals(rq)) {
            return;
        }
        double temp=0;
        if(size.get(rp)>size.get(rq)){
            parent.put(rq,rp);
            temp=num.get(q);
            size.put(rp,size.get(rp)+size.get(rq));
            num.put(rq,num.get(rq)*num.get(p)*den.get(q));
            den.put(rq,den.get(rq)*dis*den.get(p)*temp);
        }else{
            parent.put(rp,rq);
            size.put(rq,size.get(rq)+size.get(rp));
            temp=num.get(p);
            num.put(rp,num.get(rp)*dis*num.get(q)*den.get(p));
            den.put(rp,den.get(rq)*den.get(q)*temp);
        }
    };
    /* 判断 p 和 q 是否连通 */
    public boolean connected(String p, String q){
        String rp=find(p);
        String rq=find(q);
        return rp.equals(rq);
    }
    /* 判断 p 和 q 联通权重，无返回-1 */
    public double divide(String p, String q){
        if(!parent.containsKey(p)||!parent.containsKey(q)){
            return -1;
        }
        String rp=find(p);
        String rq=find(q);
        return rp.equals(rq)?num.get(p)*den.get(q)/(num.get(q)*den.get(p)):-1;
    };
    /* 返回某个节点 x 的根节点 */
    //private int find(int x) {
    private String find(String x) {
        //return x.equals(parent.get(x))?x:parent.put(x,parent.get(parent.get(x)));
        while(!x.equals(parent.get(x))){
        	// 进行路径压缩
        	num.put(x,num.get(x)*num.get(parent.get(x)));
        	den.put(x,den.get(x)*den.get(parent.get(x)));
        	parent.put(x,parent.get(parent.get(x)));
        	x=parent.get(x);
        }
        return x;
    }
    private void init(String s){
        if (!parent.containsKey(s)) {
            parent.put(s,s);
            num.put(s,1.0);
            den.put(s,1.0);
            size.put(s,1);
        }
    }
}
//public class UF{
//    // 节点 x 的根节点是 parent[x]
//    private int[] parent;
//    // 新增一个数组记录树的“重量”
//    private int[] size;
//    // 新增一个数组记录权值
//    private double[][] dist;
//    /* 构造函数，n 为图的节点总数 */
//    public UF(int n) {
//        // 一开始互不连通
//        parent = new int[n];
//        size = new int[n];
//        dist=new double[n][2];
//        for (int i = 0; i < n; i++){
//            // 父节点指针初始指向自己
//            parent[i] = i;
//            // 重量应该初始化 1
//            size[i] = 1;
//            dist[i][0]=1;
//            dist[i][1]=1;
//        }
//    }
//
//    /* 将 p 和 q 连接 */
//    public void union(int p, int q,double dis){
//        int rp=find(p);
//        int rq=find(q);
//        if(rp==rq){
//            return;
//        }
//        if(size[rp]>size[rq]){
//            parent[rq]=rp;
//            size[rp] += size[rq];
//            dist[rq][0]=dist[p][0];
//            dist[rq][1]*=dis*dist[p][1];
//        }else{
//            parent[rp]=rq;
//            size[rq] += size[rp];
//            dist[rp][0]*=dis*dist[q][0];
//            dist[rp][1]=dist[q][1];
//        }
//    };
//    /* 判断 p 和 q 是否连通 */
//    public boolean connected(int p, int q){
//        int rp=find(p);
//        int rq=find(q);
//        return parent[rp]==parent[rq];
//    }
//    /* 判断 p 和 q 联通权重，无返回-1 */
//    public double divide(int p, int q){
//        int rp=find(p);
//        int rq=find(q);
//        return parent[rp]==parent[rq]?dist[p][0]*dist[q][1]/(dist[q][0]*dist[p][1]):-1;
//    };;
//
//    /* 返回某个节点 x 的根节点 */
//    private int find(int x) {
//        // 根节点的 parent[x] == x
//        while(x!=parent[x]){
//            // 进行路径压缩
//            dist[x][0]*=dist[parent[x]][0];
//            dist[x][1]*=dist[parent[x]][1];
//            parent[x] = parent[parent[x]];
//            x=parent[x];
//        }
//        return x;
//    }
//}
