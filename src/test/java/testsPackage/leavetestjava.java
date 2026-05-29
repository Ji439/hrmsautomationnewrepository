package testsPackage;


import java.time.Duration;

//Selenium Imports
//===============================
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//===============================
//TestNG Imports
//===============================
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;


public class leavetestjava {
	
	WebDriver driver ;
	   @BeforeMethod
	    public void setup() {

	        // Object Creation
	        // Java Concept:
	        // Object + Constructor

	        driver = new ChromeDriver();

	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


	        driver.get("https://staginghrmsuat-gil.gujarat.gov.in/");
	        
	        // LOGIN CODE
	     // LOGIN CODE

	        driver.findElement(
	            By.xpath("//input[@placeholder='HRPN No']")
	        ).sendKeys("20051337");

	        driver.findElement(
	            By.xpath("//input[@placeholder='Password']")
	        ).sendKeys("abc123");

	        driver.findElement(
	            By.xpath("//button[contains(text(),'Login')]")
	        ).click();
	        
	     // OPEN LEAVE PAGE

	        driver.get("https://staginghrmsuat-gil.gujarat.gov.in/LeaveDetails");

	    }

	    // TEST CASE 1
	    // Verify Leave Request Tab
	    // ==============================

	    @Test(priority = 1)
	    public void verifyLeaveRequestTab() {

	        WebElement leaveRequestTab =
	                driver.findElement(By.xpath("//a[contains(text(),'Leave Request')]"));

	        Assert.assertTrue(leaveRequestTab.isDisplayed());

	        leaveRequestTab.click();

	        System.out.println("Leave Request Tab Verified");
	    }
	    // ==============================
	    // TEST CASE 2
	    // Verify Leave Type Dropdown
	    // ==============================

	    @Test(priority = 2)
	    public void verifyLeaveTypeDropdown() {

	        WebElement leaveType =
	                driver.findElement(By.id("LeaveTypeId"));

	        Select select = new Select(leaveType);

	        select.selectByIndex(1);

	        Assert.assertTrue(leaveType.isDisplayed());

	        System.out.println("Leave Type Selected");
	    }
	    @Test(priority = 3)
	    public void verifyMandatoryValidation() {

	        driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();

	        WebElement validation =
	                driver.findElement(By.xpath("//*[contains(text(),'required')]"));

	        Assert.assertTrue(validation.isDisplayed());

	        System.out.println("Validation Message Displayed");
	    }
	    // Verify Date Selection
	    // ==============================

	    @Test(priority = 4)
	    public void verifyDateSelection() {

	        driver.findElement(By.id("StartDate"))
	                .sendKeys("20/06/2026");

	        driver.findElement(By.id("EndDate"))
	                .sendKeys("22/06/2026");

	        String startDate =
	                driver.findElement(By.id("StartDate")).getAttribute("value");

	        Assert.assertEquals(startDate, "20/06/2026");

	        System.out.println("Dates Entered Successfully");
	    }
	 // ==============================
	    // TEST CASE 5
	    // Verify Leave Reason Dropdown
	    // ==============================

	    @Test(priority = 5)
	    public void verifyLeaveReasonDropdown() {

	        WebElement reason =
	                driver.findElement(By.id("LeaveReasonId"));

	        Select select = new Select(reason);

	        select.selectByIndex(1);

	        Assert.assertTrue(reason.isDisplayed());

	        System.out.println("Leave Reason Selected");
	    }
	    // TEST CASE 6
	    // Verify Note Field
	    // ==============================

	    @Test(priority = 6)
	    public void verifyNoteField() {

	        WebElement note =
	                driver.findElement(By.id("Note"));

	        note.sendKeys("Personal work leave request");

	        Assert.assertTrue(note.getAttribute("value")
	                .contains("Personal"));

	        System.out.println("Note Entered Successfully");
	    }
	   
	    	    // TEST CASE 7
	    	    // Verify File Upload
	    	    // ==============================

	    	    @Test(priority = 7)
	    	    public void verifyFileUpload() {

	    	        WebElement upload =
	    	                driver.findElement(By.xpath("//input[@type='file']"));

	    	        upload.sendKeys("C:\\Users\\Admin\\Desktop\\test.pdf");

	    	        System.out.println("File Uploaded Successfully");
	    	    }
	    	    // Verify Reset Button
	    	    // ==============================

	    	    @Test(priority = 8)
	    	    public void verifyResetButton() {

	    	        driver.findElement(By.id("Note"))
	    	                .sendKeys("Testing Reset");

	    	        driver.findElement(By.xpath("//button[contains(text(),'Reset')]"))
	    	                .click();

	    	        String noteValue =
	    	                driver.findElement(By.id("Note"))
	    	                        .getAttribute("value");

	    	        Assert.assertEquals(noteValue, "");

	    	        System.out.println("Reset Button Working");
	    	    }
	    	    // TEST CASE 9
	    	    // Verify Complete Leave Submission
	    	    // ==============================

	    	    @Test(priority = 9)
	    	    public void verifyLeaveSubmission() {

	    	        // Leave Type
	    	        Select leaveType =
	    	                new Select(driver.findElement(By.id("LeaveTypeId")));

	    	        leaveType.selectByIndex(1);

	    	        // Start Date
	    	        driver.findElement(By.id("StartDate"))
	    	                .sendKeys("20/06/2026");

	    	        // End Date
	    	        driver.findElement(By.id("EndDate"))
	    	                .sendKeys("22/06/2026");

	    	        // Leave Reason
	    	        Select reason =
	    	                new Select(driver.findElement(By.id("LeaveReasonId")));

	    	        reason.selectByIndex(1);

	    	        // Note
	    	        driver.findElement(By.id("Note"))
	    	                .sendKeys("Family function leave");

	    	        // Submit
	    	        driver.findElement(By.xpath("//button[contains(text(),'Submit')]"))
	    	                .click();

	    	        // Success Message
	    	        WebElement success =
	    	                driver.findElement(By.xpath("//*[contains(text(),'successfully')]"));

	    	        Assert.assertTrue(success.isDisplayed());

	    	        System.out.println("Leave Submitted Successfully");
	    	    }
	    	 // TEST CASE 10
	    	    // Verify End Date Validation
	    	    // ==============================

	    	    @Test(priority = 10)
	    	    public void verifyEndDateValidation() {

	    	        driver.findElement(By.id("StartDate"))
	    	                .sendKeys("25/06/2026");

	    	        driver.findElement(By.id("EndDate"))
	    	                .sendKeys("20/06/2026");

	    	        driver.findElement(By.xpath("//button[contains(text(),'Submit')]"))
	    	                .click();

	    	        WebElement error =
	    	                driver.findElement(By.xpath("//*[contains(text(),'End Date')]"));

	    	        Assert.assertTrue(error.isDisplayed());

	    	        System.out.println("End Date Validation Verified");
	    	    }
	    	    
	    	    @AfterMethod
	    	    public void tearDown() {

	    	        driver.quit();
	    	    }
}
