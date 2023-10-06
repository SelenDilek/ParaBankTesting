package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Events {
    public static void sendKeys(WebElement element, String text) {
        GWD.getWait().until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    public static void click(WebElement element) {
        GWD.getWait().until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static void jsClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript ("arguments[0].click();", element);
    }

    public static void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void verifyContainsText(WebElement element, String value) {
        GWD.getWait().until(ExpectedConditions.textToBePresentInElement(element, value));
        Assert.assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()));
    }

    public static Select select(WebElement element) {
        GWD.getWait().until(ExpectedConditions.elementToBeClickable(element));
        return new Select(element);
    }
}
