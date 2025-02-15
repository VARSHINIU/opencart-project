package pageobjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Accountregistrationpage extends basepage{

    public Accountregistrationpage(WebDriver driver){

        super(driver);
    }
    @FindBy(xpath="//input[@id='input-firstname']")
    WebElement firstname;

    @FindBy(xpath="//input[@id='input-lastname']")
    WebElement lastname;

    @FindBy(xpath="//input[@id='input-email']")
    WebElement email;

    @FindBy(xpath="//input[@id='input-telephone']")
    WebElement phonenum;

    @FindBy(xpath="//input[@id='input-password']")
    WebElement password;

    @FindBy(xpath="//input[@id='input-confirm']")
    WebElement cfmpass;

    @FindBy(name="newsletter")
    WebElement newsletteryess;

    @FindBy(name="agree")
    WebElement agreement;

    @FindBy(xpath="//input[@class=\"btn btn-primary\"][1]")
    WebElement continuebtn;

    @FindBy(xpath="//p[contains(text(),'Congratulations! Your new account has been success')]")
    WebElement successregistration;

    //action methods
    public void setFirstname(String fname){
        firstname.sendKeys(fname);
    }
    public void setlastname(String lname){
        lastname.sendKeys(lname);
    }

    public void setmail(String mail){
        email.sendKeys(mail);
    }

    public void setphonenum(String num){
        phonenum.sendKeys(num);
    }

    public void setPassword(String pass){
        password.sendKeys(pass);
    }
    public void setconfmpass(String cpass){
        cfmpass.sendKeys(cpass);
    }
    public void setnewsletter(){
        newsletteryess.click();
    }
    public void setagree(){
        agreement.click();
    }
    public void clickcontinuebtn(){
        continuebtn.click();
    }
    public String successmsg(){
        try {
            String statusregistration = successregistration.getText();
            return statusregistration;
        } catch (NoSuchElementException e) {
            String statusregistration =successregistration.getText();
            System.out.println(statusregistration);
            return statusregistration;
        }
    }

}
