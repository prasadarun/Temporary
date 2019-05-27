package com.wordpress.pagelayers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wordpress.base.TestBase;
import com.wordpress.utils.LoadingTime;



public class Homepage extends TestBase {

	Homepage homepage;




	@FindBy(partialLinkText = "Customize Your Site")
	WebElement customizebutton;

	@FindBy(xpath = "//a[@class='welcome-icon welcome-write-blog']")
	WebElement firstEntry;


	@FindBy(xpath="//a[@class='welcome-icon welcome-add-page']")
	WebElement Createpage;


	@FindBy(xpath = "//a[@class='welcome-icon welcome-comments']")
	WebElement Comments;



	public Homepage() {
		PageFactory.initElements(driver, this);
	}



	public boolean validatecustomizesite() {
		customizebutton.click();
		return true;

	}



	public boolean validatePostmenu() throws Exception {

		Actions actions = new Actions(driver);
		WebElement mainMenu = driver.findElement(By.xpath("//div[contains(text(),'Posts')]"));
		actions.moveToElement(mainMenu).perform();

		// for submenu
		WebElement subMenu = driver.findElement(By.xpath("//div[contains(text(),'Posts')]"));
		actions.moveToElement(subMenu).perform();
		boolean flag = subMenu.isDisplayed();
		return flag;


	}


	public boolean validatefirstentry() throws Exception {
		firstEntry.click();
		driver.manage().timeouts().implicitlyWait(LoadingTime.IMPLICT_WAIT, TimeUnit.SECONDS);
		return true;

	}


	public boolean validatecreatePage() {
		Createpage.click();
		driver.manage().timeouts().implicitlyWait(LoadingTime.IMPLICT_WAIT, TimeUnit.SECONDS);
		return true;

	}


	public boolean validateComments() {
		Comments.click();
		driver.manage().timeouts().implicitlyWait(LoadingTime.IMPLICT_WAIT, TimeUnit.SECONDS);
		return true;
	}


}
