package com.software.test;

public class TestRegist {
    public static void main(String[] args) {
        System.out.println("1373178064514580480".replaceAll("\\d{16}(\\d{3})", "**** **** **** **** $1"));
    }
}
