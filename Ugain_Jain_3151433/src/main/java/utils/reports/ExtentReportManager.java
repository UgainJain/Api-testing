package utils.reports;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import utils.Base.BaseClass;
import utils.dataSource.LoadProperty;

public class ExtentReportManager {
	private static ExtentReports extent;
	public static ExtentReports getInstance() {
		if(extent == null) {
			Date d  = new Date();
				BaseClass.timestamp = d.toString().replace(":", "_").replace(" ", "_");
				
				String reportFolderPath = LoadProperty.getvar("reportsPath", "config")+"Test_Report_"+BaseClass.timestamp+"\\";
				reportFolderPath = System.getProperty("user.dir") + "/"+reportFolderPath;
				BaseClass.testReportFolderPath =reportFolderPath;
				String filename = BaseClass.timestamp+".html";
				extent = new ExtentReports(BaseClass.testReportFolderPath+filename,true,DisplayOrder.NEWEST_FIRST);
				
				extent.loadConfig(new File(System.getProperty("user.dir")+"//ReportsConfig.xml"));
				
				extent.addSystemInfo("Selenium version", "3.11.0");
		}
		return extent;
	}
}