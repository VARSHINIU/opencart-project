package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homepage extends basepage{

    public homepage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath="//ul[@class=\"list-inline\"]/li[@class=\"dropdown\"]")
    WebElement myacc;

    @FindBy(xpath="//ul[@class=\"dropdown-menu dropdown-menu-right\"]/li[1]")
    WebElement reg;

    @FindBy(xpath="//ul[@class=\"dropdown-menu dropdown-menu-right\"]/li[2]")
    WebElement loginbtn;

    public void clickmyacc(){
        myacc.click();
    }
    public void chooseregister(){
        reg.click();
    }
    public void chooselogin(){
        loginbtn.click();
    }


}
