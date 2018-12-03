package com.aki.sorting.service.serviceimpl;

import com.aki.sorting.service.ServiceSorting;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Aki on 2018/10/15.
 */
@Service(value = "sort")
public class ServiceSortingImpl implements ServiceSorting {

    /*  一. 冒泡排序(BubbleSort)
      基本思想：两个数比较大小，较大的数下沉，较小的数冒起来。
      过程：
      比较相邻的两个数据，如果第二个数小，就交换位置。
      从后向前两两比较，一直到比较最前两个数据。最终最小数被交换到起始的位置，这样第一个最小数的位置就排好了。
      继续重复上述过程，依次将第2.3...n-1个最小数排好位置。*/
   /* 优化
    设置标志位flag，如果发生了交换flag设置为true；如果没有交换就设置为false。
    这样当一轮比较结束后如果flag仍为false，即：这一轮没有发生交换，说明数据的顺序已经排好，没有必要继续进行下去。*/
    @Override
    public void bubblesort(int[] ints) throws Exception {
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
                if (!flag) break;
            }
        }
    }

    /*    二. 选择排序(SelctionSort)
        基本思想：
        在长度为N的无序数组中，第一次遍历n-1个数，找到最小的数值与第一个元素交换；
        第二次遍历n-2个数，找到最小的数值与第二个元素交换；
                。。。
        第n-2次遍历，找到最小的数值与第n-2个元素交换，排序完成。
        第n-1次遍历，找到最小的数值与第n-1个元素交换，排序完成。*/
    @Override
    public void selectsort(int[] array) throws Exception {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
    }

    /* 基本思想：
     在要排序的一组数中，假定前n-1个数已经排好序，
     现在将第n个数插到前面的有序数列中，使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。*/
    @Override
    public void insertionsort(int[] array) throws Exception {
        int length = array.length;
        int temp;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                } else {         //不需要交换
                    break;
                }
            }
        }
    }

    /*  前言：
      数据序列1： 13-17-20-42-28 利用插入排序，13-17-20-28-42. Number of swap:1;
      数据序列2： 13-17-20-42-14 利用插入排序，13-14-17-20-42. Number of swap:3;
      如果数据序列基本有序，使用插入排序会更加高效。
      基本思想：
      在要排序的一组数中，根据某一增量分为若干子序列，并对子序列分别进行插入排序。
      然后逐渐将增量减小,并重复上述过程。直至增量为1,此时数据序列基本有序,最后进行插入排序。*/
    @Override
    public void shellsort(int[] array) throws Exception {
        int temp = 0;
        int length = array.length;
        int incre = length;

        while (true) {
            incre = incre / 2;     //分成了多少组
            for (int k = 0; k < incre; k++) {    //循环排序多少组
                for (int i = k; i < length - incre; i += incre) {  //插排
                    for (int j = i + incre; j > k; j -= incre) {
                        if (array[j] < array[j - incre]) {
                            temp = array[j - incre];
                            array[j - incre] = array[j];
                            array[j] = temp;
                        } else {
                            break;
                        }
                    }
                }
            }
            if (incre == 1) {
                break;
            }
        }
    }

    /*    基本思想：（分治）
        先从数列中取出一个数作为key值；
        将比这个数小的数全部放在它的左边，大于或等于它的数全部放在它的右边；
        对左右两个小数列重复第二步，直至各区间只有1个数。*/
    @Override
    public void quicksort(int a[], int low, int high) throws Exception {
        if(low >= high)return;
        int s = low;
        int e = high;
        int key = a[s];

        while (s < e){
            while (s < e && key <= a[e]){
                e--;
            }
            if(s < e){
                a[s] = a[e];
                s++;
            }
            while (s < e && a[s] < key){
                s++;
            }
            if(s < e){
                a[e] = a[s];
                e--;
            }
            a[s] = key;
            System.out.println(Arrays.toString(a));
        }

        quicksort(a, low, s-1);
        quicksort(a, s+1, high);
    }

/*    归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法的一个非常典型的应用。
    首先考虑下如何将2个有序数列合并。这个非常简单，只要从比较2个数列的第一个数，谁小就先取谁，
    取了后就在对应数列中删除这个数。然后再进行比较，如果有数列为空，那直接将另一个数列的数据依次取出即可。*/
    @Override
    //合并 ：将两个序列a[first-middle],a[middle+1-end]合并
    public void mergeArray(int[] a, int first, int middle, int end, int[] temp) throws Exception {
        int i = first;
        int m = middle;
        int j = middle + 1;
        int n = end;
        int k = 0;
        while (i <= m && j <= n){
            if (a[i] < a[j]){
                temp[k] = a[i];
                k++;
                i++;
            }else{
                temp[k] = a[j];
                k++;
                j++;
            }
        }

        //其中有一边取完了
        while (i <= m){
            temp[k] = a[i];
            k++;
            i++;
        }
        while (j <= n){
            temp[k] = a[j];
            k++;
            j++;
        }

        for (int l = 0; l < k; l++) {
            a[first + l] = temp[l];
        }
    }

    @Override
    public void merge_sort(int[] a, int first, int last, int[] temp) throws Exception {
        if(first < last){
            int middle = (first + last) / 2;
            merge_sort(a, first, middle, temp);             //左半部分排好序
            merge_sort(a, middle + 1, last, temp);      //右半部分排好序
            mergeArray(a,first,middle,last,temp);           //合并左右部分
        }
    }

    @Override
    //n节点总数
    public void MinHeapFixdown(int[] a, int i, int n) throws Exception {
        int j = 2*i+1;
        int temp = 0;

        while (j<n){
            //在左右节点中号最小的
            if(j+1<n && a[j+1]<a[j]){
                j++;
            }
            if(a[i] <= a[j])
                break;
            //较大节点下移
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;

            i = j;
            j = 2*i+1;
        }
    }

    @Override
    public void MakeMinHeap(int[] a, int n) throws Exception {
        for(int i=(n-1)/2 ; i>=0 ; i--){
            MinHeapFixdown(a,i,n);
        }
    }

    @Override
    public void MinHeap_Sort(int[] a, int n) throws Exception {
        int temp = 0;
        MakeMinHeap(a,n);

        for(int i=n-1;i>0;i--){
            temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            MinHeapFixdown(a,0,i);
        }
    }

/*    （1）首先确定基数为10，数组的长度也就是10.每个数34都会在这10个数中寻找自己的位置。
            （2）不同于BinSort会直接将数34放在数组的下标34处，基数排序是将34分开为3和4，
    第一轮排序根据最末位放在数组的下标4处，第二轮排序根据倒数第二位放在数组的下标3处，然后遍历数组即可。*/
    @Override
    public void RadixSort(int[] A, int[] temp, int n, int k, int r, int[] cnt) throws Exception {
        //A:原数组
        //temp:临时数组
        //n:序列的数字个数
        //k:最大的位数2
        //r:基数10
        //cnt:存储bin[i]的个数

        for(int i=0 , rtok=1; i<k ; i++ ,rtok = rtok*r){

            //初始化
            for(int j=0;j<r;j++){
                cnt[j] = 0;
            }
            //计算每个箱子的数字个数
            for(int j=0;j<n;j++){
                cnt[(A[j]/rtok)%r]++;
            }
            //cnt[j]的个数修改为前j个箱子一共有几个数字
            for(int j=1;j<r;j++){
                cnt[j] = cnt[j-1] + cnt[j];
            }
            for(int j = n-1;j>=0;j--){      //重点理解
                cnt[(A[j]/rtok)%r]--;
                temp[cnt[(A[j]/rtok)%r]] = A[j];
            }
            for(int j=0;j<n;j++){
                A[j] = temp[j];
            }
        }
    }
}
