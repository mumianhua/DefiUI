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

}
