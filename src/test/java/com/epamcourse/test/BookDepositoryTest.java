package com.epamcourse.test;

import com.epamcourse.Utilities;
import com.epamcourse.pageobject.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;

public class BookDepositoryTest  extends BaseTest {

    @Test
    public void ResultBooksTest()  {
        SearchBookPage searchBookPage = new SearchBookPage(driver);
        int lowerBound = 3;

        searchBookPage.searchProduct("Thinking in Java");
        int actualNumber = searchBookPage.getResultProduct();

        Assert.assertTrue(actualNumber >= lowerBound,
                "The number " + actualNumber + " is  less " + lowerBound);
    }


    @Test
    public void applyKindleFilterTest(){
        SearchBookPage searchBookPage = new SearchBookPage(driver);

        searchBookPage.searchProduct("Thinking in Java");
        searchBookPage.applykindleEditionFilter();
        int actualNumber = searchBookPage.getResultProduct();
        int currentNumberProductType = searchBookPage.getBookWithType("Kindle");

        Assert.assertTrue(Math.abs(actualNumber - currentNumberProductType) <= 5);

    }

    @Test
    public void applyPaperbackFilterTest(){
        SearchBookPage searchBookPage = new SearchBookPage(driver);

        searchBookPage.searchProduct("Thinking in Java");
        searchBookPage.applyPaperBackFilter();
        int actualNumber = searchBookPage.getResultProduct();
        int currentNumberProductType = searchBookPage.getBookWithType("Paperback");

        Assert.assertEquals(actualNumber,currentNumberProductType);

    }

    @Test
    public void checkoutTest() throws InterruptedException {
        SearchBookPage searchBookPage = new SearchBookPage(driver);
        DetailsProductPage detailsProductPage = new DetailsProductPage(driver);
        PreviewCheckoutPage  previewCheckoutPage = new PreviewCheckoutPage(driver);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        SingInPage singInPage = new SingInPage(driver);

        int actualnumberBooks = Utilities.generateRandomNumber(2,5);

        searchBookPage.searchProduct("Sthepen king");
        searchBookPage.applyPaperBackFilter();
        searchBookPage.selectProductByPosition(1);
        detailsProductPage.addProductCart();
        searchBookPage.searchProduct("Sthepen king");
        searchBookPage.applyPaperBackFilter();
        searchBookPage.selectProductByPosition(2);
        detailsProductPage.addProductCart();
        previewCheckoutPage.goToCart();
        int actualItemslist = shoppingCartPage.itemsCartList();
        int actualSubtotalItems = shoppingCartPage.getItemCount();
        Assert.assertEquals(actualItemslist,2);
        Assert.assertEquals(actualSubtotalItems,2);

        shoppingCartPage.addNumberItems(actualnumberBooks,0);
        shoppingCartPage.addNumberItems(actualnumberBooks,1);

        actualSubtotalItems = shoppingCartPage.getItemCount();

        Assert.assertEquals(actualSubtotalItems,actualnumberBooks *2);

        shoppingCartPage.deleteItem(0);

        actualSubtotalItems = shoppingCartPage.getItemCount();

        Assert.assertEquals(actualSubtotalItems,actualnumberBooks);
        
        shoppingCartPage.proceedCheckout();


        Assert.assertTrue(singInPage.emailFieldIspresent());
        String actualUrl = driver.getCurrentUrl();
        System.out.println(actualUrl);
        Assert.assertTrue(Objects.requireNonNull(actualUrl).contains("signin"));






    }

}
