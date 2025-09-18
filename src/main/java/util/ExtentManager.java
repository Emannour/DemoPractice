package util;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class ExtentManager {
    public static  ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("reports/extent-report.html");
            spark.config().setReportName("Automation Test Report");
            spark.config().setDocumentTitle("Extent Report Example");

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Tester", "Eman");
            extent.setSystemInfo("Environment", "Test");
        }
        return extent;
    }
}
