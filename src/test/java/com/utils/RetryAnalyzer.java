package com.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

// RetryAnalyzer > it means that if we receive an error while we are running the tests, it will run same test case again.

public class RetryAnalyzer implements IRetryAnalyzer {
    private static final int MAX_RETRY_COUNT = 1;
    private int retryCount = 0;

    @Override
    public boolean retry(ITestResult result) {
        if (!result.isSuccess() && retryCount < MAX_RETRY_COUNT) {
            retryCount++;
            return true;
        }
        return false;
    }
}