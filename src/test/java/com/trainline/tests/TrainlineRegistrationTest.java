package com.trainline.tests;

import com.trainline.pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.net.MalformedURLException;
import java.net.URL;

public class TrainlineRegistrationTest  {
    public WebDriver driver;

    @BeforeTest
    private void setUp(ITestContext icx) throws MalformedURLException {
        //BROWSER=> selenium/firfox
        //HUB HOST=> localhoat/ip/hostmane

        String host= "192.168.0.104";
        DesiredCapabilities dc;

        if(System.getProperty("BROWSER") != null & System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            dc=DesiredCapabilities.firefox();
        }else{
            dc=DesiredCapabilities.chrome();
        }
        if(System.getProperty("HUB_HOST") != null) {
            host = System.getProperty("HUB_HOST");
        }
String testName=icx.getCurrentXmlTest().getName();
//grid url
        String URL="http://"+host+":4444/wd/hub";
//name
        dc.setCapability("name",testName);


        //System.setProperty("webdriver.chrome.driver","C:\\Users\\NileshK\\Downloads\\TrainlineDockerSelenium\\driverStore\\chromedriver.exe");
        this.driver=new RemoteWebDriver(new URL(URL),dc);
        //this.driver=new ChromeDriver();

    }

       @Test
    private  void TrainlineRegister(){

           SearchPage searchPage=new SearchPage(driver);
        searchPage.goTO();
        searchPage.register();
    }

    @AfterTest
    private void QuitBroswer(){
        this.driver.quit();
    }

}
