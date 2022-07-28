package tron.defi.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import tron.defi.pages.MetaMaskLoginPage;
import tron.common.utils.Configuration;
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



    public void setUpChromeDriver()throws Exception {
//      killChromePid();
      System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver103");
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--user-data-dir=/Users/sophiawang/Library/Application Support/Google/Chrome/");
//      options.addArguments ("load-extension=/Users/sophiawang/Library/Application Support/Google/Chrome/Default/Extensions/ibnejdfjmmkpcnlpebklmnkoeoihofec/3.26.8_1");
//      options.addArguments ("load-extension=/Users/sophiawang/Library/Application Support/Google/Chrome/Default/Extensions/");
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
        DRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MetaMaskLoginPage metaMaskloginPage = new MetaMaskLoginPage(DRIVER);
        metaMaskloginPage.password_input.sendKeys("Sophia123");
        DRIVER.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        metaMaskloginPage.login_btn.click();
        DRIVER.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String first = DRIVER.getWindowHandle();
        System.out.println("first: " + first);

        //login tronlink
        String tronlinkUrl = "chrome-extension://ibnejdfjmmkpcnlpebklmnkoeoihofec/packages/popup/build/index.html";
        String js = "window.open(\"" + tronlinkUrl + "\")";
        DRIVER.executeScript(js);
        DRIVER.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        String second = DRIVER.getWindowHandle();
        System.out.println("second: "+second);
        DRIVER.switchTo().window(first).close();

        for(String tem: DRIVER.getWindowHandles()){
          second = tem;
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

        String add = "TH48niZfbwHMyqZwEB8wmHfzcvR8ZzJKC6";
        switchTronlinkAddress(add);

        //login bttc
        js = "window.open(\"" + URL + "\")";
        DRIVER.executeScript(js);
        DRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(30000);

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
    if(tt == null){
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

}
