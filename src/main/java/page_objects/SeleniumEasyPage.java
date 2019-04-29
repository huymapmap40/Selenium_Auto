package page_objects;

import org.openqa.selenium.By;
import wrappers.ElementWrapper;

public class SeleniumEasyPage {

    private static SeleniumEasyPage instance;

    //Locators
    protected ElementWrapper inputUserMessage = new ElementWrapper(By.xpath("//input[@id='user-message']"));
    protected ElementWrapper btnShowMessage = new ElementWrapper(By.xpath("//form[@id='get-input']//button[@class='btn btn-default']"));
    protected ElementWrapper txtMessage = new ElementWrapper(By.xpath("//div[@id='user-message']/span[@id='display']"));

    public static SeleniumEasyPage getInstance() {
        if(instance == null){
            instance = new SeleniumEasyPage();
        }
        return instance;
    }

    public void inputMessageToField(String message) {
        inputUserMessage.type(message);
    }

    public void clickShowMessage() {
        btnShowMessage.click();
    }

    public String getMessageShow() {
        return txtMessage.getText();
    }
}
