package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MyAccountpage extends basepage{

    public MyAccountpage(WebDriver driver){

        super(driver);
    }
    @FindBy(xpath="//h2[normalize-space()='My Account']")
    WebElement myacc;

    @FindBy(xpath="//a[text()=\"Logout\" and @class=\"list-group-item\"]")
    WebElement logout;

    @FindBy(xpath="//a[normalize-space()='Desktops']")
    WebElement desktops;

    @FindBy(xpath="//a[normalize-space()='Mac (1)']")
    WebElement macproduct;
    public void setLogout(){
        logout.click();
    }

    public void desktopstomacs(){
        Actions act=new Actions(driver);
        act.moveToElement(desktops).moveToElement(macproduct).click().build().perform();
    }
}
