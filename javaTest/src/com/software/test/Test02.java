package com.software.test;

public class Test02 {
    public static void main(String[] args) {
        String str="粘贴板上是IB9A6D-bjw，ios已经跟他调了";
        int index=str.indexOf("-bjw");
       String str2= str.substring(index-6,index);
        System.out.println(str2);


    }
}
