package tron.defi.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

/**
 * mine page
 */
public class MenuePage extends AbstractPage {


    public MenuePage(ChromeDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(css = ".menu-list-li:nth-child(1) .inn-title")
    public WebElement homeBtn;

    @FindBy(css = ".menu-list-li:nth-child(2) .inn-title")
    public WebElement walletBtn;

    @FindBy(css = ".menu-list-li:nth-child(3) .inn-title")
    public WebElement bridgeBtn;

    @FindBy(css = ".menu-list-li:nth-child(4) .inn-title")
    public WebElement stakingBtn;

    @FindBy(css = ".menu-list-li:nth-child(5) .inn-title")
    public WebElement converterBtn;

    @FindBy(css = ".menu-list-li:nth-child(6) .inn-title")
    public WebElement bttRedenominationBtn;

}
