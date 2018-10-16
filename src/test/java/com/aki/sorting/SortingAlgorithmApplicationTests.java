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

	private int[] ints;
	private Gson gson = new Gson();

	@Before
	public void first(){
		int number = 10;
		ints = new int[number];
		Random random = new Random();
		for (int i = 0; i < number; i++) {
//			ints[i] = 99 + (int)(Math.random()*(100+1-99));
			ints[i] = random.nextInt(100-0+1) + 0;
//			ints[i] = (int)((Math.random()*9+1)*100000);
		}
	}

	@Test
	public void contextLoads()throws Exception {
		System.out.println(gson.toJson(ints));
		//冒泡
		serviceSorting.bubblesort(ints);
		System.out.println(gson.toJson(ints));
	}

}
