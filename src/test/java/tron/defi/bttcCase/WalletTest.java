package tron.defi.bttcCase;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import tron.defi.base.Base;
import tron.defi.pages.MenuePage;
import tron.defi.pages.WalletPage;

public class WalletTest extends Base {

  @Test(alwaysRun = true, description = "search bttc origin btt and, check balance,value and network")
  public void test01SearchOriginBttByAddress() throws Exception {
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
  public void test02SelectAllTokenFromTron() throws Exception {
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

  @Test(alwaysRun = true, description = "select address's All Token From Tron network and open Hide zero balances switch")
  public void test03SelectAllTokenFromTronExclude0Balance() throws Exception {
    refreshPage();
    waitingTime(7);
    WalletPage walletPage = new WalletPage(DRIVER);
    Actions builder = new Actions(DRIVER);
    builder.moveToElement(walletPage.pickNetworkImg).perform();
    walletPage.pickNetworkImg.click();
    walletPage.pickNetworkImg.click();
    waitingTime(1);
    walletPage.networkTron.click();
    waitingTime(3);
    walletPage.closeZeroSwitch.click();
    waitingTime(2);
    Assert.assertEquals(walletPage.tokenList.size(), 3);
  }

  @Test(alwaysRun = true, description = "select token by name")
  public void test04SelectTokenByName() throws Exception {
    refreshPage();
    waitingTime(7);
    MenuePage menuePage = new MenuePage(DRIVER);
    menuePage.walletBtn.click();
    waitingTime(2);
    WalletPage walletPage = new WalletPage(DRIVER);
    walletPage.searchTokenInput.sendKeys("BTT");
    waitingTime(3);
    Assert.assertEquals(walletPage.tokenList.size(), 3);

    String btteMappedNetwork = walletPage.getTokenNetwork(3).getText();
    Assert.assertEquals(btteMappedNetwork, "Ethereum");
    String btteBalance = walletPage.getTokenBalance(3).getText();
    Assert.assertEquals(btteBalance, "0.879999");
    String btteUsdValue = walletPage.getTokenUsdValue(3).getText();
    Assert.assertEquals(btteUsdValue, "< $ 0.01");

    String bttcMappedNetwork = walletPage.getTokenNetwork(4).getText();
    Assert.assertEquals(bttcMappedNetwork, "BSC");
    String bttcBalance = walletPage.getTokenBalance(4).getText();
    Assert.assertEquals(bttcBalance, "0.80111");
    String bttcUsdValue = walletPage.getTokenUsdValue(4).getText();
    Assert.assertEquals(bttcUsdValue, "< $ 0.01");
  }

  @Test(alwaysRun = true, description = "select address's All Token From eth network and open Hide zero balances switch")
  public void test05SelectAllTokenFromEthExclude0Balance() throws Exception {
    refreshPage();
    waitingTime(7);
    WalletPage walletPage = new WalletPage(DRIVER);
    Actions builder = new Actions(DRIVER);
    builder.moveToElement(walletPage.pickNetworkImg).perform();
    walletPage.pickNetworkImg.click();
    walletPage.pickNetworkImg.click();
    waitingTime(1);
    walletPage.networkEth.click();
    waitingTime(3);
    walletPage.closeZeroSwitch.click();
    waitingTime(2);
    Assert.assertEquals(walletPage.tokenList.size(), 3);
  }

  @Test(alwaysRun = true, description = "select address's All Token From bsc network and open Hide zero balances switch")
  public void test06SelectAllTokenFromBscExclude0Balance() throws Exception {
    refreshPage();
    waitingTime(7);
    WalletPage walletPage = new WalletPage(DRIVER);
    Actions builder = new Actions(DRIVER);
    builder.moveToElement(walletPage.pickNetworkImg).perform();
    walletPage.pickNetworkImg.click();
    walletPage.pickNetworkImg.click();
    waitingTime(1);
    walletPage.networkBsc.click();
    waitingTime(3);
    walletPage.closeZeroSwitch.click();
    waitingTime(2);
    Assert.assertEquals(walletPage.tokenList.size(), 3);
  }

  @Test(alwaysRun = true, description = "test total value on bttc")
  public void test07GetTotalValueOnBttc() {
    WalletPage walletPage = new WalletPage(DRIVER);
    String balanceText = walletPage.totalValueOnBttc.getText().substring(1);
    double balance = Float.valueOf(balanceText);
    Assert.assertTrue(balance > 0 && balance<1);
  }

  @Test(alwaysRun = true, description = "select address's All none zero token")
  public void test08SelectAllNoneZeroToken() throws Exception {
    refreshPage();
    waitingTime(7);
    WalletPage walletPage = new WalletPage(DRIVER);
    walletPage.closeZeroSwitch.click();
    waitingTime(2);
    Assert.assertEquals(walletPage.tokenList.size(), 9);
  }

  @Test(alwaysRun = true, description = "sort None Zero Token By Name In TronNetwork")
  public void test09SortNoneZeroTokenByNameInTronNetwork() throws Exception {
    refreshPage();
    waitingTime(7);
    WalletPage walletPage = new WalletPage(DRIVER);
    Actions builder = new Actions(DRIVER);
    builder.moveToElement(walletPage.pickNetworkImg).perform();
    walletPage.pickNetworkImg.click();
    walletPage.pickNetworkImg.click();
    waitingTime(1);
    walletPage.networkTron.click();
    waitingTime(3);
    walletPage.closeZeroSwitch.click();
    waitingTime(2);
    Assert.assertEquals(walletPage.tokenList.size(), 3);

    walletPage.nameSort.click();  //sort by name down
    waitingTime(2);
    Assert.assertEquals(walletPage.tokenSymbol.get(0).getText(),"TRX");
    Assert.assertEquals(walletPage.tokenSymbol.get(1).getText(),"JST_t");
    Assert.assertEquals(walletPage.tokenSymbol.get(2).getText(),"BTT");

    walletPage.nameSort.click();  //sort by name up
    waitingTime(2);
    Assert.assertEquals(walletPage.tokenSymbol.get(2).getText(),"TRX");
    Assert.assertEquals(walletPage.tokenSymbol.get(1).getText(),"JST_t");
    Assert.assertEquals(walletPage.tokenSymbol.get(0).getText(),"BTT");

    walletPage.nameSort.click();  //sort by default name
    waitingTime(2);
    Assert.assertEquals(walletPage.tokenSymbol.get(0).getText(),"TRX");
    Assert.assertEquals(walletPage.tokenSymbol.get(1).getText(),"JST_t");
    Assert.assertEquals(walletPage.tokenSymbol.get(2).getText(),"BTT");
  }

  @Test(alwaysRun = true, description = "sort None Zero Token By balance In TronNetwork")
  public void test10SortNoneZeroTokenByBalanceInTronNetwork() throws Exception {
    refreshPage();
    waitingTime(7);
    WalletPage walletPage = new WalletPage(DRIVER);
    Actions builder = new Actions(DRIVER);
    builder.moveToElement(walletPage.pickNetworkImg).perform();
    walletPage.pickNetworkImg.click();
    walletPage.pickNetworkImg.click();
    waitingTime(1);
    walletPage.networkTron.click();
    waitingTime(3);
    walletPage.closeZeroSwitch.click();
    waitingTime(2);
    Assert.assertEquals(walletPage.tokenList.size(), 3);

    walletPage.balanceSort.click();  //sort by balance down
    waitingTime(2);
    Assert.assertEquals(walletPage.tokenSymbol.get(0).getText(),"BTT");
    Assert.assertEquals(walletPage.tokenSymbol.get(1).getText(),"TRX");
    Assert.assertEquals(walletPage.tokenSymbol.get(2).getText(),"JST_t");

    walletPage.balanceSort.click();  //sort by balance up
    waitingTime(2);
    Assert.assertEquals(walletPage.tokenSymbol.get(2).getText(),"BTT");
    Assert.assertEquals(walletPage.tokenSymbol.get(1).getText(),"TRX");
    Assert.assertEquals(walletPage.tokenSymbol.get(0).getText(),"JST_t");

    walletPage.balanceSort.click();  //sort by default balance
    waitingTime(2);
    Assert.assertEquals(walletPage.tokenSymbol.get(0).getText(),"TRX");
    Assert.assertEquals(walletPage.tokenSymbol.get(1).getText(),"JST_t");
    Assert.assertEquals(walletPage.tokenSymbol.get(2).getText(),"BTT");
  }

}
