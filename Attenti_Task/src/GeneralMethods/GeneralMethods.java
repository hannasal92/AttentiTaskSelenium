package GeneralMethods;

import Constant.Constant;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GeneralMethods {
    public static void sendValueToInput(String primeryKey, String value, String symbol, WebDriver driver) {
        try {
            driver.findElement(By.id(primeryKey)).sendKeys(value);
            Thread.sleep(1000);
            driver.findElement(By.id(primeryKey)).sendKeys(symbol);
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void sendValueToInputByXpath(String primeryKey, String value, WebDriver driver) {
        try {
            Thread.sleep(10000);
            driver.findElement(By.xpath(primeryKey)).sendKeys(value);
            driver.findElement(By.xpath(primeryKey)).sendKeys(Keys.RETURN);

            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void checkIfElementExistByXPAth(String primeryKey, WebDriver driver) {
        try {
            boolean check = driver.findElement(By.xpath(primeryKey)).isDisplayed();
            if (check) {
                System.out.println("The element with primeryKey " + primeryKey + " exist");
                throw new Exception("The element with primeryKey " + primeryKey + " exist");

            } else {
                System.out.println("The element with primeryKey " + primeryKey + " Not exist");

            }

        } catch (NoSuchElementException e) {
            System.out.println("The element with primeryKey " + primeryKey + " Not exist");
        } catch (Exception e) {
            System.out.println("The element with primeryKey " + primeryKey + " Not exist");
        }

    }

    public static void checkIfElementExist(String primeryKey, WebDriver driver) {
        try {
            boolean check = driver.findElement(By.id(primeryKey)).isDisplayed();
            if (check) {
                System.out.println("The element with primeryKey " + primeryKey + " exist");
                throw new Exception("The element with primeryKey " + primeryKey + " exist");

            } else {
                System.out.println("The element with primeryKey " + primeryKey + " Not exist");

            }

        } catch (NoSuchElementException e) {
            System.out.println("The element with primeryKey " + primeryKey + " Not exist");
        } catch (Exception e) {
            System.out.println("The element with primeryKey " + primeryKey + " Not exist");
        }

    }

    public static void refreshPAge(WebDriver driver) {
        try {
            driver.navigate().refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void ClickButton(String primeryKey, WebDriver driver) {
        try {
            // driver.findElement(By.xpath(primeryKey)).click();
            WebDriverWait wait = new WebDriverWait(driver, 20);
            WebElement clickBtn;
            clickBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(primeryKey)));
            clickBtn.click();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public static void linkTextWithWaiter(String primeryKey, WebDriver driver) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, 20);
                WebElement linkT;
                linkT = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(primeryKey)));
                linkT.click();
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    public static void linkText(String primeryKey, WebDriver driver) {
        try {
            driver.findElement(By.linkText(primeryKey)).click();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static String calucateMetersToFeets(String Meter) {

        double meter_int = Double.parseDouble(Meter);
        meter_int = ((meter_int) / (0.3048));
        return String.valueOf(meter_int);

    }

    public static String calucateOuncesToGrams(String Cel) {
        double cel_int = Double.parseDouble(Cel);
        cel_int = (cel_int) * (28.34952);
        return String.valueOf(cel_int);

    }

    public static String calucateCelsiusToFahrenheit(String Cel) {
        NumberFormat formatter = null;

        double cel_int = Double.parseDouble(Cel);
        cel_int = (cel_int * 9) / 5;
        double fahrenheit = cel_int + 32;
        return String.valueOf(fahrenheit);

    }

    public static void checkResults(String expectedResult, String actualResult) throws Exception {
        if (expectedResult.equals(actualResult)) {
            System.out.println("The Values Are equals expectedValue is " + expectedResult + " Actual Value is " + actualResult);
        } else {
            System.out.println("The Values Are not equals expectedValue is " + expectedResult + " Actual Value is " + actualResult);
            throw new Exception("The Values Are not equals expectedValue is " + expectedResult + " Actual Value is " + actualResult);
        }

    }

    public static String getActualValue(String primeryKey, String symbol, WebDriver driver) {
        String actualResult = null;
        String updated_results = null;
        try {
            actualResult = driver.findElement(By.id(primeryKey)).getText().toString();
            String[] actualResultsSplit = actualResult.split(" ");
            String value = getActualResultsSplit(actualResult, symbol);
            updated_results = actualResultsSplit[0] + " " + value + "°F";

        } catch (Exception e) {
            e.printStackTrace();
        }

        return updated_results;

    }

    public static String getActualValuOuncesGrams(String primeryKey, String symbol, WebDriver driver) {
        String actualResult = null;
        String updated_results = null;
        try {
            actualResult = driver.findElement(By.id(primeryKey)).getText().toString();
            String[] actualResultsSplit = actualResult.split(" ");
            String value = getActualResultsSplit(actualResult, symbol);
            updated_results = actualResultsSplit[0] + " " + value + "g";

        } catch (Exception e) {
            e.printStackTrace();
        }

        return updated_results;

    }

    public static String getActualValueMetersFeets(String primeryKey, String symbol, WebDriver driver) {
        String actualResult = null;
        String updated_results = null;
        try {
            actualResult = driver.findElement(By.id(primeryKey)).getText().toString();
            String[] actualResultsSplit = actualResult.split(" ");
            String value = getActualResultsSplit(actualResult, symbol);
            updated_results = actualResultsSplit[0] + " " + value + "ft";

        } catch (Exception e) {
            e.printStackTrace();
        }

        return updated_results;

    }
    public static String getFormatWithOneDigitAfterPoint(String expectedValue){
        double new_value = Double.parseDouble(expectedValue);
        NumberFormat formatter = null;
        formatter = new DecimalFormat("#0.0");
        Double.parseDouble(formatter.format(new_value));
        System.out.println(new_value);
        String expectedValueUpdated = formatter.format(new_value);

        return expectedValueUpdated ;
    }
    public static String getExpectedFormatOuncesToGrams(String checkValue, String expectedValue) {
        String allExpectedValue = null;


        double new_value = Double.parseDouble(expectedValue);
        NumberFormat formatter = null;
        formatter = new DecimalFormat("#0.0");
        Double.parseDouble(formatter.format(new_value));
        System.out.println(new_value);
        String expectedValueUpdated = formatter.format(new_value);


        allExpectedValue = checkValue + "oz" + "=" + " " + expectedValueUpdated + "g";
        return allExpectedValue;

    }

    public static String getExpectedFormatMetersToFeet(String checkValue, String expectedValue) {
        String allExpectedValue = null;

        Double double_value = Double.parseDouble(expectedValue);
        Integer integer_value = double_value.intValue();

        System.out.println(integer_value);


        allExpectedValue = checkValue + "m" + "=" + " " + String.valueOf(integer_value) + "ft";

        return allExpectedValue;

    }

    public static String getExpectedFormatCelsToFah(String checkValue, String expectedValue) {
        String allExpectedValue = null;
        double new_value = Double.parseDouble(expectedValue);
        NumberFormat formatter = null;
        formatter = new DecimalFormat("#0.0");
        Double.parseDouble(formatter.format(new_value));
        System.out.println(new_value);
        String expectedValueUpdated = formatter.format(new_value);
        allExpectedValue = checkValue + "°C" + "=" + " " + expectedValueUpdated + "°F";
        return allExpectedValue;
    }

    public static void backToMainPage(WebDriver driver) {
        driver.findElement(By.id("logo")).click();
    }

    public static void emptyTheinput(WebDriver driver, String primeryKey) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            WebElement input;
            input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(primeryKey)));
            input.clear();

        } catch (Exception e) {
            //e.printStackTrace();
        }

    }

    public static void emptyTheinputByXpath(WebDriver driver, String primeryKey) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            WebElement input;
            input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(primeryKey)));
            input.clear();

        } catch (Exception e) {
            //e.printStackTrace();
        }

    }

    public static void checkTheExpectedResultAndActualResult(String checkValue, String symbol, WebDriver driver) throws InterruptedException {
        String expectedValue;
        String actualValue;
        checkValue = checkValue.trim();
        if (checkValue.contains(" ")) {
            checkValue = checkValue.replaceAll(" ", "");
        }
        try {
            expectedValue = GeneralMethods.calucateCelsiusToFahrenheit(checkValue);
            String allExpectedValue = GeneralMethods.getExpectedFormatCelsToFah(checkValue, expectedValue);
            actualValue = GeneralMethods.getActualValue("answer", "F", driver);
            GeneralMethods.checkResults(allExpectedValue, actualValue);
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void checkTheExpectedResultAndActualResultMetersToFeet(String checkValue, String symbol, WebDriver driver) throws InterruptedException {
        String expectedValue;
        String actualValue;
        checkValue = checkValue.trim();
        if (checkValue.contains(" ")) {
            checkValue = checkValue.replaceAll(" ", "");
        }
        try {
            expectedValue = GeneralMethods.calucateMetersToFeets(checkValue);
            String allExpectedValue = GeneralMethods.getExpectedFormatMetersToFeet(checkValue, expectedValue);
            actualValue = GeneralMethods.getActualValueMetersFeets("answer", "ft", driver);
            GeneralMethods.checkResults(allExpectedValue, actualValue);
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void checkTheExpectedResultAndActualResultOuncesToGrams(String checkValue, String symbol, WebDriver driver) throws InterruptedException {
        String expectedValue;
        String actualValue;
        checkValue = checkValue.trim();
        if (checkValue.contains(" ")) {
            checkValue = checkValue.replaceAll(" ", "");

        }
        try {
            expectedValue = GeneralMethods.calucateOuncesToGrams(checkValue);
            String allExpectedValue = GeneralMethods.getExpectedFormatOuncesToGrams(checkValue, expectedValue);
            actualValue = GeneralMethods.getActualValuOuncesGrams("answer", "g", driver);
            GeneralMethods.checkResults(allExpectedValue, actualValue);
            Thread.sleep(2000);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String getActualResultsSplit(String actualresultWithFormar, String symbol) {
        String[] value_array = actualresultWithFormar.split("=");
        NumberFormat formatter = null;
        String value = value_array[1];
        if (symbol.contains("g")) {
            value = value.replaceAll("g", "");
            formatter = new DecimalFormat("#0.0");
        } else if (symbol.equalsIgnoreCase("ft")) {
            String[] value_without_inch = value.split(" ");
            value = value_without_inch[1];
            value = value.replaceAll("ft", "");

            formatter = new DecimalFormat("#0");

        } else if (symbol.equalsIgnoreCase("F")) {
            value = value.replaceAll("F", "");
            value = value.replaceAll("°", "");
            formatter = new DecimalFormat("#0.0");
        }

        double new_value = Double.parseDouble(value);

        Double.parseDouble(formatter.format(new_value));
        System.out.println(formatter.format(new_value));
        return formatter.format(new_value);


    }
    public static String getActualValueWithTable(String primeryKey, String symbol, WebDriver driver) {

        String actualResult = null ;
        try {
            actualResult = driver.findElement(By.xpath(primeryKey)).getText().toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return actualResult;

    }
    public static void checkTheExpectedResultAndActualResulCelciusToFahrenheitWithTablBtn
            (String checkValue, String symbol, WebDriver driver) throws InterruptedException {
        String expectedValue;
        String actualValue;
        checkValue = checkValue.trim();
        if (checkValue.contains(" ")) {
            checkValue = checkValue.replaceAll(" ", "");
        }
        try {
            expectedValue = GeneralMethods.calucateCelsiusToFahrenheit(checkValue);
            expectedValue = getFormatWithOneDigitAfterPoint(expectedValue);
            expectedValue = expectedValue+"°F";
            actualValue = getActualValueWithTable("//*[@id=\"innerConversionTable\"]/div[2]/table/tbody/tr[1]/td[2]",symbol,driver);
            String[] actualValueWithoutF = actualValue.split("°F");
            actualValue = getFormatWithOneDigitAfterPoint(actualValueWithoutF[0]);
            actualValue = actualValue+"°F";

            GeneralMethods.checkResults(expectedValue, actualValue);

        } catch (Exception e) {
        e.printStackTrace();
    }
    }


    public static void checkResultsAPITemp(WebDriver driver , String tempAPI){

        try{


        String expectedResult = tempAPI ;
        String actualResult = driver.findElement(By.xpath("//*[@id='main-Nowcard-92c6937d-b8c3-4240-b06c-9da9a8b0d22b']/div/div/section/div[2]/div[1]/div[2]/span")).getText().toString();

        expectedResult = calucateCelsiusToFahrenheit(expectedResult);

        double range =  Double.parseDouble(expectedResult) *  10 ;
        range = range / 100 ;


        double  max_value =  Double.parseDouble(expectedResult) + range ;
        double  min_value =  Double.parseDouble(expectedResult) - range ;

        actualResult = actualResult.replaceAll("°","");

        double actualResult_int = Double.parseDouble(actualResult);

        if(actualResult_int >= min_value && actualResult_int <= max_value){
            System.out.println("The Value in Range");
        }else{
            throw new Exception("The Value is not in Range");
        }

        }
        catch(Exception e){
            e.printStackTrace();
        }


    }
    public static String sendGet() throws Exception {
        String temperature = null ;
        String url = Constant.API_TEMPERETURE;
        URL obj = new URL(url);

        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");



        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println(response.toString());


        JSONObject obj2= new JSONObject(response.toString());
        JSONObject locs = obj2.getJSONObject("observations");

        System.out.println(locs.getJSONArray("location"));
        JSONArray jsonArray = locs.getJSONArray("location") ;

        for (int i = 0; i < jsonArray.length(); ++i) {
            JSONObject rec = jsonArray.getJSONObject(i);
           // int id = rec.getInt("id");
            JSONArray jsonArray2 =  rec.getJSONArray("observation");
            for (int j = 0; j < jsonArray2.length(); ++j) {
                JSONObject rec2 = jsonArray2.getJSONObject(j);
                String str = rec2.getString("temperature");
                System.out.println(str);
                temperature = str ;
                return temperature ;



            }

        }

        return temperature ;

    }
}
