package tron.defi.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

/**
 * mine page
 */
public class TronlinkMainPage extends AbstractPage {


    public TronlinkMainPage(ChromeDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(className = "mw-130")
    public WebElement address_btn;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/div/div[2]/div[1]/div/div[1]/div[1]/img")
    public WebElement search_btn;

    @FindBy(xpath = "//*[@id=\"root\"]div/div/div/div/div/div[2]/div[1]/div/div[1]/div[1]/span/input")
    public WebElement search_input;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/div/div[2]/div[1]/div/div[1]/div[2]/div")
    public WebElement search_result;
}
