package testcases;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.CommonMethods;
import utility.Variables;

import java.util.List;

public class AddToChart {

    Variables variables = new Variables();
    CommonMethods commonMethods = new CommonMethods(Variables.driver);
    private By searchBox = By.xpath("//*[@id=\"SearchBoxOld\"]/div/div/div[1]/div[2]/input");
    private By searchButton = By.xpath("//*[@id=\"SearchBoxOld\"]/div/div/div[2]");
    private By firstProductXPath = By.xpath("//*/li[1]/div/a");
    private By addToChartBtn = By.id("addToCart");
    private By continueToShopping = By.xpath("//*/div/div/div/div/div/h1/a");
    private By addToChartOtherSellerBtn = By.xpath("//*/tr[1]/td[3]/div/form/button");
    private By cart = By.id("shoppingCart");
    private By shoppingCartsItems = By.xpath("//*/li/div/div/div[2]/div[2]");


    @Given("Search")
    public void iSearchTheProduct() {
        commonMethods.writeText(searchBox, variables.searchText);
        commonMethods.clickWithFindElement(searchButton);
    }

    @When("Select first product")
    public void iSelectFirstProduct() {
        commonMethods.clickWithFindElement(firstProductXPath);
    }

    @When("Add To Chart")
    public void iAddToChart() throws InterruptedException {
        commonMethods.clickWithFindElement(addToChartBtn);
        Thread.sleep(1500);
        commonMethods.clickWithFindElement(continueToShopping);
    }

    @When("Add To Chart From Another Seller")
    public void iAddToChartFromAnotherSeller() throws InterruptedException {
        commonMethods.clickWithFindElement(addToChartOtherSellerBtn);
        Thread.sleep(3000);
        commonMethods.clickWithFindElement(continueToShopping);
    }

    @Then("I have seen all products were added to basket")
    public void iSeeAllProductAreAdded() {
        commonMethods.clickWithFindElement(cart);
        List<WebElement> elements = Variables.driver.findElements(shoppingCartsItems);
        for (WebElement element : elements){
            String text = element.getText();
            Assert.assertEquals(variables.searchText, text);
        }
    }





}
