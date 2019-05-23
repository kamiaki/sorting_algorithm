package com.aki.sorting;

import com.google.common.primitives.Ints;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        int[] arr = new int[]{10,23,42,1,35,65,111,34,321,95,0,8,9};
        List<Integer> list = Ints.asList(arr);
        System.out.println(list);
        bubblesort(arr);
        list = Ints.asList(arr);
        System.out.println(list);
    }

    public static void bubblesort(int[] ints)  {
        int temp;
        boolean flag;//是否交换的标志
        for (int i = 0; i < ints.length - 1; i++) {
            flag = false;
            for (int j = ints.length - 1; j > i; j--) {
                if (ints[j] < ints[j - 1]) {
                    temp = ints[j];
                    ints[j] = ints[j - 1];
                    ints[j - 1] = temp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }
}
