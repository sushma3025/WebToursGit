package rough;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAnnotations 

{

	
	@BeforeTest
	public void bftst()
	{
		System.out.println("before test");
	}
	
	@Test
	public void tst1()
	{
		System.out.println(" test 1 ");
	}
	@Test
	public void tst2()
	{
		System.out.println(" test 2");
	}
	
}
