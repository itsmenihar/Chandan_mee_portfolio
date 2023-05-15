package portfolio.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import portfolio.abstractComponents.AbstractComponent;




public class LandingPage extends AbstractComponent {
	private WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//nav[@class='nav-menu d-none d-xl-block']//ul/li/a[@href='contact.html']")
	WebElement contact;
	public ContactMePage getContact() {
		contact.click();
		ContactMePage cp = new ContactMePage(driver);
		return cp;
	}
	

	public void goTo() {
		driver.get("https://chandanmee.com/index.html");
	}

}
