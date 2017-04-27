package com.test.ww;

import java.util.HashMap;

import org.testng.annotations.Test;
import org.openqa.selenium.By;

public class WWTestCases extends WWTestBase {

	String xpath;
	String Item;

	public WWTestCases() {
		this.resourceFileName = "ww_en_US.properties";
	}

	@Test
	public void TestCase1_PrintFoodItems() throws Exception {
		Item = driver.findElement(By.xpath(getProperty("Third_Item")))
				.getText();
		System.out.println(Item);
		Item = driver.findElement(By.xpath(getProperty("Fifth_Item")))
				.getText();
		System.out.println(Item);
	}

	@Test
	public void TestCase2_PrintFoodServingsFromMap() throws Exception {
		String foodname, servings;
		HashMap<String, String> fooditems = new HashMap<String, String>();
		for (int i = 1; i <= 5; i++) {
			foodname = driver.findElement(By.xpath("//div[@class=”itemContent”]/span[@class=”title ng-bindin”][i]")).getText();
			servings = driver.findElement(By.xpath("//div[@class=”itemContent”]/span[@class=”description ng-binding”][i]")).getText();

			fooditems.put(foodname, servings);
		}
		System.out.println("map size" + fooditems.size());
		for (String key : fooditems.keySet()) {
			System.out.println(key + fooditems.get(key));
			System.out.println();
		}

	}
}
