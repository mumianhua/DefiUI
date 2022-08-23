package tron.defi.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

/**
 * mine page
 */
public class MetaMaskMainPage extends AbstractPage {


    public MetaMaskMainPage(ChromeDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(className = "identicon__address-wrapper")
    public WebElement address_btn;

    @FindBy(id = "search-accounts")
    public WebElement search_input;

    @FindBy(xpath = "/html/body/div[1]/div/div[3]/div[4]/div[3]/button")
    public WebElement search_result;

}
