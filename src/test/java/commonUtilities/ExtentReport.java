package commonUtilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	ExtentReports extent;
	ExtentSparkReporter spark;
	ExtentTest extentTest;

	public void ExtentReports(String fileName,String reportName) {
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("ExtentReports/"+util.getFileName(fileName,"html"));
		spark.config().setReportName(reportName);
		spark.config().setTheme(Theme.STANDARD);
		extent.attachReporter(spark);
	}
	public void Pass(String test, String message) {
		extent.createTest(test).log(Status.PASS,message);
	}
	public void info(String test, String message) {
		extent.createTest(test).log(Status.INFO,message);
	}
	public void Warning(String test, String message) {
		extent.createTest(test).log(Status.WARNING,message);
	}
	public void Skip(String test, String message) {
		extent.createTest(test).log(Status.SKIP, message);
	}
	public void Fail(String test, String message) {
		extent.createTest(test).log(Status.FAIL,message);
	}
	public void Pass_With_Screenshot(String test,String message) {
		extentTest = extent.createTest(test);
		ExtentTest node = extentTest.createNode(message);
		node.pass(message);
	}
	public void Fail_With_Screenshot(String test,String message) {
		extentTest = extent.createTest(test);
		ExtentTest node = extentTest.createNode(message);
		node.pass(message);
	}
	public void Flush() {
		extent.flush();
	}

}
