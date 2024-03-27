package com.factory;
import com.utils.ConfigurationReaderFile;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

// DriverFactory >> only use for manage drivers for browser

public class DriverFactory {


    private DriverFactory() {} // singleton design pattern - / to prevent driver conflict we use this design pattern

    public static WebDriver createDriver() {
        WebDriver driver=null;
        String browser= ConfigurationReaderFile.get("browser");
            switch (browser) {
                case "chrome" -> {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*"); // this method for allow to run on JENKINS
                    options.setPageLoadStrategy(PageLoadStrategy.NORMAL); // THIS METHOD check if the page load or not
                    driver = new ChromeDriver(options);
                }
                case "chrome-headless" -> {     // headless : invisible chrome, your test will be executed.
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless=new");
                    options.addArguments("--start-maximized");
                    driver = new ChromeDriver(options);
                }
                case "firefox" -> {
                    FirefoxOptions options = new FirefoxOptions();
                    driver = new FirefoxDriver(options);
                }
                case "firefox-headless" -> {
                    FirefoxOptions options = new FirefoxOptions();
                    driver = new FirefoxDriver(options.addArguments("--headless=new"));
                }
                case "edge" -> {
                    EdgeOptions options = new EdgeOptions();
                    driver = new EdgeDriver(options);
                }
                case "safari" -> {
                    SafariOptions options = new SafariOptions();
                    driver = new SafariDriver(options);
                }
                default -> throw new IllegalStateException("Unexpected value: " + browser);
            }
        return driver;
    }
}
