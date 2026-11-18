/*package com.qa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected void enterText(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    protected boolean isDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    protected String getText(By locator) {
        return driver.findElement(locator).getText();
    }
}*/

package com.qa.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    protected void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void enterText(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator))
                .sendKeys(text);
    }

    protected boolean isDisplayed(By locator) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        ).isDisplayed();
    }

    protected boolean isChecked(By locator) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        ).isSelected();
    }

    protected String getText(By locator) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        ).getText();
    }

    public void hover(By locator) {
    
    actions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(locator))).perform();
    }

    public void RightClick(By locator) {
        actions.contextClick(wait.until(ExpectedConditions.visibilityOfElementLocated(locator))).perform();
    }

    public void scrollToElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        actions.moveToElement(element).perform();
    }

    public void javascriptHighlight(By locator) {
    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    String originalStyle = element.getAttribute("style");
    JavascriptExecutor js = (JavascriptExecutor) driver;

    // Apply highlight style
    js.executeScript("arguments[0].style.border = '2px solid red'; arguments[0].style.backgroundColor = 'yellow';", element);

    // Pause to visually see the flash
    try {
        Thread.sleep(2500);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt(); // Proper interruption handling
    }

    // Restore original style safely
    if (originalStyle != null) {
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, originalStyle);
    } else {
        js.executeScript("arguments[0].removeAttribute('style');", element);
    }
}



}