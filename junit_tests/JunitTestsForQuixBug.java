package junit_tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;

import junit.framework.Assert;

public class JunitTestsForQuixBug {

	@Test
	public void testBucketsort() throws IOException {
		generalJnitTest("bucketsort", "BUCKETSORT");
	}

	@Test
	public void testGcd() throws IOException {
		generalJnitTest("gcd", "GCD");
	}
	
	@Test
	public void testHanoi() throws IOException {
		generalJnitTest("hanoi", "HANOI");
	}
	
	@Test
	public void testFindFirstInSorted() throws IOException {
		generalJnitTest("find_first_in_sorted", "FIND_FIRST_IN_SORTED");
	}
	
	@Test
	public void testGetFactores() throws IOException {
		generalJnitTest("get_factors", "GET_FACTORS");
	}
	
	@Test
	public void testKth() throws IOException {
		generalJnitTest("kth", "KTH");
	}
	
	
	

	public void generalJnitTest(String jsonFile, String clazzName) throws IOException {
		JsonElement jsonElement = ReadJsonUtil.readJsonFile(jsonFile);
		System.out.println("jsonElement: " + jsonElement);
		JsonArray jsonArray = jsonElement.getAsJsonArray();
		JsonElement input = jsonArray.get(0);
		JsonElement output = jsonArray.get(1);
		System.out.println("input: " + input);
		JsonArray inputArray;
		if(input.isJsonArray()){
			inputArray = input.getAsJsonArray();
		} else {
			inputArray = new JsonArray();
			inputArray.add(input);
		}


		Class targetClass;
		try {
			targetClass = Class.forName("java_programs." + clazzName);
			Method[] method = targetClass.getDeclaredMethods();
			Type[] types = method[0].getParameterTypes();
			Assert.assertEquals("input parmeters are incorrect!", types.length, inputArray.size());
			// System.out.println("types: " + types[0]);

			Object[] parameters = ReadJsonUtil.getParameters(types, inputArray);
			String returnValue = String.valueOf(method[0].invoke(null, parameters));
			System.out.println("returnValue: " + returnValue);
			System.out.println("expected output: " + output.toString());
			Assert.assertEquals("Not expected output:", output.toString(), returnValue);

		} catch (ClassNotFoundException e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

}
