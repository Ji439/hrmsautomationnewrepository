package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
public class Leavepage {
	   WebDriver driver;
	   

	    // ===============================
	    // Constructor
	    // Java Concept:
	    // Constructor + this keyword
	    // ===============================
	    public void LeavePage(WebDriver driver) {

	        this.driver = driver;
	    }

	    // ===============================
	    // Locators
	    // ===============================

	    By leaveTypeDropdown =
	            By.xpath("//select[contains(@class,'form-select')]");

	    By startDate =
	            By.xpath("//input[@placeholder='Start Date']");

	    By endDate =
	            By.xpath("//input[@placeholder='End Date']");

	    By leaveReasonDropdown =
	            By.xpath("//select[contains(@name,'leave_reason')]");

	    By noteBox =
	            By.xpath("//textarea[@placeholder='Enter Note']");

	    By uploadFile =
	            By.xpath("//input[@type='file']");

	    By submitButton =
	            By.xpath("//button[contains(text(),'Submit')]");

	    // ===============================
	    // Methods
	    // ===============================

	    // Select Leave Type
	    public void selectLeaveType(String leaveType) {

	        Select select =
	                new Select(driver.findElement(leaveTypeDropdown));

	        select.selectByVisibleText(leaveType);
	    }

	    // Enter Start Date
	    public void enterStartDate(String sDate) {

	        driver.findElement(startDate)
	              .sendKeys(sDate);
	    }

	    // Enter End Date
	    public void enterEndDate(String eDate) {

	        driver.findElement(endDate)
	              .sendKeys(eDate);
	    }

	    // Select Leave Reason
	    public void selectLeaveReason(String reason) {

	        Select select =
	                new Select(driver.findElement(leaveReasonDropdown));

	        select.selectByVisibleText(reason);
	    }

	    // Enter Note
	    public void enterNote(String note) {

	        driver.findElement(noteBox)
	              .sendKeys(note);
	    }

	    // Upload File
	    public void uploadDocument(String filePath) {

	        driver.findElement(uploadFile)
	              .sendKeys(filePath);
	    }

	    // Click Submit
	    public void clickSubmit() {

	        driver.findElement(submitButton)
	              .click();
	    }

	    // ===============================
	    // Complete Apply Leave Method
	    // Reusable Method
	    // ===============================
	    public void applyLeave(
	            String leaveType,
	            String start,
	            String end,
	            String reason,
	            String note) {

	        selectLeaveType(leaveType);

	        enterStartDate(start);

	        enterEndDate(end);

	        selectLeaveReason(reason);

	        enterNote(note);

	        clickSubmit();
	    }

}
