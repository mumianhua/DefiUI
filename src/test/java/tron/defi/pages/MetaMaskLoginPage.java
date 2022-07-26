package tron.defi.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

/**
 * mine page
 */
public class MetaMaskLoginPage extends AbstractPage {


    public MetaMaskLoginPage(ChromeDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(xpath = "/html/body/div[1]/div/div[3]/div/div/form/div/div/input")
    public WebElement password_input;

    @FindBy(xpath = "/html/body/div[1]/div/div[3]/div/div/button")
    public WebElement login_btn;

}
