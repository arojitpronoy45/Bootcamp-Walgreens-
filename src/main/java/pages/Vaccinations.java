package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static common.CommonActions.*;

public class Vaccinations {
	WebDriver driver;

	public Vaccinations(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}


	@FindBy(xpath = "//li[@id='at-hp-rp-covid-li-1']/a/div")
	WebElement appointment;

	@FindBy(xpath = "//input[@id='userDob']")
	WebElement dateOfBirth;

	@FindBy(xpath = "//input[@id='field-email']")
	WebElement email;

	@FindBy(xpath = "//input[@name='userPhone']")
	WebElement phonE;

	@FindBy(name = "cdcguestcheck")
	WebElement checkbox;

	@FindBy(xpath = "//span[@id='nextBtn']")
	WebElement next;

	@FindBy(xpath = "//input[@id='check-1']")
	WebElement checkFluShot;

	@FindBy(xpath = "//span[@class='next-btn btn btn__blue']")
	WebElement nextButton;

	@FindBy(xpath = "//input[@id='check-207']")
	WebElement checkCovidButton;

	@FindBy(id = "cancel-btn")
	WebElement selectMenu;

	@FindBy(xpath = "//a[@id='0']")
	WebElement viewTimes;

	@FindBy(xpath = "//*[@id='wag-store-info-0']/div/div/div[7]/section/section/section/a[7]/span")
	WebElement time11_10;

	@FindBy(xpath = "//button[@class='confirmDoseTimeslots btn btn__blue']")
	WebElement nextTest;

	@FindBy(xpath = "//input[@name='userFirstname']")
	WebElement pFirstNamE;

	@FindBy(xpath = "//input[@name='userLastname']")
	WebElement pLastNamE;

	@FindBy(xpath = "//select[@name='userGender']")
	WebElement selectGender;

	@FindBy(xpath = "//option[@value='Male']")
	WebElement male;

	@FindBy(xpath = "//select[@id=\"race-dropdown\"]")
	WebElement selectRace;
	
	@FindBy(xpath = "//select[@id=\"race-dropdown\"]/option[4]")
	WebElement RaceOption;
	
	@FindBy(xpath = "//select[@id=\"ethnicity-dropdown\"]")
	WebElement selectEthnicity;
	
	@FindBy(xpath = "//select[@id=\"ethnicity-dropdown\"]/option[4]")
	WebElement EthnicityOption;
	
	@FindBy(xpath = "//button[@id=\"nextButton-cdcInfoGuest\"]")
	WebElement patientNext;
	
	

	public void useOfVaccination() {
		clickElement(appointment);
		pause(2);
		clickElement(dateOfBirth);
		pause(3);
		inputText(dateOfBirth, "08022001");
		pause(2);
		clickElement(email);
		pause(2);
		inputText(email, "arojitpronoy@gmail.com");
		pause(2);
		clickElement(phonE);
		pause(2);
		inputText(phonE, "9175957072");
		pause(2);
		clickElement(checkbox);
		buttonEnabled(checkbox);
		pause(2);
		clickElement(next);
		pause(3);
		clickElement(checkFluShot);
		buttonEnabled(checkFluShot);
		pause(3);
		clickElement(nextButton);
		pause(3);
		clickElement(checkCovidButton);
		pause(3);
		clickElement(selectMenu);
		pause(3);
		clickElement(viewTimes);
		pause(3);
		clickElement(time11_10);
		pause(3);
		clickElement(nextTest);
		pause(2);
		clickElement(pFirstNamE);
		pause(2);
		inputText(pFirstNamE, "Arojit");
		pause(3);
		clickElement(pLastNamE);
		pause(2);
		inputText(pLastNamE, "Pronoy");
		pause(3);
		clickElement(male);
		pause(3);
		clickElement(selectRace);
		pause(3);
		clickElement(RaceOption);
		pause(3);
		clickElement(selectEthnicity);
		pause(3);
		clickElement(EthnicityOption);
		pause(3);
		clickElement(patientNext);
		pause(3);
		
	}

}
