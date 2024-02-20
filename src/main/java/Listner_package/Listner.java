package Listner_package;

import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Listner implements ITestListener
{
	 private ExtentReports extentReports;
	    private ExtentTest extentTest;

	    @Override
	    public void onStart(ITestContext context)
	      {
	        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extent-report.html");
	        extentReports = new ExtentReports();
	        extentReports.attachReporter(sparkReporter);
	        sparkReporter.config().setDocumentTitle("Automation Test Results");
	        sparkReporter.config().setReportName("Test Execution Report");
	        sparkReporter.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.STANDARD);
	      }

	    @Override
	    public void onTestStart(ITestResult result) 
	    {
	        extentTest = extentReports.createTest(result.getMethod().getMethodName());
	        extentTest.assignCategory("Regression");
	        extentTest.assignAuthor("Harish.v");
	        extentTest.log(Status.INFO, "Browser: Chrome");
	        extentTest.log(Status.INFO, "OS: Windows 10");
	        extentTest.log(Status.INFO, "Test Environment: " + System.getProperty("test.environment"));
	        extentTest.log(Status.INFO, "Test Duration: " + (result.getEndMillis() - result.getStartMillis()) + " ms");
	        extentTest.log(Status.INFO, "Test Parameters: " + Arrays.toString(result.getParameters()));
	        extentTest.log(Status.INFO, "Thread ID: " + Thread.currentThread().getId());

	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        extentTest.log(Status.PASS, "Test passed");
	       
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        extentTest.log(Status.FAIL, "Test failed");
	        extentTest.log(Status.FAIL, result.getThrowable());
	        extentTest.log(Status.INFO, "Screenshot: <a href='screenshots/screenshot.png'>View Screenshot</a>");
	        extentTest.log(Status.INFO, "Video: <a href='videos/testvideo.mp4'>View Video</a>");
	        
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        extentTest.log(Status.SKIP, "Test skipped");
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        extentReports.flush();
	    }
}
