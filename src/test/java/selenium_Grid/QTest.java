package selenium_Grid;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class QTest {

	@Test(invocationCount = 2)
	public void a() {
		System.out.println("a is a test method");
	}

	@Test
	public void b() {
		System.out.println("b is a test method");
	}

	@Test(invocationCount = 3)
	public void s() {
		System.out.println("s is a test method");
	}

	@Test
	public void p() {
		System.out.println("p is a test method");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This is Before Method");
	}
	}

