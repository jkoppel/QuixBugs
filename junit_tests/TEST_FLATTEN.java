package junit_tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.google.gson.JsonParser;
import java_programs.FLATTEN;

/**
 * 
 * @author HE YE
 * Created Junit tests for FIND_IN_SORTED
 * To test StackOverflowError
 */
public class TEST_FLATTEN extends BasicTest{

	/*
	 * [[[[1, [], [2, 3]], [[4]], 5]], [1, 2, 3, 4, 5]]
	 */
	@Test(timeout = TIMEOUT)
	public void testFlatten1() {		
		Object obj = new JsonParser().parse("[[[1, [], [2, 3]], [[4]], 5]]");		
		Object returnObj = FLATTEN.flatten(obj);
		Object expectedObj = new JsonParser().parse("[1, 2, 3, 4, 5]");
		assertEquals(expectedObj, returnObj);
	}
	
	
	/*
	 * [[[[], [], [], [], []]], []]
	 */
	@Test(timeout = TIMEOUT)
	public void testFlatten2() {		
		Object obj = new JsonParser().parse("[[[], [], [], [], []]]");		
		Object returnObj = FLATTEN.flatten(obj);
		Object expectedObj = new JsonParser().parse("[]");
		assertEquals(expectedObj, returnObj);
	}
	

	/*
	 * [[[[], [], 1, [], 1, [], []]], [1, 1]]
	 */
	@Test(timeout = TIMEOUT)
	public void testFlatten3() {		
		Object obj = new JsonParser().parse("[[[], [], 1, [], 1, [], []]]");		
		Object returnObj = FLATTEN.flatten(obj);
		Object expectedObj = new JsonParser().parse("[1, 1]");
		assertEquals(expectedObj, returnObj);
	}
	
	/*
	 * [[[1, 2, 3, [[4]]]], [1, 2, 3, 4]]
	 */
	@Test(timeout = TIMEOUT)
	public void testFlatten4() {		
		Object obj = new JsonParser().parse("[[1, 2, 3, [[4]]]]");		
		Object returnObj = FLATTEN.flatten(obj);
		Object expectedObj = new JsonParser().parse("[1, 2, 3, 4]");
		assertEquals(expectedObj, returnObj);
	}
	
	
	/*
	 * [[[1, 4, 6]], [1, 4, 6]]
	 */
	@Test(timeout = TIMEOUT)
	public void testFlatten5() {		
		Object obj = new JsonParser().parse("[[1, 4, 6]]");	
		System.out.println("obj:"+obj);
		Object returnObj = FLATTEN.flatten(obj);
		Object expectedObj = new JsonParser().parse("[1, 4, 6]");
		assertEquals(expectedObj, returnObj);
	}
	
	

	/*
	 * [[["moe", "curly", "larry"]], ["moe", "curly", "larry"]]
	 */
	@Test(timeout = TIMEOUT)
	public void testFlatten6() {		
		Object obj = new JsonParser().parse("[[\"moe\", \"curly\", \"larry\"]]");	
		System.out.println("obj:"+obj);
		Object returnObj = FLATTEN.flatten(obj);
		Object expectedObj = new JsonParser().parse("[\"moe\", \"curly\", \"larry\"]");
		assertEquals(expectedObj, returnObj);
	}
	
	
}
