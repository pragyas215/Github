package com.qait.automation.GitHubAutomation;



import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import cloning.process.Cloning;

public class DetectOS {

private static String OS = System.getProperty("os.name").toLowerCase();
	static Cloning clon=new Cloning();
	
	public  String detectOS() throws Exception {
		
		System.out.println(OS);
		
		if (isWindows()) {
			System.out.println("This is Windows");
			String UserName="pragyas215";                            
		    String RepoName="newly-created";
		    String CloneUrl="https://github.com/"+UserName+"/"+RepoName+".git";
		    
		    String workDir = System.getProperty("user.dir");
		    String fil = "abc.bat";
		    File myFile = new File(workDir + fil);
		    String userPath = myFile.getPath();
		    System.out.println("workDir : "+workDir);
		    System.out.println("myFile : "+myFile);
			System.out.println("userPath:"+userPath);
		    
			File file1 = new File(workDir +"/fil");
			file1.createNewFile();
		    file1.setExecutable(true);
			FileWriter fw = new FileWriter(file1.getAbsoluteFile());
			PrintWriter pw = new PrintWriter(fw);
		
		    pw.println("cd ..");
		    pw.println("cd users");
		    
		    pw.println("cd Desktop");
		    pw.println("git clone "+CloneUrl);
		    pw.println("cd newly-created");
		    pw.println("touch Readme.txt");
		    pw.println("git add Readme.txt");
		    pw.println("git status");
		    
		    String comment = yaml.getvalue("Text")+System.currentTimeMillis();
		    // comment="demo repository"+System.currentTimeMillis();
		     pw.println("git commit -m \""+comment+"\"");
		  
		     pw.println("git status");
		     pw.println("git push https://pragyas215:Alanturing_05@github.com/pragyas215/newly-created.git");
		     pw.close();	

		     Process p=new ProcessBuilder(workDir +"/fil").start();
		     int rc = p.waitFor();
		     
		  	
		
		} else if (isUnix()) {
			System.out.println("This is Unix or Linux");
			clon.writeFile();
			clon.pullCommand();
		
		} else {
			System.out.println("Your OS is not support!!");
		}
	
		return OS;
	}

	public static boolean isWindows() {

		return (OS.indexOf("win") >= 0);
        
	}

	

	public static boolean isUnix() {

		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
		
	}

	

	
}
