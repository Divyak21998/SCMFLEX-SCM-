package genericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listenerutil implements ITestListener {
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		String Methodname=result.getMethod().getMethodName();
		 test = report.createTest(Methodname);
		 Reporter.log(Methodname+"----Testscript execution starts from here-----");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String Methodname=result.getMethod().getMethodName();
		test.log(Status.PASS, Methodname+"---->passed");
		Reporter.log(Methodname+"---test script executed successfully-----");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String Fs= result.getMethod().getMethodName();
		String Fscript=Fs+new JavaUtilities().systemDateFormate();
		
		try {
			test.addScreenCaptureFromPath(WebDriverUtilies.takeScreenshots(BaseClass.sdriver, Fscript));
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL, Fscript+"----->failed");
		Reporter.log(Fscript+"--->Testscript execution failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String Methodname=result.getMethod().getMethodName();
		test.log(Status.SKIP, Methodname+"---->skipped");
		Reporter.log(Methodname+"---test script is skipped-----");
		
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		//consolidate the report/clean older report
		report.flush();
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./Extentreport/report.html");
		htmlreport.config().setDocumentTitle("SupplyChainManagement");
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setReportName("SCM-Flex");
		 report=new ExtentReports();
		 report.attachReporter(htmlreport);
		 report.setSystemInfo("Base-Browser","chrome");
		 report.setSystemInfo("url","http://rmgtestingserver/domain/Supply_Chain_Management/index.php");
		 report.setSystemInfo("Reportername","Divya");
	}
	

}
