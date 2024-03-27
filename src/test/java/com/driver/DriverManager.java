package com.driver;

import org.openqa.selenium.WebDriver;


public class DriverManager {

    private static ThreadLocal<WebDriver> dr = new ThreadLocal<>(); // Driver factory de ki driver al buraya set et
    // daha  sonra

    public static WebDriver getDriver() {
        return dr.get();
    }

    public static void setDriver(WebDriver driverRef) {
        dr.set(driverRef);
    }

    public static void unload(){
        dr.remove();
    }
}
