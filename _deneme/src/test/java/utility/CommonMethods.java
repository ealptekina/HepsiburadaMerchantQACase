package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods {
    WebDriver driver;
    private WebDriverWait wait;

    //Constructor
    public CommonMethods(WebDriver driver) {
        this.driver = driver;
        Variables.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    //Gönderilen web elementin görünür olmasını bekler
    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }

    //Gönderilen web elementin mevcut olmasını bekler
    public void waitPresence(By elementBy) {
        wait.until(ExpectedConditions.presenceOfElementLocated(elementBy));
    }

    //önderilen web elemente tıklanmasını sağlar
    public void clickWithFindElement(By elementBy) {
        //waitPresence(elementBy);
        Variables.driver.findElement(elementBy).click();
    }

    //Bir web elemente text girilmesini sağlar
    public void writeText(By elementBy, String text) {
        waitVisibility(elementBy);
        Variables.driver.findElement(elementBy).sendKeys(text);
    }



}