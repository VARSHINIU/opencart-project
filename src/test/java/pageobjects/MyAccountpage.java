package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountpage extends basepage{

    public MyAccountpage(WebDriver driver){

        super(driver);
    }
    @FindBy(xpath="//h2[normalize-space()='My Account']")
    WebElement myacc;

    @FindBy(xpath="//a[text()=\"Logout\" and @class=\"list-group-item\"]")
    WebElement logout;

    public void setLogout(){
        logout.click();
    }

}
