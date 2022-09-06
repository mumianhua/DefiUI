package tron.defi.bttcCase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import tron.common.utils.MyIRetryAnalyzer;
import tron.defi.base.Base;

public class CheckBalance extends  Base{



    @Test(enabled = true,retryAnalyzer = MyIRetryAnalyzer.class)
    public void test001() throws Exception{
        loginAccount();
    }

}