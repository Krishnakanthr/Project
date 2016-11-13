package wrappers;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;
 
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
 
import utils.Reporter;
 
public class GenericWrappers extends Reporter implements Wrappers {
               
                public GenericWrappers(RemoteWebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test=test;
   }
 
                public RemoteWebDriver driver;
                protected static Properties prop;
                public String sUrl,primaryWindowHandle,sHubUrl,sHubPort;
 
                public GenericWrappers() {
                                Properties prop = new Properties();
                                try {
                                                prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));
                                                sHubUrl = prop.getProperty("HUB");
                                                sHubPort = prop.getProperty("PORT");
                                                sUrl = prop.getProperty("URL");
                                } catch (FileNotFoundException e) {
                                                e.printStackTrace();
                                } catch (IOException e) {
                                                e.printStackTrace();
                                }
                }
 
                public void loadObjects() {
                                prop = new Properties();
                                try {
                                                prop.load(new FileInputStream(new File("./src/main/resources/object.properties")));
                                } catch (FileNotFoundException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                } catch (IOException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                }
 
                }
 
                public void unloadObjects() {
                                prop = null;
                }
 
                /**
                * This method will launch the browser in local machine and maximise the browser and set the
                * wait for 30 seconds and load the url
                * @author Babu - TestLeaf
                * @param url - The url with http or https
                *
                 */
                public void invokeApp(String browser) {
                                invokeApp(browser,false);
                }
 
                /**
                * This method will launch the browser in grid node (if remote) and maximise the browser and set the
                * wait for 30 seconds and load the url
                 * @author Babu - TestLeaf
                * @param url - The url with http or https
                *
                 */
                public void invokeApp(String browser, boolean bRemote) {
                                try {
 
                                                DesiredCapabilities dc = new DesiredCapabilities();
                                                dc.setBrowserName(browser);
                                                dc.setPlatform(Platform.WINDOWS);
 
                                                // this is for grid run
                                                if(bRemote)
                                                                driver = new RemoteWebDriver(new URL("http://"+sHubUrl+":"+sHubPort+"/wd/hub"), dc);
                                                else{ // this is for local run
                                                                if(browser.equalsIgnoreCase("chrome")){
                                                                                System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
                                                                                driver = new ChromeDriver();
                                                                }else{
                                                                                System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
                                                                                driver = new FirefoxDriver();
                                                                }
                                                }
 
                                                driver.manage().window().maximize();
                                                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                                                driver.get(sUrl);
 
                                                primaryWindowHandle = driver.getWindowHandle();                   
                                                reportStep("The browser:" + browser + " launched successfully", "PASS");
 
                                } catch (Exception e) {
                                                e.printStackTrace();
                                                reportStep("The browser:" + browser + " could not be launched", "FAIL");
                                }
                }
 
                /**
                * This method will enter the value to the text field using id attribute to locate
                *
                 * @param idValue - id of the webelement
                * @param data - The data to be sent to the webelement
                * @author Babu - TestLeaf
                * @throws IOException
                 * @throws COSVisitorException
                 */
                public void enterById(String idValue, String data) {
                                try {
                                                driver.findElement(By.id(idValue)).clear();
                                                driver.findElement(By.id(idValue)).sendKeys(data);      
                                                reportStep("The data: "+data+" entered successfully in field :"+idValue, "PASS");
                                } catch (NoSuchElementException e) {
                                                reportStep("The data: "+data+" could not be entered in the field :"+idValue, "FAIL");
                                } catch (Exception e) {
                                                reportStep("Unknown exception occured while entering "+data+" in the field :"+idValue, "FAIL");
                                }
                }
 
                /**
                * This method will enter the value to the text field using name attribute to locate
                *
                 * @param nameValue - name of the webelement
                * @param data - The data to be sent to the webelement
                * @author Babu - TestLeaf
                * @throws IOException
                 * @throws COSVisitorException
                 */
                public void enterByName(String nameValue, String data) {
                                try {
                                                driver.findElement(By.name(nameValue)).clear();
                                                driver.findElement(By.name(nameValue)).sendKeys(data);      
                                                reportStep("The data: "+data+" entered successfully in field :"+nameValue, "PASS");
 
                                } catch (NoSuchElementException e) {
                                                reportStep("The data: "+data+" could not be entered in the field :"+nameValue, "FAIL");
                                } catch (Exception e) {
                                                reportStep("Unknown exception occured while entering "+data+" in the field :"+nameValue, "FAIL");
                                }
 
                }
 
                /**
                * This method will enter the value to the text field using class name attribute to locate
                *
                 * @param nameValue - name of the webelement
                * @param data - The data to be sent to the webelement
                * @author Babu - TestLeaf
                * @throws IOException
                 * @throws COSVisitorException
                 */
 
                //@Override
                public void enterByClassname(String nameValue, String data) {
                                driver.findElementByClassName(nameValue).clear();
                                driver.findElementByClassName(nameValue).sendKeys(data);
                                System.out.println("The Text "+nameValue+" entered successfully");
                                takeSnap();
 
                }
 
                /**
                * This method will enter the value to the text field using name attribute to locate
                *
                 * @param xpathValue - xpathValue of the webelement
                * @param data - The data to be sent to the webelement
                * @author Babu - TestLeaf
                * @throws IOException
                 * @throws COSVisitorException
                 */
                public void enterByXpath(String xpathValue, String data) {
                                try {
                                                driver.findElement(By.xpath(xpathValue)).clear();
                                                driver.findElement(By.xpath(xpathValue)).sendKeys(data);      
                                                reportStep("The data: "+data+" entered successfully in field :"+xpathValue, "PASS");
 
                                } catch (NoSuchElementException e) {
                                                reportStep("The data: "+data+" could not be entered in the field :"+xpathValue, "FAIL");
                                } catch (Exception e) {
                                                reportStep("Unknown exception occured while entering "+data+" in the field :"+xpathValue, "FAIL");
                                }
 
                }
 
                //@Override
                public void enterByTagName(String tagNameValue, String data) {
                                System.out.println(tagNameValue);
                                driver.findElementByXPath(tagNameValue).clear();
                                driver.findElementByXPath(tagNameValue).sendKeys(data);
                                System.out.println("The Text "+tagNameValue+" entered successfully");
                                takeSnap();
 
                }
 
                /**
                * This method will verify the title of the browser
                 * @param title - The expected title of the browser
                * @author Babu - TestLeaf
                */
                public boolean verifyTitle(String title){
                                boolean bReturn = false;
                                try{
                                                if (driver.getTitle().equalsIgnoreCase(title)){
                                                                reportStep("The title of the page matches with the value :"+title, "PASS");
                                                                bReturn = true;
                                                }else
                                                                reportStep("The title of the page:"+driver.getTitle()+" did not match with the value :"+title, "SUCCESS");
 
                                }catch (Exception e) {
                                                reportStep("Unknown exception occured while verifying the title", "FAIL");
                                }
                                return bReturn;
                }
               
                /**
                * This method will verify the given text is available in the element text
                * @param id - The locator of the object in id
                * @param text  - The text to be verified
                * @author Babu - TestLeaf
                */
                public void verifyTextById(String id, String text) {
                                try{
                                                String sText = driver.findElementById(id).getText();
                                                if (sText.equalsIgnoreCase(text)){
                                                                reportStep("The text: "+sText+" matches with the value :"+text, "PASS");
                                                }else{
                                                                reportStep("The text: "+sText+" did not match with the value :"+text, "FAIL");
                                                }
                                }catch (Exception e) {
                                                reportStep("Unknown exception occured while verifying the title", "FAIL");
                                }
                }
 
                /**
                * This method will verify the given text matches in the element text
                * @param xpath - The locator of the object in xpath
                * @param text  - The text to be verified
                * @author Babu - TestLeaf
                */
                public void verifyTextByXpath(String xpath, String text){
                                try {
                                                String sText = driver.findElementByXPath(xpath).getText();
                                                if (sText.equalsIgnoreCase(text)){
                                                                reportStep("The text: "+sText+" matches with the value :"+text, "PASS");
                                                }else{
                                                                reportStep("The text: "+sText+" did not match with the value :"+text, "FAIL");
                                                }
                                }catch (Exception e) {
                                                reportStep("Unknown exception occured while verifying the title", "FAIL");
                                }
                }
               
                //@Override
                public void verifyTextByClassname(String cname, String text) {
                                //System.out.println(cname + text);
                                System.out.println(driver.findElementByClassName(cname).getText());
                                Assert.assertTrue(driver.findElementByClassName(cname).getText().equals(text));
                                System.out.println("Element matches the text:- " +text);
                }
               
                //@Override
                public void verifyTextByName(String name, String text) {
                                //System.out.println(name + text);
                                System.out.println(driver.findElementByName(name).getText());
                                Assert.assertTrue(driver.findElementByName(name).getText().equals(text));
                                System.out.println("Element matches the text:- " +text);
                }
               
                //@Override
                public void verifyTextByTagname(String tagname, String text) {
                                //System.out.println(name + text);
                                System.out.println(driver.findElementByTagName(tagname).getText());
                                Assert.assertTrue(driver.findElementByName(tagname).getText().equals(text));
                                System.out.println("Element matches the text:- " +text);
                }
 
                /**
                * This method will verify the given text is available in the element text
                * @param xpath - The locator of the object in xpath
                * @param text  - The text to be verified
                * @author Babu - TestLeaf
                */
                public void verifyTextContainsByXpath(String xpath, String text){
                	try{
                		String sText = driver.findElementByXPath(xpath).getText();
                		if (sText.contains(text)){
                			reportStep("The text: "+sText+" contains the value :"+text, "PASS");
                		}else{
                			reportStep("The text: "+sText+" did not contain the value :"+text, "FAIL");
                		}
                	}catch (Exception e) {
                		reportStep("Unknown exception occured while verifying the title", "FAIL");
                	}
                }
 
                //@Override
                public void verifyTextContainsByName(String name, String text) {
                                Assert.assertTrue(driver.findElementByName(name).getText().contains(text));
                                System.out.println("Element contains the text:- " +text);
                }
 
                /**
                * This method will verify the given text is available in the element text
                * @param xpath - The locator of the object in xpath
                * @param text  - The text to be verified
                * @author Babu - TestLeaf
                */
                public void verifyTextContainsByClassname(String cname, String text){
                	try{
                		String sText = driver.findElementByClassName(cname).getText();
                		if (sText.contains(text)){
                			reportStep("The text: "+sText+" contains the value :"+text, "PASS");
                		}else{
                			reportStep("The text: "+sText+" did not contain the value :"+text, "FAIL");
                		}
                	}catch (Exception e) {
                		reportStep("Unknown exception occured while verifying the title", "FAIL");
                	}
                }
               
                //@Override
                public void verifyTextContainsByTagname(String tagname, String text) {
                                Assert.assertTrue(driver.findElementByTagName(tagname).getText().contains(text));
                                System.out.println("Element contains the text:- " +text);
                }
               
                /**
                * This method will verify the given text is available in the element text
                * @param id - The locator of the object in id
                * @param text  - The text to be verified
                * @author Babu - TestLeaf
                */
                public void verifyTextContainsById(String id, String text) {
                                try{
                                                String sText = driver.findElementById(id).getText();
                                                if (sText.contains(text)){
                                                                reportStep("The text: "+sText+" contains the value :"+text, "PASS");
                                                }else{
                                                                reportStep("The text: "+sText+" did not contain the value :"+text, "FAIL");
                                                }
                                }catch (Exception e) {
                                                reportStep("Unknown exception occured while verifying the title", "FAIL");
                                }
                }
 
                /**
                * This method will close all the browsers
                * @author Babu - TestLeaf
                */
                public void quitBrowser() {
                                try {
                                                driver.quit();
                                } catch (Exception e) {
                                                reportStep("The browser:"+driver.getCapabilities().getBrowserName()+" could not be closed.", "FAIL");
                                }
 
                }
 
                /**
                * This method will click the element using id as locator
                * @param id  The id (locator) of the element to be clicked
                * @author Babu - TestLeaf
                */
                public void clickById(String id) {
                                try{
                                                driver.findElement(By.id(id)).click();
                                                reportStep("The element with id: "+id+" is clicked.", "PASS");
 
                                } catch (Exception e) {
                                                reportStep("The element with id: "+id+" could not be clicked.", "FAIL");
                                }
                }
 
                /**
                * This method will click the element using id as locator
                * @param id  The id (locator) of the element to be clicked
                * @author Babu - TestLeaf
                */
                public void clickByClassName(String classVal) {
                                try{
                                                driver.findElement(By.className(classVal)).click();
                                                reportStep("The element with class Name: "+classVal+" is clicked.", "PASS");
                                } catch (Exception e) {
                                                reportStep("The element with class Name: "+classVal+" could not be clicked.", "FAIL");
                                }
                }
                /**
                * This method will click the element using name as locator
                * @param name  The name (locator) of the element to be clicked
                * @author Babu - TestLeaf
                */
                public void clickByName(String name) {
                                try{
                                                driver.findElement(By.name(name)).click();
                                                reportStep("The element with name: "+name+" is clicked.", "PASS");
                                } catch (Exception e) {
                                                reportStep("The element with name: "+name+" could not be clicked.", "FAIL");
                                }
                }
 
                /**
                * This method will click the element using link name as locator
                * @param name  The link name (locator) of the element to be clicked
                * @author Babu - TestLeaf
                */
                public void clickByLink(String name) {
                                try{
                                                driver.findElement(By.linkText(name)).click();
                                                reportStep("The element with link name: "+name+" is clicked.", "PASS");
                                } catch (Exception e) {
                                                reportStep("The element with link name: "+name+" could not be clicked.", "FAIL");
                                }
                }
 
                /**
                * This method will click the element using xpath as locator
                * @param xpathVal  The xpath (locator) of the element to be clicked
                * @author Babu - TestLeaf
                */
                public void clickByXpath(String xpathVal) {
                                try{
                                                driver.findElement(By.xpath(xpathVal)).click();
                                                reportStep("The element : "+xpathVal+" is clicked.", "PASS");
                                } catch (Exception e) {
                                                reportStep("The element with xpath: "+xpathVal+" could not be clicked.", "FAIL");
                                }
                }
 
                /**
                * This method will click the element without taking snap
                * @param xpathVal  The xpath (locator) of the element to be clicked
                * @author Babu - TestLeaf
                */
 
                public void clickByWoSnap(String locator, char M) {
                                try{
                                                if (M=='x')
                                                {
                                                                driver.findElement(By.xpath(locator)).click();
                                                }
                                               
                                                if (M=='i')
                                                {
                                                                driver.findElement(By.id(locator)).click();
                                                }
 
                                                if (M=='c')
                                                {
                                                                driver.findElement(By.className(locator)).click();
                                                }
 
                                                if (M=='n')
                                                {
                                                                driver.findElement(By.name(locator)).click();
                                                }
 
                                                if (M=='t')
                                                {
                                                                driver.findElement(By.tagName(locator)).click();
                                                }
 
                                                if (M=='l')
                                                {
                                                                driver.findElement(By.linkText(locator)).click();
                                                }
 
                                } catch (Exception e) {
 
                                }
                }
 
                /**
                * This method will mouse over on the element using xpath as locator
                * @param xpathVal  The xpath (locator) of the element to be moused over
                * @author Babu - TestLeaf
                */
                public void mouseOverByXpath(String xpathVal) {
                                try{
                                                new Actions(driver).moveToElement(driver.findElement(By.xpath(xpathVal))).build().perform();
                                                reportStep("The mouse over by xpath : "+xpathVal+" is performed.", "PASS");
                                } catch (Exception e) {
                                                reportStep("The mouse over by xpath : "+xpathVal+" could not be performed.", "FAIL");
                                }
                }
 
                /**
                * This method will mouse over on the element using link name as locator
                * @param xpathVal  The link name (locator) of the element to be moused over
                * @author Babu - TestLeaf
                */
                public void mouseOverByLinkText(String linkName) {
                                try{
                                                new Actions(driver).moveToElement(driver.findElement(By.linkText(linkName))).build().perform();
                                                reportStep("The mouse over by link : "+linkName+" is performed.", "PASS");
                                } catch (Exception e) {
                                                reportStep("The mouse over by link : "+linkName+" could not be performed.", "FAIL");
                                }
                }
 
                /**
                * This method will return the text of the element using xpath as locator
                * @param xpathVal  The xpath (locator) of the element
                * @author Babu - TestLeaf
                */
                public String getTextByXpath(String xpathVal){
                                String bReturn = "";
                                try{
                                                return driver.findElement(By.xpath(xpathVal)).getText();
                                } catch (Exception e) {
                                                reportStep("The element with xpath: "+xpathVal+" could not be found.", "FAIL");
                                }
                                return bReturn;
                }
               
                 
 
}