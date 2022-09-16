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
    public WebElement searchValidatorInput;

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
    @FindBy(xpath = "//*[@id=\"root\"]/div/section/main/div/div/section/section/section[2]/section[1]/div/div[1]/div[1]/div[1]/h1")
    public WebElement totalStake;

    //div[@id='wallet_list_wrap']/div[2]/div/div/div/div/div/table/tbody/tr[2]/td[4]/div/span
    @FindBy(xpath = "//*[@id=\"root\"]/div/section/main/div/div/section/section/section[2]/section[1]/div/div[1]/div[1]/div[2]/h1")
    public WebElement totalRewards;

    @FindBy(xpath = "//*[@id=\"root\"]/div/section/main/div/div/section/section/section[2]/section[1]/div/div[1]/div[1]/div[3]/h1")
    public WebElement stakingAPY;

    @FindBy(xpath = "//*[@id=\"root\"]/div/section/main/div/div/section/section/section[2]/section[1]/div/div[1]/div[2]/section[1]/section/h1")
    public WebElement deliveryBlocks;

    @FindBy(xpath = "//*[@id=\"root\"]/div/section/main/div/div/section/section/section[2]/section[1]/div/div[1]/div[2]/section[2]/section/h1/ul/li[1]")
    public WebElement tronCheckpoints;

    @FindBy(xpath = "//*[@id=\"root\"]/div/section/main/div/div/section/section/section[2]/section[1]/div/div[1]/div[2]/section[2]/section/h1/ul/li[2]")
    public WebElement ethCheckpoints;

    @FindBy(xpath = "//*[@id=\"root\"]/div/section/main/div/div/section/section/section[2]/section[1]/div/div[1]/div[2]/section[2]/section/h1/ul/li[3]")
    public WebElement bscCheckpoints;

    @FindBy(xpath = "//*[@id=\"validatorVote\"]/section/span")
    public WebElement allValidatorTitle;

    @FindBy(xpath = "/html/body/div/div/section/main/div/div/section/section/section[2]/section[3]/div/div/div/div/div/div/div/div/table/tbody/tr[2]/td[1]/a/div/div/div")
    public WebElement validatorName;

    @FindBy(xpath = "/html/body/div/div/section/main/div/div/section/section/section[2]/section[3]/div/div/div/div/div/div/div/div/table/tbody/tr[2]/td[2]/div")
    public WebElement validatorApy;

    @FindBy(xpath = "/html/body/div/div/section/main/div/div/section/section/section[2]/section[3]/div/div/div/div/div/div/div/div/table/tbody/tr[2]/td[3]/div/div[1]")
    public WebElement validatorStaked;

    @FindBy(xpath = "/html/body/div/div/section/main/div/div/section/section/section[2]/section[3]/div/div/div/div/div/div/div/div/table/tbody/tr[2]/td[4]/div")
    public WebElement nodeEfficiency;

    @FindBy(xpath = "/html/body/div/div/section/main/div/div/section/section/section[2]/section[3]/div/div/div/div/div/div/div/div/table/tbody/tr[2]/td[5]")
    public WebElement rewardRatio;

    @FindBy(css = "th.right:nth-child(2)")
    public WebElement apyButton;

    @FindBy(css = "th.right:nth-child(3)")
    public WebElement stakedButton;

    @FindBy(css = "th.right:nth-child(4)")
    public WebElement efficiencyButton;

    @FindBy(css = "th.right:nth-child(5)")
    public WebElement rewardButton;

    @FindBy(css = ".ant-input-suffix")
    public WebElement deleteButton;


    @FindBy(css = ".qucik-staking")
    public WebElement quickStakeButton;

    @FindBy(xpath = "//*[@id='rcDialogTitle3']")
    public WebElement Title;

    @FindBy(xpath = "//*[@id=\"stake_modal_v2\"]/div/div[1]/div[3]/span[1]")
    public WebElement per25Button;

    @FindBy(xpath = "//*[@id=\"stake_modal_v2\"]/div/div[1]/div[3]/span[2]")
    public WebElement per50Button;

    @FindBy(xpath = "//*[@id=\"stake_modal_v2\"]/div/div[1]/div[3]/span[3]")
    public WebElement per75Button;

    @FindBy(xpath = "//*[@id=\"stake_modal_v2\"]/div/div[1]/div[3]/span[4]")
    public WebElement per100Button;

    @FindBy(css = ".amount-title > span:nth-child(2) > b:nth-child(1)")
    public WebElement getBalance;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[2]/div[2]/section/div/div/div[1]/div[2]/input")
    public WebElement inputAmount;

    @FindBy(css = ".ant-modal-close-x")
    public WebElement windowClose;

    @FindBy(css = ".modal-ant-btn")
    public WebElement nextButton;

    @FindBy(css = ".staking-info-wrap > p:nth-child(3) > b:nth-child(1)")
    public WebElement stakedAmount;

    @FindBy(css = ".validator-info > p:nth-child(1)")
    public WebElement noteWord;

    @FindBy(css = ".stake-back-ico")
    public WebElement backButton;

    @FindBy(css = ".validator-info")
    public WebElement chooseValidator;

    @FindBy(css = ".validator-list-search > input:nth-child(1)")
    public WebElement searchValidator;

    @FindBy(css = ".name-s")
    public WebElement validator;

    @FindBy(css = ".valid-item-wrap")
    public WebElement selectValidator;

    @FindBy(css = ".validator-info > div:nth-child(2) > div:nth-child(1) > span:nth-child(2)")
    public WebElement newValidator;


}
