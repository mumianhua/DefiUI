package tron.defi.bttcCase;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tron.defi.base.Base;
import tron.defi.pages.MenuePage;
import tron.defi.pages.WalletPage;

public class WalletTest extends Base {
//  MenuePage menuePage;
//  WalletPage walletPage;
//
//  @BeforeClass
//  public void before() throws Exception {
//    menuePage = new MenuePage(DRIVER);
//    walletPage = new WalletPage(DRIVER);
//  }


  @Test(alwaysRun = true, description = "search bttc origin btt and, check balance,value and network")
  public void searchBtt() throws Exception {
    MenuePage menuePage = new MenuePage(DRIVER);
    menuePage.walletBtn.click();
    waitingTime(2);
    WalletPage walletPage = new WalletPage(DRIVER);
    walletPage.searchTokenInput.sendKeys(originBtt);
    waitingTime(3);
    String balance = walletPage.bttBalance.getText();
    Assert.assertEquals(balance, "547.398934");

    String bttUsdValue = walletPage.bttUsdValue.getText();
    Assert.assertEquals(bttUsdValue, "< $ 0.01");

    String bttMappedNetwork = walletPage.bttMappedNetwork.getText();
    Assert.assertEquals(bttMappedNetwork, "TRON");
  }

  @Test(alwaysRun = true, description = "select address's All Token From Tron network")
  public void selectAllTokenFromTron() throws Exception {
    WalletPage walletPage = new WalletPage(DRIVER);
    Actions builder = new Actions(DRIVER);
    builder.moveToElement(walletPage.pickNetworkImg).perform();
    walletPage.pickNetworkImg.click();
    waitingTime(2);
    walletPage.networkTron.click();
    waitingTime(3);
    DRIVER.executeScript("arguments[0].scrollIntoView();", walletPage.page2Token);
    waitingTime(3);
    walletPage.page2Token.click();
  }

}
