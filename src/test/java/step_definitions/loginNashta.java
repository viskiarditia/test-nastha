package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import step_definitions.Hooks;

import java.time.Duration;
import java.util.List;

import static step_definitions.Hooks.webDriver;

public class loginNashta {
    private final JavascriptExecutor js;
    private final WebDriverWait wait;
    private WebDriver webDriver;
    private Actions actions;

    public loginNashta() {
        super();
        this.webDriver = Hooks.webDriver;
        this.js = (JavascriptExecutor) webDriver;
        this.actions = new Actions(webDriver);
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    @Given("User open the website Official nastha")
    public void userOpenTheWebsiteOfficialNastha() throws InterruptedException {
        WebElement openWebSite = webDriver.findElement(By.xpath("//img[@alt='logo']"));
        openWebSite.isDisplayed();
        Assert.assertTrue(true);
        Thread.sleep(1000);
    }


    @When("User input Username and Password in page sign in")
    public void userInputUsernameAndPasswordInPageSignIn() throws InterruptedException {
        WebElement userName = webDriver.findElement(By.xpath("//input[@name='email']"));
        userName.sendKeys("addiyat.sandi@gmail.com");
        WebElement password = webDriver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("Nashta@2023");
        WebElement clickSignIn = webDriver.findElement(By.cssSelector(".MuiButton-root"));
        clickSignIn.click();
        Thread.sleep(1000);
    }


    @Then("User already on landing page login hover cursor to role Menu")
    public void userAlreadyOnLandingPageLoginHoverCursorToRoleMenu() throws InterruptedException {
        WebElement hoverRoleMenu = webDriver.findElement(By.xpath("//ul[@class='MuiList-root MuiList-padding navigation whitespace-nowrap px-6 py-0 active-undefined-list navigation muiltr-10ofg0s']"));
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'start'});", hoverRoleMenu);

        WebElement role = webDriver.findElement(By.xpath("//span[contains(text(),'Role')]"));
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        actions.moveToElement(role).perform();
        wait.until(ExpectedConditions.elementToBeClickable(role));
        role.click();
        Thread.sleep(3000);
    }

    @And("User Click Add New fill out the form")
    public void userClickAddNewfillouttheform() throws InterruptedException {
        WebElement addNew = webDriver.findElement(By.xpath("//div[@class='flex flex-col w-full sm:w-auto sm:flex-row space-y-16 sm:space-y-0 flex-1 items-center justify-end space-x-8']/div[.='Add New']"));
        actions.moveToElement(addNew).perform();
        addNew.click();
        Thread.sleep(3000);

        WebElement isiForm = webDriver.findElement(By.cssSelector("[name='role_name']"));
        isiForm.sendKeys("Fizki Arditia");
        WebElement checkBoxAdmin = webDriver.findElement(By.xpath("//input[@name='is_admin']"));
        checkBoxAdmin.click();
        WebElement checkBoxSuperAdmin = webDriver.findElement(By.xpath("//input[@name='is_superadmin']"));
        checkBoxSuperAdmin.click();
        By saveButtonLocator = By.cssSelector(".MuiButton-containedWarning");
        WebElement buttonSave = wait.until(ExpectedConditions.elementToBeClickable(saveButtonLocator));
        buttonSave.click();
        Thread.sleep(5000);
    }

    @Then("click Action Bottom For Edit or Delete")
    public void clickActionBottomForEditOrDelete() throws InterruptedException {
        // klik action button
        WebElement actionButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[last()]/td[2]/button[1]")));
        actionButton.click();
        // edit data
        WebElement edit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Edit')]")));
        edit.click();

        WebElement isiForm = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name='role_name']")));
        isiForm.click();
        isiForm.clear();
        isiForm.sendKeys(" Kusuma");

        By saveButtonLocator = By.cssSelector(".MuiButton-containedWarning");
        WebElement buttonSave = wait.until(ExpectedConditions.elementToBeClickable(saveButtonLocator));
        buttonSave.click();

        //delete data
        WebElement actionButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[last()]/td[2]/button[1]")));
        actionButton2.click();
        WebElement delete = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Delete')]")));
        delete.click();
        WebElement confirmDelete = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[7]/div[3]/div/div/div[2]/button[2]")));
        confirmDelete.click();

        Thread.sleep(5000);
    }
}