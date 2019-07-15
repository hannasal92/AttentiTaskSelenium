package SeleniumTests;

import GeneralMethods.GeneralMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CelsiusToFahrenheit {
    private WebDriver driver;

    public CelsiusToFahrenheit(WebDriver driver){
        this.driver = driver ;

    }
    public void runAllTests() throws InterruptedException {
        System.out.println("Run First Test Check Legal Values with Table BTN");
        sisxxthTest("99", "c");



        System.out.println("Run First Test Check Legal Values");
        firstTest("99"," C");
        GeneralMethods.backToMainPage(driver);
        secondTest("55","c ");
        GeneralMethods.backToMainPage(driver);
        firstTest("100","C");
        GeneralMethods.backToMainPage(driver);
        firstTest("7.5","C ");
        GeneralMethods.backToMainPage(driver);
        firstTest("1254","C");
        GeneralMethods.backToMainPage(driver);
        firstTest("698754","C");
        GeneralMethods.backToMainPage(driver);
        System.out.println("--------------");
        System.out.println("Run Second Test Check Legal Values after press Temperature");
        secondTest("66","c");
        GeneralMethods.backToMainPage(driver);
        secondTest("165"," c");
        GeneralMethods.backToMainPage(driver);
        secondTest("7.5","c ");
        GeneralMethods.backToMainPage(driver);
        secondTest("999","C");
        GeneralMethods.backToMainPage(driver);
        secondTest("15789","C");
        GeneralMethods.backToMainPage(driver);
        System.out.println("--------------");
        System.out.println("Run Third Test Check Legal Values after enter value no need to go back to the main page without the C ");
        firstTest("99"," C");
        thirdTest("789","");
        thirdTest("7.69","");
        thirdTest("1000","");
        thirdTest("15978","");
        thirdTest("164.98","");
        GeneralMethods.backToMainPage(driver);
//        System.out.println("--------------");
//        System.out.println("Run Fourth Test Check ILLegal Values the search container should not appears");
//        fourthTest("QWEQWR"," C");
//        fourthTest("7.5!@#EQWE","C");
//        fourthTest("!@#$"," C ");
//        fourthTest("   "," C");

        System.out.println("--------------");
        System.out.println("Run Fifth Test Check ILLegal Values the search container should not appears do not needs to go back to main page");
        firstTest("99"," C");
        fifthTest("E+++"," C");
        fifthTest("7.5----+++","C");
        fifthTest("+++"," C ");
        fifthTest("   "," C");
        GeneralMethods.backToMainPage(driver);





    }
    //check Legal Values
    public void firstTest( String checkValue , String symbol ) throws InterruptedException {
        System.out.println("Value is "+checkValue);

        Thread.sleep(2000);
        GeneralMethods.sendValueToInput("queryFrom",checkValue,symbol,driver);
        GeneralMethods.ClickButton("//*[@id=\"results\"]/ol/li[2]/div/a[2]",driver);
        Thread.sleep(2000);
        GeneralMethods.checkTheExpectedResultAndActualResult(checkValue,symbol,driver);
        Thread.sleep(2000);
    }
    public void secondTest(String checkValue , String symbol) throws InterruptedException {
        System.out.println("Value is "+checkValue);
        Thread.sleep(2000);
        GeneralMethods.linkText("Temperature",driver);
        GeneralMethods.sendValueToInput("queryFrom",checkValue,symbol,driver);
        GeneralMethods.ClickButton("//*[@id=\"results\"]/ol/li[1]/div/a[2]\n",driver);
        Thread.sleep(2000);
        GeneralMethods.checkTheExpectedResultAndActualResult(checkValue,symbol,driver);
        Thread.sleep(2000);

    }
    public void thirdTest(String checkValue , String symbol) throws InterruptedException {
        GeneralMethods.emptyTheinput(driver,"argumentConv");
        GeneralMethods.sendValueToInput("argumentConv",checkValue,"",driver);
        GeneralMethods.checkTheExpectedResultAndActualResult(checkValue,symbol,driver);
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
        GeneralMethods.checkTheExpectedResultAndActualResult(checkValue,symbol,driver);
    }
    public void sisxxthTest(String checkValue, String symbol) throws InterruptedException {
        System.out.println("Value is "+checkValue);
        GeneralMethods.sendValueToInput("queryFrom",checkValue,symbol,driver);
        GeneralMethods.ClickButton("//*[@id=\"results\"]/ol/li[2]/div/a[1]\n",driver);
        GeneralMethods.emptyTheinputByXpath(driver,"//*[@id=\"startval\"]");
        GeneralMethods.sendValueToInput("startval",checkValue,symbol,driver);
        GeneralMethods.checkTheExpectedResultAndActualResulCelciusToFahrenheitWithTablBtn(checkValue,symbol,driver);

    }


}
