package com.Thiiamas.SpringCourse.SeleniumScripts;


import java.time.Duration;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FanslyDriver {
	public static String login = "fluffycheum@gmail.com";
	public static String password = "ghwscn4715FY!";
	public static String postText = "Hey :)";
	public static String picturePath = "C:\\Users\\fkuhl\\Workflow\\Ikosh\\Fluffy\\MarquisFluffy.png";

	public static void main(String[] args) throws InterruptedException, AWTException {
		postWithPicture(login, password, postText, picturePath);
	}

	public static boolean postWithPicture(String login, String password, String text, String picture)
			throws InterruptedException, AWTException {
		WebDriverManager.chromedriver().setup();
		System.setProperty("java.awt.headless", "false");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://fansly.com/");
		// accept popup
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).ignoring(NoSuchElementException.class)
				.withTimeout(Duration.ofSeconds(2)).pollingEvery(Duration.ofSeconds(1));
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("/html/body/app-root/div/div[3]/app-age-gate-modal/div/div[2]/div[2]/div[2]"))).click();

		// login
		driver.findElement(By.xpath(
				"/html/body/app-root/div/div[1]/div/app-landing-page/div/div[1]/div[2]/div[1]/div[2]/div[1]/div/input"))
				.sendKeys(login);
		driver.findElement(By.xpath(
				"/html/body/app-root/div/div[1]/div/app-landing-page/div/div[1]/div[2]/div[1]/div[2]/div[2]/div/input"))
				.sendKeys(password);
		driver.findElement(By.xpath(
				"/html/body/app-root/div/div[1]/div/app-landing-page/div/div[1]/div[2]/div[1]/div[2]/app-button"))
				.click();
		Thread.sleep(2000);

		try {
			//Click popup

			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
							"/html/body/app-root/div/div[3]/app-new-version-info-modal/div/div[3]/div")))
					.click();
		} catch(Exception e){

		}

		
		
		// WritePost if in Home (note : maybe improve to force https://fansly.com/home
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"/html/body/app-root/div/div[1]/div/app-feed-route/div[1]/div/div/app-post-creation/div[1]/div[2]/div[1]/textarea")))
				.click();

		Actions action = new Actions(driver);
		action.sendKeys(text).build().perform();

		// uploadpicture
		driver.findElement(By.xpath(
				"/html/body/app-root/div/div[1]/div/app-feed-route/div[1]/div/div/app-post-creation/div[2]/div[1]/div"))
				.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
						"/html/body/app-root/div/div[1]/div/app-feed-route/div[1]/div/div/app-post-creation/div[2]/div[1]/div/div[2]/div[1]/xd-localization-string")))
				.click();
/*		driver.findElement(By.xpath(
				"/html/body/app-root/div/div[1]/div/app-feed-route/div[1]/div/div/app-post-creation/div[2]/div[1]/div/div[2]/div[1]/xd-localization-string"))
				.click();*/
		System.out.println("start wait");
		Thread.sleep((2000));
		System.out.println("end wait");
		//copy filepath into the clipboad
		Robot robot = new Robot();
		StringSelection str = new StringSelection(picture);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		
		//press CTRL + V then ENTER
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("/html/body/app-root/div/div[3]/app-account-media-upload/div/div[3]/div[2]/div[3]"))).click();

		System.out.println("start wait Upload");
		Thread.sleep(15000);
		System.out.println("end wait");
		driver.findElement(By.xpath(
				"/html/body/app-root/div/div[1]/div/app-feed-route/div[1]/div/div/app-post-creation/div[2]/div[8]/xd-localization-string"))
				.click();
		Thread.sleep(2000);
		driver.quit();
		return true;
	}

}
