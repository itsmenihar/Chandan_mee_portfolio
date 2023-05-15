package portfolio.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.util.Assert;

import portfolio.abstractComponents.AbstractComponent;

public class ContactMePage extends AbstractComponent {
	WebDriver driver;

	public ContactMePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='fullName']")
	WebElement FullNameInput;

	public WebElement inputFullName() {
		return FullNameInput;
	}

	@FindBy(xpath = "//input[@id='phoneNumber']")
	WebElement PhoneNoInput;

	public WebElement inputPhoneNo() {
		return PhoneNoInput;
	}

	@FindBy(xpath = "//input[@id='emailAddress']")
	WebElement EmailInput;

	public WebElement inputEmail() {
		return EmailInput;
	}

	@FindBy(xpath = "//textarea[@id='message']")
	WebElement MessageInputBox;

	@FindBy(xpath = "//button[text()='Send Message ']")
	WebElement SendMsgButton;
	
	public String getText() {
		 String inputText = FullNameInput.getAttribute("value");
		 return inputText;
	}
	
	public String getTextFromPhoneNoField() {
		 String inputPhoneNo = PhoneNoInput.getAttribute("value");
		 return inputPhoneNo;
	}

	public ThankUPage inputContactdetails(String fullname, String phoneNo, String email, String Msg) {
		FullNameInput.sendKeys(fullname);
		PhoneNoInput.sendKeys(phoneNo);
		EmailInput.sendKeys(email);
		MessageInputBox.sendKeys(Msg);
		
		SendMsgButton.click();
		ThankUPage tp = new ThankUPage(driver);
		return tp;
	}

}
