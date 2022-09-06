package tron.defi.base;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import tron.defi.pages.MetaMaskLoginPage;
import tron.common.utils.Configuration;
import tron.defi.pages.MetaMaskMainPage;
import tron.defi.pages.TronlinkLoginPage;
import tron.defi.pages.TronlinkMainPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Base {

  public ChromeDriver DRIVER;
  public String originBtt = Configuration.getByPath("testng.conf")
      .getString("bttc.bttcOriginBtt");
  public String metamaskAddress = Configuration.getByPath("testng.conf")
      .getString("bttc.metamaskAddress");
  public String tronlinkAddress = Configuration.getByPath("testng.conf")
      .getString("bttc.tronlinkAddress");


  public String URL = Configuration.getByPath("testng.conf")
      .getString("bttc.url");


  Integer retryLoginTimes = 1;

  @BeforeSuite(alwaysRun=true)
  public void before() throws Exception{
    setUpChromeDriver();
    loginAccount();
  }


  public void setUpChromeDriver() throws Exception {
//      killChromePid();
    System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver103");
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--user-data-dir=/Users/sophiawang/Library/Application Support/Google/Chrome/");
    options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
    options.addArguments("--enable-extensions");
    options.addArguments("--verbose");
    options.setHeadless(Boolean.FALSE);
    DRIVER = new ChromeDriver(options);

  }

  public boolean loginAccount() throws Exception {
    while (retryLoginTimes > 0) {
      try {
        retryLoginTimes--;
        //login metaFox
        String metaMaskUrl = "chrome-extension://nkbihfbeogaeaoehlefnkodbefgpgknn/popup.html";
        DRIVER.get(metaMaskUrl);
        waitingTime(10);
        MetaMaskLoginPage metaMaskloginPage = new MetaMaskLoginPage(DRIVER);
        metaMaskloginPage.password_input.sendKeys("Sophia123");
        waitingTime(5);
        metaMaskloginPage.login_btn.click();
        waitingTime(15);

        String first = DRIVER.getWindowHandle();
        System.out.println("first: " + first);
        waitingTime(5);

//        String to = "0xEbae50590810b05D4B403F13766f213518Edef65";
        switchMetamaskAddress(metamaskAddress);

        //login tronlink
        String tronlinkUrl = "chrome-extension://ibnejdfjmmkpcnlpebklmnkoeoihofec/packages/popup/build/index.html";
        String js = "window.open(\"" + tronlinkUrl + "\")";
        DRIVER.executeScript(js);
        waitingTime(10);

        String second = DRIVER.getWindowHandle();
        System.out.println("second: "+second);
        System.out.println("size: " + DRIVER.getWindowHandles().size());
        DRIVER.switchTo().window(first).close();

        for(String tem: DRIVER.getWindowHandles()){
          second = tem;
          System.out.println("second: "+second);
        }
        DRIVER.switchTo().window(second);
        waitingTime(10);

        DRIVER.get(tronlinkUrl);
        waitingTime(10);
        TronlinkLoginPage tlLoginPage = new TronlinkLoginPage(DRIVER);
        tlLoginPage.password_input.sendKeys("Sophia123");
        waitingTime(5);
        tlLoginPage.login_btn.click();
        waitingTime(10);

        switchTronlinkAddress(tronlinkAddress);
        DRIVER.manage().window().maximize();

        //login bttc
        js = "window.open(\"" + URL + "\")";
        DRIVER.executeScript(js);
        waitingTime(10);
        String third = DRIVER.getWindowHandle();
        System.out.println("third: " + third);
        DRIVER.switchTo().window(second).close();
        waitingTime(10);

        for(String tem: DRIVER.getWindowHandles()){
          third = tem;
          System.out.println("third2: " + third);
        }
        DRIVER.switchTo().window(third);
        waitingTime(10);

      } catch (Exception e) {
        e.printStackTrace();
        DRIVER.quit();
        setUpChromeDriver();
      }
    }
    return false;

  }

  public void logoutAccount() {
    DRIVER.quit();
  }

  public  static void killChromePid() throws IOException {
    Runtime.getRuntime().exec("sh kill_chrome.sh");
  }

  public void switchMetamaskAddress(String add) throws Exception{
    MetaMaskMainPage metaMaskMainPage = new MetaMaskMainPage(DRIVER);
    DRIVER.manage().window().setSize(new Dimension(357, 650));
    metaMaskMainPage.address_btn.click();
    waitingTime(5);
    metaMaskMainPage.search_input.sendKeys(add);
    waitingTime(5);
    metaMaskMainPage.search_result.click();
    waitingTime(5);
    DRIVER.manage().window().maximize();
  }

  public void switchTronlinkAddress(String toAddress) throws Exception{
    TronlinkMainPage tronlinkMainPage = new TronlinkMainPage(DRIVER);
    waitingTime(5);
//    WebElement closeBtn = DRIVER.findElementByClassName("switch-closed");
//    if (closeBtn != null && closeBtn.isDisplayed()){
//      tronlinkMainPage.switch_closed_btn.click();
//    }
    tronlinkMainPage.address_btn.click();
    waitingTime(5);
    tronlinkMainPage.search_btn.click(); //放大镜
    tronlinkMainPage.search_input.sendKeys(toAddress);
    waitingTime(5);
    tronlinkMainPage.search_result.click();
    waitingTime(2);
  }

  public void waitingTime(long time) throws InterruptedException {
    TimeUnit.SECONDS.sleep(time);
  }

  @AfterSuite(alwaysRun=true)
  public void after() throws Exception {
    logoutAccount();
  }

}
