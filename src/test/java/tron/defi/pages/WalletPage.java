package tron.defi.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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

    @FindBy(css = ".justify-content-end > img")
    public WebElement pickNetworkImg;

    @FindBy(css = ".table-header-filter-wrap-item:nth-child(1)")
    public WebElement allNetwork;

    @FindBy(css = ".table-header-filter-wrap-item:nth-child(2)")
    public WebElement tronNetwork;

    @FindBy(css = ".table-header-filter-wrap-item:nth-child(3)")
    public WebElement ethNetwork;

    @FindBy(css = ".table-header-filter-wrap-item:nth-child(4)")
    public WebElement bscNetwork;

    //token page 2
//    @FindBy(css = ".ant-pagination-item-2 > a")
    @FindBy(xpath = "//div[@id='wallet_list_wrap']/div[2]/div/div/ul/li[3]/a")
    public WebElement page2Token;

//    @FindBy(className = "ant-table-row ant-table-row-level-0")
    @FindBy(className = "ant-table-row")
    public List<WebElement> tokenList;

    @FindBy(className = "balance-v")
    public WebElement totalValueOnBttc;

    /**
     *
     *  search token from wallet page, then use the index of token to get balance.
     *  and the first index is 2,and then 3,4,5....
      * @return   token balance
     */
    public WebElement getTokenBalance(int index){
        String path1 = "//div[@id='wallet_list_wrap']/div[2]/div/div/div/div/div/table/tbody/tr[";
        String path2 = "]/td[3]/div";
        String path = path1 + index + path2;
        return driver.findElementByXPath(path);
    }

    /**
     *
     *  search token from wallet page, then use the index of token to get token's mapped network.
     *  and the first index is 2,and then 3,4,5....
     * @return   token's mapped network
     */
    public WebElement getTokenNetwork(int index){
        String path1 = "//div[@id='wallet_list_wrap']/div[2]/div/div/div/div/div/table/tbody/tr[";
        String path2 = "]/td[2]/div";
        String path = path1 + index + path2;
        return driver.findElementByXPath(path);
    }

    /**
     *
     *  search token from wallet page, then use the index of token to get token's usd value.
     *  and the first index is 2,and then 3,4,5....
     * @return   token's usd value
     */
    public WebElement getTokenUsdValue(int index){
        String path1 = "//div[@id='wallet_list_wrap']/div[2]/div/div/div/div/div/table/tbody/tr[";
        String path2 = "]/td[4]/div/span";
        String path = path1+index+path2;
        return driver.findElementByXPath(path);
    }
}
