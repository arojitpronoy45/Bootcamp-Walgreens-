package pagesTest;

import org.testng.AssertJUnit;

import org.testng.SkipException;

import java.awt.Dimension;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import javax.swing.JScrollBar;

import org.apache.commons.io.filefilter.TrueFileFilter;
import org.bouncycastle.asn1.misc.NetscapeRevocationURL;
import org.bouncycastle.cms.bc.BcEdDSASignerInfoVerifierBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseUtil.BaseClass;
import net.bytebuddy.description.ModifierReviewable.OfAbstraction;
import pages.HomePage;
import static common.CommonActions.*;

public class HomePageTest extends BaseClass {
	//@Test(enabled = true)
	public void useOfEmailAndPasswordMethod () throws InterruptedException{
		homePage.useOfEmailAndPasswordMethod();
	}
	
	@Test(enabled = true)
	public void useOfVaccinationsTest () throws InterruptedException{
		Thread.sleep(4000);
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//span[contains(text(),'Vaccinations')]")).click();
		Thread.sleep(4000);
	}
}
