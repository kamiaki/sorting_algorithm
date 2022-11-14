package com.aki.sorting;

import com.aki.sorting.service.ServiceSorting;
import com.aki.sorting.service.serviceimpl.ServiceSortingImpl;
import com.google.common.primitives.Ints;

import java.util.ArrayList;
import java.util.List;

public class test {
    static ServiceSorting serviceSorting;
    static{
        serviceSorting = new ServiceSortingImpl();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10,23,42,1,35,65,111,34,321,95,0,8,9};

        List<Integer> list = Ints.asList(arr);
        System.out.println(list);

        try {
            serviceSorting.bubblesort(arr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        list = Ints.asList(arr);
        System.out.println(list);
    }

}
