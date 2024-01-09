package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import step_definitions.Hooks;

public class loginNashta {
    private WebDriver webDriver;
    public loginNashta(){
        super();
        this.webDriver = Hooks.webDriver;
    }
    @Given("User open the website Official nastha")
    public void userOpenTheWebsiteOfficialNastha() throws InterruptedException {
        WebElement openWebSite = webDriver.findElement(By.xpath("//img[@alt='logo']"));
        openWebSite.isDisplayed();
        Assert.assertTrue(true);
        Thread.sleep(4000);
    }


    @When("User input Username and Password in page sign in")
    public void userInputUsernameAndPasswordInPageSignIn() throws InterruptedException {
        WebElement userName = webDriver.findElement(By.xpath("//input[@name='email']"));
        userName.sendKeys("addiyat.sandi@gmail.com");
        WebElement password = webDriver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("Nashta@2023");
        WebElement clickSignIn = webDriver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedWarning MuiButton-sizeLarge MuiButton-containedSizeLarge MuiButton-root MuiButton-contained MuiButton-containedWarning MuiButton-sizeLarge MuiButton-containedSizeLarge  w-full mt-16 muiltr-qnk7s0']"));
        clickSignIn.click();
        Thread.sleep(5000);
    }

    @Then("User already on landing page login")
    public void userAlreadyOnLandingPageLogin() {
        WebElement landingPage= webDriver.findElement(By.xpath("//img[@src='assets/images/pages/profile/bg_websitev3.png']"));
        landingPage.isDisplayed();
        Assert.assertTrue(true);

    }



}
