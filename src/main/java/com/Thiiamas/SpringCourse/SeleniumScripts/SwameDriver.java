package com.Thiiamas.SpringCourse.SeleniumScripts;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwameDriver {

    public static String login = "fluffycheum@gmail.com";
    public static String password = "ghwscnSE!";
    public static String postText = "Hey :)";
    public static String picturePath = "C:\\Users\\fkuhl\\Workflow\\Ikosh\\Fluffy\\MarquisFluffy.png";

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub

        postWithPicture(login, password, postText, picturePath);
    }

    public static boolean postWithPicture(String login, String password, String text, String picture)
            throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        System.setProperty("java.awt.headless", "false");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://swame.com/en/");
        driver.manage().window().maximize();

        // login
        driver.findElement(By.id("id_email_login")).sendKeys(login);
        driver.findElement(By.id("id_password_login")).sendKeys(password);
        driver.findElement(By.className("registration__form__button")).click();

        // click on publish button
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

        wait.until(
                        ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div/nav/ul/li[5]/button")))
                .click();
        // wait for div to spawn and input text
        WebElement textDiv = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//*[@id=\"create-post-form-modal\"]/div[4]/div[1]/div[1]")));
        textDiv.click();
        Actions action = new Actions(driver);
        action.sendKeys(text).build().perform();

        // upload 1 picture
        WebElement uploadElement = driver.findElement(By.id("create-post-form-modal-inputfile"));
        uploadElement.sendKeys(picture);
        // TO IMPROVE wait for upload
        System.out.println("start wait");
        Thread.sleep(5000);
        System.out.println("start end");

        // Post
        driver.findElement(By.xpath("//*[@id=\"create-post-form-modal\"]/div[5]/div[2]/button[3]")).click();

        driver.quit();
        return true;
    }
}
