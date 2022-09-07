package tron.defi.bttcCase;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import tron.defi.base.Base;
import tron.defi.pages.MenuePage;
import tron.defi.pages.WalletPage;
import tron.defi.pages.StakingPage;

public class StakingTest extends Base {

  @Test(alwaysRun = true, description = "staking details have value")
  public void haveValue() throws Exception {
    MenuePage menuePage = new MenuePage(DRIVER);
    menuePage.stakingBtn.click();
    waitingTime(2);
    StakingPage stakingPage = new StakingPage(DRIVER);
    //walletPage.searchTokenInput.sendKeys(originBtt);
    //waitingTime(3);
    String totalStake = stakingPage.totalStake.getText();
    Assert.assertNotNull(totalStake);

    String totalRewards = stakingPage.totalRewards.getText();
    Assert.assertNotNull(totalRewards);

    String stakingAPY = stakingPage.stakingAPY.getText();
    Assert.assertNotNull(stakingAPY);
  }

//  @Test(alwaysRun = true, description = "select address's All Token From Tron network")
//  public void selectAllTokenFromTron() throws Exception {
//    MenuePage menuePage = new MenuePage(DRIVER);
//    menuePage.walletBtn.click();
//    waitingTime(2);
//    WalletPage walletPage = new WalletPage(DRIVER);
//    Actions builder = new Actions(DRIVER);
//    builder.moveToElement(walletPage.pickNetworkImg).perform();
//    walletPage.pickNetworkImg.click();
//    waitingTime(2);
//    walletPage.networkTron.click();
//    waitingTime(3);
//    DRIVER.executeScript("arguments[0].scrollIntoView();", walletPage.page2Token);
//    waitingTime(3);
//    walletPage.page2Token.click();
//  }

}
