package tron.defi.bttcCase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import tron.defi.base.Base;
import tron.defi.pages.ConverterPage;
import tron.defi.pages.MenuePage;

public class ConverterTest extends Base {

  @Test(alwaysRun = true, description = "test convert default token BTT_e to BTT")
  public void test01ConvertDefaultTokenWithMaxAmount() throws Exception {
    MenuePage menuePage = new MenuePage(DRIVER);
    menuePage.converterBtn.click();
    waitingTime(5);
    ConverterPage converterPage = new ConverterPage(DRIVER);
    converterPage.maxBtn.click();
    waitingTime(2);
    String toConvertBalance = converterPage.balanceToConvertInput.getText();
    String amountToConvert = converterPage.amountConvertInput.getAttribute("value");
    String amountToReceive = converterPage.amountReceiveInput.getAttribute("value");
    System.out.println("toConvertBalance: " + toConvertBalance + "  amountToConvert: "+amountToConvert +"   amountToReceive: "+amountToReceive);
    Assert.assertEquals(toConvertBalance, amountToConvert);
    Assert.assertEquals(amountToReceive, amountToConvert);
    Assert.assertTrue(converterPage.confirmBtn.isEnabled());
  }

  @Test(alwaysRun = true, description = "test convert default token BTT_e to BTT with amount bigger than balance")
  public void test02ConvertDefaultTokenWithWrongAmount() throws Exception {
    refreshPage();
    waitingTime(7);
    ConverterPage converterPage = new ConverterPage(DRIVER);
    String toConvertBalance = converterPage.balanceToConvertInput.getText();
    String amount =Double.valueOf(toConvertBalance) + 100 +"";
    converterPage.amountConvertInput.sendKeys(amount);
    waitingTime(2);
    String amountToReceive = converterPage.amountReceiveInput.getAttribute("value").replace(",","").trim();
    Assert.assertEquals(amount, amountToReceive);
    Assert.assertFalse(converterPage.confirmBtn.isEnabled());
  }


  @Test(alwaysRun = true, description = "test convert JST_t to JST_e and JST_b")
  public void test03ConvertDefaultTokenWithMaxAmount() throws Exception {
    System.out.println("11");
    refreshPage();
    waitingTime(7);
    ConverterPage converterPage = new ConverterPage(DRIVER);
    converterPage.arrowList.get(0).click();
    waitingTime(2);
//    converterPage.searchTokenInput.sendKeys(tronJst);   //can not search token with contract address
    converterPage.searchTokenInput.sendKeys("JST_t");
    waitingTime(2);
    converterPage.tokenModalList.findElements(By.className("list-item")).get(0).click();
    waitingTime(2);
    converterPage.arrowList.get(1).click();
    waitingTime(2);
    converterPage.tokenModalList.findElements(By.className("list-item")).get(0).click();
    waitingTime(2);
    Assert.assertFalse(converterPage.confirmBtn.isEnabled());
    String convertAmount = "0.1";
    converterPage.amountConvertInput.sendKeys(convertAmount);
    waitingTime(2);
    String amountToReceive = converterPage.amountReceiveInput.getAttribute("value");
    Assert.assertEquals(convertAmount, amountToReceive);
    Assert.assertTrue(converterPage.confirmBtn.isEnabled());  //convert JST_t to JST_e

    converterPage.arrowList.get(1).click();
    waitingTime(2);
    converterPage.tokenModalList.findElements(By.className("list-item")).get(1).click();  //convert JST_t to JST_b
    waitingTime(2);
    String amountToConvert = converterPage.amountConvertInput.getAttribute("value");
    amountToReceive = converterPage.amountReceiveInput.getAttribute("value");
    Assert.assertEquals(convertAmount, amountToReceive);
    Assert.assertEquals(amountToConvert, amountToReceive);
    Assert.assertTrue(converterPage.confirmBtn.isEnabled());
  }

}
