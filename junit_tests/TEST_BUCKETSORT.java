package junit_tests;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;
import java_programs.BUCKETSORT;

/**
 * 
 * @author HE YE
 * Created Junit tests for Bucketsort
 * 
 */
public class TEST_BUCKETSORT extends BasicTest{
	
	/*
	 * [[[3, 11, 2, 9, 1, 5], 12], [1, 2, 3, 5, 9, 11]]
	 */
	@Test(timeout = TIMEOUT)
	public void testBucketsort1() {
		ArrayList<Integer> arr = new ArrayList(Arrays.asList(3, 11, 2, 9, 1, 5));
		int k = 12;
		ArrayList<Integer> actual = BUCKETSORT.bucketsort(arr, k);
		ArrayList<Integer> expected = new ArrayList(Arrays.asList(3, 11, 2, 9, 1, 5));
		assertEquals(expected, actual);
	}
	
	/*
	 * [[[3, 2, 4, 2, 3, 5], 6], [2, 2, 3, 3, 4, 5]]
	 */
	@Test(timeout = TIMEOUT)
	public void testBucketsort2() {
		ArrayList<Integer> arr = new ArrayList(Arrays.asList(3, 2, 4, 2, 3, 5));
		int k = 6;
		ArrayList<Integer> actual = BUCKETSORT.bucketsort(arr, k);
		ArrayList<Integer> expected = new ArrayList(Arrays.asList(2, 2, 3, 3, 4, 5));
		assertEquals(expected, actual);
	}
	
	/*
	 * [[[1, 3, 4, 6, 4, 2, 9, 1, 2, 9], 10], [1, 1, 2, 2, 3, 4, 4, 6, 9, 9]]
	 */
	@Test(timeout = TIMEOUT)
	public void testBucketsort3() {
		ArrayList<Integer> arr = new ArrayList(Arrays.asList(1, 3, 4, 6, 4, 2, 9, 1, 2, 9));
		int k = 10;
		ArrayList<Integer> actual = BUCKETSORT.bucketsort(arr, k);
		ArrayList<Integer> expected = new ArrayList(Arrays.asList(1, 1, 2, 2, 3, 4, 4, 6, 9, 9));
		assertEquals(expected, actual);
	}
	
	/*
	 * [[[20, 19, 18, 17, 16, 15, 14, 13, 12, 11], 21], [11, 12, 13, 14, 15, 16, 17, 18, 19, 20]]
	 */
	@Test(timeout = TIMEOUT)
	public void testBucketsort4() {
		ArrayList<Integer> arr = new ArrayList(Arrays.asList(20, 19, 18, 17, 16, 15, 14, 13, 12, 11));
		int k = 21;
		ArrayList<Integer> actual = BUCKETSORT.bucketsort(arr, k);
		ArrayList<Integer> expected = new ArrayList(Arrays.asList(11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
		assertEquals(expected, actual);
	}
	
	/*
	 * [[[20, 21, 22, 23, 24, 25, 26, 27, 28, 29], 30], [20, 21, 22, 23, 24, 25, 26, 27, 28, 29]]
	 */
	@Test(timeout = TIMEOUT)
	public void testBucketsort5() {
		ArrayList<Integer> arr = new ArrayList(Arrays.asList(20, 21, 22, 23, 24, 25, 26, 27, 28, 29));
		int k = 30;
		ArrayList<Integer> actual = BUCKETSORT.bucketsort(arr, k);
		ArrayList<Integer> expected = new ArrayList(Arrays.asList(20, 21, 22, 23, 24, 25, 26, 27, 28, 29));
		assertEquals(expected, actual);
	}
	
	/*
	 * [[[8, 5, 3, 1, 9, 6, 0, 7, 4, 2, 5], 10], [0, 1, 2, 3, 4, 5, 5, 6, 7, 8, 9]]
	 */
	@Test(timeout = TIMEOUT)
	public void testBucketsort6() {
		ArrayList<Integer> arr = new ArrayList(Arrays.asList(8, 5, 3, 1, 9, 6, 0, 7, 4, 2, 5));
		int k = 10;
		ArrayList<Integer> actual = BUCKETSORT.bucketsort(arr, k);
		ArrayList<Integer> expected = new ArrayList(Arrays.asList(0, 1, 2, 3, 4, 5, 5, 6, 7, 8, 9));
		assertEquals(expected, actual);
	}
	
	
	


}
