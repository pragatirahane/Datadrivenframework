package com.learndatadriven.sourcecode;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class datadrivenapproachexample1 {

	public static void main(String[] args) {
		try {
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			FileInputStream fis = new FileInputStream("D:\\ExcelR\\Selenium class\\DataDrivenFramework\\src\\com\\datadriven\\utils\\data.properties");
			Properties p = new Properties();
			p.load(fis);
			String url = p.getProperty("url");
			String topictitem = p.getProperty("topicitem");
		    String principalamount = p.getProperty("principalamount");
		    String intrestrate = p.getProperty("interestrate");
		    String intrestunits = p.getProperty("intrestunit");
		    String desired_time = p.getProperty("desired_time");
		    String desiredtimeunit = p.getProperty("desiredtimeunits");
		    driver.get(url);
			Thread.sleep(3000);
			WebElement generalmath = driver.findElement(By.cssSelector("a[title='General Math']"));
			generalmath.click();
			Thread.sleep(2000);
			WebElement topicitem = driver.findElement(By.name("topicItem"));
			Select topicitemselect = new Select(topicitem);
			Thread.sleep(2000);
			topicitemselect.selectByVisibleText(topictitem);
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("input[name='principal']")).sendKeys(principalamount);
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("input[name='interest']")).sendKeys(intrestrate);
			Thread.sleep(2000);
			WebElement intrestunit = driver.findElement(By.cssSelector("select[name='interest_units']"));
			Select intrestunitselect = new Select(intrestunit);
			intrestunitselect.selectByIndex(Integer.parseInt(intrestunits));
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("input[name='desired_time']")).sendKeys(desired_time);
			Thread.sleep(2000);
			WebElement desiredtimeunits = driver.findElement(By.cssSelector("select[name='desired_time_units']"));
			Select desiredtimeunitselect = new Select(desiredtimeunits);
			desiredtimeunitselect.selectByIndex(Integer.parseInt(desiredtimeunit));
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("input[type='submit']")).click();
			Thread.sleep(3000);
			driver.quit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}


	}


