package org.example;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Exercise1_TestLifecycle {

    @BeforeTest
    public void openWebSite() {
        System.out.println("Opening website...");
    }

    @Test(priority = 1)
    public void signUp() {
        System.out.println("Signing up user...");
    }

    @Test(priority = 2)
    public void logIn() {
        System.out.println("Logging in...");
    }

    @Test(priority = 3)
    public void addToCart() {
        System.out.println("Adding product to cart...");
    }

    @AfterTest
    public void logOut() {
        System.out.println("Logging out and closing browser...");
    }
}
