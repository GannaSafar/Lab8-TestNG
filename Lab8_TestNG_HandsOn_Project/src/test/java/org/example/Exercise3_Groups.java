package org.example;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class Exercise3_Groups {

    @BeforeGroups("Smoke")
    public void beforeSmoke() {
        System.out.println("Starting Smoke tests...");
    }

    @AfterGroups("Smoke")
    public void afterSmoke() {
        System.out.println("Finished Smoke tests.");
    }

    @BeforeGroups("Regression")
    public void beforeRegression() {
        System.out.println("Starting Regression tests...");
    }

    @AfterGroups("Regression")
    public void afterRegression() {
        System.out.println("Finished Regression tests.");
    }

    @Test(groups = {"Smoke"})
    public void testHomepageLoads() {
        System.out.println("Smoke: Homepage loads");
    }

    @Test(groups = {"Smoke"})
    public void testLoginPageVisible() {
        System.out.println("Smoke: Login page visible");
    }

    @Test(groups = {"Smoke"})
    public void testFooterLinks() {
        System.out.println("Smoke: Footer links");
    }

    @Test(groups = {"Regression"})
    public void testLoginValidCreds() {
        System.out.println("Regression: Valid login");
    }

    @Test(groups = {"Regression"})
    public void testLoginInvalidCreds() {
        System.out.println("Regression: Invalid login");
    }

    @Test(groups = {"Regression"})
    public void testPasswordReset() {
        System.out.println("Regression: Password reset");
    }

    @Test(groups = {"Regression"})
    public void testAccountBalance() {
        System.out.println("Regression: Account balance");
    }
}
