package com.epamcourse.pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class SearchBookPage  extends  BasePage{

    @FindBy(name = "field-keywords")
    WebElement searchInput;

    @FindBy(id = "nav-search-submit-button")
    WebElement searchButton;

    private final By searchResultlist = By.xpath("//div[@data-component-type='s-search-result']");


    @FindBy(xpath = "//span[text()='Hardcover']")
    WebElement hardcoverfilter;

    @FindBy(xpath = "//span[text()='Kindle Edition']")
    WebElement kindleEditionFilter;

    @FindBy(xpath = "//span[text()='Paperback']")
    WebElement paperBackFilter;




    @FindBy(id = "//a[@id='nav-cart']")
    WebElement cartButton;

    public SearchBookPage(WebDriver driver) {
        super(driver);
    }

    public void  searchProduct(String product){
        searchInput.sendKeys(product);
        searchButton.click();
    }

    public  int  getResultProduct(){
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(searchResultlist,3));
        List<WebElement>  resultSearch = driver.findElements(searchResultlist);
        return  resultSearch.size();
    }



    public void selectProductByPosition(int positionList) {

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(searchResultlist, 3));

        List<WebElement> resultSearch = driver.findElements(searchResultlist);

        if (positionList >= 0 && positionList < resultSearch.size()) {

            WebElement product = resultSearch.get(positionList -1);
            product.findElement(By.xpath(".//div[@data-cy='title-recipe']")).click();
        } else {
            throw new IndexOutOfBoundsException("the position " + positionList + " is outside of  the range");
        }
    }

    public void applyHardcoverFilter(){
        hardcoverfilter.click();
    }

    public  void applykindleEditionFilter(){
        kindleEditionFilter.click();

    }

    public  void applyPaperBackFilter(){
        paperBackFilter.click();

    }

    public String GetTitleFirstProduct(){
        List<WebElement>  resultSearch = driver.findElements(searchResultlist);
        return resultSearch.get(0).findElement(By.xpath("//div[@data-cy='title-recipe']//h2")).getText();

    }

    public int getBookWithType(String typeBook) {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(searchResultlist, 3));
        List<WebElement> resultSearch = driver.findElements(searchResultlist);

        long count = resultSearch.stream()
                .filter(element -> {
                    try {
                        return !element.findElements(By.xpath(".//a[contains(text(),'" + typeBook + "')]")).isEmpty();
                    } catch (NoSuchElementException | StaleElementReferenceException e) {
                        return false;
                    }
                })
                .count();

        return (int) count;
    }

    public void goCart(){
        cartButton.click();
    }
}
