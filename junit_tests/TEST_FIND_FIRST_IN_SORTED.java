package junit_tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java_programs.FIND_FIRST_IN_SORTED;

/**
 * 
 * @author HE YE
 * To test ArrayIndexOutOfBoundsException
 */
public class TEST_FIND_FIRST_IN_SORTED extends BasicTest {

	/*
	 * [[[3, 4, 5, 5, 5, 5, 6], 5], 2]
	 */
	@Test(timeout = TIMEOUT)
	public void testFindFirstInSorted1() {
		int[] arr = new int[]{3, 4, 5, 5, 5, 5, 6};
		int x = 30;
		int returnVal = FIND_FIRST_IN_SORTED.find_first_in_sorted(arr, x);
		assertEquals(2, returnVal);
	}
	
	
	/*
	 * [[[3, 4, 5, 5, 5, 5, 6], 7], -1]
	 */
	@Test(timeout = TIMEOUT)
	public void testFindFirstInSorted2() {
		int[] arr = new int[]{3, 4, 5, 5, 5, 5, 6};
		int x = 7;
		int returnVal = FIND_FIRST_IN_SORTED.find_first_in_sorted(arr, x);
		assertEquals(-1, returnVal);
	}
	
	
	/*
	 * [[[3, 4, 5, 5, 5, 5, 6], 2], -1]
	 */
	@Test(timeout = TIMEOUT)
	public void testFindFirstInSorted3() {
		int[] arr = new int[]{3, 4, 5, 5, 5, 5, 6};
		int x = 2;
		int returnVal = FIND_FIRST_IN_SORTED.find_first_in_sorted(arr, x);
		assertEquals(-1, returnVal);
	}
	
	
	/*
	 * [[[3, 6, 7, 9, 9, 10, 14, 27], 14], 6]
	 */
	@Test(timeout = TIMEOUT)
	public void testFindFirstInSorted4() {
		int[] arr = new int[]{3, 6, 7, 9, 9, 10, 14, 27};
		int x = 14;
		int returnVal = FIND_FIRST_IN_SORTED.find_first_in_sorted(arr, x);
		assertEquals(6, returnVal);
	}
	
	/*
	 * [[[0, 1, 6, 8, 13, 14, 67, 128], 80], -1]
	 */
	@Test(timeout = TIMEOUT)
	public void testFindFirstInSorted5() {
		int[] arr = new int[]{0, 1, 6, 8, 13, 14, 67, 128};
		int x = 80;
		int returnVal = FIND_FIRST_IN_SORTED.find_first_in_sorted(arr, x);
		assertEquals(-1, returnVal);
	}
	
	/*
	 * [[[0, 1, 6, 8, 13, 14, 67, 128], 67], 6]
	 */
	@Test(timeout = TIMEOUT)
	public void testFindFirstInSorted6() {
		int[] arr = new int[]{0, 1, 6, 8, 13, 14, 67, 128};
		int x = 67;
		int returnVal = FIND_FIRST_IN_SORTED.find_first_in_sorted(arr, x);
		assertEquals(6, returnVal);
	}
	
	/*
	 * [[[0, 1, 6, 8, 13, 14, 67, 128], 128], 7]
	 */
	@Test(timeout = TIMEOUT)
	public void testFindFirstInSorted7() {
		int[] arr = new int[]{0, 1, 6, 8, 13, 14, 67, 128};
		int x = 128;
		int returnVal = FIND_FIRST_IN_SORTED.find_first_in_sorted(arr, x);
		assertEquals(7, returnVal);
	}
}
