package page_objects;

import org.openqa.selenium.By;
import wrappers.BrowserWrapper;
import wrappers.ElementWrapper;

public class GoBearPage {

    private static GoBearPage instance;

    //Locators
    protected ElementWrapper tabInsurance = new ElementWrapper(By.xpath("//ul[@class='nav nav-tabs nav-justified']//li[@data-gb-name='Insurance']"));
    protected ElementWrapper tabTravel = new ElementWrapper(By.xpath("//ul[@class='subnav-tabs nav nav-tabs nav-justified']//li[@data-gb-name='Travel']"));
    protected ElementWrapper btnShowResults = new ElementWrapper(By.xpath("//button[@name='product-form-submit']"));


    public static GoBearPage getInstance() {
        if(instance == null){
            instance = new GoBearPage();
        }
        return instance;
    }

    public void chooseInsuranceTab() {
        tabInsurance.waitForVisibilityOf();
        tabInsurance.click();
    }

    public void chooseTravelTab() {
        tabTravel.waitForVisibilityOf();
        tabTravel.click();
    }

    public InsuranceResultsPage showMyResults() {
        btnShowResults.waitForVisibilityOf();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        BrowserWrapper.executeScript("return document.getElementsByName('product-form-submit')[0].click()");
//        btnShowResults.click();
        return InsuranceResultsPage.getInstance();
    }
}
