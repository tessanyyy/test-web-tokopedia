package com.juaracoding.selenium.pageobject.drivers.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome implements DriverStrategy {
    public WebDriver setStrategy() {
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe"); //WebDriversManagers.chrome.setup();
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--no-sandbox");

        return new ChromeDriver(options);
    }
}
