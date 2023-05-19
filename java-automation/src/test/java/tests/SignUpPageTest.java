package tests;

import Utils.SeleniumUtils;
import dataProviders.SignUpPageDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SignUpPage;

public class SignUpPageTest extends BaseUITest {

    @Test(dataProvider = "signUpPageDataProvider", dataProviderClass = SignUpPageDataProvider.class)
    public void testIfSignupPageIsAvailable(String browserType, boolean expectedPageAvailability) {
        driver = SeleniumUtils.getDriver(browserType);

        SignUpPage signUpPage = new SignUpPage(driver);
        boolean isPageAvailable = signUpPage.open(signUpPageUrl);

        Assert.assertEquals(isPageAvailable, expectedPageAvailability);

    }
}
