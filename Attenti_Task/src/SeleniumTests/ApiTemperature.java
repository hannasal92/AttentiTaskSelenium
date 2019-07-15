package SeleniumTests;

import GeneralMethods.GeneralMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ApiTemperature {
    private WebDriver driver ;
    private String temp ;



    public ApiTemperature(WebDriver driver, String temp){
        this.driver = driver ;
        this.temp = temp ;
    }

    public void getTempFromWeather(){
        GeneralMethods.sendValueToInputByXpath("//*[@id='header-TwcHeader-10c7c60c-aebb-4e78-b655-512b2460d9f4']/div/div/div/div[1]/div/div[1]/div/input","20852",driver);
        GeneralMethods.linkTextWithWaiter("Rockville, MD, UNITED STATES OF AMERICA",driver);
        GeneralMethods.checkResultsAPITemp(driver , temp);

    }
}
