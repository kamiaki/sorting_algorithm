package com.aki.sorting;

import com.aki.sorting.service.ServiceSorting;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import org.json.JSONArray;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SortingAlgorithmApplicationTests {
	@Autowired
	@Qualifier(value = "sort")
	ServiceSorting serviceSorting;

	private int number = 10;
	private int min = 0;
	private int max = 10;
	private int[] ints;
	private Gson gson = new Gson();
	private Random random = new Random();

	@Before
	public void first(){
		ints = new int[number];
		for (int i = 0; i < number; i++) {
			ints[i] = min+(int)(Math.random()*(max+1-min));
		}
	}

	@Test
	public void contextLoads()throws Exception {
		System.out.println(gson.toJson(ints));
//		//冒泡
//		serviceSorting.bubblesort(ints);
//		System.out.println(gson.toJson(ints));
		//选择
		serviceSorting.selectsort(ints);
		System.out.println(gson.toJson(ints));
	}

}
