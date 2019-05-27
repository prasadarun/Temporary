package com.wordpress.test;


import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wordpress.base.TestBase;
import com.wordpress.pagelayers.Homepage;
import com.wordpress.pagelayers.Loginpage;

public class LoginpageTest extends TestBase {

	Loginpage loginpage;
	Homepage homepage;

	Logger log = Logger.getLogger("Loginpage");
	//PropertyConfigurator.configure("log4j.properties");


	public LoginpageTest() {
		super();
	}


	@BeforeMethod

	public void setUp() {
		intilization();
		log.info("The browser is intilalised and opened");
		loginpage = new Loginpage();
		log.info("fetching the website url");
		log.info("The login page is opened");

	}



	@Test
	public void validateloginTest() {
		homepage = loginpage.validatelogin();
		log.info("Given correct username and password");
	}



	@Test
	public void validateincorrectloginTest1() {
		loginpage.validateincorrectlogin1();
		log.info("given correct username and incorrect password");
	}



	@Test
	public void validateincorrectloginTest2() {
		loginpage.validateincorrectlogin2();
		log.info("given incorrect username and correct password");
	}



	@Test

	public void validatetitleTest() {
		String flag = loginpage.validateLoginpageTitle();
		String flag1 = "Log In ‹ opensourcecms — WordPress";
		Assert.assertEquals(flag,flag1);
		log.info("The title of the page is"+ flag);

	}




	@AfterMethod
	public void tearDown() {
		driver.quit();
	}



}
