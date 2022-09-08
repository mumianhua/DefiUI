package tron.defi.bttcCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import tron.defi.base.Base;
import tron.defi.pages.BridgePage;
import tron.defi.pages.HomePage;
import tron.defi.pages.MenuePage;
import tron.defi.pages.WalletPage;

public class BridgeTest extends Base {

  @Test(alwaysRun = true, description = "test deposit time from tron")
  public void test01TronDepositArrivingTime() throws Exception {
    MenuePage menuePage = new MenuePage(DRIVER);
    menuePage.bridgeBtn.click();
    waitingTime(2);
    BridgePage bridgePage = new BridgePage(DRIVER);
    int time = getArrivingTime(bridgePage.arrivingTime.getText());
    Assert.assertTrue(time < 10);
  }

  @Test(alwaysRun = true, description = "test withdraw arriving time,from bttc to tron,eth,bsc")
  public void test02WithdrawArrivingTime() throws Exception {
    BridgePage bridgePage = new BridgePage(DRIVER);
    bridgePage.fromNetworkSpan.click();
    waitingTime(1);
    bridgePage.getFromNetworkDiv(1).click();
    waitingTime(3);
    bridgePage.toNetworkSpan.click();
    waitingTime(3);
    bridgePage.toNetworkList.get(5).click();
    waitingTime(2);
    int time = getArrivingTime(bridgePage.arrivingTime.getText());
    Assert.assertTrue(time < 60);
    waitingTime(1);

    bridgePage.toNetworkSpan.click();
    waitingTime(3);
    bridgePage.toNetworkList.get(6).click();
    waitingTime(2);
    time = getArrivingTime(bridgePage.arrivingTime.getText());
    Assert.assertTrue(time < 60);
    waitingTime(1);

    bridgePage.toNetworkSpan.click();
    waitingTime(3);
    bridgePage.toNetworkList.get(7).click();
    waitingTime(2);
    time = getArrivingTime(bridgePage.arrivingTime.getText());
    Assert.assertTrue(time < 60);
  }

  @Test(alwaysRun = true, description = "test deposit nft from tron")
  public void test03DepositNftFromTron() throws Exception {
    BridgePage bridgePage = new BridgePage(DRIVER);
    bridgePage.fromNetworkSpan.click();
    waitingTime(1);
    bridgePage.getFromNetworkDiv(2).click(); //from tron
    waitingTime(3);
    bridgePage.toNetworkSpan.click();
    waitingTime(1);
    bridgePage.toNetworkList.get(4).click();
    waitingTime(2);
    Assert.assertFalse(bridgePage.crossChainBtn.isEnabled());
    bridgePage.tokenShow.click();
    waitingTime(1);
    bridgePage.searchTokenInput.sendKeys(tronNft);
    waitingTime(1);
    bridgePage.searchTokenResult.click();
    waitingTime(1);
    bridgePage.maxAmountBtn.click();
    Assert.assertTrue(bridgePage.crossChainBtn.isEnabled());
  }

}
