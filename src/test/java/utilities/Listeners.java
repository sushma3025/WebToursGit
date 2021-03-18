package utilities;



import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class Listeners implements ITestListener
{

	public void onFinish(ITestContext Result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext Result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult Result) 
	{
		System.out.println("Test Failed" +Result);
		
	}

	public void onTestSkipped(ITestResult Result) 
	{
		System.out.println("Test Skipped " +Result);
		
	}

	public void onTestStart(ITestResult Result) 
	{
		System.out.println("Test Started " +Result);
	}

	public void onTestSuccess(ITestResult Result) 
	{
		System.out.println("Test Successfully Passed" +Result);
	}


}

