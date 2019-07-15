import Constant.Constant;
import GeneralMethods.GeneralMethods;
import SeleniumTests.ApiTemperature;
import SeleniumTests.CelsiusToFahrenheit;
import SeleniumTests.MetersToFeets;
import SeleniumTests.OuncesToGrams;
import org.openqa.selenium.WebDriver;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {
    private static WebDriver driver;
    //Must Run the same tests on differents Browsers , and Run the same tests on differents Operation Systems
    public static void main(String[] args){
            String tempereture = null ;
        try {
            //get the temp from API
            tempereture =  GeneralMethods.sendGet();

            //open the weather website and get the temp and compair it with the api result value
            invokeBrowser(Constant.WEATHER_URL);
            ApiTemperature ApiTemp = new ApiTemperature(driver,tempereture);
            ApiTemp.getTempFromWeather();



            invokeBrowser(Constant.METRIC_URL);
            CelsiusToFahrenheit cToF = new CelsiusToFahrenheit(driver);
            System.out.println("Run Test to Check Convert Celsius To Fahrenheit");
            cToF.runAllTests();
            System.out.println("-----------------------------------------------");
            MetersToFeets mToF = new MetersToFeets(driver);
            System.out.println("Run Test to Check Convert Meters To Feet");
         //   mToF.runAllTests();
            System.out.println("-----------------------------------------------");
            OuncesToGrams oToG = new OuncesToGrams(driver);
            System.out.println("Run Test to Check Convert Ounces To Grams");
          //  oToG.runAllTests();
            System.out.println("-----------------------------------------------");



        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Open the specific URL
    public static void invokeBrowser(String URL) {
        try {
            ChromeOptions chromeOptions = new ChromeOptions();
           // chromeOptions.addArguments("--kiosk");
            System.setProperty("webdriver.chrome.driver", "chromedriver");
            driver = new ChromeDriver(chromeOptions);
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.get(URL);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
