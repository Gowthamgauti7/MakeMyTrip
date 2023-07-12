package com.qa.testscripts;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Logo {
    WebDriver driver=null;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
          driver =new ChromeDriver();
          driver.get("https://www.makemytrip.com/");
          driver.manage().window().maximize();
    }
    @Test
    public void BookTicket() throws InterruptedException{
        // TODO Auto-generated method stub
  WebElement onway=driver.findElement(By.xpath("//li[@class='selected']"));
  onway.click();
  WebElement from=driver.findElement(By.xpath("//input[@id=\"fromCity\"]"));
  from.click();
    WebElement inputfrom=driver.findElement(By.xpath("//input[@placeholder='From']"));
    inputfrom.sendKeys("mumbai");
    List<WebElement> allFrom=driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li"));
    
    for(WebElement i:allFrom) {
        if(i.getText().contains("Mumbai")) {
            i.click();
            break;
        }
    }
    String fromvalue=driver.findElement(By.xpath("//input[@id=\"fromCity\"]")).getText();
    System.out.println("value "+fromvalue);
    WebElement to=driver.findElement(By.xpath("//input[@id=\"toCity\"]"));
      to.click();
        WebElement inputto=driver.findElement(By.xpath("//input[@placeholder='To']"));
        inputto.sendKeys("bangkok");
        List<WebElement> allTo=driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li"));
        
        for(WebElement i:allTo) {
            if(i.getText().contains("Bangkok")) {
                i.click();
                break;
            }
        }
        WebElement date=driver.findElement(By.xpath("//div[@aria-label='Fri May 12 2023']"));
        date.click();
        WebElement search=driver.findElement(By.xpath("//a[normalize-space()='Search']"));
    search.click();
    Thread.sleep(3000);
    String title=driver.findElement(By.xpath("//p[@class='font24 blackFont whiteText appendBottom20 journey-title']")).getText();
Assert.assertEquals("Flights from Mumbai to Bangkok", "Flights from Mumbai to Bangkok");
    }
    @AfterMethod
    public void tearDown() {
//      driver.quit();
    }
}
