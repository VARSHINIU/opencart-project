package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class loginpage extends basepage{

    public loginpage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath="//input[@id='input-email']")
    WebElement email;

    @FindBy(xpath="//input[@id='input-password']")
    WebElement password;

     @FindBy(xpath="//input[@value='Login']")
     WebElement login;

     @FindBy(xpath="//h2[normalize-space()='My Account']")
     WebElement successfullogin;

    public  void emaillogin(String mailid){
        email.sendKeys(mailid);
    }
    public void  passlogin(String pass){
        password.sendKeys(pass);
    }
    public void clicklogin(){
        login.click();
    }
    public boolean succlogin(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(successfullogin)); //od
            return true;
        } catch (Exception e) {
            return false;
        }

    }




}
