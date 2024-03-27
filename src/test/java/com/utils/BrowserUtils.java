package com.utils;

import com.driver.DriverManager;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import static com.pages.BasePage.actions;
import static com.pages.BasePage.wait;

// we store other methods than javascripts here.

public class BrowserUtils {

    /**
     * This method enables to wait desired seconds
     *
     * @param seconds
     */
    public static void waitFor(int seconds) {
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(seconds));
    }

    /**
     * This method enables to wait visibility of the element
     *
     * @param element
     */
    public static void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * This method enables to wait clickable of the element
     *
     * @param element
     */
    public static void waitForClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * This method enables to navigate desired URL
     *
     * @param url
     */
    public static void navigateTo_URL(String url) {
        DriverManager.getDriver().get(url);
    }

    /**
     * This method enables to click the element
     *
     * @param element
     */
    public static void click(WebElement element) {
        wait.until(driver -> ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    /**
     * This method enables to enter text into inputBox
     *
     * @param element
     * @param keyword
     */
    public static void enterText(WebElement element, String keyword) {
        wait.until(driver -> ExpectedConditions.elementToBeClickable(element));
        element.clear();
        element.sendKeys(keyword);
    }


    public static void switchToNewWindow(String windowHandle) {

        Set<String> windowHandleList = DriverManager.getDriver().getWindowHandles();

        for (String each : windowHandleList) {
            if (each != windowHandle) {
                DriverManager.getDriver().switchTo().window(each);
            }
        }
    }
    public static String createYearWithYearFormatter(){
        LocalDate tarih=LocalDate.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyy-MM-dd");
        String formattedBugununTarihi= tarih.format(formatter);
        String year=formattedBugununTarihi.substring(0,4);
        return year;

    }
    public static String createDayWithDateFormatter(){

        LocalDate tarih=LocalDate.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyy-MM-dd");
        String formattedBugununTarihi= tarih.format(formatter);
        String day=formattedBugununTarihi.substring(8);
        return day;

    }
    public static boolean verifyFileDownload(String path,String fileName){
        File file=new File(path);
        File[] files=file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if(files[i].getName().equals(fileName)){
                files[i].delete();
                return true;
            }
        }
        return false;
    }
    public static void hoverOver(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        actions.moveToElement(element).perform();
    }
}