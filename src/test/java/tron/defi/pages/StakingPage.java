package tron.defi.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

/**
 * mine page
 */
public class StakingPage extends AbstractPage {


    public StakingPage(ChromeDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(css = ".ant-switch")
    public WebElement closeZeroSwitch;

    @FindBy(css = ".ant-input")
    public WebElement searchTokenInput;

//    @FindBy(css = ".table-header-filter-wrap-item:nth-child(1)")
//    public WebElement networkAll;
//
//    @FindBy(css = ".table-header-filter-wrap-item:nth-child(2)")
//    public WebElement networkTron;
//
//    @FindBy(css = ".table-header-filter-wrap-item:nth-child(3)")
//    public WebElement networkEth;
//
//    @FindBy(css = ".table-header-filter-wrap-item:nth-child(4)")
//    public WebElement networkBsc;
//
    @FindBy(xpath = "//*[@id=\"root\"]/div/section/main/div/div/section/section/section[2]/section[1]/div/div[1]/div[1]/div[1]/h1/text()")
    public WebElement totalStake;

    //div[@id='wallet_list_wrap']/div[2]/div/div/div/div/div/table/tbody/tr[2]/td[4]/div/span
    @FindBy(xpath = "//*[@id=\"root\"]/div/section/main/div/div/section/section/section[2]/section[1]/div/div[1]/div[1]/div[2]/h1/text()")
    public WebElement totalRewards;

    @FindBy(xpath = "//*[@id=\"root\"]/div/section/main/div/div/section/section/section[2]/section[1]/div/div[1]/div[1]/div[3]/h1/text()")
    public WebElement stakingAPY;
//
//    @FindBy(css = ".justify-content-end > img")
//    public WebElement pickNetworkImg;
//
//    @FindBy(css = ".table-header-filter-wrap-item:nth-child(1)")
//    public WebElement allNetwork;
//
//    @FindBy(css = ".table-header-filter-wrap-item:nth-child(2)")
//    public WebElement tronNetwork;
//
//    @FindBy(css = ".table-header-filter-wrap-item:nth-child(3)")
//    public WebElement ethNetwork;
//
//    @FindBy(css = ".table-header-filter-wrap-item:nth-child(4)")
//    public WebElement bscNetwork;
//
//    //token page 2
////    @FindBy(css = ".ant-pagination-item-2 > a")
//    @FindBy(xpath = "//div[@id='wallet_list_wrap']/div[2]/div/div/ul/li[3]/a")
//    public WebElement page2Token;


}
