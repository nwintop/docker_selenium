package com.trainline.tests;

import com.trainline.pages.SearchPage;
import com.trainline.pages.TfwPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.net.MalformedURLException;
import java.net.URL;

public class TfwRegistrationTest  {
    public WebDriver driver;

    @BeforeTest
    private void setUp() throws MalformedURLException {
        //BROWSER=> selenium/firfox
        //HUB HOST=> localhoat/ip/hostmane

        String host= "localhost";
        DesiredCapabilities dc;

        if(System.getProperty("BROWSER") != null & System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            dc=DesiredCapabilities.firefox();
        }else{
            dc=DesiredCapabilities.chrome();
        }
        if(System.getProperty("HUB_HOST") != null) {
            host = System.getProperty("HUB_HOST");
        }

        String URL="http://"+host+":4444/wd/hub";


            //System.setProperty("webdriver.chrome.driver","C:\\Users\\NileshK\\Downloads\\TrainlineDockerSelenium\\driverStore\\chromedriver.exe");
        this.driver=new RemoteWebDriver(new URL(URL),dc);

    }

    @Test
    private  void TrainlineRegister(){
        TfwPage tfwPage=new TfwPage(driver);
        tfwPage.goTO();
        tfwPage.register();
    }

    @AfterTest
    private void QuitBroswer(){
        this.driver.quit();
    }

}
