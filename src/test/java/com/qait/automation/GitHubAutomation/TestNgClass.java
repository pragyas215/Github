package com.qait.automation.GitHubAutomation;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import cloning.process.Cloning;

public class TestNgClass 
{
		private static final String String = null;
		WebDriver driver;
		String url;
		SignInPage sign;
		LogInPage logIn;
		HomePage home;
		CreateRepo repo;
		Cloning clone;
		RepoHome repoHomePage;
		String UIcommit;
		String commit;
		DetectOS detect;
		yaml yml;
		String updatedline;
		private final  Logger LOGGER = Logger.getLogger(TestNgClass.class.getName()); 
		@BeforeClass
		public void initialize() throws SecurityException, IOException{
			driver=new FirefoxDriver();
			url="https://github.com/";
			sign=new SignInPage(driver);
			logIn=new LogInPage(driver);
		    home=new HomePage(driver);
			repo=new CreateRepo(driver);
			clone=new Cloning();
			repoHomePage=new RepoHome(driver);
			detect=new DetectOS();
			yml=new yaml();
			
			String workDir = System.getProperty("user.dir");
		    String Logfile = "MYLogFile.log";
		    File myFile = new File(workDir + Logfile);
		    String userPath = myFile.getPath();
		    System.out.println("workDir : "+workDir);
		    System.out.println("myFile : "+myFile);
			System.out.println("userPath:"+userPath);
		    
			
			FileHandler  fh = new FileHandler(workDir +"/Logfile");  
		        LOGGER.addHandler(fh);
		        SimpleFormatter formatter = new SimpleFormatter();  
		        fh.setFormatter(formatter);  
		}
		
		@Test
		public void case1() throws Exception                   
		{
			driver.get(url);
			driver.manage().window().maximize();
			String title1=sign.click2();
			Assert.assertEquals(title1,"Sign in to GitHub · GitHub");
			LOGGER.info("info is verified");
		}
		@Test
		public void case2() throws InterruptedException
		{
			String title2=logIn.enterDetails();
			Assert.assertEquals(title2,"GitHub");
			LOGGER.info("title matched!!!");
			//LOGGER.warning("title is not matched up!!!");
		}
		@Test
		public void case3()
		{
		String title3=home.create_repo();
		Assert.assertEquals(title3,"Create a New Repository");
		repo.enter();
		LOGGER.info("New Repository created");
		}
		
		@Test
		public void case4() throws Exception               
		{
			commit=clone.writeFile();
			driver.navigate().refresh();
			UIcommit=repoHomePage.getCommitMsg();
			Assert.assertEquals(UIcommit,commit);
			LOGGER.info("commit message is verified");
		}
		
		@Test
		public void case5() throws Exception
		{
			repoHomePage.editReadMe();
			 updatedline=clone.pullCommand();
			clone.pullCommand();
			driver.quit();
			LOGGER.info("Clone created");
		}
		
		
		@Test
		public void case6() throws Exception
		{
			detect.isUnix();
			detect.isWindows();
			detect.detectOS();
			LOGGER.info("OS is detected and created file");
		}
	

}
