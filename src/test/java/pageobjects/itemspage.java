package pageobjects;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class itemspage extends basepage{
     public  itemspage(WebDriver driver){
         super(driver);
     }


     @FindBy(xpath="//div[@class=\"button-group\"]/child::button[1]")
    WebElement addtocart;

     @FindBy(xpath="//div[contains(normalize-space(), 'Success: You have added')]\n")
    WebElement  sucesssaddtocart;

     public void addingtocart(){
         addtocart.click();
     }
     public boolean sucessmsgcart(){
         try {
             boolean statusaddtocart = sucesssaddtocart.isDisplayed();
             return statusaddtocart;
         } catch (NoSuchElementException e) {
             boolean statusaddtocart =sucesssaddtocart.isDisplayed();
             System.out.println(statusaddtocart);
             return statusaddtocart;
         }
     }


}
