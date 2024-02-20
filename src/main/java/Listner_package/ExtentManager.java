package Listner_package;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager 
{
	private static ExtentReports extentReports;

    public synchronized static ExtentReports createExtentReportInstance() 
    {
        if (extentReports == null) {
         ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extent-report.html");
            extentReports = new ExtentReports();
            extentReports.attachReporter(htmlReporter);
        }
        return extentReports;
    }
}
