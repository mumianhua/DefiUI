package tron.defi.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * mine page
 */
public class ConverterPage extends AbstractPage {


    public ConverterPage(ChromeDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(id = "my-swap-input")
    public WebElement amountConvertInput ;

    @FindBy(xpath = "//*[@id=\"root\"]/div/section/main/div/section/div/section[2]/div[1]/div[5]/div[2]/span/input")
    public WebElement amountReceiveInput ;

//    @FindBy(xpath = "//*[@id=\"root\"]/div/section/main/div/section/div/section[2]/div[1]/div[5]/div[2]/span/input")
    @FindBy(xpath = "//*[@id=\"root\"]/div/section/main/div/section/div/section[2]/div[1]/div[3]/div[1]/span[2]/span/span")
    public WebElement balanceToConvertInput ;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[2]/div/section/div/div/div[2]/div[1]/span/span/span[1]/input")
    public WebElement searchTokenInput ;

    @FindBy(className = "coin-max-r2")
    public WebElement maxBtn ;

    @FindBy(className = "swap-btn")
    public WebElement confirmBtn ;

    //total 2, 0: to convert, 1: to receive
    @FindBy(className = "cur-btt-arrow")
    public List<WebElement> arrowList ;


    @FindBy(className = "token-modal-list")
    public WebElement tokenModalList;

}
