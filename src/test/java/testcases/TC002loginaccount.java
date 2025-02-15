package testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.MyAccountpage;
import testbase.baseclass;
import pageobjects.homepage;
import pageobjects.loginpage;
import utilities.DataProviders;
import java.time.Duration;


public class TC002loginaccount extends baseclass {

    @Test(dataProvider ="loginValidInvaliddatas", dataProviderClass = DataProviders.class)
    public void  loginvalidation(String mail,String pass, String exp){


        try{
            homepage hm=new homepage(driver);
            hm.clickmyacc();
            hm.chooselogin();


            loginpage lgn=new loginpage(driver);
            lgn.emaillogin(mail);
            lgn.passlogin(pass);
            lgn.clicklogin();

            MyAccountpage macc=new MyAccountpage(driver);

            try {
                if (exp.equalsIgnoreCase("valid"))
                {
                    Assert.assertTrue(lgn.succlogin());
                    macc.setLogout();
                    System.out.println("login successfull at valid cred only");
                }else{
                    Assert.assertFalse(lgn.succlogin());
                    System.out.println("unsuccess login for invalid");
                }
            } catch (Exception e) {
                logger.error("login is not working");
            }} catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}


