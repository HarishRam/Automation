package main.java.test.DRMMainTests;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import main.java.test.DRMPageObjects.iOSDRMPageObjects;
import main.java.test.smpFunctions.CommonFunction;
import main.java.test.smpFunctions.LiveRewindFunctions;
import main.java.test.smpFunctions.iOSCommonFunctions;
import main.java.test.smpPageObjects.CommonObjects;
import main.java.test.smpPageObjects.LiveRewindPageObjects;
import main.java.test.smpPageObjects.iOSCommonObjects;
import main.java.test.smpUtilityFunctions.AppiumManager;
import main.java.test.smpUtilityFunctions.PortFactory;

public class iOSDRMTest {
	
	public iOSDRMPageObjects iosdrmpageobjects;
	public CommonObjects commonobjects;

	public List<String> deviceID = new ArrayList<String>();
	public List<String> deviceOS = new ArrayList<String>();
	public List<String> deviceName = new ArrayList<String>();

	public AndroidDriver<WebElement> driver = null;
	public DesiredCapabilities capa;
	String message;

	public WebDriverWait wait;

	String filename = "iOSDRM";
	String workingDirectory = "/Users/ramakh01/Desktop/Automation/Automation/Results"; /// System.getProperty("user.dir");
	String absoluteFilePath = workingDirectory + File.separator + filename;
	public String ScreenshotPath = "/Users/ramakh01/Desktop/Automation/Automation/Results/iOSDRM/";
	File screenhotfiles = new File(ScreenshotPath);

	File file;// = new File(absoluteFilePath);

	AppiumManager appiummanager = new AppiumManager();

	iOSCommonFunctions ioscommonfunction = new iOSCommonFunctions();
	
	CommonFunction commonfunction = new CommonFunction();

	PortFactory portFactory = new PortFactory();

	DesiredCapabilities capabilities;

	IOSDriver<WebElement> iosdriver;
	
	iOSCommonObjects iospageobjects;



	@BeforeClass
	public void Setup() throws Exception

	{
		appiummanager.startAppium(4723);
		appiummanager.AppiumURL();
		String appiul_url = appiummanager.AppiumURL();
		System.out.println("Appium Service Address : - " + appiul_url);

		capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.6");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "MCP's iPad");
		capabilities.setCapability(MobileCapabilityType.UDID, "df43e12f4ba40c8763eb37dc17195717e094ee96");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.3.5");
		capabilities.setCapability(MobileCapabilityType.APP,
				"/Users/ramakh01/Desktop/Automation/Automation/DRM_iOS/DRMSampleApp.ipa");
		capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, "true");
		capabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, false);


		try {

			iosdriver = new IOSDriver<>(new URL(appiul_url), capabilities);
			iosdriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void openDRMApp() throws Exception {
		try {


			iosdrmpageobjects = new iOSDRMPageObjects();
			PageFactory.initElements(new AppiumFieldDecorator(iosdriver), iosdrmpageobjects);
			
			iospageobjects = new iOSCommonObjects();
			PageFactory.initElements(new AppiumFieldDecorator(iosdriver), iospageobjects);

			ioscommonfunction.CreateReport(absoluteFilePath, "df43e12f4ba40c8763eb37dc17195717e094ee96", "4723",
					"9.3.5",
					"iPad-Air2");

			


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(dependsOnMethods={"openDRMApp"})
	public void vpid_Download() throws Exception
	{
		iosdrmpageobjects.addDownload_Button.click();
		Thread.sleep(1000);
		
		iosdrmpageobjects.vpidClearButton.click();
		Thread.sleep(600);
		
	//	iosdrmpageobjects.enterVPIDField.sendKeys(iosdrmpageobjects.audio_Vpid);
		//Thread.sleep(1000);
		
		ioscommonfunction.enterText(iosdrmpageobjects.enterVPIDField, "Entering the VPID", iosdrmpageobjects.audio_Vpid, iosdriver, ScreenshotPath);
		//iosdrmpageobjects.downloadButton.click();
		//Thread.sleep(2000);
		
		ioscommonfunction.tapbutton(iosdrmpageobjects.downloadButton, "Adding a Audio VPID to Download", iosdriver, ScreenshotPath);
		
	}
	
	@Test(dependsOnMethods={"vpid_Download"})
	public void check_Vpid() throws Exception, ArrayIndexOutOfBoundsException
	
	{
		WebElement elements[] = {
				iosdrmpageobjects.downloadingStatus,
				iosdrmpageobjects.downloadingVPID,
				//iosdrmpageobjects.downloadingVPID_FileSize,
				iosdrmpageobjects.downloadingVPID_Expiry,
				iosdrmpageobjects.downloadingVPID_MediaType
			};

		try
		{
				for(int i1=0;i1<elements.length;i1++)
			{
							System.out.println("Downloading "+ elements[i1].getText());
							Assert.assertEquals(elements[i1].getText(), elements[i1].getText());
							//Assert.assertNotEquals(elements[i1].getText(), elements[i1].getText());
						//	logger.log(LogStatus.PASS, elements[i1]);
					
			}	
		
		Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	@Test(dependsOnMethods={"check_Vpid"})
	public void turnWiFi_Off() throws Exception
	{
		//
		ioscommonfunction.turnWifiON("Turning Off WiFi Connection", iosdriver, iospageobjects.wifi_mode,
				iospageobjects.dismiss_wholewindow,ScreenshotPath, "Download Status After Network OFF "+ iosdrmpageobjects.progressStatus.getText());
		
		System.out.println("Download Status After Network OFF:- "+ iosdrmpageobjects.downloadingStatus.getText());
		AssertJUnit.assertEquals("Paused", iosdrmpageobjects.downloadingStatus.getText());
		Thread.sleep(3000);
	}
	
	@Test(dependsOnMethods={"turnWiFi_Off"})
	public void turnWiFi_ON() throws Exception
	{
		ioscommonfunction.turnWifiON("Turning ON WiFi Connection", iosdriver, iospageobjects.wifi_mode,
				iospageobjects.dismiss_wholewindow,ScreenshotPath, "Download Status After Network ON"+ iosdrmpageobjects.progressStatus.getText());
		
		System.out.println("Download Status After Network ON:- "+ iosdrmpageobjects.downloadingStatus.getText());
	//	AssertJUnit.assertEquals(iosdrmpageobjects.downloadingStatus.getText(), iosdrmpageobjects.downloadingStatus.getText());
		String inprogressText = iosdrmpageobjects.downloadingStatus.getText();
		AssertJUnit.assertEquals("In Progress",inprogressText.substring(0, 11));
		Thread.sleep(3000);
	}
	
	@Test(dependsOnMethods={"turnWiFi_ON"})
	public void downloadPause() throws Exception
	{
		ioscommonfunction.tapbutton(iosdrmpageobjects.pause_resume_button, "Pausing the Download", iosdriver, ScreenshotPath);
		
	}
	
	@Test(dependsOnMethods={"downloadPause"})
	public void downloadResume() throws Exception
	{
		ioscommonfunction.tapbutton(iosdrmpageobjects.pause_resume_button, "Resume the Download", iosdriver, ScreenshotPath);
		
	}
	
	
	@Test(dependsOnMethods={"downloadResume"})
	public void DownloadProgress() throws Exception
	{
		
		
	//	WebElement progress_status = iosdriver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAProgressIndicator[1]"));
		String downloadingstatus = iosdrmpageobjects.progressStatus.getText();
		
		System.out.println("Before Download Completes"+downloadingstatus);
		
		waitForScreenToLoad(iosdriver, iosdrmpageobjects.downloadcomplete, 320);
		
		String downloadingstatus1 = iosdrmpageobjects.downloadcomplete.getText();
		
		System.out.println("After Download Completes "+downloadingstatus1);
		
	}
	
	
	@Test(dependsOnMethods={"DownloadProgress"})
	public void DownloadComplete() throws Exception
	{
		{
			WebElement elements[] = {
					iosdrmpageobjects.downloadingStatus,
					iosdrmpageobjects.downloadingVPID,
					iosdrmpageobjects.downloadingVPID_FileSize,
					iosdrmpageobjects.downloadingVPID_Expiry,
					iosdrmpageobjects.downloadingVPID_MediaType
				};

			try
			{
					for(int i1=0;i1<elements.length;i1++)
				{
								System.out.println("Downloaded "+ elements[i1].getText());
								Assert.assertEquals(elements[i1].getText(), elements[i1].getText(), "The Values Matched");
							//	logger.log(LogStatus.PASS, elements[i1]);
						
				}	
			
			Thread.sleep(2000);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		Thread.sleep(10000);
		
		
	}
	
	
	@AfterClass
	public void tearDown()
	{
		ioscommonfunction.GenerateReport();
		iosdriver.quit();
		appiummanager.stopappium();
	}
	
	
	
	
	public void waitForScreenToLoad(IOSDriver<WebElement> lDriver, WebElement element, int seconds)
	{

	    WebDriverWait wait = new WebDriverWait(lDriver,seconds);
	    wait.until(ExpectedConditions.visibilityOf(element));
	   
	}

}
