package tron.defi.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

/**
 * mine page
 */
public class WalletPage extends AbstractPage {


    public WalletPage(ChromeDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(css = ".ant-switch")
    public WebElement closeZeroSwitch;

    @FindBy(css = ".ant-input")
    public WebElement searchTokenInput;

    @FindBy(css = ".table-header-filter-wrap-item:nth-child(1)")
    public WebElement networkAll;

    @FindBy(css = ".table-header-filter-wrap-item:nth-child(2)")
    public WebElement networkTron;

    @FindBy(css = ".table-header-filter-wrap-item:nth-child(3)")
    public WebElement networkEth;

    @FindBy(css = ".table-header-filter-wrap-item:nth-child(4)")
    public WebElement networkBsc;

    @FindBy(xpath = "//div[@id='wallet_list_wrap']/div[2]/div/div/div/div/div/table/tbody/tr[2]/td[3]/div")
    public WebElement bttBalance;

    //div[@id='wallet_list_wrap']/div[2]/div/div/div/div/div/table/tbody/tr[2]/td[4]/div/span
    @FindBy(css = ".justify-content-end > span")
    public WebElement bttUsdValue;

    @FindBy(xpath = "//div[@id='wallet_list_wrap']/div[2]/div/div/div/div/div/table/tbody/tr[2]/td[2]/div")
    public WebElement bttMappedNetwork;



}
