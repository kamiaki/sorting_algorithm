package com.aki.sorting.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Aki on 2018/10/15.
 */
public interface ServiceSorting {
    void bubblesort(int[] ints)throws Exception;
    void selectsort(int[] array)throws Exception;
    void insertionsort(int[] array)throws Exception;
    void shellsort(int[] array)throws Exception;
}
