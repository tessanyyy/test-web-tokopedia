package com.juaracoding.selenium.pageobject;

import com.juaracoding.selenium.pageobject.drivers.DriverSingleton;
import com.juaracoding.selenium.pageobject.pages.Tokopedia;
import com.juaracoding.selenium.pageobject.utils.Constants;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestTokopedia {

    public static WebDriver driver;

    private Tokopedia tokopedia;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance(Constants.CHROME);
        driver = DriverSingleton.getDriver();
        driver.get(Constants.URL);
    }

    @BeforeMethod
    public void pageObject(){
        tokopedia = new Tokopedia();
    }

    @AfterClass
    public void closeBrowser(){
        delay(3);
        DriverSingleton.closeObjectInstance();
    }

    @Test()
    public void testSearchTokopedia(){
        delay(Constants.DETIK);
        tokopedia.setSearchProduct();
        delay(Constants.DETIK);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 600)", "");
        Assert.assertEquals(tokopedia.txtChooseProduct(), "Air Fryer Strogen Sanic, Airfryer Penggoreng Tanpa Minyak");
        System.out.println("Air Fryer Strogen Sanic, Airfryer Penggoreng Tanpa Minyak");
    }

    @Test()
    public void testProductTokopedia() {
        tokopedia.clickChooseProduct();
        Assert.assertEquals(tokopedia.txtJumlahProduk(), "Stock Total : 645");
        System.out.println("Stock Total : 645");
    }

    static void delay(int detik) {
        try {
            Thread.sleep(1000*detik);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
