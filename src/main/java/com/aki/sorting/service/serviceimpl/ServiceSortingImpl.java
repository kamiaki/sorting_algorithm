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
   /* 优化
    设置标志位flag，如果发生了交换flag设置为true；如果没有交换就设置为false。
    这样当一轮比较结束后如果flag仍为false，即：这一轮没有发生交换，说明数据的顺序已经排好，没有必要继续进行下去。*/
    @Override
    public void bubblesort(int[] ints) throws Exception {
        int temp;
        boolean flag;//是否交换的标志
        for (int i = 0; i < ints.length - 1; i++) {
            flag = false;
            for (int j = ints.length - 1; j > i ; j--) {
                if(ints[j] < ints[j - 1]){
                    temp = ints[j];
                    ints[j] = ints[j - 1];
                    ints[j-1] = temp;
                    flag = true;
                }
                if(!flag) break;
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
    public void selectsort(int[] array)throws Exception{
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                    if (array[j] < array[minIndex]){
                        minIndex = j;
                    }
            }
            if(minIndex != i){
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
    }
}
