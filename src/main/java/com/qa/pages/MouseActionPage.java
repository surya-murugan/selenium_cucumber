package com.qa.pages;

import com.qa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MouseActionPage extends BasePage {

     private By MobileButton = By.linkText("Mobiles");
    private By hoverButton = By.xpath("//button[text()='Point Me']");
    private By FileUploadButton = By.id("singleFileInput");
    private By Smartwatch = By.xpath("//table//tr[td[text()='Smartwatch']]");
    private By SmartwatchCheckbox = By.xpath("//table//tr[td[text()='Smartwatch']]/td/input[@type='checkbox']");
    private By DatePicker = By.id("datepicker");
    private By TelevisionCheckbox = By.xpath("//table//tr[td[text()='Television']]/td/input[@type='checkbox']");
    private By SoundbarCheckbox = By.xpath("//table//tr[td[text()='Soundbar']]/td/input[@type='checkbox']");
    private By Linktext2 = By.linkText("2");
    private By Linktext4 = By.linkText("4");


public MouseActionPage(WebDriver driver) {
        super(driver);
    }

   
    public void hoverOverButton() {
        hover(hoverButton);
    }

    // public void rightClickPointMeButton() {
    //     RightClick(hoverText);
    // }
     public void clickMobilesButton() {
        click(MobileButton);
     }

    public void clickFileUploadButton() {
        actions.moveToElement(driver.findElement(FileUploadButton)).click().perform();
    }

    public void uploadFile() {
        String filePath = "C:\\Users\\Santhosh\\Downloads\\30_Day_Java_Selenium_Interview_Plan.pdf"; 
        driver.findElement(FileUploadButton).sendKeys(filePath);
    }
    public void clickSmartwatchCheckbox() {
        scrollToElement(SmartwatchCheckbox);
        javascriptHighlight(Smartwatch);

        click(SmartwatchCheckbox);
    }

    public void clickTelevisionCheckbox() {


scrollToElement(SmartwatchCheckbox);
click(Linktext2);
        click(TelevisionCheckbox);
    }

    public void clickSoundbarCheckbox() {
        scrollToElement(SmartwatchCheckbox);
        click(Linktext4);
        click(SoundbarCheckbox);
    }

    public void verifySmartwatchCheckboxSelected() {
        isChecked(SmartwatchCheckbox);
    }

    public void selectDateFromDatePicker(String date) 
    {
        click(DatePicker);
        while (true) 
        {
            String month = driver.findElement(By.className("ui-datepicker-month")).getText();
            String year = driver.findElement(By.className("ui-datepicker-year")).getText();
            
          if (month.equals("September")&& year.equals("2026"))
          {
           break;
          }
        
           driver.findElement(By.className("ui-datepicker-next")).click();
        }

        driver.findElement(By.xpath("//a[text()='15']")).click();
    }

    public String getSelectedDate() {
        return driver.findElement(DatePicker).getAttribute("value");
    }

}
