package tron.defi.base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import tron.defi.pages.MetaMaskLoginPage;
import tron.common.utils.Configuration;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Base {

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
        String metaMaskUrl = "chrome-extension://nkbihfbeogaeaoehlefnkodbefgpgknn/popup.html";
        DRIVER.get(metaMaskUrl);
        DRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MetaMaskLoginPage metaMaskloginPage = new MetaMaskLoginPage(DRIVER);
        metaMaskloginPage.password_input.sendKeys("Sophia123");
        DRIVER.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        metaMaskloginPage.login_btn.click();
        DRIVER.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        DRIVER.getWindowHandle();
        Thread.sleep(10000);

        //login bttc
        String js = "window.open(\"" + URL + "\")";
        DRIVER.executeScript(js);
        DRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(60000);

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

}
