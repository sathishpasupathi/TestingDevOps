package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testing {
	@Test
	@Parameters("browser")
public void testLogin(String value)
{
		
WebDriver driver=null;
if (value.equals("chrome"))
{
	System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\chromedriver.exe");
	driver=new ChromeDriver();	
}
else if(value.equals("firefox"))
{
	System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\Driver\\geckodriver.exe");
	driver=new FirefoxDriver();		
}

driver.get("https://github.com/login");
driver.findElement(By.id("login_field")).sendKeys("sathishpasupathi");
driver.findElement(By.id("password")).sendKeys("P@ssw0rd");
driver.findElement(By.name("commit")).click();
String title=driver.getTitle();
System.out.println(title);

Assert.assertEquals(title, "GitHub");
driver.close();
System.out.println("EndofFilesComments");
}
}
