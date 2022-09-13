package tron.defi.bttcCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import tron.defi.base.Base;
import tron.defi.pages.HomePage;
import tron.defi.pages.MenuePage;
import tron.defi.pages.WalletPage;

public class HomeTest extends Base {

  @Test(alwaysRun = true, description = "test wallet value on home page is equal with wallet value on wallet value")
  public void test01WalletValue() throws Exception {
    MenuePage menuePage = new MenuePage(DRIVER);
    menuePage.homeBtn.click();
    waitingTime(2);
    HomePage homePage = new HomePage(DRIVER);
    String homeWalletValue = homePage.walletValueSpan.getText();
    menuePage.walletBtn.click();
    waitingTime(3);
    WalletPage walletPage = new WalletPage(DRIVER);
    String walletWalletBalance = walletPage.totalValueOnBttc.getText();
    Assert.assertEquals(homeWalletValue, walletWalletBalance);
  }

  @Test(alwaysRun = true, description = "test account's staking value")
  public void test02AccountStakingValue() throws Exception {
    MenuePage menuePage = new MenuePage(DRIVER);
    menuePage.homeBtn.click();
    waitingTime(2);
    HomePage homePage = new HomePage(DRIVER);
    String homeStakingValue = homePage.stakingValueSpan.getText().substring(1);
    Double value = Double.valueOf(homeStakingValue);
    Assert.assertTrue(value == 0);
  }



}
