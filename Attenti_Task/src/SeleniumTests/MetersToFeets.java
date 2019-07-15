package SeleniumTests;

import GeneralMethods.GeneralMethods;
import org.openqa.selenium.WebDriver;

public class MetersToFeets {
    private WebDriver driver;

    public MetersToFeets(WebDriver driver){
        this.driver = driver;
    }
    public void runAllTests() throws InterruptedException {
        System.out.println("Run First Test Check Legal Values with Convert BTN");
        firstTest("99"," M");
        GeneralMethods.backToMainPage(driver);
        firstTest("7.5","M");
        GeneralMethods.backToMainPage(driver);
        firstTest("789","M ");
        GeneralMethods.backToMainPage(driver);
        firstTest("5"," M");
        GeneralMethods.backToMainPage(driver);
        firstTest("14562","m");
        GeneralMethods.backToMainPage(driver);
        firstTest("99"," m");
        GeneralMethods.backToMainPage(driver);
        firstTest("99"," m ");
        GeneralMethods.backToMainPage(driver);
        firstTest("99","m ");
        GeneralMethods.backToMainPage(driver);
        System.out.println("--------------");
        System.out.println("Run Second Test Check Legal Values after press Length with Convert BTN");
        secondTest("99","m ");
        GeneralMethods.backToMainPage(driver);
        secondTest("1"," m");
        GeneralMethods.backToMainPage(driver);
        secondTest("45687"," m ");
        GeneralMethods.backToMainPage(driver);
        secondTest("7.5","M ");
        GeneralMethods.backToMainPage(driver);
        System.out.println("--------------");
        System.out.println("Run Third Test Check Legal Values after enter value no need to go back to the main page without the M ");
        firstTest("99"," M");
        thirdTest("789","");
        thirdTest("9.5","");
        GeneralMethods.backToMainPage(driver);
//        System.out.println("--------------");
//        System.out.println("Run Fourth Test Check ILLegal Values the search container should not appears");
//        fourthTest("QWEQWR"," M");
//        fourthTest("7.5!@#EQWE","M");
//        fourthTest("!@#$"," M ");
//        fourthTest("   "," m");

        System.out.println("--------------");
        System.out.println("Run Fifth Test Check ILLegal Values the search container should not appears do not needs to go back to main page");
        firstTest("99"," M");
        fifthTest("E+++"," M");
        fifthTest("7.5----+++","M");
        fifthTest("+++"," M ");
        fifthTest("   "," M");
        GeneralMethods.backToMainPage(driver);

    }

    public void firstTest( String checkValue , String symbol ) throws InterruptedException {
        System.out.println("Value is "+checkValue);
        Thread.sleep(2000);
        GeneralMethods.sendValueToInput("queryFrom",checkValue,symbol,driver);
        GeneralMethods.ClickButton("//*[@id=\"results\"]/ol/li[1]/div/a[2]",driver);
        Thread.sleep(2000);
        GeneralMethods.checkTheExpectedResultAndActualResultMetersToFeet(checkValue,symbol,driver);
        Thread.sleep(2000);
    }
    public void secondTest(String checkValue , String symbol) throws InterruptedException {
        System.out.println("Value is "+checkValue);
        Thread.sleep(2000);
        GeneralMethods.linkText("Length",driver);
        GeneralMethods.sendValueToInput("queryFrom",checkValue,symbol,driver);
        GeneralMethods.ClickButton("//*[@id=\"results\"]/ol/li[1]/div/a[2]",driver);
        Thread.sleep(2000);
        GeneralMethods.checkTheExpectedResultAndActualResultMetersToFeet(checkValue,symbol,driver);
        Thread.sleep(2000);

    }
    public void thirdTest(String checkValue , String symbol) throws InterruptedException {
        System.out.println("Value is "+checkValue);
        GeneralMethods.emptyTheinput(driver,"argumentConv");
        GeneralMethods.sendValueToInput("argumentConv",checkValue,"",driver);
        GeneralMethods.checkTheExpectedResultAndActualResultMetersToFeet(checkValue,symbol,driver);
        Thread.sleep(2000);

    }
    public void fourthTest(String checkValue , String symbol) throws InterruptedException {
        System.out.println("Value is "+checkValue);
        GeneralMethods.sendValueToInput("queryFrom",checkValue,symbol,driver);
        GeneralMethods.checkIfElementExistByXPAth("//*[@id=\"results\"]/ol",driver);
        GeneralMethods.emptyTheinputByXpath(driver," //*[@id=\"queryFrom\"]");

    }

    public void fifthTest(String checkValue,  String symbol ) throws InterruptedException {
        System.out.println("Value is "+checkValue);
        GeneralMethods.emptyTheinput(driver,"argumentConv");
        GeneralMethods.sendValueToInput("argumentConv",checkValue,"",driver);
        checkValue = "0";
        GeneralMethods.checkTheExpectedResultAndActualResultMetersToFeet(checkValue,symbol,driver);
    }

}
