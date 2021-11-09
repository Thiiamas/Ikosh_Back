package com.Thiiamas.SpringCourse.Test;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MymDriver {

    public static String login = "floarctic332@gmail.com";
    public static String password = "ghwscn4715MM!";
    public static String postText = "Hey :)";
    public static String picturePath = "C:\\Users\\fkuhl\\Workflow\\Ikosh\\Fluffy\\MarquisFluffy.png";

    public static void main(String[] args) throws InterruptedException, AWTException {
        // TODO Auto-generated method stub
        postWithPicture(login, password, postText, picturePath);
    }

    public static boolean postWithPicture(String login, String password, String text, String picture)
            throws InterruptedException, AWTException {
        WebDriverManager.chromedriver().setup();
        System.setProperty("java.awt.headless", "false");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://creators.mym.fans/");

        // Accept cookies
        driver.findElement(By.xpath("//*[@id=\"cookie-accept\"]")).click();

        // login
        driver.findElement(By.xpath("/html/body/div[2]/div[3]/a[1]")).click();
        // weird popup spawn so i dealy to handle it
        Thread.sleep(1000);
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).ignoring(NoSuchElementException.class)
                .withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cookie-accept"))).click();
        wait.until(
                        ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div[2]/div/div/a[1]")))
                .click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username"))).sendKeys(login);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/form/div[2]/div/button")).click();

        // create new post
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/aside/nav/div/button")))
                .click();
        wait.until(
                        ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"sidebar-menu__choice--1\"]/div")))
                .click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"sidebar-menu__choice--3\"]/div[1]")))
                .click();

        // copy filepath into the clipboad
        Robot robot = new Robot();
        StringSelection str = new StringSelection(picture);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        // press CTRL + V then ENTER
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(1000);
        // wait for setup and click next
        wait.until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[@id=\"overlay-default\"]/div[1]/div/div/div[5]/button/span")))
                .click();

        //wait for upload, it is finish when we can enter text
        Wait<WebDriver> waitUpload = new FluentWait<WebDriver>(driver).ignoring(NoSuchElementException.class)
                .withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(1)).withMessage("Waiting upload");

        waitUpload.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//*[@id=\"overlay-default\"]/div[1]/div[1]/div[5]/div[1]/div[2]"))).click();
        //enter text
        Actions actionText = new Actions(driver);
        actionText.sendKeys(text).build().perform();

        //click to post
        driver.findElement(By.xpath("//*[@id=\"overlay-default\"]/div[1]/div[1]/div[13]/button[1]")).click();
        driver.quit();

        return true;
    }

}
