package com.constants;


import com.utils.ConfigurationReaderFile;

// we pull the data from configurationproperties file >

public class FrameworkConstants {
    private FrameworkConstants() {
    }

    private static final String URL = ConfigurationReaderFile.get("url");
    private static final String qualityAssuranceUrl = ConfigurationReaderFile.get("urlQa");

    // final keywords meaning > we are assign an absolute value to our variable to prevent to change data (intentially or unintellialy mistake )
    // when we use final > keyword > we have to put UPPER case letter (URL > Correct version)

    public static String getUrl() {
        return URL;
    }
    public static String getQAUrl() {
        return qualityAssuranceUrl;
    }


}
