package com.company;
import java.util.*;



public class Main {
    int[] parent = new int[1001];
    int[] value = new int[1001];
    public static int find(int c){
        if(c == parent[c])
            return c;
        return find(parent[c]);
    }
    public static void main(String[] args) {
	// write your code here
        System.out.println("fuck");
        return;
    }
}
