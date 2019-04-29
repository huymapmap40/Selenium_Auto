package page_objects;

import org.openqa.selenium.By;
import wrappers.ElementWrapper;

public class InsuranceResultsPage  {

    private static InsuranceResultsPage instance;

    //Locators
    protected ElementWrapper parentResultItem = new ElementWrapper(By.xpath("//div[@id='travel-quote-list']//div[@class='grid-row']/div"));
    protected ElementWrapper txtBrandNames = new ElementWrapper(By.xpath("//div[@class='card-brand']/h4[@class='name']"));
    protected ElementWrapper txtFilter = new ElementWrapper(By.xpath("//h5[@id='collapseFilterBtn']/text()/ancestor::div[@data-gb-name='filter-bar']"));
    protected ElementWrapper txtSort = new ElementWrapper(By.xpath("//h5[@id='headingTwo']/text()/ancestor::div[@class='sort-detail sidebar-item']"));
    protected ElementWrapper txtDetails = new ElementWrapper(By.xpath("//h5[@id='detailsHeading']/text()/ancestor::div[@class='edit-detail sidebar-item']"));
    protected ElementWrapper rdPromosOnly = new ElementWrapper(By.xpath("//div[@class='radio radio-primary']//label[@for='gb_radio_18']"));
    protected ElementWrapper drpDestination = new ElementWrapper(By.xpath("//div[@class='field field-select']"));
    protected ElementWrapper inptStartDate = new ElementWrapper(By.xpath("//input[@name='dates-startdate']"));

    //Dynamic controls
    protected  ElementWrapper childResultItem(int orderItem) {
        return new ElementWrapper(By.xpath("//div[@id='travel-quote-list']//div[@class='grid-row']/div" + "[" + orderItem + "]"));
    }

    protected ElementWrapper optInsurers(String insurersName) {
        return new ElementWrapper(By.xpath("//div[@data-filter-name='"+ insurersName +"']/label"));
    }

    protected  ElementWrapper txtCardBrandName(String brandName, int order) {
        return new ElementWrapper(By.xpath("//div[@data-insuer-name='"+brandName+"'][@data-position='"+order+"']//div[@class='card-brand']/h4[@class='name']"));
    }

    protected  ElementWrapper itemDestinationSelect(String name) {
        return new ElementWrapper(By.xpath("//div[@class='field field-select']//li//span[text()='"+name+"']"));
    }

    protected  ElementWrapper dateSelect(int dateNumber) {
        return new ElementWrapper(By.xpath("//div[@class='datepicker-days']//tbody//tr/td[@class='day' and text()='"+dateNumber+"']"));
    }

    protected  ElementWrapper optSort(String optionName) {
        return new ElementWrapper(By.xpath("//div[@data-gb-name='sort-option']/label[contains(text(),'"+optionName+"')]"));
    }

    public static InsuranceResultsPage getInstance() {
        if(instance == null) {
            instance = new InsuranceResultsPage();
        }
        return instance;
    }

    public boolean isItemResultDisplayed() {
        boolean isItemResultDisplayed = false;
        int numberOfItemResult = parentResultItem.getElementCount();
        if(numberOfItemResult > 3) {
            for(int i=0; i<3; i++) {
                if(!childResultItem(i+1).isElementDisplayed()){
                    System.out.println("Item at index" + (i+1) + "is not displayed");
                    return false;
                }
            }
            isItemResultDisplayed = true;
        }
        return isItemResultDisplayed;
    }

    public void chooseInsurer(String insurerName) {
        optInsurers(insurerName).click();
    }

    public boolean isFilterSectionDisplayed() {
        return txtFilter.isElementDisplayed();
    }

    public boolean isSortSectionDisplayed() {
        return txtSort.isElementDisplayed();
    }

    public boolean isDetailSectionDisplayed() {
        return txtDetails.isElementDisplayed();
    }

    public String getExistCardBrandName(String insurerName) {
        String cardBrandName = "";
        if(txtBrandNames.getElementCount()>0) {
            int cardOrder = 1;
            cardBrandName = txtCardBrandName(insurerName, cardOrder).getText();
        }
        return cardBrandName;
    }

    public void selectSortOption(String optionName) {
        optSort(optionName).click();
    }

    public void selectDestination(String nameDestination) {
        drpDestination.click();
        itemDestinationSelect(nameDestination).moveMouseAndClick();
    }

    public void selectDate(int date){
        inptStartDate.click();
        dateSelect(date).click();
    }
}
