package junit_tests;

import org.junit.Test;
import java_programs.BITCOUNT;
import static org.junit.Assert.assertEquals;

/**
 * 
 * @author HE YE
 * Created Junit tests for Bitcount
 * Bitcount contains a dead loop bug
 */

public class TEST_BITCOUNT extends BasicTest{

	/*
	 * [127, 7]
	 */
	@Test(timeout = TIMEOUT)
	public void testBitcount1() {
		int inputVal = 127;
		int returnVal = BITCOUNT.bitcount(inputVal);
		assertEquals(7, returnVal);
	}

	/*
	 * [128, 1]
	 */
	@Test(timeout = TIMEOUT)
	public void testBitcount2() {
		int inputVal = 128;
		int returnVal = BITCOUNT.bitcount(inputVal);
		assertEquals(1, returnVal);
	}

	/*
	 * [3005, 9]
	 */
	@Test(timeout = TIMEOUT)
	public void testBitcount3() {
		int inputVal = 3005;
		int returnVal = BITCOUNT.bitcount(inputVal);
		assertEquals(9, returnVal);
	}

	/*
	 * [13, 3]
	 */
	@Test(timeout = TIMEOUT)
	public void testBitcount4() {
		int inputVal = 13;
		int returnVal = BITCOUNT.bitcount(inputVal);
		assertEquals(3, returnVal);
	}

	/*
	 * [14, 3]
	 */
	@Test(timeout = TIMEOUT)
	public void testBitcount5() {
		int inputVal = 14;
		int returnVal = BITCOUNT.bitcount(inputVal);
		assertEquals(3, returnVal);
	}

	/*
	 * [27, 4]
	 */
	@Test(timeout = TIMEOUT)
	public void testBitcount6() {
		int inputVal = 27;
		int returnVal = BITCOUNT.bitcount(inputVal);
		assertEquals(4, returnVal);
	}

	/*
	 * [834, 4]
	 */
	@Test(timeout = TIMEOUT)
	public void testBitcount7() {
		int inputVal = 834;
		int returnVal = BITCOUNT.bitcount(inputVal);
		assertEquals(4, returnVal);
	}

	/*
	 * [254, 7]
	 */
	@Test(timeout = TIMEOUT)
	public void testBitcount8() {
		int inputVal = 254;
		int returnVal = BITCOUNT.bitcount(inputVal);
		assertEquals(7, returnVal);
	}

	/*
	 * [256, 1]
	 */
	@Test(timeout = TIMEOUT)
	public void testBitcount9() {
		int inputVal = 261;
		int returnVal = BITCOUNT.bitcount(inputVal);
		assertEquals(1, returnVal);
	}

	//
	//   @Test(expected = ArithmeticException.class)
	//   public void divideByZero() ...{
	//         calculator.divide(0);
	//   }

}
