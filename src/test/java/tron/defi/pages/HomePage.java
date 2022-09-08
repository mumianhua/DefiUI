package tron.defi.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * mine page
 */
public class HomePage extends AbstractPage {


    public HomePage(ChromeDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(css = ".portal-bttc-wallet .amount > span")
    public WebElement walletValueSpan;

    @FindBy(css = ".portal-stake-account .title > span")
    public WebElement stakingValueSpan;
}
