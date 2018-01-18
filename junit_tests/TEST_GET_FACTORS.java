package junit_tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import java_programs.GET_FACTORS;


/**
 * 
 * @author HE YE
 * Created Junit tests for GET_FACTORS
 */
public class TEST_GET_FACTORS extends BasicTest{
	
	/*
	 * [1, []]
	 */
	@Test(timeout = TIMEOUT)
	public void testGetFactors1() {
		ArrayList<Integer> actual = GET_FACTORS.get_factors(1);	
		ArrayList<Integer> expected = new ArrayList(Arrays.asList());
		assertEquals(expected, actual);
	}

}
