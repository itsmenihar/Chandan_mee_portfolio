package portfolio.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import portfolio.abstractComponents.AbstractComponent;

public class ThankUPage extends AbstractComponent{
	WebDriver driver;

	public ThankUPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h2[text()='Thank you for reaching out to me !']")
	WebElement element;
	
	public String getThankText() {
		return element.getText();
	}
}
