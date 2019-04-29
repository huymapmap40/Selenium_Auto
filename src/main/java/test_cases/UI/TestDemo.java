package test_cases.UI;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import page_objects.SeleniumEasyPage;
import test_cases.TestSetup;
import utilities.Constant;

public class TestDemo extends TestSetup {

    private String mesageText = "hello world";

    @Test
    public void TCDEMO() {
        System.out.println("Demo test case run");
        TestDemo.setupTest(Constant.urlPage);
        SeleniumEasyPage seleniumEasyPage = SeleniumEasyPage.getInstance();

        seleniumEasyPage.inputMessageToField(mesageText);
        seleniumEasyPage.clickShowMessage();
        String messString = seleniumEasyPage.getMessageShow();

        // VP: Message is matched with input message
        assertEquals(messString, mesageText);

        TestDemo.cleanUpTest();
    }
}
