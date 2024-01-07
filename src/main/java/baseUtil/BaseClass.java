package baseUtil;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import common.CommonActions;
import constants.Profile;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.ForgotUserId;
import pages.HomePage;
import pages.NewUserRegistration;
import pages.Vaccinations;
import reports.ExtentManager;
import reports.ExtentTestManager;
import utils.Configuration;
import static utils.IConstant.*;

public class BaseClass {
	public WebDriver driver;
	public HomePage homePage;
	Configuration configuration;
	public Dimension dimension;
	public Actions actions;
	public JavascriptExecutor js;
	public ForgotUserId forgotUserId;
	public Select select;
	public WebDriverWait wait;
	public Alert alert;
	//String browserName;// edge
	
	public NewUserRegistration newUserRegistration;
	public Vaccinations vaccinations; 
	ExtentReports report;
	ExtentTest extentTest;
	
	@BeforeSuite
	public void initialReporting() {
		report = ExtentManager.initialReports();
	}
	@BeforeClass
	public void beforeClassSetUp() {
		configuration = new Configuration(Profile.GENERAL); 
		// default Constructor of Configuration Class will be initialized
	}
	
	@Parameters("browser")
	@BeforeMethod
	public void setUP(@Optional(CHROME) String browserName) {// "CHROME
		//this.browserName = browserName;
		initDriver(browserName);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(configuration.getProperties(URL));
		long pageLoadWait = Long.parseLong(configuration.getProperties(PAGELOAD_WAIT));
		long implicitlyWait = Long.parseLong(configuration.getProperties(IMPLICITLY_WAIT));
		long explicitlyWait = Long.parseLong(configuration.getProperties(EXPLICITLY_WAIT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadWait));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWait));
		wait = new WebDriverWait(driver, Duration.ofSeconds(explicitlyWait));
		initClass();
		actions = new Actions(driver);
		
		js = (JavascriptExecutor) driver;


	}
	public void initDriver(String browserName) {// edge
	   // String browserName =	configuration.getProperties(BROWSER);// "chrome"
		
		switch (browserName) {// edge
		
		case CHROME:
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			driver = new ChromeDriver();			
			break;

		case FIREFOX:
			System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		
		case EDGE:
			//System.setProperty("webdriver.edge.driver", "./driver/msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
	
		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}
	
	}
		public void initClass () {
			homePage = new HomePage(driver);
			forgotUserId = new ForgotUserId(driver);
			newUserRegistration = new NewUserRegistration(driver);
			vaccinations = new Vaccinations(driver);
		}
		@BeforeMethod
		public void initialTest(Method method) {
			extentTest = ExtentTestManager.createTest(report, method.getName());
			extentTest.assignCategory(method.getDeclaringClass().getName());
		}
	@AfterMethod
	public void tearUp() {
		driver.quit();
		
	}
	@AfterMethod
	public void afterEachTest(Method method, ITestResult result) {
		for(String group: result.getMethod().getGroups()) {
			extentTest.assignCategory(group);
		}
		
		if(result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, "Test PASSED");
		}else if(result.getStatus() == ITestResult.FAILURE) {
			extentTest.addScreenCaptureFromPath(CommonActions.getSreenShot(method.getName(), driver));
			extentTest.log(Status.FAIL, "Test FAILED");
		}else if(result.getStatus() == ITestResult.SKIP) {
			extentTest.log(Status.SKIP, "Test SKIPPED");
		}
	}
	
	@AfterSuite
	public void publishReport() {
		report.flush();
	}

}

