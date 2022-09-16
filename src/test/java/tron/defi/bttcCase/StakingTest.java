package tron.defi.bttcCase;

import lombok.val;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import tron.defi.base.Base;
import tron.defi.pages.MenuePage;
import tron.defi.pages.StakingPage;
import tron.defi.pages.WalletPage;

import static java.lang.Float.valueOf;

public class StakingTest extends Base {

  @Test(alwaysRun = true, description = "staking details have value")
  public void test01haveStakingValue() throws Exception {
    MenuePage menuePage = new MenuePage(DRIVER);
    menuePage.stakingBtn.click();
    waitingTime(2);
    StakingPage stakingPage = new StakingPage(DRIVER);

    String totalStakeText = stakingPage.totalStake.getText().substring(0,1);
    double totalStake = valueOf(totalStakeText);
    Assert.assertTrue(totalStake > 0);

    String totalRewardsText = stakingPage.totalRewards.getText().substring(0,1);
    double totalRewards = valueOf(totalRewardsText);
    Assert.assertTrue(totalRewards>0);

    String stakingAPYText = stakingPage.stakingAPY.getText().substring(0,1);
    double stakingAPY = valueOf(stakingAPYText);
    Assert.assertTrue(stakingAPY>0);

    String deliveryBlocksText = stakingPage.deliveryBlocks.getText().substring(0,1);
    double deliveryBlocks = valueOf(deliveryBlocksText);
    Assert.assertTrue(deliveryBlocks > 0);

    String tronCheckpointsText = stakingPage.tronCheckpoints.getText().substring(0,1);
    double tronCheckpoints = valueOf(tronCheckpointsText);
    Assert.assertTrue(tronCheckpoints > 0);

    String ethCheckpointsText = stakingPage.ethCheckpoints.getText().substring(0,1);
    double ethCheckpoints = valueOf(ethCheckpointsText);
    Assert.assertTrue(ethCheckpoints > 0);

    String bscCheckpointsText = stakingPage.bscCheckpoints.getText().substring(0,1);
    double bscCheckpoints = valueOf(bscCheckpointsText);
    Assert.assertTrue(bscCheckpoints > 0);
  }

  @Test(alwaysRun = true, description = "search by validator name and check value")
  public void test02SearchByValidator() throws Exception {
    MenuePage menuePage = new MenuePage(DRIVER);
    menuePage.stakingBtn.click();
    waitingTime(2);
    StakingPage stakingPage = new StakingPage(DRIVER);

    String allValidators = stakingPage.allValidatorTitle.getText();
    Assert.assertEquals(allValidators, "All Validators");

    stakingPage.searchValidatorInput.sendKeys("binance");
    waitingTime(1);
    String validatorName = stakingPage.validatorName.getText();
    Assert.assertEquals(validatorName, "Binance Staking");

    String validatorApyText = stakingPage.validatorApy.getText().replace("%","");
    double validatorApy = valueOf(validatorApyText);
    Assert.assertTrue(validatorApy>0);

    String validatorStakedText = stakingPage.validatorStaked.getText().substring(0,1);
    double validatorStaked = valueOf(validatorStakedText);
    Assert.assertTrue(validatorStaked > 0);

    String nodeEfficiencyText = stakingPage.nodeEfficiency.getText().replace("%","");
    double nodeEfficiency = valueOf(nodeEfficiencyText);
    Assert.assertTrue(nodeEfficiency > 0);

    String rewardRatioText = stakingPage.rewardRatio.getText().replace("%","");
    double rewardRatio = valueOf(rewardRatioText);
    Assert.assertTrue(rewardRatio > 0);

    stakingPage.deleteButton.click();

  }

  @Test(alwaysRun = true, description = "Validator Sort Button：APY，Staked，Node efficiency, Reward Ratio, clickable")
  public void test03ValidatorSortButton() throws Exception {
    MenuePage menuePage = new MenuePage(DRIVER);
    menuePage.stakingBtn.click();
    waitingTime(2);
    StakingPage stakingPage = new StakingPage(DRIVER);

    stakingPage.apyButton.click();
    String validator1Name = stakingPage.validatorName.getText();
    Assert.assertEquals(validator1Name, "Binance Staking");

    stakingPage.apyButton.click();
    validator1Name = stakingPage.validatorName.getText();
    Assert.assertEquals(validator1Name, "Smart Consensus");

    stakingPage.apyButton.click();
    validator1Name = stakingPage.validatorName.getText();
    Assert.assertEquals(validator1Name, "Binance Staking");

    stakingPage.stakedButton.click();
    String validator2Name = stakingPage.validatorName.getText();
    Assert.assertEquals(validator2Name, "Binance Staking");

    stakingPage.stakedButton.click();
    validator2Name = stakingPage.validatorName.getText();
    Assert.assertEquals(validator2Name, "Ant Investment");

    stakingPage.stakedButton.click();
    validator2Name = stakingPage.validatorName.getText();
    Assert.assertEquals(validator2Name, "Binance Staking");

    stakingPage.efficiencyButton.click();
    String validator3Name = stakingPage.validatorName.getText();
    Assert.assertEquals(validator3Name, "Binance Staking");

    stakingPage.efficiencyButton.click();
    validator3Name = stakingPage.validatorName.getText();
    Assert.assertEquals(validator3Name, "Smart Consensus");

    stakingPage.efficiencyButton.click();
    validator3Name = stakingPage.validatorName.getText();
    Assert.assertEquals(validator3Name, "Binance Staking");

    stakingPage.rewardButton.click();
    String validator4Name = stakingPage.validatorName.getText();
    Assert.assertEquals(validator4Name, "Binance Staking");

    stakingPage.rewardButton.click();
    validator4Name = stakingPage.validatorName.getText();
    Assert.assertEquals(validator4Name, "Binance Staking");

    stakingPage.rewardButton.click();
    validator4Name = stakingPage.validatorName.getText();
    Assert.assertEquals(validator4Name, "Binance Staking");


  }
  @Test(alwaysRun = true, description = "click quick stake, check the element in quick stake window")
  public void test04QuickStake1stWindow() throws Exception {
    MenuePage menuePage = new MenuePage(DRIVER);
    menuePage.stakingBtn.click();
    waitingTime(2);
    StakingPage stakingPage = new StakingPage(DRIVER);

    stakingPage.quickStakeButton.click();
//    String Title = stakingPage.Title.getText();
//    Assert.assertEquals(Title, "Quick Stake");

    String per25Button = stakingPage.per25Button.getText();
    Assert.assertEquals(per25Button, "25%");
    stakingPage.per25Button.click();

    String per50Button = stakingPage.per50Button.getText();
    Assert.assertEquals(per50Button, "50%");
    stakingPage.per50Button.click();

    String per75Button = stakingPage.per75Button.getText();
    Assert.assertEquals(per75Button, "75%");
    stakingPage.per75Button.click();

    String per100Button = stakingPage.per100Button.getText();
    Assert.assertEquals(per100Button, "100%");
    stakingPage.per100Button.click();


  }

  @Test(alwaysRun = true, description = "click quick stake, staked 100%，check the input equals the balance")
  public void test05QuickStake100percent() throws Exception {
    MenuePage menuePage = new MenuePage(DRIVER);
    menuePage.stakingBtn.click();
    waitingTime(2);
    StakingPage stakingPage = new StakingPage(DRIVER);

    stakingPage.quickStakeButton.click();

    String getBalance = stakingPage.getBalance.getText().replace(" BTT","");
    stakingPage.per100Button.click();
    String inputAmount = stakingPage.inputAmount.getAttribute("value");
    Assert.assertEquals(getBalance, inputAmount);
    stakingPage.windowClose.click();


  }

  @Test(alwaysRun = true, description = "click quick stake, staked 100%，click next, check the stakedAmount in the 2nd window")
  public void test06QuickStake2ndWindowStakedAmount() throws Exception {
    MenuePage menuePage = new MenuePage(DRIVER);
    menuePage.stakingBtn.click();
    waitingTime(2);
    StakingPage stakingPage = new StakingPage(DRIVER);

    stakingPage.quickStakeButton.click();
    stakingPage.per100Button.click();
    String inputAmount = stakingPage.inputAmount.getAttribute("value");
    stakingPage.nextButton.click();
    waitingTime(2);
    String stakedAmount = stakingPage.stakedAmount.getText().replace(" BTT","");
    Assert.assertEquals(stakedAmount, inputAmount);
    stakingPage.windowClose.click();

  }

  @Test(alwaysRun = true, description = "click quick stake, input value, click next, click return button in the 2nd window")
  public void test07QuickStakeBackin2ndWindow() throws Exception {
    MenuePage menuePage = new MenuePage(DRIVER);
    menuePage.stakingBtn.click();
    waitingTime(2);
    StakingPage stakingPage = new StakingPage(DRIVER);

    stakingPage.quickStakeButton.click();
    stakingPage.inputAmount.sendKeys("1");
    stakingPage.nextButton.click();
    waitingTime(2);
    String noteWord = stakingPage.noteWord.getText();
    Assert.assertEquals(noteWord, "You will stake to the validator below");
    stakingPage.backButton.click();
    String per100Button = stakingPage.per100Button.getText();
    Assert.assertEquals(per100Button, "100%");
    stakingPage.windowClose.click();

  }
  @Test(alwaysRun = true, description = "click quick stake, input value, click next, choose validator window，search validator")
  public void test08QuickStakeChooseValidator() throws Exception {
    MenuePage menuePage = new MenuePage(DRIVER);
    menuePage.stakingBtn.click();
    waitingTime(2);
    StakingPage stakingPage = new StakingPage(DRIVER);

    stakingPage.quickStakeButton.click();
    stakingPage.inputAmount.sendKeys("1");
    stakingPage.nextButton.click();
    waitingTime(2);
    stakingPage.chooseValidator.click();
    stakingPage.searchValidator.sendKeys("smart");
    String validator = stakingPage.validator.getText();
    Assert.assertEquals(validator, "Smart Consensus");
    stakingPage.selectValidator.click();

    String newValidator = stakingPage.newValidator.getText();
    Assert.assertEquals(newValidator, "Smart Consensus");

  }
}
