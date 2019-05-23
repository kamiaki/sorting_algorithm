package com.aki.sorting.thread;

import com.aki.sorting.webSocket.sortingWebSocket;
import com.google.common.primitives.Ints;

import java.util.List;

public class outPutSorting implements Runnable{
    private int[] intArray;
    private sortingWebSocket wsObj;

    public outPutSorting(int[] intArray, sortingWebSocket wsObj) {
        this.intArray = intArray;
        this.wsObj = wsObj;
    }

    @Override
    public void run() {
        List list;
        int temp;
        boolean flag;//是否交换的标志
        for (int i = 0; i < intArray.length - 1; i++) {
            flag = false;
            for (int j = intArray.length - 1; j > i; j--) {
                if (intArray[j] < intArray[j - 1]) {
                    temp = intArray[j];
                    intArray[j] = intArray[j - 1];
                    intArray[j - 1] = temp;
                    flag = true;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    list = Ints.asList(intArray);
                    wsObj.sendMsg(list.toString());
                }
            }
            if (!flag) break;
        }
    }
}
