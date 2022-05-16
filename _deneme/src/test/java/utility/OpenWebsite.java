package utility;

import org.openqa.selenium.chrome.ChromeDriver;
import static java.util.concurrent.TimeUnit.SECONDS;
public class OpenWebsite {

    private ChromeDriver driver;
    private CommonMethods commonMethods;

    public OpenWebsite(String baseUrl){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ea_al\\OneDrive\\Masaüstü\\hepsiburada\\_deneme\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        driver.manage().timeouts().pageLoadTimeout(200, SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        commonMethods = new CommonMethods(driver);
    }

    public ChromeDriver getDriver() {
        return driver;
    }

    public void setDriver(ChromeDriver driver) {
        this.driver = driver;
    }

    public CommonMethods getCommonMethods() {
        return commonMethods;
    }

    public void setCommonMethods(CommonMethods commonMethods) {
        this.commonMethods = commonMethods;
    }
}
