package pages;


import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import static common.CommonActions.*;
public class HomePage {
	WebDriver driver;
	

	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
		@FindBy(id = "submit_btn")
		WebElement loginButton;

		@FindBy(xpath = "//input[@id='user_name']")
		WebElement userId;
		
		@FindBy(xpath = "//img[@class='img-responsive']")
		WebElement logo;
		
		@FindBy(name = "showPassword")
		WebElement checkBox;
		
		@FindBy(xpath = "//input[@id ='user_password']")
		WebElement password;
		
		@FindBy(id = "goto_resetpass")
		WebElement resetPassword;
	

		
		
		public void useOfEmailAndPasswordMethod () throws InterruptedException {
			
			driver.navigate().to("https://www.walgreens.com/login.jsp?ru=%2F");
			inputText(userId, "May 2023 QA Bootcamp");
			inputText(password, "Enthrall@042023");
			pause(5);
			clickElement(checkBox);
			pause(5);
			clickElement(loginButton);
			pause(5);
		}
			
			}

