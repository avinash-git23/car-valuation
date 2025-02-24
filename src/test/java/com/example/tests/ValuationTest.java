package com.example.tests;

import com.example.model.Car;
import com.example.pages.ValuationPage;
import com.example.utils.ExpectedCarDataLoader;
import com.example.utils.RegistrationExtractor;
import io.github.bonigarcia.wdm.WebDriverManager;  // Import WebDriverManager
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ValuationTest {
    private WebDriver driver;
    private ValuationPage valuationPage;

    @BeforeClass
    public void setUp() {
        try {
            // Force WebDriverManager to download the correct driver for Chrome version 133
            WebDriverManager.chromedriver()
                    .forceDownload()
                    .browserVersion("133.0.6943.127")
                    .setup();

            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            valuationPage = new ValuationPage(driver);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error in @BeforeClass setup: " + e.getMessage());
        }
    }

    @Test
    public void testCarValuations() throws Exception {
        // Extract registration numbers from the free-form input file
        List<String> regs = RegistrationExtractor.extractRegistrations("src/test/resources/car_input.txt");

        // Load expected car details from the CSV output file
        Map<String, Car> expectedCars = ExpectedCarDataLoader.loadExpectedData("src/test/resources/car_output.txt");

        // Validate each registration
        for (String reg : regs) {
            // Normalize registration by removing spaces for consistency
            String normReg = reg.replaceAll("\\s", "");
            Car actual = valuationPage.lookupVehicle(reg);
            Assert.assertNotNull(actual, "Vehicle details not found for registration: " + reg);

            Car expected = expectedCars.get(normReg);
            Assert.assertNotNull(expected, "No expected data for registration: " + reg);

            // Assertions to fail the test if details do not match
            Assert.assertEquals(actual.getModel(), expected.getModel(), "Mismatch in make/model for " + reg);
            Assert.assertEquals(actual.getYear(), expected.getYear(), "Mismatch in year for " + reg);
        }
    }

    @Test
    public void testFileAccessibility() throws Exception {
        InputStream input = getClass().getClassLoader().getResourceAsStream("car_input.txt");
        Assert.assertNotNull(input, "car_input.txt not found in classpath");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
