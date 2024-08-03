package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //Init
        //System.setProperty("Webdriver.chrome.driver", "C:\\Users\\rahul.shetkar\\selenium2\\introduction\\webdriver\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();

        //Open Fitpeo Homepage
        driver.get("https://www.fitpeo.com/");

        //Click on Revenue Calculator
        driver.findElement(By.linkText("Revenue Calculator")).click();
        Thread.sleep(3000);

        //Scroll down until slider is visible
        js.executeScript("window.scrollBy(0,300)");
        Thread.sleep(2000);

        //Find Slider Element
        WebElement slider = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[2]/div/div/span[1]/span[3]/input"));
         for(Integer i=0;i<620;i++)
         {
            slider.sendKeys(Keys.ARROW_RIGHT);
         }

        WebElement inputDiv = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[2]/div/div/div/div"));
        WebElement input = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[2]/div/div/div[1]/div/input"));
        System.out.println("Input Field Value after slider is set:" + input.getAttribute("value"));

        inputDiv.click();
        input.sendKeys("560");
        System.out.println("Slider value after input field is set:" + slider.getAttribute("value"));

        //Set input to 820 and Tick the checkboxes to calculate Total
        inputDiv.click();
        input.sendKeys("820");
        js.executeScript("window.scrollBy(0,500)");
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[1]/label/span[1]/input")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[2]/label/span[1]/input")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[3]/label/span[1]/input")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[8]/label/span[1]/input")).click();
        Thread.sleep(2000);

        //Total Recurring Reimbursement for all Patients Per Month:
        System.out.println("Total Recurring Reimbursement for all Patients Per Month:" + driver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div/p[4]/p")).getText());

    }
}
