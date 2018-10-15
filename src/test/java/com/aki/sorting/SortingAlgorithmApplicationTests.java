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
	@Before
	public void first(){
		ints = new int[10];
		for (int i = 0; i < 10; i++) {
			ints[i] = Long.valueOf(Math.round(Math.random()*(100-0)+0)).intValue();
		}
	}

	@Test
	public void contextLoads()throws Exception {
		Gson gson = new Gson();
		System.out.println(gson.toJson(ints));
		serviceSorting.bubblesort(ints);
		System.out.println(gson.toJson(ints));
	}

}
