package com.aki.sorting.service.serviceimpl;

import com.aki.sorting.service.ServiceSorting;
import org.springframework.stereotype.Service;

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
    @Override
    public void bubblesort(int[] ints) throws Exception {
        int[] arr = ints;
        int temp;//临时变量
        for (int i = 0; i < arr.length - 1; i++) {   //表示趟数，一共arr.length-1次。
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }
}
