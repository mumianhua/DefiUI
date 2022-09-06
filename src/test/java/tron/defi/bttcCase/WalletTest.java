package tron.defi.bttcCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import tron.defi.base.Base;
import tron.defi.pages.MenuePage;
import tron.defi.pages.WalletPage;

public class WalletTest extends Base {

  @Test(alwaysRun = true)
  public void searchBtt()  throws Exception {
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
}
