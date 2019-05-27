package com.wordpress.test;



import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wordpress.base.TestBase;
import com.wordpress.pagelayers.Homepage;
import com.wordpress.pagelayers.Loginpage;



public class HomepageTest extends TestBase {

	Homepage homepage;
	Loginpage loginpage;


	Logger log = Logger.getLogger("Homepage");

	public HomepageTest() {
		super();
	}

	@BeforeMethod

	public void setUp() {
		intilization();
		log.info("The browser is getting launched");
		loginpage = new Loginpage();
		log.info("The url is getting fetched");
		log.info("The loginpage is opened");
		homepage = loginpage.validatelogin();
		log.info("The login page is validated with correct username and password");
	}



	@Test

	public void validatecustomizeTest() {
		homepage.validatecustomizesite();
		log.info("Clicked on the  customize link");
		log.info("The page is redirected to Customized link");
	}

	@Test
	public void validatepostTest() throws Exception {
		homepage.validatePostmenu();
		log.info("Clicked on the post menu option present in side menu");
		log.info("The sub-optionns in post are getting displayed");

	}


	@Test 

	public void validatefirstenrtyTest() throws Exception {
		homepage.validatefirstentry();
		log.info("Clicked on the writing blog");
		log.info("The page is redirected to new writing blog");

	}


	@Test  // currently the script is getting fail

	public void validatecreatepageTest() {
		homepage.validatecreatePage();
		log.info("Clicked on the welcome add page");
		log.info("The page is redirected to welcome add page");
	}


	@Test

	public void validatecommentsTest() {
		homepage.validateComments();
		log.info("Clicked on the Comments link");
		log.info("The page is redirected to comments page");
	}






	@AfterMethod

	public void tearDown() {
		driver.quit();

	}

}
