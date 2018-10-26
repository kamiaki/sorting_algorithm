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
    void quicksort(int a[],int low,int high)throws Exception;

    //归并
    void mergeArray(int a[],int first,int middle,int end,int temp[])throws Exception;
    void merge_sort(int a[],int first,int last,int temp[])throws Exception;

    //堆排序
    void MinHeapFixdown(int a[],int i,int n)throws Exception;//从i节点开始调整,n为节点总数 从0开始计算 i节点的子节点为 2*i+1, 2*i+2
    void MakeMinHeap(int a[], int n)throws Exception;//构建最小堆
    void MinHeap_Sort(int a[],int n)throws Exception;

    void RadixSort(int A[],int temp[],int n,int k,int r,int cnt[])throws Exception;
}
