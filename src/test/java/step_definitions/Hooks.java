package step_definitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Paths;
import java.util.HashMap;

public class Hooks {
    public static WebDriver webDriver;
    @Before
    public void openBrowser(){
        HashMap<String, Object> chromePrefs = new HashMap<>();
        ChromeOptions options = new ChromeOptions();
        chromePrefs.put("download.default_directory", Paths.get("").toAbsolutePath().toString());
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--test-type");
        options.addArguments("--incognito","--ignore-certificate-errors","--disable-extensions","--no-sandbox","--disable-gpu");
        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        webDriver= new ChromeDriver(options);
        String URL = "https://hris.nashta.co.id/sign-in";


        webDriver.get(URL);
        webDriver.manage().window().maximize();
    }
//    @Before
//    public void openBrowser(){
//        ChromeOptions a = new ChromeOptions();
//        a.addArguments("--remote-allow-origins=*");
//        WebDriverManager.chromedriver().setup();
//
//        webDriver = new ChromeDriver();
//        String appUrl = "https://hris.nashta.co.id/sign-in";
//        webDriver.get(appUrl);
//        webDriver.manage().window().maximize();
//    }

    @After
    public void closeBrowser(){
        webDriver.quit();
    }

}