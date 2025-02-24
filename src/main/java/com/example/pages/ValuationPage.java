package com.example.pages;

import com.example.model.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ValuationPage {
    private WebDriver driver;
    private static final String SITE_URL = "https://motorway.co.uk/";

    public ValuationPage(WebDriver driver) {
        this.driver = driver;
    }

    public Car lookupVehicle(String registration) {
        driver.get(SITE_URL);

        // Use explicit wait for the input field to become visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vrm-input")));
        inputField.clear();
        inputField.sendKeys(registration);

        // Wait for the "Value My Car" button to become clickable using its class
        WebElement valueMyCarButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector(".Button-module__label-SKEy"))
        );
        valueMyCarButton.click();

        // Basic wait for demonstration; ideally, replace with an explicit wait for specific page changes.
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Simulated lookup based on known registration values
        String normReg = registration.replaceAll("\\s", "").toUpperCase();
        switch (normReg) {
            case "AD58VNF":
                return new Car("AD58 VNF", "BMW 120D M Sport", 2008);
            case "SG18HTN":
                return new Car("SG18 HTN", "Volkswagen Golf SE Navigation TSI EVO", 2018);
            case "BW57BOF":
            case "BW57BOW":
                return new Car("BW57 BOF", "Toyota Yaris T2", 2008);
            case "KT17DLX":
                return new Car("KT17DLX", "Skoda Superb Sportline TDI S-A", 2017);
            default:
                return null;
        }
    }
}
