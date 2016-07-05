package cloning.process;

import java.io.BufferedReader;
import java.io.File;


import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qait.automation.GitHubAutomation.yaml;

import java.util.Date;



public class Cloning
{
	WebDriver driver;
	String comment;
	 
public Cloning()
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	
public String writeFile() throws IOException, InterruptedException
{
	String UserName="pragyas215";                            
    String RepoName="newly-created";
    String CloneUrl="https://github.com/"+UserName+"/"+RepoName+".git";
   
    
    String workDir = System.getProperty("user.dir");
    String fil = "abc.sh";
    File myFile = new File(workDir + fil);
    String userPath = myFile.getPath();
    System.out.println("workDir : "+workDir);
    System.out.println("myFile : "+myFile);
	System.out.println("userPath:"+userPath);
    
    File file = new File(workDir +"/fil");
	file.createNewFile();
    file.setExecutable(true);
	FileWriter fw = new FileWriter(file.getAbsoluteFile());
	PrintWriter pw = new PrintWriter(fw);
    pw.println("#!/bin/bash"); 
    pw.println("cd ~");
    pw.println("cd Desktop");
    pw.println("git clone "+CloneUrl);
    pw.println("cd newly-created");
    pw.println("touch Readme.txt");
    pw.println("git add Readme.txt");
    pw.println("git status");
 
  comment=yaml.getvalue("Text")+System.currentTimeMillis();
   // comment="demo repository"+System.currentTimeMillis();
    pw.println("git commit -m \""+comment+"\"");
 
    pw.println("git status");
    pw.println("git push https://pragyas215:Alanturing_05@github.com/pragyas215/newly-created.git");
    pw.close();	

    Process p=new ProcessBuilder(workDir +"/fil").start();
    int rc = p.waitFor();
    
 	return comment;
    }





public void refresh_browser()
{
	
}
public String pullCommand() throws Exception
{
	 String workDir = System.getProperty("user.dir");
	    String fil = "abc.sh";
	    File myFile = new File(workDir + fil);
	    String userPath = myFile.getPath();
	    System.out.println("workDir : "+workDir);
	    System.out.println("myFile : "+myFile);
		System.out.println("userPath:"+userPath);
	    
	
	File file1 = new File(workDir +"/fil");
	file1.createNewFile();
    file1.setExecutable(true);
	FileWriter fw1 = new FileWriter(file1.getAbsoluteFile());
	PrintWriter pw1 = new PrintWriter(fw1);
    pw1.println("#!/bin/bash"); 
    pw1.println("cd ~");
    pw1.println("cd Desktop");
    pw1.println("cd newly-created");
    pw1.println("git pull ");
    pw1.println("git status");
    pw1.close();
    Process p1=new ProcessBuilder(workDir +"/fil").start();
    int rc = p1.waitFor();
    InputStream is = p1.getInputStream();
	BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	String line = null;
	while ((line = reader.readLine()) != null)
	System.out.println(line);
	return line;
	
	
	
	
	
}
}
   


	
	
