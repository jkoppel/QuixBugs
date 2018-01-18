package junit_tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import java_programs.BUCKETSORT;
import java_programs.GCD;

/**
 * 
 * @author HE YE
 * Created Junit tests for GCD
 * To test StackOverflowError
 */
public class TEST_GCD extends BasicTest{

	/*
	 * [[13, 13], 13]
	 */
	@Test(timeout = TIMEOUT)
	public void testGCD1() {
		int actual = GCD.gcd(13, 13);	
		assertEquals(13, actual);
	}
	
	/*
	 * [[37, 600], 1]
	 */
	@Test(timeout = TIMEOUT)
	public void testGCD2() {
		int actual = GCD.gcd(37, 600);	
		assertEquals(1, actual);
	}
	
	/*
	 * [[20, 100], 20]
	 */
	@Test(timeout = TIMEOUT)
	public void testGCD3() {
		int actual = GCD.gcd(20, 100);	
		assertEquals(20, actual);
	}
	
	/*
	 * [[624129, 2061517], 18913]
	 */
	@Test(timeout = TIMEOUT)
	public void testGCD4() {
		int actual = GCD.gcd(624129, 2061517);	
		assertEquals(18913, actual);
	}
	
	/*
	 * [[3, 12], 3]
	 */
	@Test(timeout = TIMEOUT)
	public void testGCD5() {
		int actual = GCD.gcd(3, 12);	
		assertEquals(3, actual);
	}
}
