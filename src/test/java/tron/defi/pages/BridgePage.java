package tron.defi.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * mine page
 */
public class BridgePage extends AbstractPage {


    public BridgePage(ChromeDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(css = ".item:nth-child(2) > .content")
    public WebElement arrivingTime ;

    @FindBy(css = ".token-show")
    public WebElement tokenShow ;

    @FindBy(css = ".max-btn")
    public WebElement maxAmountBtn ;

    @FindBy(css = ".search-input")
    public WebElement searchTokenInput ;

    @FindBy(xpath = "//li[@id='list-0']/div/div/div[2]")
    public WebElement searchTokenResult ;

    //ant-btn ani-button-black dis
    //*[@id="root"]/div/section/main/section/div/div[2]/div[1]/div[6]/button
//    @FindBy(css = ".ant-btn > span")
    @FindBy(xpath = "//*[@id=\"root\"]/div/section/main/section/div/div[2]/div[1]/div[6]/button")
    public WebElement crossChainBtn ;

    @FindBy(xpath = "//div[@id='root']/div/section/main/section/div/div[2]/div/div[2]/div[2]/div/div[2]/div/span[2]")
    public WebElement fromNetworkSpan ;

    @FindBy(xpath = "//*[@id=\"root\"]/div/section/main/section/div/div[2]/div[1]/div[2]/div[4]/div/div[2]")
    public WebElement toNetworkSpan ;

    @FindBy(xpath = "//*[@id=\"root\"]/div/section/main/section/div/div[2]/div[1]/div[4]/div[2]/div/input")
    public WebElement crossAmountInput ;

    //total is 8, 0-3: from, 4-7:to
    @FindBy(className = "name")
    public List<WebElement> toNetworkList;

    //total is 2, 0: from, 1: receive
    @FindBy(className = "receive-amoutn-wrap")
    public List<WebElement> crossFromReceiveAmountDivList;

    /**
     * get from network
     * @param index 1:bttc ,2:tron, 3:eth, 4:bsc
     * @return
     */
    public WebElement getFromNetworkDiv(int index){
        String path1 = "/html/body/div[2]/div/div/div/div[2]/div[1]/div/div/div[";
        String path2 = "]";
        String path = path1 + index + path2;
        return driver.findElementByXPath(path);
    }


}
