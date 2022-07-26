package tron.defi.base;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import tron.defi.pages.MetaMaskLoginPage;
import tron.common.utils.Configuration;

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

    public boolean loginAccount() throws Exception{
      while (retryLoginTimes > 0) {
        try {
          retryLoginTimes--;
          //login tronlink
          /*String tronlinkUrl = "chrome-extension://ibnejdfjmmkpcnlpebklmnkoeoihofec/packages/popup/build/index.html";
          DRIVER.get(tronlinkUrl);
          DRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

          LoginPage loginPage = new LoginPage(DRIVER);
          loginPage.password_input.sendKeys("Sophia123");
          DRIVER.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
          loginPage.login_btn.click();

          DRIVER.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
          System.out.println("old: "+DRIVER.getTitle());

          String oldtab = DRIVER.getWindowHandle();
          Thread.sleep(10000);*/

          //login metaFox
          String metaMaskUrl = "chrome-extension://nkbihfbeogaeaoehlefnkodbefgpgknn/popup.html";
//          String js = "window.open(\"" + metaMaskUrl + "\")";
//          DRIVER.executeScript(js);
          DRIVER.get(metaMaskUrl);
          DRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//          WebElement reloadButton = DRIVER.findElementByXPath("/html/body/div[1]/div[2]/div/button[1]");
//          if(reloadButton != null){
//            System.out.println("11111111111111");
//            reloadButton.click();
//          }
//          Thread.sleep(100000);
//          DRIVER.navigate().refresh();
//          DRIVER.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
//
//          DRIVER.navigate().refresh();

          DRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

          MetaMaskLoginPage metaMaskloginPage = new MetaMaskLoginPage(DRIVER);
          metaMaskloginPage.password_input.sendKeys("Sophia123");
          DRIVER.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
          metaMaskloginPage.login_btn.click();

          DRIVER.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
          System.out.println("old: "+DRIVER.getTitle());

          DRIVER.getWindowHandle();
          Thread.sleep(10000);

          //login bttc
          String js = "window.open(\"" + URL + "\")";
          DRIVER.executeScript(js);
//          DRIVER.get(URL);
          DRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
          Thread.sleep(60000);

//          DRIVER.findElementByTagName("body").sendKeys(Keys.CONTROL + "t");
//          DRIVER.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//          DRIVER.findElementByXPath("/html/body/div/div/section/header/section/div/section[2]/section/section[2]").click();
//          DRIVER.findElementByXPath("/html/body/div[2]/div/div[2]/div/div[2]/div/section/section/div[2]/div[2]/div").click();
//          Thread.sleep(60000);

//          DRIVER.quit();
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


    public double getBalanceFromSelectionBtn(String string) {
      System.out.println("string:" + string);
      int left = string.indexOf('(');
      int right = string.indexOf(')');
      return Double.valueOf(string.substring(left+1,right));
    }

    public  static void killChromePid() throws IOException {
      Runtime.getRuntime().exec("sh kill_chrome.sh");
    }

  public boolean elementIsExist(By locator) {
    try {
      DRIVER.findElement(locator);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
