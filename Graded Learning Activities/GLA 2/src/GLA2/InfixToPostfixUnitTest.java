/**
 * 
 */
package GLA2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author mmurshed
 *
 */
class InfixToPostfixUnitTest {
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Begin testing Infix to Postfix expression conversion: ");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("All tests complete... ");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test1() {
		InfixToPostfix exp1=new InfixToPostfix();
		String infix="w - 5.1 / sum * 2";
		String groundTruth="w 5.1 sum / 2 * -";
		String postfix=exp1.getInfixToPostfix(infix);
		
		System.out.println(postfix+"=="+groundTruth);
		assertEquals(postfix,groundTruth);
		
	}
	
	
	@Test
	void test2() {
		InfixToPostfix exp1=new InfixToPostfix();
		String infix="A + B * C";
		String groundTruth="A B C * +";
		String postfix=exp1.getInfixToPostfix(infix);
		
		System.out.println(postfix+"=="+groundTruth);
		assertEquals(postfix,groundTruth);
		
	}
	
	@Test
	void test3() {
		InfixToPostfix exp1=new InfixToPostfix();
		String infix="A + B + C + D";
		String groundTruth="A B + C + D +";
		String postfix=exp1.getInfixToPostfix(infix);
		
		System.out.println(postfix+"=="+groundTruth);
		assertEquals(postfix,groundTruth);
		
	}
	
	@Test
	void test4() {
		InfixToPostfix exp1=new InfixToPostfix();
		String infix="10 + 3 * 5 / 16 - 4";
		String groundTruth="10 3 5 * 16 / + 4 -";
		String postfix=exp1.getInfixToPostfix(infix);
		
		System.out.println(postfix+"=="+groundTruth);
		assertEquals(postfix,groundTruth);
		
	}
	
	@Test
	void test5() {
		InfixToPostfix exp1=new InfixToPostfix();
		String infix="Apple * Banana + Cake / Donut";
		String groundTruth="Apple Banana * Cake Donut / +";
		String postfix=exp1.getInfixToPostfix(infix);
		
		System.out.println(postfix+"=="+groundTruth);
		assertEquals(postfix,groundTruth);
		
	}
	
	@Test
	void test6() {
		InfixToPostfix exp1=new InfixToPostfix();
		String infix="100 - 87 + 6 * 2 / 12 - 33 * 2 + 3 % 4 * 12 / 2 + 3 - 12 % 2 * 3";
		String groundTruth="100 87 - 6 2 * 12 / + 33 2 * - 3 4 % 12 * 2 / + 3 + 12 2 % 3 * -";
		String postfix=exp1.getInfixToPostfix(infix);
		
		System.out.println(postfix+"=="+groundTruth);
		assertEquals(postfix,groundTruth);
		
	}

}
