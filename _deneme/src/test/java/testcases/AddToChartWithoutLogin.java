package testcases;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.CommonMethods;
import utility.OpenWebsite;
import utility.Variables;

import java.util.List;

public class AddToChartWithoutLogin {

    Variables variables = new Variables();
    ChromeDriver driver;
    CommonMethods commonMethods;
    private By searchBox = By.xpath("//*[@id=\"SearchBoxOld\"]/div/div/div[1]/div[2]/input");
    private By searchButton = By.xpath("//*[@id=\"SearchBoxOld\"]/div/div/div[2]");
    private By firstProductXPath = By.xpath("//*/li[1]/div/a");
    private By addToChartBtn = By.id("addToCart");
    private By continueToShopping = By.xpath("//*/div/div/div/div/div/h1/a");
    private By addToChartOtherSellerBtn = By.xpath("//*/tr[1]/td[3]/div/form/button");
    private By cart = By.id("shoppingCart");
    private By shoppingCartsItems = By.xpath("//*/li/div/div/div[2]/div[2]");
    private By successMessageNotificationId = By.xpath("/html/body/div[9]/div");


    @Given("Search on {string}")
    public void iSearchTheProduct(String baseUrl) {
        OpenWebsite ow = new OpenWebsite(baseUrl);
        driver = ow.getDriver();
        commonMethods = ow.getCommonMethods();
        commonMethods.writeText(searchBox, variables.searchText);
        commonMethods.clickWithFindElement(searchButton);
    }

    @When("Select first product wl")
    public void iSelectFirstProduct() {
        commonMethods.clickWithFindElement(firstProductXPath);
    }

    @When("Add To Chart wl")
    public void iAddToChart() throws InterruptedException {
        commonMethods.clickWithFindElement(addToChartBtn);
        Thread.sleep(5000);
    }

    @When("Add To Chart From Another Seller wl")
    public void iAddToChartFromAnotherSeller() throws InterruptedException {
        commonMethods.clickWithFindElement(addToChartOtherSellerBtn);
        Thread.sleep(5000);
    }

    @Then("I have seen all products were added to basket wl")
    public void iSeeAllProductAreAdded() {
        commonMethods.clickWithFindElement(cart);
        List<WebElement> elements = Variables.driver.findElements(shoppingCartsItems);
        Assert.assertTrue(elements.size()==2);
        for (WebElement element : elements){
            String text = element.getText();
            Assert.assertEquals(variables.searchText, text);
        }
    }
}
