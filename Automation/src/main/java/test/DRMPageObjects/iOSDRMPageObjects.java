package main.java.test.DRMPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.iOSFindBy;

public class iOSDRMPageObjects {
	
	public iOSDRMPageObjects()
	{
		
	}
	
	
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[3]")
	public WebElement addDownload_Button;
	
	@iOSFindBy(xpath=" //UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIATextField[1] ")
	public WebElement enterVPIDField;
	
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIATextField[1]/UIAButton[1]")
	public WebElement vpidClearButton;
	
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[2]/UIATextField[1]")
	public WebElement mediaTypeField;
	
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[2]/UIATextField[1]/UIAButton[1]")
	public WebElement mediaTypeField_Clear;
	
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[2]/UIAButton[2")
	public WebElement cancelButton;
	
	@iOSFindBy(xpath=" //UIAApplication[1]/UIAWindow[1]/UIANavigationBar[2]/UIAButton[3]")
	public WebElement downloadButton;
	
	@iOSFindBy(xpath=" //UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")
	public WebElement downloadingStatus;
	
	@iOSFindBy(xpath=" //UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[2]")
	public WebElement downloadingVPID;
	
	@iOSFindBy(xpath=" //UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[3]")
	public WebElement downloadingVPID_FileSize;
	
	@iOSFindBy(xpath=" //UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[4]")
	public WebElement downloadingVPID_Expiry;
	
	@iOSFindBy(xpath=" //UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[5]")
	public WebElement downloadingVPID_MediaType;
	
	@iOSFindBy(xpath="  //UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAProgressIndicator[1] ")
	public WebElement downloadingVPID_Progress;
	
	
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]")
	public WebElement pause_resume_button;
	
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1][contains(@name, 'Download Complete')]")
 	public WebElement downloadcomplete;
	
//	@iOSFindBy(xpath="//UIAStaticText[@text='Download Complete']")
//	public WebElement downloadcomplete;
	
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAProgressIndicator[1]")
	public WebElement progressStatus;
	
	public String audio_Vpid = "b08jfc17";
	
	WebElement elements[] = {
								downloadingStatus,
								downloadingVPID,
								downloadingVPID_FileSize,
								downloadingVPID_Expiry,
								downloadingVPID_MediaType
		};

public String text[] ={
					"Vpid_Status",
					 "Vpid_Name",
					 "Vpid_FileSize",
					 "Vpid_Expiry",
					 "Vpid_MediaType"
};
	
	
	
	
	
	
	
	

}
