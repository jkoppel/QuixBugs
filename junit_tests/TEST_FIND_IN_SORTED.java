package junit_tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java_programs.FIND_IN_SORTED;

/**
 * 
 * @author HE YE
 * Created Junit tests for FIND_IN_SORTED
 * To test StackOverflowError
 */
public class TEST_FIND_IN_SORTED extends BasicTest {

	/*
	 * [[[3, 4, 5, 5, 5, 5, 6], 5], 3]
	 */
	@Test(timeout = TIMEOUT)
	public void testFindInSorted1() {
		int[] arr = new int[]{3, 4, 5, 5, 5, 5, 6};
		int x = 5;
		int returnVal = FIND_IN_SORTED.find_in_sorted(arr, x);
		assertEquals(3, returnVal);
	}
	
	/*
	 * [[[1, 2, 3, 4, 6, 7, 8], 5], -1]
	 */
	@Test(timeout = TIMEOUT)
	public void testFindInSorted2() {
		int[] arr = new int[]{1, 2, 3, 4, 6, 7, 8};
		int x = 5;
		int returnVal = FIND_IN_SORTED.find_in_sorted(arr, x);
		assertEquals(-1, returnVal);
	}
	
	/*
	 * [[[1, 2, 3, 4, 6, 7, 8], 4], 3]
	 */
	@Test(timeout = TIMEOUT)
	public void testFindInSorted3() {
		int[] arr = new int[]{1, 2, 3, 4, 6, 7, 8};
		int x = 4;
		int returnVal = FIND_IN_SORTED.find_in_sorted(arr, x);
		assertEquals(3, returnVal);
	}
	
	/*
	 * [[[2, 4, 6, 8, 10, 12, 14, 16, 18, 20], 18], 8]
	 */
	@Test(timeout = TIMEOUT)
	public void testFindInSorted4() {
		int[] arr = new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
		int x = 18;
		int returnVal = FIND_IN_SORTED.find_in_sorted(arr, x);
		assertEquals(8, returnVal);
	}
	
	/*
	 * [[[3, 5, 6, 7, 8, 9, 12, 13, 14, 24, 26, 27], 0], -1]
	 */
	@Test(timeout = TIMEOUT)
	public void testFindInSorted5() {
		int[] arr = new int[]{3, 5, 6, 7, 8, 9, 12, 13, 14, 24, 26, 27};
		int x = 0;
		int returnVal = FIND_IN_SORTED.find_in_sorted(arr, x);
		assertEquals(-1, returnVal);
	}
	
	/*
	 * [[[3, 5, 6, 7, 8, 9, 12, 12, 14, 24, 26, 27], 12], 6]
	 */
	@Test(timeout = TIMEOUT)
	public void testFindInSorted6() {
		int[] arr = new int[]{3, 5, 6, 7, 8, 9, 12, 12, 14, 24, 26, 27};
		int x = 12;
		int returnVal = FIND_IN_SORTED.find_in_sorted(arr, x);
		assertEquals(6, returnVal);
	}
	
	/*
	 * [[[24, 26, 28, 50, 59], 101], -1]
	 */
	@Test(timeout = TIMEOUT)
	public void testFindInSorted7() {
		int[] arr = new int[]{24, 26, 28, 50, 59};
		int x = 101;
		int returnVal = FIND_IN_SORTED.find_in_sorted(arr, x);
		assertEquals(-1, returnVal);
	}
	
	
	
	
}
