package tron.defi.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import tron.common.utils.Configuration;
import tron.defi.pages.MetaMaskLoginPage;
import tron.defi.pages.TronlinkLoginPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseBak {

  public ChromeDriver DRIVER;
  static String password = Configuration.getByPath("testng.conf")
      .getString("chromeExtension.password");
  public String accountAddress001 = Configuration.getByPath("testng.conf")
      .getString("chromeExtension.accountAddress001");
  public String accountKey001 = Configuration.getByPath("testng.conf")
      .getString("chromeExtension.accountKey001");
  public String accountAddress002 = Configuration.getByPath("testng.conf")
      .getString("chromeExtension.accountAddress002");

  public String URL = Configuration.getByPath("testng.conf")
      .getString("bttc.url");


  Integer retryLoginTimes = 1;


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
//        DRIVER.manage().window().fullscreen();

        String metaMaskUrl = "chrome-extension://nkbihfbeogaeaoehlefnkodbefgpgknn/popup.html";
        DRIVER.get(metaMaskUrl);
        DRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MetaMaskLoginPage metaMaskloginPage = new MetaMaskLoginPage(DRIVER);
        metaMaskloginPage.password_input.sendKeys("Sophia123");
        DRIVER.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        metaMaskloginPage.login_btn.click();
        DRIVER.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String first = DRIVER.getWindowHandle();
        System.out.println("first: " + first);
        Thread.sleep(10000);

        String to = "0xEbae50590810b05D4B403F13766f213518Edef65";
        switchMetamaskAddress(to);

        //login tronlink
        String tronlinkUrl = "chrome-extension://ibnejdfjmmkpcnlpebklmnkoeoihofec/packages/popup/build/index.html";
        String js = "window.open(\"" + tronlinkUrl + "\")";
        DRIVER.executeScript(js);
        DRIVER.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        String second = DRIVER.getWindowHandle();
        System.out.println("second: "+second);
        System.out.println("size: " + DRIVER.getWindowHandles().size());
        DRIVER.switchTo().window(first).close();

        for(String tem: DRIVER.getWindowHandles()){
          second = tem;
          System.out.println("second: "+second);
        }
        DRIVER.switchTo().window(second);
        DRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        DRIVER.get(tronlinkUrl);
        DRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        TronlinkLoginPage tlLoginPage = new TronlinkLoginPage(DRIVER);
        tlLoginPage.password_input.sendKeys("Sophia123");
        DRIVER.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        tlLoginPage.login_btn.click();
        DRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        switchTronlinkAddress("TXTNcgJHD9GPfpiTbSG2VGtfdfii9VcpEr");
        DRIVER.manage().window().maximize();

        //login bttc
        js = "window.open(\"" + URL + "\")";
        DRIVER.executeScript(js);
        DRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(10000);
        String third = DRIVER.getWindowHandle();
        System.out.println("third: " + third);
        DRIVER.switchTo().window(second).close();
        Thread.sleep(10000);

        for(String tem: DRIVER.getWindowHandles()){
          third = tem;
          System.out.println("third2: " + third);
        }
        DRIVER.switchTo().window(third);
        Thread.sleep(10000);
        switchMetamask222(third);

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
    DRIVER.manage().window().setSize(new Dimension(357, 650));
    DRIVER.findElementByClassName("identicon__address-wrapper").click();
    DRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    Thread.sleep(10000);
    DRIVER.findElement(By.id("search-accounts")).sendKeys(add);
    DRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    Thread.sleep(10000);
    DRIVER.findElementByXPath("/html/body/div[1]/div/div[3]/div[4]/div[3]/button").click();
    Thread.sleep(20000);
    DRIVER.manage().window().maximize();
  }

  public void switchTronlinkAddress(String toAddress){
    WebElement ss = DRIVER.findElementByClassName("mw-130");
    DRIVER.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    if(ss == null){
      System.out.println("0000000000000");
      return;
    }else {
      System.out.println("111111111");
      System.out.println(ss.getText()+" : " + ss.isEnabled());
      ss.click();
    }
    DRIVER.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    DRIVER.findElementByXPath("/html/body/div/div/div/div/div/div[2]/div[1]/div/div[1]/div[1]/img").click(); //放大镜
    DRIVER.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    WebElement tt = DRIVER.findElementByXPath("/html/body/div/div/div/div/div/div[2]/div[1]/div/div[1]/div[1]/span/input");
    if(tt == null) {
      System.out.println("222222");
      return;
    }else {
      System.out.println("333333");
      tt.sendKeys(toAddress);
    }

    DRIVER.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    DRIVER.findElementByXPath("/html/body/div/div/div/div/div/div[2]/div[1]/div/div[1]/div[2]/div").click();
    DRIVER.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
  }

  public void switchMetamask222(String fromHandle) throws Exception{
    String metaMaskUrl = "chrome-extension://nkbihfbeogaeaoehlefnkodbefgpgknn/popup.html";
    String js = "window.open(\"" + metaMaskUrl + "\")";
    DRIVER.executeScript(js);
    DRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    for (String tem : DRIVER.getWindowHandles()) {
      if (!(fromHandle.equalsIgnoreCase(tem))) {
        DRIVER.switchTo().window(tem);
      }
    }
    DRIVER.get(metaMaskUrl);
    DRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    String to = "0x4DB7719251CE8BA74549BA35BBDC02418ECDE595";
    switchMetamaskAddress(to);
    DRIVER.manage().window().maximize();
    for(String tem: DRIVER.getWindowHandles()){
      if(!(fromHandle.equalsIgnoreCase(tem))){
        DRIVER.switchTo().window(tem).close();
      }
    }
    DRIVER.switchTo().window(fromHandle);
    DRIVER.navigate().refresh();
    Thread.sleep(20000);
  }

  public void loginTronlink(){

  }
}
