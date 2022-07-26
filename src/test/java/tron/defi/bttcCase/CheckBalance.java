package tron.defi.bttcCase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tron.common.utils.MyIRetryAnalyzer;
import tron.defi.base.Base;

public class CheckBalance extends  Base{

    @BeforeClass
    public void before() throws Exception{
        setUpChromeDriver();
//        loginAccount();
    }

    @Test(enabled = true,retryAnalyzer = MyIRetryAnalyzer.class)
    public void test001() throws Exception{
        loginAccount();
    }


    @AfterClass(enabled = true)
    public void after() throws Exception {
        logoutAccount();
    }
}