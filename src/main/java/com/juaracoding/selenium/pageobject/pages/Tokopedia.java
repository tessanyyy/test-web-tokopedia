package com.juaracoding.selenium.pageobject.pages;

import com.juaracoding.selenium.pageobject.drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tokopedia {

    private WebDriver driver;

    public Tokopedia() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='Cari di Tokopedia']")
    WebElement searchProduct;

    @FindBy(xpath = "//div[normalize-space()='Air Fryer Strogen Sanic, Airfryer Penggoreng Tanpa Minyak']")
    WebElement chooseProduct;

    @FindBy(xpath = "//p[@class='css-1hhh2ha-unf-heading e1qvo2ff8']")
    WebElement jumlahProduct;



    public void setSearchProduct() {
        searchProduct.sendKeys("airfryer" + Keys.ENTER);
    }

    public void clickChooseProduct(){
        this.chooseProduct.sendKeys(Keys.RETURN);
    }

    public String txtChooseProduct(){
        return chooseProduct.getText();
    }

    public String txtJumlahProduk(){
        return jumlahProduct.getText();
    }

    static void delay(int detik) {
        // delay
        try {
            Thread.sleep(1000 * detik);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
