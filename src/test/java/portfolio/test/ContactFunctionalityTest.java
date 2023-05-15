package portfolio.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import portfolio.TestComponents.BaseTest;
import portfolio.pageObject.ContactMePage;
import portfolio.pageObject.ThankUPage;

public class ContactFunctionalityTest extends BaseTest {

	WebDriver driver;

	// 1-Validate with valid data
	@Test
	public void validateWith_ValidData() {
		String expectedMsg = "Thank you for reaching out to me !";
		String fullname = "admin";
		String phoneNo = "8794562315";
		String email = "admin@gmail.com";
		String Msg = "hi";
		ContactMePage cp = lp.getContact();
		ThankUPage tp = cp.inputContactdetails(fullname, phoneNo, email, Msg);
		String actualMsg = tp.getThankText();
		Assert.assertTrue(actualMsg.equalsIgnoreCase(expectedMsg));
	}

	// 2-validate with empty field
	@Test
	public void validateWith_EmptyField() {
		String fullname = "";
		String phoneNo = "";
		String email = "";
		String Msg = "";
		ContactMePage cp = lp.getContact();
		cp.inputContactdetails(fullname, phoneNo, email, Msg);
		String fullname_Tooltip = cp.inputFullName().getAttribute("validationMessage");
		String phoneNo_Tooltip = cp.inputPhoneNo().getAttribute("validationMessage");
		String email_Tooltip = cp.inputEmail().getAttribute("validationMessage");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(fullname_Tooltip.contains("Please"));
		softAssert.assertTrue(phoneNo_Tooltip.contains("Please"));
		softAssert.assertTrue(email_Tooltip.contains("Please"));
		softAssert.assertAll();

	}

	// 3- validate with only fullname field is empty
	@Test
	public void validateWith_FullnameEmpty() {
		String fullname = "";
		String phoneNo = "7984562130";
		String email = "admin@gmail.com";
		String Msg = "hi";
		ContactMePage cp = lp.getContact();
		cp.inputContactdetails(fullname, phoneNo, email, Msg);
		String fullname_Tooltip = cp.inputFullName().getAttribute("validationMessage");
		Assert.assertTrue(fullname_Tooltip.contains("Please"));
	}

	// 4- validate with only phoneNo field is empty
	@Test
	public void validateWith_PhoneNoEmpty() {
		String fullname = "admin";
		String phoneNo = "";
		String email = "admin@gmail.com";
		String Msg = "hi";
		ContactMePage cp = lp.getContact();
		cp.inputContactdetails(fullname, phoneNo, email, Msg);
		String phoneNo_Tooltip = cp.inputPhoneNo().getAttribute("validationMessage");
		Assert.assertTrue(phoneNo_Tooltip.contains("Please"));
	}

	// 5- validate with only email field is empty
	@Test
	public void validateWith_EmailEmpty() {
		String fullname = "admin";
		String phoneNo = "7986543120";
		String email = "";
		String Msg = "hi";
		ContactMePage cp = lp.getContact();
		cp.inputContactdetails(fullname, phoneNo, email, Msg);
		String email_Tooltip = cp.inputEmail().getAttribute("validationMessage");
		Assert.assertTrue(email_Tooltip.contains("Please"));
	}

	// 6- validate with only message field is empty
	@Test
	public void validateWith_MsgEmpty() {
		String expectedMsg = "Thank you for reaching out to me !";
		String fullname = "admin";
		String phoneNo = "7986543120";
		String email = "admin@gmail.com";
		String Msg = "";
		ContactMePage cp = lp.getContact();
		ThankUPage tp = cp.inputContactdetails(fullname, phoneNo, email, Msg);
		String actualMsg = tp.getThankText();
		Assert.assertTrue(actualMsg.equalsIgnoreCase(expectedMsg));

	}

	// 7- validate with lengthy full name, the character size is above 25
	@Test
	public void validateWith_LengthyFullName() {
		String fullname = "adminhjfeuihofuygfewgogfweygyygwfgywogffogwfgggeg";
//		String phoneNo = "8794562315";
//		String email = "admin@gmail.com";
//		String Msg = "hi";
		ContactMePage cp = lp.getContact();
		cp.inputFullName().sendKeys(fullname);
		String inputText = cp.inputFullName().getAttribute("value");
		Assert.assertTrue(inputText.length() > 4 && inputText.length() <= 20);

	}

	// 8- validate with character in phone number field
	@Test
	public void validateWith_CharPhonNo() {
//		String fullname = "admin";
		String phoneNo = "12asdfgh78";
//		String email = "admin@gmail.com";
//		String Msg = "hi";
		ContactMePage cp = lp.getContact();
		cp.inputPhoneNo().sendKeys(phoneNo);
		String inputPhoneNo = cp.inputPhoneNo().getAttribute("value");
		Assert.assertTrue(inputPhoneNo.matches("\\d"), "Phone number field should not contain characters");

	}

	// 9- validate without @ symbol in email field
	@Test
	public void validateWith_EmailWithoutSymbol() {
		String fullname = "admin";
		String phoneNo = "asdfghwedf";
		String email = "admingmail.com";
		String Msg = "hi";
		ContactMePage cp = lp.getContact();
		cp.inputContactdetails(fullname, phoneNo, email, Msg);
		String email_Tooltip = cp.inputEmail().getAttribute("validationMessage");
		Assert.assertTrue(email_Tooltip.contains("@"));

	}

	// 10- validate without @ symbol in email field
	@Test
	public void validateWith_InvalidEmail() {
		String fullname = "admin";
		String phoneNo = "asdfghwedf";
		String email = "admin@";
		String Msg = "hi";
		ContactMePage cp = lp.getContact();
		cp.inputContactdetails(fullname, phoneNo, email, Msg);
		String email_Tooltip = cp.inputEmail().getAttribute("validationMessage");
		Assert.assertTrue(email_Tooltip.contains("Please enter a part following '@'"));

	}

	// 11- validate with after @symbol .domain name in email field
	@Test
	public void validateWith_InvalidEmail2() {
		String fullname = "admin";
		String phoneNo = "asdfghwedf";
		String email = "admin@";
		String Msg = "hi";
		ContactMePage cp = lp.getContact();
		cp.inputContactdetails(fullname, phoneNo, email, Msg);
		String email_Tooltip = cp.inputEmail().getAttribute("validationMessage");
		Assert.assertTrue(email_Tooltip.contains("Please enter a part following '@'"));

	}

	// 12- validate with more than 10 number in phone number field
	@Test
	public void validateWith_LengthyPhoneNo() {
		String phoneNo = "798465321465879123";
		ContactMePage cp = lp.getContact();
		cp.inputPhoneNo().sendKeys(phoneNo);
		String inputPhoneNo = cp.inputPhoneNo().getAttribute("value");
		Assert.assertTrue(inputPhoneNo.length() == 10);
	}
}
