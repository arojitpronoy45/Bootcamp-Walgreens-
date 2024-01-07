package pages;

import org.openqa.selenium.WebDriver;
import static common.CommonActions.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewUserRegistration {
	WebDriver driver;
	
	
	
	public NewUserRegistration(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy (xpath = "//span[text()='Please enter a valid first name only with letters.']")
	WebElement Pleaseenteravalidfirstnamenlywithletters;
	
	
	
	@FindBy(id = "create_btn")
	WebElement newUserRegistration;
	
	@FindBy(xpath = "//h1[@class='wag-header-text wag-head-xs-mt10 mb15 text-color__blue-aa']")
	WebElement header;
	
	@FindBy(xpath = "//span[@id='firstname-error-text']")
	WebElement pleaseEnterYourNamElement;
	
	@FindBy(xpath = "//input[@id='wag-RXUser-firstname']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@id='wag-RXUser-lastname']")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@name='registerData']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='wag-password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@id='wag-terms-checkbox']")
	WebElement checkbox;
	
	@FindBy(partialLinkText = "Continue")
	WebElement continu;
	
	@FindBy(xpath = "//a[@class='store-trigger']")
	WebElement nearestStore;
	
	@FindBy(id = "12490-selectBtn")
	WebElement storeSelection;	
	
	
	public void directingToNewUserRegistration () {
		driver.navigate().to("https://www.walgreens.com/login.jsp?ru=%2F");
		buttonEnabled(newUserRegistration);
		verifyTextOfTheWebElement(newUserRegistration, "Create a new account");
		clickElement(newUserRegistration);
		
	}
	public void validationNewUserRegistration () {
		pause(3);
		currentUrl(driver);
		verifyTitle(driver, "Create Your Account | Walgreens");
		validationOfHeader(header, "Create Your Walgreens.com Account");
		}
	public void searchKeyword () {
		
		pause(5);
		currentUrl(driver);
		verifyTitle(driver, "Create Your Account | Walgreens");
		pause(3);
		inputTextThenClickTab(firstName, "% & \\\" ( )");
		verifyErrorMsgUnderTheField(Pleaseenteravalidfirstnamenlywithletters, "Please enter a valid first name only with letters.");
		pause(3);
		clearTextFromTheField(firstName);
		pause(3);
		inputText(firstName, "Arojit");
		pause(3);
		
		inputTextThenClickTab(lastName, "% & \\\" ( )");
		verifyErrorMsgUnderTheField(Pleaseenteravalidfirstnamenlywithletters, "Please enter a valid first name only with letters.");
		pause(3);
		clearTextFromTheField(lastName);
		pause(3);
		inputText(lastName, "Pronoy");
		pause(3);
		clickElement(email);
		inputText(email, "antarmored@gmail.com");
		pause(3);
		clickElement(password);
		inputText(password, "232134214dsfg");
		pause(2);
		clickElement(checkbox);
		buttonEnabled(checkbox);
		pause(2);
		clickElement(continu);
		pause(3);
	//verifyTextOfTheWebElement(searchElement, null);
		
	}
	
		
	}

